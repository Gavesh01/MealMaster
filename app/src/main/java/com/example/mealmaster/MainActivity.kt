package com.example.mealmaster

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity



class MainActivity : AppCompatActivity() {

    private lateinit var addMealsToDb_btn: Button
    private lateinit var searchMealsByIngredient_btn: Button
    private lateinit var searchMeals_btn: Button
    private lateinit var webSearchMeals_btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addMealsToDb_btn = findViewById(R.id.addMealDB_btn)
        searchMealsByIngredient_btn = findViewById(R.id.searchByIngredient_btn)
        searchMeals_btn = findViewById(R.id.SearchMeals_btn)
        webSearchMeals_btn = findViewById(R.id.webSearchForMeals_btn)

        addMealsToDb_btn.setOnClickListener { AddMealsActivity() }
        searchMealsByIngredient_btn.setOnClickListener { SearchMealsByIngredientActivity() }
        searchMeals_btn.setOnClickListener { SearchMealsActivity() }
        webSearchMeals_btn.setOnClickListener { WebSearchForMeal() }
    }

    private fun AddMealsActivity() {
        val intent = Intent(this, AddMealsActivity::class.java)
        startActivity(intent)
    }

    private fun SearchMealsByIngredientActivity() {
        val intent = Intent(this, SearchByIngredientActivity::class.java)
        startActivity(intent)
    }

    private fun SearchMealsActivity() {
        val intent = Intent(this, SearchMealsActivity::class.java)
        startActivity(intent)
    }

    private fun WebSearchForMeal() {
        val intent = Intent(this, WebSearchForMeals::class.java)
        startActivity(intent)
    }
}
