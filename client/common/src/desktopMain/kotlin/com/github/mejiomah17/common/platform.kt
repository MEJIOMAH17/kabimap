package com.github.mejiomah17.common

import androidx.compose.material.LocalTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.ParagraphIntrinsics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.createFontFamilyResolver
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

actual fun hideKeyboard() {
}

@Composable
actual fun measureText(text: String, textStyle: TextStyle): Dp {
    return with(LocalDensity.current) {
        ParagraphIntrinsics(
            text = text,
            style = textStyle,
            density = this,
            fontFamilyResolver = createFontFamilyResolver()
        ).maxIntrinsicWidth.toDp()
    }
}