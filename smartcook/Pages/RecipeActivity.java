package com.smartcook.smartcook.Pages;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.smartcook.smartcook.Models.Items;
import com.smartcook.smartcook.R;

public class RecipeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        Items items = (Items)getIntent().getSerializableExtra("Item");

        RecipieFragment frag = new RecipieFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("Item", items);
        frag.setArguments(bundle);

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.Recipie_frag, frag)
                .commit();
    }
}
