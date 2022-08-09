package com.techmeskills.an16.miseyko_denis.homework01

data class User(
    val name: String,
    val secondName: String,
    val age: Int,
) {

    override fun toString(): String {
        return "Пользователь с именем $name, фамилией $secondName в возрасте $age"
    }
}