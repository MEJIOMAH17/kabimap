package com.github.mejiomah17.common

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun App() {
    val nodeState = remember { NodeState() }
    Box(modifier = Modifier.fillMaxSize().pointerInput(Unit) {
        detectTapGestures(
            onTap = {
                nodeState.editable = false
            },
        )
    }) {
        Node(nodeState = nodeState, modifier = Modifier.align(Alignment.Center))
    }
}

class NodeState() {
    var editable by mutableStateOf(false)
}

@Composable
fun BoxScope.Node(nodeState: NodeState = remember { NodeState() }, modifier: Modifier) = nodeState.run {
    var text by remember { mutableStateOf("Hello, World!") }
    if (!editable) {
        hideKeyboard()
    }

    val textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center)
    TextField(
        text,
        textStyle = textStyle,
        singleLine = true,
        enabled = editable,
        onValueChange = { text = it },
        modifier = modifier
            .width(measureText(text + "aaaa", textStyle))
            .align(Alignment.Center)
            .pointerInput(Unit) {
                detectTapGestures(
                    onLongPress = {
                        editable = true
                    },
                )
            },
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(
            onDone = {
                editable = false
            },
        )
    )
}