package com.kromer.presentation.extensions

import android.view.View
import androidx.constraintlayout.widget.Group
import com.google.android.material.snackbar.Snackbar

fun View.show(show: Boolean): View {
    if (show) {
        this.show()
    } else {
        this.hide()
    }
    return this
}

fun View.inVisible(inVisible: Boolean): View {
    if (inVisible) {
        this.inVisible()
    } else {
        this.show()
    }
    return this
}

fun View.show(): View {
    this.visibility = View.VISIBLE
    if (this is Group) {
        this.requestLayout()
    }
    return this
}

fun View.hide(): View {
    this.visibility = View.GONE
    if (this is Group) {
        this.requestLayout()
    }
    return this
}

fun View.inVisible(): View {
    this.visibility = View.INVISIBLE
    if (this is Group) {
        this.requestLayout()
    }
    return this
}

fun View.showSnackBar(
    message: String,
    actionName: String? = null,
    action: (() -> Unit)? = null
) {
    val snackBar = Snackbar.make(this, message, Snackbar.LENGTH_INDEFINITE)

    action?.let {
        snackBar.setAction(actionName) {
            it()
        }
    }

    snackBar.show()
}