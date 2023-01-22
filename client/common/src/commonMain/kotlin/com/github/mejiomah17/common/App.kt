package com.github.mejiomah17.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.Button
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.input.ImeAction

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
fun Node(nodeState: NodeState = remember { NodeState() }, modifier: Modifier) = nodeState.run {
    var text by remember { mutableStateOf("Hello, World!") }
    if (!editable) {
        hideKeyboard()
    }
    TextField(
        text,
        enabled = editable,
        onValueChange = { text = it },
        modifier = modifier.pointerInput(Unit) {
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
            onGo = {
                editable = false
            },
            onNext = {
                editable = false
            },
            onPrevious = {
                editable = false
            },
            onSend = {
                editable = false
            },
        )
    )
}