package com.techmeskills.an16.miseyko_denis.homework02

data class User (val name: String, val secondName: String, val age: Int){

    override fun toString(): String {
        return "$name $secondName $age"
    }
}