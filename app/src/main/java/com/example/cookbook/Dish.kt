package com.example.cookbook

class Dish private constructor(val name: String, val recipe: String, val time: Int,
                               val imageResourceId: Int) {

    override fun toString(): String {
        return name
    }

    companion object {
        val dishes = arrayOf(
            Dish("Jajecznica", "Nothing", 11*60, R.drawable.jajecznica),
            Dish("Płatki z mlekiem", "test1", 3*60, R.drawable.platki_na_mleku),
            Dish("Kanapki", "test2", 5*60, R.drawable.kanapki),
            Dish("Kanapki", "test2", 5*60, R.drawable.kanapki),
            Dish("Kanapki", "test2", 5*60, R.drawable.kanapki),
            Dish("Kanapki", "test2", 5*60, R.drawable.kanapki),
            Dish("Kanapki", "test2", 5*60, R.drawable.kanapki),
            Dish("Kanapki", "test2", 5*60, R.drawable.kanapki),
            Dish("Kanapki", "test2", 5*60, R.drawable.kanapki),
            Dish("Kanapki", "test2", 5*60, R.drawable.kanapki),
            Dish("Kanapki", "test2", 5*60, R.drawable.kanapki),
            Dish("Kanapki", "test2", 5*60, R.drawable.kanapki),
            Dish("Kanapki", "test2", 5*60, R.drawable.kanapki),
            Dish("Kanapki", "test2", 5*60, R.drawable.kanapki),
            Dish("Kanapki", "test2", 5*60, R.drawable.kanapki),
            Dish("Kanapki", "test2", 5*60, R.drawable.kanapki),
            Dish("Kanapki", "test2", 5*60, R.drawable.kanapki),
            Dish("Kanapki", "test2", 5*60, R.drawable.kanapki)
        )
    }
}