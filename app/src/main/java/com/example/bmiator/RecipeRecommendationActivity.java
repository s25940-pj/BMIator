package com.example.bmiator;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bmiator.model.Recipe;

import java.util.ArrayList;
import java.util.List;

/**
 * Activity showing recipe suggestions based on diet types.
 */
public class RecipeRecommendationActivity extends AppCompatActivity {

    TextView recipeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_recommendation);

        recipeText = findViewById(R.id.recipeText);

        List<Recipe> recipes = getRecommendedRecipes();
        StringBuilder builder = new StringBuilder();

        for (Recipe r : recipes) {
            builder.append("🍽 ").append(r.title).append("\n")
                    .append("Calories: ").append(r.calories).append(" kcal\n")
                    .append("Diet: ").append(r.dietType).append("\n\n")
                    .append(r.description).append("\n\n---\n\n");
        }

        recipeText.setText(builder.toString());
    }

    private List<Recipe> getRecommendedRecipes() {
        List<Recipe> list = new ArrayList<>();

        list.add(new Recipe(
                "High Protein Omelette",
                "3 eggs, spinach, tomatoes, feta cheese. Fry everything together with olive oil. Great for muscle building.",
                450,
                "High Protein"));

        list.add(new Recipe(
                "Vegan Oatmeal Bowl",
                "Oats with almond milk, chia seeds, banana, and peanut butter. Quick and rich in fiber.",
                400,
                "Vegan"));

        return list;
    }
}
