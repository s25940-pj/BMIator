package com.example.bmiator;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.bmiator.model.ShoppingItem;

import java.util.List;

public class ShoppingListAdapter extends RecyclerView.Adapter<ShoppingListAdapter.ViewHolder> {

    private List<ShoppingItem> shoppingItems;

    public ShoppingListAdapter(List<ShoppingItem> shoppingItems) {
        this.shoppingItems = shoppingItems;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shopping_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ShoppingItem item = shoppingItems.get(position);
        holder.nameTextView.setText(item.getName());
        holder.checkBox.setChecked(item.isChecked());

        holder.checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> item.setChecked(isChecked));
    }

    @Override
    public int getItemCount() {
        return shoppingItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        CheckBox checkBox;

        public ViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.item_name);
            checkBox = itemView.findViewById(R.id.item_checkbox);
        }
    }
}
