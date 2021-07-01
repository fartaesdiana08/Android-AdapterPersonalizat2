package com.example.adapterpersonalizat2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnAdd;
    ListView listView;
    final int CODE = 100;

    public Intent intent;
    List<AgentVanzari> listaAgenti = new ArrayList<>();

    AdapterAgent adapter;

    EditText filtrare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);
        btnAdd = findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AdaugaAgentActivity.class);
                startActivityForResult(intent, CODE);
            }
        });

        //adapter
        adapter = new AdapterAgent(this, R.layout.row_item, listaAgenti, getLayoutInflater());
        listView.setAdapter(adapter);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CODE && resultCode == RESULT_OK) {
            AgentVanzari agent1 = (AgentVanzari) data.getExtras().getSerializable("agent");
            listaAgenti.add(agent1);
            adapter.notifyDataSetChanged();
            Toast.makeText(this, agent1.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}

