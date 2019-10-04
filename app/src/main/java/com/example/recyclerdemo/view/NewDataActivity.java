package com.example.recyclerdemo.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.example.recyclerdemo.R;

public class NewDataActivity extends AppCompatActivity {
    public static String NOTE_ADDED;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_data);
        editText = findViewById(R.id.input_et);

        findViewById(R.id.btn_submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                if (TextUtils.isEmpty(editText.getText())) {
                    setResult(RESULT_CANCELED, resultIntent);
                } else {
                    String item = editText.getText().toString();
                    resultIntent.putExtra(NOTE_ADDED, item);
                    setResult(RESULT_OK, resultIntent);
                }
                finish();
            }
        });
    }
}
