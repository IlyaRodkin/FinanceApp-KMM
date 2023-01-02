package com.example.financeapp_kmm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform