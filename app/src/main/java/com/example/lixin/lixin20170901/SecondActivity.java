package com.example.lixin.lixin20170901;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by hua on 2017/9/1.
 */

public class SecondActivity extends AppCompatActivity implements MyCustomView.OnClickListener {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        MyCustomView second_custom = (MyCustomView) findViewById(R.id.second_custom);
        second_custom.setOnClickListener(this);
    }

    @Override
    public void onClickListener(View icon) {
        SecondActivity.this.finish();
    }
}
