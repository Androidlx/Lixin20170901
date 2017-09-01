package com.example.lixin.lixin20170901;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MyCustomView.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyCustomView customView = (MyCustomView) findViewById(R.id.custom);
        customView.setOnClickListener(this);
    }

    @Override
    public void onClickListener(View view) {
        startActivity(new Intent(this, SecondActivity.class));
    }
}
