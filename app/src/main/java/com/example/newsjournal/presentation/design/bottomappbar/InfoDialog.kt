package com.example.newsjournal.presentation.design.bottomappbar

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

@Composable
fun InfoDialog(
    title: String,
    message: String,
    onPositive: () -> Unit,
    onCancel: (() -> Unit)? = null
) {
    Dialog(
        onDismissRequest = onCancel ?: onPositive,
        properties = DialogProperties(dismissOnClickOutside = true)
    ) {
        Card(
            shape = RoundedCornerShape(2.dp),
            elevation = CardDefaults.cardElevation(8.dp),
        ) {
            Column(modifier = Modifier.padding(10.dp)) {
                Text(
                    text = title,
                    fontSize = 24.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(vertical = 8.dp)
                )

                Text(
                    text = message,
                    fontSize = 16.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(vertical = 8.dp)
                )

                Button(
                    onClick = onPositive,
                    modifier = Modifier.align(Alignment.End)
                ) {
                    Text(text = "Ok")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun InfoDialogPreview() {
    InfoDialog(
        title = "Title",
        message = "Some dialog info text with some descriptions lines",
        onPositive = {})
}