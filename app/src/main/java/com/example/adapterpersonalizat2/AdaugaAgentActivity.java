package com.example.adapterpersonalizat2;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TimePicker;
import android.widget.Toast;

public class AdaugaAgentActivity extends AppCompatActivity {

    EditText nume_agent;
    EditText oras;
    CheckBox este_barbat;
    SeekBar procent_vanzari;
    TimePicker ora_incepere;

    Button btnSalveaza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adauga_agent);

        nume_agent=findViewById(R.id.nume);
        oras=findViewById(R.id.oras);
        este_barbat=findViewById(R.id.barbat);
        procent_vanzari=findViewById(R.id.seek_bar);
        ora_incepere=findViewById(R.id.ora_start);

        btnSalveaza=findViewById(R.id.btnSalveaza);

        btnSalveaza.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                if(nume_agent.getText().toString().isEmpty())
                {
                    Toast.makeText(AdaugaAgentActivity.this, R.string.error1,Toast.LENGTH_SHORT).show();
                }
                else if(oras.getText().toString().isEmpty() )
                {
                    Toast.makeText(AdaugaAgentActivity.this, R.string.error2,Toast.LENGTH_SHORT).show();
                }
                else{
                    String txt_nume=nume_agent.getText().toString();
                    String txt_oras=oras.getText().toString();
                    boolean txt_barbat=este_barbat.isChecked();
                    int txt_procent=procent_vanzari.getProgress();
                    int txt_ora=ora_incepere.getHour();

                    AgentVanzari agentV=new AgentVanzari(txt_nume,txt_oras,txt_barbat,txt_procent,txt_ora);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("agent",agentV);

                    Intent intent = new Intent();
                    intent.putExtras(bundle);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });
    }
}