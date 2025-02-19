package com.paulklauser.catfacts

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform