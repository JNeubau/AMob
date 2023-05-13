package com.example.cookbook

class Dish private constructor(val name: String, val recipe: String, val time: Int) {

    override fun toString(): String {
        return name
    }

    companion object {
        val dishes = arrayOf(
            Dish("Jajecznica", "Nothing", 11*60),
            Dish("Płatki z mlekiem", "test1", 3*60),
            Dish("Kanapki", "test2", 5*60)
        )
    }
}