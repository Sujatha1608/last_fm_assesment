package sampleproject.com.my.skeletonApp.core

import sampleproject.com.my.skeletonApp.feature.login.GetDataActivity
import sampleproject.com.my.skeletonApp.feature.display.DisplayInfoActivity


class Router {
    enum class Destination {
        LOGIN,
        MAIN
    }

    enum class Parameter{
        USERNAME,
        ID
    }

    companion object {
        fun getClass(destination: Destination): Class<*> {
            return when (destination) {
                Destination.LOGIN -> GetDataActivity::class.java
                Destination.MAIN -> DisplayInfoActivity::class.java
                else -> {
                    TODO("Implement Default case")
                }
            }
        }
    }
}