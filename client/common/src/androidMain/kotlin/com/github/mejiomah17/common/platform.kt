package com.github.mejiomah17.common

import androidx.compose.material.LocalTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.ParagraphIntrinsics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.createFontFamilyResolver
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalComposeUiApi::class)
@Composable
actual fun hideKeyboard() {
    LocalSoftwareKeyboardController.current?.hide()
}

@Composable
actual fun measureText(text: String, textStyle: TextStyle): Dp {
    return with(LocalDensity.current) {
        ParagraphIntrinsics(
            text = text,
            style = textStyle,
            density = this,
            fontFamilyResolver = createFontFamilyResolver(LocalContext.current)
        ).maxIntrinsicWidth.toDp()
    }
}