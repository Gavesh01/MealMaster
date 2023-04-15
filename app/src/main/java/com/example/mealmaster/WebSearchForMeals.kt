package com.example.mealmaster

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.json.JSONObject
import java.net.URL

class WebSearchForMeals : AppCompatActivity(){

    private lateinit var textViewMeals: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.web_search_for_meals)


        var searchIngredientText  = findViewById<EditText>(R.id.search_web_meals_bar)
        var retrieveMealsButton  = findViewById<Button>(R.id.search_web_meals_btn)
        textViewMeals  = findViewById(R.id.search_web_meals_text_view)

        if (savedInstanceState != null) {
            textViewMeals.text = savedInstanceState.getString("textViewMealsText", "")
        }

        retrieveMealsButton.setOnClickListener{
            val searchIngredient = searchIngredientText.text.toString()

            runBlocking {
                launch {
                    withContext(Dispatchers.IO){
                        val mealList: List<Meal> = searchMealRecipeByIngredient(searchIngredient)

                        for (i in mealList ){
                            Log.d("meal name - ********************************",i.strMeal.toString())
                        }
                        val stringBuilderMealRecipes: StringBuilder = displayRecipeOnTextView(mealList)

                        runOnUiThread{
                            if (stringBuilderMealRecipes.isNotEmpty()){
                                textViewMeals.text = stringBuilderMealRecipes.toString()
                            }else{
                                textViewMeals.text = "Can't find any related meals"
                            }
                        }
                    }
                }
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("textViewMealsText", textViewMeals.text.toString())
    }



    // this method use for display recipes on textview
    private fun displayRecipeOnTextView(mealList: List<Meal>): StringBuilder{
        // use StringBuilder object to hold recipeDetails
        val stringBuilderRecipeDetails = StringBuilder()
        for (meal in mealList){
            stringBuilderRecipeDetails.append("Meal :- ${meal.strMeal}\n")
            stringBuilderRecipeDetails.append("DrinkAlternate :- ${meal.strDrinkAlternate}\n")
            stringBuilderRecipeDetails.append("Category :- ${meal.strCategory}\n")
            stringBuilderRecipeDetails.append("Area :- ${meal.strArea}\n")
            stringBuilderRecipeDetails.append("Instructions :- ${meal.strInstructions}\n")
            stringBuilderRecipeDetails.append("strMealThumb :- ${meal.strMealThumb}\n")
            stringBuilderRecipeDetails.append("Tags :- ${meal.strTags}\n")
            stringBuilderRecipeDetails.append("Youtube :- ${meal.strYoutube}\n")
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
            stringBuilderRecipeDetails.append("\n\n")

        }
        return stringBuilderRecipeDetails
    }



    private fun validateNullAndBlanks(strings: String?): Boolean{
        return if (strings == "null")
            false
        else !(strings == "" || strings == " ")
    }
}

