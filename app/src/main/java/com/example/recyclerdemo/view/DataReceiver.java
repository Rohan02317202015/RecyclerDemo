package com.example.recyclerdemo.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.recyclerdemo.Constants;
import com.example.recyclerdemo.R;
import com.example.recyclerdemo.model.Data;

public class DataReceiver extends AppCompatActivity {
   private TextView mTextName,mTextAbout;
   private Data data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_receiver);
        mTextName = findViewById(R.id.txt_name);
        mTextAbout = findViewById(R.id.txt_about);
        bindData();
    }

    private void bindData() {
       if(getIntent()!=null && getIntent().getParcelableExtra(Constants.CommonConstants.DATA)!=null) {
           data = (Data)getIntent().getParcelableExtra(Constants.CommonConstants.DATA);
           mTextName.setText(data.getName());
           mTextAbout.setText(data.getAboutYou());
       }
    }
}
