package com.techmeskills.an16.eliseyev_aleksandr.homework02.model

data class Users (val name:String, val secondName:String, val age:String){
    override fun toString(): String {
        return "$name $secondName, $age y.o."
    }
}