private fun searchMealRecipeByIngredient(ingredients: String): List<Meal>{

    // here can't access fully details in one step.
    // first get meals summery, by filtering their ingredients.
    // ------
    val url = URL("https://www.themealdb.com/api/json/v1/$apiKeyNumber/search.php?s=$ingredients")
    val jsonString = url.readText()
    val jsonObject = JSONObject(jsonString)
    val mealsArray = jsonObject.getJSONArray("meals")
    val detailsOfRecipe = mutableListOf<Meal>()
//    val urlSummary = URL("https://www.themealdb.com/api/json/v1/$apiKeyNumber/filter.php?i=$ingredients")
//    // read what api returned
//    val jsonStringOutSummery = urlSummary.readText()
//    // convert output to the Json objects
//    val summeryInJsonForm = JSONObject(jsonStringOutSummery)
//    // get Json array called meals
//    val mealsSummery = summeryInJsonForm.getJSONArray("meals")
//    // create a mutable list object to hold Meal instances.
//    val detailsOfRecipe = mutableListOf<Meal>()

    for (i in 0 until mealsArray.length()){
        val detailsOfTheMeal =  mealsArray.getJSONObject(i)
        // get meal id
        val idMeal = detailsOfTheMeal.getInt("idMeal")

        val url = URL("https://www.themealdb.com/api/json/v1/$apiKeyNumber/lookup.php?i=$idMeal")

        val jsonStrings = url.readText()
        // convert output to the Json objects
        val jsonOb = JSONObject(jsonStrings)

        // get Json array called meals
        val meals = jsonOb.getJSONArray("meals")

        for (i in 0 until meals.length()){
            // getting meal by meal
            val meal = meals.getJSONObject(i)
            val idMeal = meal.getInt("idMeal")
            val strMeal = meal.getString("strMeal")
            val strDrinkAlternate = meal.getString("strDrinkAlternate")
            val strCategory = meal.getString("strCategory")
            val strArea = meal.getString("strArea")
            val strInstructions = meal.getString("strInstructions")
            val strMealThumb = meal.getString("strMealThumb")
            val strTags = meal.getString("strTags")
            val strYoutube = meal.getString("strYoutube")
            val strIngredient1 = meal.getString("strIngredient1")
            val strIngredient2 = meal.getString("strIngredient2")
            val strIngredient3 = meal.getString("strIngredient3")
            val strIngredient4 = meal.getString("strIngredient4")
            val strIngredient5 = meal.getString("strIngredient5")
            val strIngredient6 = meal.getString("strIngredient6")
            val strIngredient7 = meal.getString("strIngredient7")
            val strIngredient8 = meal.getString("strIngredient8")
            val strIngredient9 = meal.getString("strIngredient9")
            val strIngredient10 = meal.getString("strIngredient10")
            val strIngredient11 = meal.getString("strIngredient11")
            val strIngredient12 = meal.getString("strIngredient12")
            val strIngredient13 = meal.getString("strIngredient13")
            val strIngredient14 = meal.getString("strIngredient14")
            val strIngredient15 = meal.getString("strIngredient15")
            val strIngredient16 = meal.getString("strIngredient16")
            val strIngredient17 = meal.getString("strIngredient17")
            val strIngredient18 = meal.getString("strIngredient18")
            val strIngredient19 = meal.getString("strIngredient19")
            val strIngredient20 = meal.getString("strIngredient20")
            val strMeasure1 = meal.getString("strMeasure1")
            val strMeasure2 = meal.getString("strMeasure2")
            val strMeasure3 = meal.getString("strMeasure3")
            val strMeasure4 = meal.getString("strMeasure4")
            val strMeasure5 = meal.getString("strMeasure5")
            val strMeasure6 = meal.getString("strMeasure6")
            val strMeasure7 = meal.getString("strMeasure7")
            val strMeasure8 = meal.getString("strMeasure8")
            val strMeasure9 = meal.getString("strMeasure9")
            val strMeasure10 = meal.getString("strMeasure10")
            val strMeasure11 = meal.getString("strMeasure11")
            val strMeasure12 = meal.getString("strMeasure12")
            val strMeasure13 = meal.getString("strMeasure13")
            val strMeasure14 = meal.getString("strMeasure14")
            val strMeasure15 = meal.getString("strMeasure15")
            val strMeasure16 = meal.getString("strMeasure16")
            val strMeasure17 = meal.getString("strMeasure17")
            val strMeasure18 = meal.getString("strMeasure18")
            val strMeasure19 = meal.getString("strMeasure19")
            val strMeasure20 = meal.getString("strMeasure20")
            val strSource = meal.getString("strSource")
            val strImageSource = meal.getString("strImageSource")
            val strCreativeCommonsConfirmed = meal.getString("strCreativeCommonsConfirmed")
            val dateModified = meal.getString("dateModified")

            detailsOfRecipe.add(
                Meal(
                    idMeal,
                    strMeal,
                    strDrinkAlternate,
                    strCategory,
                    strArea,
                    strInstructions,
                    strMealThumb,
                    strTags,
                    strYoutube,
                    strIngredient1,
                    strIngredient2,
                    strIngredient3,
                    strIngredient4,
                    strIngredient5,
                    strIngredient6,
                    strIngredient7,
                    strIngredient8,
                    strIngredient9,
                    strIngredient10,
                    strIngredient11,
                    strIngredient12,
                    strIngredient13,
                    strIngredient14,
                    strIngredient15,
                    strIngredient16,
                    strIngredient17,
                    strIngredient18,
                    strIngredient19,
                    strIngredient20,
                    strMeasure1,
                    strMeasure2,
                    strMeasure3,
                    strMeasure4,
                    strMeasure5,
                    strMeasure6,
                    strMeasure7,
                    strMeasure8,
                    strMeasure9,
                    strMeasure10,
                    strMeasure11,
                    strMeasure12,
                    strMeasure13,
                    strMeasure14,
                    strMeasure15,
                    strMeasure16,
                    strMeasure17,
                    strMeasure18,
                    strMeasure19,
                    strMeasure20,
                    strSource,
                    strImageSource,
                    strCreativeCommonsConfirmed,
                    dateModified
                )
            )
        }
    }
    return detailsOfRecipe
}