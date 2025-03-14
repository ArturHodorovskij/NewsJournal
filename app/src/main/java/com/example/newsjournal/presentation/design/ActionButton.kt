package com.example.newsjournal.presentation.design

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ActionButton(textButton:String, onClick:()->Unit){

    Button(
        onClick = onClick,
        shape = RoundedCornerShape(15.dp),
        border = BorderStroke(3.dp, Color.DarkGray),
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.White,
            containerColor = Color.Black
        ),
        modifier = Modifier
            .size(height = 48.dp, width = 240.dp)
    ) {

        Text(textButton, fontSize = 16.sp)
    }
}

@Preview(showBackground = true)
@Composable

fun ActionButtonPreview(){
    ActionButton("хуй", onClick = {})
}