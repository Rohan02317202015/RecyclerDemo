package com.example.recyclerdemo.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.recyclerdemo.Constants;
import com.example.recyclerdemo.R;
import com.example.recyclerdemo.model.Data;

import org.w3c.dom.Text;

public class DataSenderView extends AppCompatActivity {
    private EditText name, about;
    private Data model = new Data();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_sender_view);
        init();
    }

    private void init() {
        name = findViewById(R.id.et_name);
        about = findViewById(R.id.et_about);
        findViewById(R.id.btn_send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()) {
                    Intent i = new Intent(DataSenderView.this, DataReceiver.class);
                    i.putExtra(Constants.CommonConstants.DATA, model);
                    startActivity(i);
                } else {
                    Toast.makeText(DataSenderView.this, "Fill all fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean validate() {
        if (TextUtils.isEmpty(name.getText().toString())) {
            return false;
        }

        if (TextUtils.isEmpty((about.getText().toString()))) {
            return false;
        }

        model.setAboutYou(about.getText().toString());
        model.setName(name.getText().toString());
        return true;
    }
}
