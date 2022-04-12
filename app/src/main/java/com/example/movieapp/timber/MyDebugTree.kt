package com.example.movieapp.timber

import timber.log.Timber

class MyDebugTree : Timber.DebugTree() {

    override fun createStackElementTag(element: StackTraceElement): String? {
        return String.format(
            "C:%s:%s:%s",
            super.createStackElementTag(element),
            element.lineNumber, element.methodName
        )
    }
}