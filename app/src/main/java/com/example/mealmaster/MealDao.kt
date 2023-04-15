package com.example.mealmaster

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MealDao {
    @Insert
    suspend fun insertAll(vararg meals: Meal)

    @Query("SELECT * FROM meals")
    suspend fun getAllMeals(): List<Meal>

    @Query("SELECT * FROM meals WHERE strMeal LIKE '%' || :searchQuery || '%' OR strIngredient1 LIKE '%' || :searchQuery || '%' OR strIngredient2 LIKE '%' || :searchQuery || '%' OR strIngredient3 LIKE '%' || :searchQuery || '%' OR strIngredient4 LIKE '%' || :searchQuery || '%' OR strIngredient5 LIKE '%' || :searchQuery || '%'  OR strIngredient6 LIKE '%' || :searchQuery || '%' OR strIngredient7 LIKE '%' || :searchQuery || '%' OR strIngredient8 LIKE '%' || :searchQuery || '%' OR strIngredient9 LIKE '%' || :searchQuery || '%' OR strIngredient10 LIKE '%' || :searchQuery || '%' OR strIngredient11 LIKE '%' || :searchQuery || '%' OR strIngredient12 LIKE '%' || :searchQuery || '%' OR strIngredient13 LIKE '%' || :searchQuery || '%' OR strIngredient14 LIKE '%' || :searchQuery || '%' OR strIngredient15 LIKE '%' || :searchQuery || '%' OR strIngredient16 LIKE '%' || :searchQuery || '%' OR strIngredient17 LIKE '%' || :searchQuery || '%' OR strIngredient18 LIKE '%' || :searchQuery || '%' OR strIngredient18 LIKE '%' || :searchQuery || '%' OR strIngredient19 LIKE '%' || :searchQuery || '%' OR strIngredient20 LIKE '%' || :searchQuery || '%'")
    suspend fun getTheMeals(searchQuery: String):List<Meal>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMeals(vararg meal: Meal)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMealsList(meal: List<Meal>)
}