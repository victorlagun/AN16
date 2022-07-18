package com.techmeskills.an16.tsybulkina_darya.homework02.model

data class Person (val name:String, val secondName:String, val age:Int){
    override fun toString(): String {
        return "$name $secondName ($age лет)"
    }
}