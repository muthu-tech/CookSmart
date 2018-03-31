package com.smartcook.smartcook.Pages;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.smartcook.smartcook.DBManager.ModelQueryManager;
import com.smartcook.smartcook.Models.Items;
import com.smartcook.smartcook.R;

import java.util.ArrayList;
import java.util.Date;

public class CaptureActivity extends AppCompatActivity {

    private TextView mCaptured;
    private Button mSubmitButton;

    String det = "";
    String nw = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capture);

        mCaptured = (TextView)findViewById(R.id.capture_Details);
        mSubmitButton = (Button)findViewById(R.id.capture_Submit);
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DisplayRecipActivity.class);
                intent.putExtra("Item", det);
                intent.putExtra("Item2", nw);
                startActivity(intent);

            }
        });



        ArrayList<String> capt = (ArrayList<String>)getIntent().getStringArrayListExtra("Item");
        for(int i = 0; i< capt.size(); i++){
            det = det + "\n" +capt.get(i);
            nw = nw +" " +capt.get(i);
        }

        mCaptured.setText(det);



        Date date = new Date();
        String dt = date.toString();
        Items itms = new Items(dt, det);

        ModelQueryManager.get(this.getApplicationContext()).createItem(itms);

    }
}
