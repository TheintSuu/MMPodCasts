package com.theintsuhtwe.mmpodcasts.activities

import org.json.JSONArray
import org.json.JSONObject

class Json() {

    private val json = JSONObject()

    constructor(init: Json. () -> Unit) : this() {
        this.init()
    }

    infix fun String.to(value: Json) {
        json.put(this, value.json)
    }

    infix fun <T> String.to(value: T) {
        json.put(this, value)
    }

    override fun toString(): String {
        return json.toString()
    }
}

fun main(args: Array<String>) {

    val json = Json {
        "name" to "Roy"
        "body" to Json {
            "height" to 173
            "weight" to 80
        }
        "cars" to JSONArray().apply {
            put("Tesla")
            put("Porsche")
            put("BMW")
            put("Ferrari")
        }
    }

    println(json)

}