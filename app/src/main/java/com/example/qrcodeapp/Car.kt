package com.example.qrcodeapp

import javax.inject.Inject

class Car @Inject constructor(val engine: Engine) {
    fun drive(): String = engine.start() + "driving start"
}