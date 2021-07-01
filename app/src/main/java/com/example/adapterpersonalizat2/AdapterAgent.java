package com.example.adapterpersonalizat2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class AdapterAgent extends ArrayAdapter<AgentVanzari> {

    Context context;
    List<AgentVanzari>  agenti;
    LayoutInflater layoutInflater;
    int resource;

    public AdapterAgent(@NonNull Context context, int resource, @NonNull List<AgentVanzari> objects, LayoutInflater layoutInflater) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.agenti=objects;
        this.layoutInflater=layoutInflater;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view= layoutInflater.inflate(resource, parent, false);
        AgentVanzari agent=agenti.get(position);
        if(agent!=null)
        {
            TextView tv1= view.findViewById(R.id.tv_nume);
            tv1.setText(agent.getNume());

            TextView tv2= view.findViewById(R.id.tv_oras);
            tv2.setText(agent.getOras());

            TextView tv3= view.findViewById(R.id.tv_procent);
            tv3.setText(String.valueOf(agent.getProcent_vanzari()+""));

            Button btnClasificare = view.findViewById(R.id.btnClasificare);
            Button btnEditare = view.findViewById(R.id.btnEditare);

            btnClasificare.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //daca procentul este mai mic de 50%, itemul are culaorea rosie
                    if(agent.getProcent_vanzari() < 50){
                        view.setBackgroundColor(Color.RED);
                    }
                    else if(agent.getProcent_vanzari() < 66)
                        view.setBackgroundColor(Color.rgb(255, 165, 0));
                    else view.setBackgroundColor(Color.GREEN);
                }
            });

            btnEditare.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //modifica
                    Intent intent = new Intent(context, AdaugaAgentActivity.class);
                    intent.putExtra("pozitie",position);
                    intent.putExtra("agent",agent);
                    ((Activity)context).startActivityForResult(intent,11);
                }
            });

        }
        return view;
    }
}
