package com.example.mealmaster

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import kotlinx.coroutines.runBlocking

class SearchMealsActivity : AppCompatActivity(){

    private lateinit var textViewMeals: TextView

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.search_for_meals)

        val context: Context = applicationContext
        val db = Room.databaseBuilder(context, MealDatabase::class.java, "meal_database").build()

        var mealSearchBar  = findViewById<EditText>(R.id.search_for_meals_bar)
        var mealSearchBtn  = findViewById<Button>(R.id.search_for_meals_btn)
        textViewMeals = findViewById(R.id.search_for_meals_text_view)

        if (savedInstanceState != null) {
            textViewMeals.text = savedInstanceState.getString("textViewMealsText", "")
        }

        fun myNonSuspendFunction() {

            val searchIngredient = mealSearchBar.text.toString()
            val stringBuilderRecipeDetails = StringBuilder()

            runBlocking {
                val meals = db.mealDao().getTheMeals(searchIngredient)
                val all = db.mealDao().getAllMeals()
                for (u in meals) {
                    //tv.append("\n ${u.meal} ${u.area}")
                    println("MEALS\\n ${u.strMeal} ${u.strDrinkAlternate} ${u.id}")

                }

                for (u in all) {
                    //tv.append("\n ${u.meal} ${u.area}")
                    println("ALL MEALS\\n ${u.strMeal} ${u.strDrinkAlternate} ${u.id}")

                }
                for(meal in meals){
                    stringBuilderRecipeDetails.append("Meal :- ${meal.strMeal}\nDrinkAlternate :- ${meal.strDrinkAlternate}\nCategory :- ${meal.strCategory}\nArea :- ${meal.strArea}\nInstructions :- ${meal.strInstructions}\nstrMealThumb :- ${meal.strMealThumb}\nTags :- ${meal.strTags}\nYoutube :- ${meal.strYoutube}\n")
                    if(validateNullAndBlanks(meal.strIngredient1))stringBuilderRecipeDetails.append("Ingredient1 :- ${meal.strIngredient1}\n")
                    if(validateNullAndBlanks(meal.strIngredient2))stringBuilderRecipeDetails.append("Ingredient2 :- ${meal.strIngredient2}\n")
                    if(validateNullAndBlanks(meal.strIngredient3))stringBuilderRecipeDetails.append("Ingredient3 :- ${meal.strIngredient3}\n")
                    if(validateNullAndBlanks(meal.strIngredient4))stringBuilderRecipeDetails.append("Ingredient4 :- ${meal.strIngredient4}\n")
                    if(validateNullAndBlanks(meal.strIngredient5))stringBuilderRecipeDetails.append("Ingredient5 :- ${meal.strIngredient5}\n")
                    if(validateNullAndBlanks(meal.strIngredient6))stringBuilderRecipeDetails.append("Ingredient6 :- ${meal.strIngredient6}\n")
                    if(validateNullAndBlanks(meal.strIngredient7))stringBuilderRecipeDetails.append("Ingredient7 :- ${meal.strIngredient7}\n")
                    if(validateNullAndBlanks(meal.strIngredient8))stringBuilderRecipeDetails.append("Ingredient8 :- ${meal.strIngredient8}\n")
                    if(validateNullAndBlanks(meal.strIngredient9))stringBuilderRecipeDetails.append("Ingredient9 :- ${meal.strIngredient9}\n")
                    if(validateNullAndBlanks(meal.strIngredient10))stringBuilderRecipeDetails.append("Ingredient10 :- ${meal.strIngredient10}\n")
                    if(validateNullAndBlanks(meal.strIngredient11))stringBuilderRecipeDetails.append("Ingredient11 :- ${meal.strIngredient11}\n")
                    if(validateNullAndBlanks(meal.strIngredient12))stringBuilderRecipeDetails.append("Ingredient12 :- ${meal.strIngredient12}\n")
                    if(validateNullAndBlanks(meal.strIngredient13))stringBuilderRecipeDetails.append("Ingredient13 :- ${meal.strIngredient13}\n")
                    if(validateNullAndBlanks(meal.strIngredient14))stringBuilderRecipeDetails.append("Ingredient14 :- ${meal.strIngredient14}\n")
                    if(validateNullAndBlanks(meal.strIngredient15))stringBuilderRecipeDetails.append("Ingredient15 :- ${meal.strIngredient15}\n")
                    if(validateNullAndBlanks(meal.strIngredient16))stringBuilderRecipeDetails.append("Ingredient16 :- ${meal.strIngredient16}\n")
                    if(validateNullAndBlanks(meal.strIngredient17))stringBuilderRecipeDetails.append("Ingredient17 :- ${meal.strIngredient17}\n")
                    if(validateNullAndBlanks(meal.strIngredient18))stringBuilderRecipeDetails.append("Ingredient18 :- ${meal.strIngredient18}\n")
                    if(validateNullAndBlanks(meal.strIngredient19))stringBuilderRecipeDetails.append("Ingredient19 :- ${meal.strIngredient19}\n")
                    if(validateNullAndBlanks(meal.strIngredient20))stringBuilderRecipeDetails.append("Ingredient20 :- ${meal.strIngredient20}\n")
                    if(validateNullAndBlanks(meal.strMeasure1))stringBuilderRecipeDetails.append("Measure1 :- ${meal.strMeasure1}\n")
                    if(validateNullAndBlanks(meal.strMeasure2))stringBuilderRecipeDetails.append("Measure2 :- ${meal.strMeasure2}\n")
                    if(validateNullAndBlanks(meal.strMeasure3))stringBuilderRecipeDetails.append("Measure3 :- ${meal.strMeasure3}\n")
                    if(validateNullAndBlanks(meal.strMeasure4))stringBuilderRecipeDetails.append("Measure4 :- ${meal.strMeasure4}\n")
                    if(validateNullAndBlanks(meal.strMeasure5))stringBuilderRecipeDetails.append("Measure5 :- ${meal.strMeasure5}\n")
                    if(validateNullAndBlanks(meal.strMeasure6))stringBuilderRecipeDetails.append("Measure6 :- ${meal.strMeasure6}\n")
                    if(validateNullAndBlanks(meal.strMeasure7))stringBuilderRecipeDetails.append("Measure7 :- ${meal.strMeasure7}\n")
                    if(validateNullAndBlanks(meal.strMeasure8))stringBuilderRecipeDetails.append("Measure8 :- ${meal.strMeasure8}\n")
                    if(validateNullAndBlanks(meal.strMeasure9))stringBuilderRecipeDetails.append("Measure9 :- ${meal.strMeasure9}\n")
                    if(validateNullAndBlanks(meal.strMeasure10))stringBuilderRecipeDetails.append("Measure10 :- ${meal.strMeasure10}\n")
                    if(validateNullAndBlanks(meal.strMeasure11))stringBuilderRecipeDetails.append("Measure11 :- ${meal.strMeasure11}\n")
                    if(validateNullAndBlanks(meal.strMeasure12))stringBuilderRecipeDetails.append("Measure12 :- ${meal.strMeasure12}\n")
                    if(validateNullAndBlanks(meal.strMeasure13))stringBuilderRecipeDetails.append("Measure13 :- ${meal.strMeasure13}\n")
                    if(validateNullAndBlanks(meal.strMeasure14))stringBuilderRecipeDetails.append("Measure14 :- ${meal.strMeasure14}\n")
                    if(validateNullAndBlanks(meal.strMeasure15))stringBuilderRecipeDetails.append("Measure15 :- ${meal.strMeasure15}\n")
                    if(validateNullAndBlanks(meal.strMeasure16))stringBuilderRecipeDetails.append("Measure16 :- ${meal.strMeasure16}\n")
                    if(validateNullAndBlanks(meal.strMeasure17))stringBuilderRecipeDetails.append("Measure17 :- ${meal.strMeasure17}\n")
                    if(validateNullAndBlanks(meal.strMeasure18))stringBuilderRecipeDetails.append("Measure18 :- ${meal.strMeasure18}\n")
                    if(validateNullAndBlanks(meal.strMeasure19))stringBuilderRecipeDetails.append("Measure19 :- ${meal.strMeasure19}\n")
                    if(validateNullAndBlanks(meal.strMeasure20))stringBuilderRecipeDetails.append("Measure20 :- ${meal.strMeasure20}\n")
                    stringBuilderRecipeDetails.append("\n****************************************************************************************************")
                    stringBuilderRecipeDetails.append("\n\n")
                }
            }
            textViewMeals.text = stringBuilderRecipeDetails.toString()
        }
        mealSearchBtn.setOnClickListener {
            myNonSuspendFunction()
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("textViewMealsText", textViewMeals.text.toString())
    }

    private fun validateNullAndBlanks(strings: String?): Boolean{
        return if (strings == "null")
            false
        else !(strings == "" || strings == " ")
    }
}