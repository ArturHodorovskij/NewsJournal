package com.example.newsjournal.presentation.design

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import coil.compose.SubcomposeAsyncImage
import com.example.newsjournal.R

/**
 * Кастомный компонент для загрузки изображений
 * @param imageUrl принимает ссылку на изображение
 * @param modifier параметр для кастомизации контрола
 * @param loadingResource прнимает Painter, имеет знаечние по умолчанию
 */
@Composable
fun CustomImage(
    imageUrl: String?,
    modifier: Modifier,
    loadingResource: Painter = painterResource(R.drawable.image_placeholder)
) {
    SubcomposeAsyncImage(
        model = imageUrl,
        contentDescription = null,
        modifier = modifier,
        loading = {
            Image(
                painter = loadingResource,
                contentDescription = null,
                modifier = modifier.shimmer()
            )
        },
        contentScale = ContentScale.Crop
    )
}