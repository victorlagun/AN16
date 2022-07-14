package com.example.an16tms

data class User (val name: String, val secondName: String, val age: Int){

    override fun toString(): String {
        return "Пользователь с именем $name, фамилией $secondName в возрасте $age"
    }
}