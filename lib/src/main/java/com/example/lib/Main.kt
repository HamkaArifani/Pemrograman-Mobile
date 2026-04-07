package com.example.lib

fun main(){
    val systemManager = CowManager()
    val app = CowMenu(systemManager)
    app.menu()
}