package com.example.recyclerdemo.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.recyclerdemo.adapters.ItemAdapter;
import com.example.recyclerdemo.viewmodel.MainViewModel;
import com.example.recyclerdemo.R;
import com.example.recyclerdemo.database.Item;

import java.util.List;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {
    private static final int NEW_DATA_REQUEST_CODE = 100;
    private MainViewModel mainViewModel;
    private RecyclerView recyclerView;
    private ItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.rv_list);
        adapter = new ItemAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NewDataActivity.class);
                startActivityForResult(intent, NEW_DATA_REQUEST_CODE);
            }
        });
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mainViewModel.getAllItems().observe(this, new Observer<List<Item>>() {
            @Override
            public void onChanged(@Nullable List<Item> items) {
                adapter.updateItems(items);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_switch:
                Intent i = new Intent(MainActivity.this,DataSenderView.class);
                startActivity(i);
                break;
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_DATA_REQUEST_CODE && resultCode == RESULT_OK) {
            final String item_id = UUID.randomUUID().toString();
            Item item = new Item(item_id, data.getStringExtra(NewDataActivity.NOTE_ADDED));
            mainViewModel.insert(item);
            Toast.makeText(this, "Successfully Saved", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();

        }
    }
}
