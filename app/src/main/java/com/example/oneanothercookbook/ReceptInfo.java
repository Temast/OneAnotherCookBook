package com.example.oneanothercookbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;

public class ReceptInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recept_info);

        //получаем Intent, с помощью которого запущен Activity
        Intent intent = getIntent();

        //извлекаем информацию
        String receptJson = intent.getStringExtra("receptJson");

        //создаем объект для сериализации рецепта
        Gson gson = new Gson();

        //десиарилизуем объект класса
        ReceptBluda rb = gson.fromJson(receptJson, ReceptBluda.class);

        // Вывод информации по рецепту на Activity

        //TextView nazv = (TextView)findViewById(R.id.textViewNazv);
//        nazv.setText(rb.getNazvanie());
//
//        TextView opis = (TextView)findViewById(R.id.textViewOpisanie);
//        opis.setText(rb.getPolnoeOpisanie());

    }
}
