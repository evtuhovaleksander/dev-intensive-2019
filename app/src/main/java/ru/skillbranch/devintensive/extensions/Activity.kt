package ru.skillbranch.devintensive.extensions

import android.app.Activity
import android.graphics.Rect
import android.view.View
import android.view.inputmethod.InputMethodManager


fun Activity.hideKeyboard() {
    //hideKeyboard(currentFocus ?: View(this))
    val view = currentFocus ?: View(this)
    val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
}

val Activity.isKeyboardOpen: Boolean
    get() {

        val rootView = findViewById<View>(android.R.id.content)
        val rect = Rect().apply { rootView.getWindowVisibleDisplayFrame(this) }
        val screenHeight = rootView.height
        val keypadHeight = screenHeight - rect.bottom
        val isShown = keypadHeight > screenHeight * 0.15
        return isShown
    }

val Activity.isKeyboardClosed: Boolean
    get() { return !isKeyboardOpen }