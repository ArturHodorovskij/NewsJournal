package com.example.newsjournal.presentation.design

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsjournal.presentation.ui.theme.defaultBackground

@Composable
fun InputWindowInformation(
    textInside: String,
    userPutData: MutableState<String> = remember { mutableStateOf("") }
    
) {
    Box(
        modifier = Modifier
            .border(width = 2.dp, color = Color.Gray)
            .size(height = 56.dp, width = 240.dp)
    ) {
        TextField(
            value = userPutData.value,
            onValueChange = { newText -> userPutData.value = newText },
            singleLine = true,
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = defaultBackground,
                unfocusedTextColor = Color(0xff888888),
                focusedContainerColor = Color.White,
                focusedTextColor = Color(0xff222222)
            ),
            textStyle = TextStyle(fontSize = 16.sp),
            placeholder = { Text(text = textInside) },
            modifier = Modifier
                .size(height = 56.dp, width = 240.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun InputWindowInformationPreview() {

    InputWindowInformation("Email")
}