package com.example.qrcode.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun QRCodeContent(content: String, size: Int) {
    val viewModel = hiltViewModel<QRCodeViewModel>()
    val bitmap = viewModel.generateQRCode(content, size)
    
    if (bitmap != null) {
        Image(bitmap = bitmap.asImageBitmap(), contentDescription = "QR Code")
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun PreviewQRCodeContent() {
    QRCodeContent("Hello, Jetpack Compose!", 200)
}