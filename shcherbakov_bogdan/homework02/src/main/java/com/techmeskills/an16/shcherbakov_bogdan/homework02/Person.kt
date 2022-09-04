package com.techmeskills.an16.shcherbakov_bogdan.homework02

data class Person(
    val name: String,
    val secondName: String,
    val age: Int
){
    override fun toString(): String {
        return "$name $secondName $age"
    }
}
