package com.example.newsjournal.samples

import androidx.compose.animation.Crossfade
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.launch

//тут я нееемного насоздавал методов-заглушек, чтобы не напрягал сильно псевдокод.
@Composable
fun SomeScreenContent(someState: SomeState.Content) {
    //тут мы уже отрисовываем весь наш экран с контентом. Списки, картинки и тд и тп.
}

@Composable
fun ErrorDialog(errorMessage: SomeState.Error) {
    //тут мы отображаем диалог пользователю что произошла ошибка
}

class SomeUseCase() {
    fun loadSomeData(): SomeState.Content {
        return SomeState.Content(firstField = "hello", secondField = 232)
    }
}

//Примитивный пример viewmodel и как она разруливает стейтом
class SomeViewModel(val useCase: SomeUseCase) : ViewModel() {

    private val _state = MutableLiveData<SomeState>(SomeState.Initial)
    val state: LiveData<SomeState> = _state

    init {
        loadData()
    }

    private fun loadData() {
        //тут мы куда-то идём за данными, скорее всего через uscecase
        _state.value =
            SomeState.Loading // перед началом загрузки выставляем стейт в состояние загрузки
        viewModelScope.launch {
            try {
                val content: SomeState.Content =
                    useCase.loadSomeData() //грузим в корутине наши данные
                _state.value =
                    content // в случае успешной загрузки передаём данные в стейт и у нас стейт уже будет в состоянии Content
            } catch (e: Exception) {
                handleError(e.message.toString())
            }
        }
    }

    fun handleError(errorMessage: String) {
        _state.value =
            SomeState.Error(errorMessage = errorMessage) // тут к примеру можно обработать ошибку, передать данные об ошибке и установить стейт в Error
    }
}

sealed class SomeState {
    //Вот так выглядит примем модели для MVI. Тут, чтобы было более ясно, следует вспомнить что такое sealed классы/интерфейсы.
    data object Initial : SomeState()
    data object Loading : SomeState()
    data class Content(val firstField: String, val secondField: Int) : SomeState()
    data class Error(val errorMessage: String) : SomeState()
}

@Composable
fun SomeScreen(viewModel: SomeViewModel = viewModel()) {   // Это корневая компоуз функция для нашего экрана.
    val state by viewModel.state.observeAsState()
    //Таким образом можно обрадатывать стейты. Т.е. в зависимости от того, какие данные вернёт нам viewmodel, такое состояние экрана мы будем отображать
    Crossfade(
        targetState = state
    ) { targetState ->
        when (targetState) {
            is SomeState.Initial -> Unit // это начальное состояние, которое пустое. Присваиваеться при создании объекта стейта. В данном случае мы ничего тут не получаем и ничего не отрисовываем.

            is SomeState.Loading -> CircularProgressIndicator() //Тут мы отображаем "крутилятор" пока данные загружаются

            is SomeState.Content -> SomeScreenContent(someState = targetState) //Это состояние мы отрисовываем когда у нас успешно загрузились данные

            is SomeState.Error -> ErrorDialog(errorMessage = targetState) //Тут мы можем обработать стояние ошибки на экране. К примеру показать какой-то диалог пользователю
            else -> {
                Unit
            }
        }
    }
}

//Ну и надо помнить как работает компоуз, при изменении стейта ui перерисовывается, что позволяет гибко обновлять сам экран.
//Стоит помнить что нужно избегать вызова функций в компоуз коде(или делать это в специальных местак, к примеру LauncedEffect)