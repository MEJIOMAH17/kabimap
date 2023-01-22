package com.github.mejiomah17.common

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalSoftwareKeyboardController

@OptIn(ExperimentalComposeUiApi::class)
@Composable
actual fun hideKeyboard() {
    LocalSoftwareKeyboardController.current?.hide()
}

