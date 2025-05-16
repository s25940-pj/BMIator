package com.example.bmiator;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bmiator.model.Recipe;
import com.example.bmiator.model.ShoppingItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Activity showing recipe suggestions based on diet types.
 */
public class RecipeRecommendationActivity extends AppCompatActivity {

    TextView recipeText;
    RecyclerView shoppingListRecyclerView;
    ShoppingListAdapter shoppingListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_recommendation);

        recipeText = findViewById(R.id.recipeText);
        shoppingListRecyclerView = findViewById(R.id.shoppingListRecyclerView);

        List<Recipe> recipes = getRecommendedRecipes();
        StringBuilder builder = new StringBuilder();

        for (Recipe r : recipes) {
            builder.append("🍽 ").append(r.title).append("\n")
                    .append("Calories: ").append(r.calories).append(" kcal\n")
                    .append("Diet: ").append(r.dietType).append("\n\n")
                    .append(r.description).append("\n\n---\n\n");
        }

        recipeText.setText(builder.toString());


        shoppingListRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        shoppingListAdapter = new ShoppingListAdapter(getShoppingItems());
        shoppingListRecyclerView.setAdapter(shoppingListAdapter);
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

    private List<ShoppingItem> getShoppingItems() {
        List<ShoppingItem> items = new ArrayList<>();

        items.add(new ShoppingItem("3 eggs"));
        items.add(new ShoppingItem("Spinach"));
        items.add(new ShoppingItem("Tomatoes"));
        items.add(new ShoppingItem("Feta cheese"));
        items.add(new ShoppingItem("Olive oil"));

        return items;
    }
}
