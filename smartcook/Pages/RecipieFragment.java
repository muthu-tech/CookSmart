package com.smartcook.smartcook.Pages;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.smartcook.smartcook.Models.Items;
import com.smartcook.smartcook.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecipieFragment extends Fragment {

    private ImageView mRecipeImageView;
    private TextView mRecipeNameTextView;
    private TextView mRecipeDetails;

    private Items mItems;

    public RecipieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recipie, container, false);

        mItems = (Items)getArguments().getSerializable("Items");
        String recipeDetail = mItems.getReceipeSuggestion();
        String recipeName = mItems.getRecipeName();

        mRecipeImageView = (ImageView)view.findViewById(R.id.Recipe_Image);
        mRecipeNameTextView = (TextView)view.findViewById(R.id.Recipe_name);
        mRecipeDetails = (TextView)view.findViewById(R.id.Recipe_details);

        mRecipeNameTextView.setText(recipeName);
        mRecipeDetails.setText(recipeDetail);


        return view;
    }

}
