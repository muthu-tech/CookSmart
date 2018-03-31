package com.smartcook.smartcook.Pages;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.smartcook.smartcook.DBManager.ModelQueryManager;
import com.smartcook.smartcook.Models.Items;
import com.smartcook.smartcook.R;

import java.util.ArrayList;
import java.util.List;

public class DisplayRecipActivity extends AppCompatActivity {

    private TextView mNameTextView;
    private TextView mDetailTextView;
    private TextView mDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_recip);

        mNameTextView = (TextView)findViewById(R.id.Display_Name);
        mDetailTextView = (TextView)findViewById(R.id.Display_Details);
        mDescription = (TextView)findViewById(R.id.Display_Desc);

        String items = getIntent().getStringExtra("Item");
        String items2 = getIntent().getStringExtra("Item2");

        String[] input = new String[1];
        input[0] = items2;
        List<Items> itm = ModelQueryManager.get(getApplicationContext()).getItem(input);

        if(itm.size() == 0){
            Toast.makeText(getApplicationContext(), "NOT Found", Toast.LENGTH_LONG).show();
        }
        else{
            Items newItem = itm.get(0);
            mNameTextView.setText(newItem.getRecipeName());
            mDetailTextView.setText(newItem.getReceipeSuggestion());
            mDescription.setText(newItem.getDirections());
        }


    }
}
