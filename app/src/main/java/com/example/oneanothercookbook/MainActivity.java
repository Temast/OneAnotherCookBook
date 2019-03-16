package com.example.oneanothercookbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<ReceptBluda> spisokReceptov;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO: переделать под загрузку из Интернета

        spisokReceptov = new ArrayList<ReceptBluda>();

        ReceptBluda recept = new ReceptBluda("Омлет","Описание","Описание");
        recept.setFoto("omlet.png");

        ArrayList<IngredientRecepta> ingredients = new ArrayList<IngredientRecepta>();

        IngredientRecepta ingredient = new IngredientRecepta("Яйцо куриное",6.0,"шт.");
        ingredients.add(ingredient);
        ingredient = new IngredientRecepta("Молоко",200.0,"мл");
        ingredients.add(ingredient);
        ingredient = new IngredientRecepta("Соль повареная");
        ingredients.add(ingredient);

        recept.setIngredienty(ingredients);

        spisokReceptov.add(recept);

        /*ArrayList<String> nazvaniia = new ArrayList<String>();

        for (ReceptBluda rb: spisokReceptov){
            nazvaniia.add(rb.getNazvanie());
        }*/

        //Gson gson = new Gson();
        //MyClass myClass = gson.fromJson(jsonString, MyClass.class);

        // находим список
        ListView spisokView = (ListView) findViewById(R.id.spisok);

        // создаем адаптеp
        ArrayAdapter<ReceptBluda> adapter = new ArrayAdapter<ReceptBluda>(this,android.R.layout.simple_list_item_1, spisokReceptov);
        // присваиваем адаптер списку
        spisokView.setAdapter(adapter);

        spisokView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //создаем объект для сериализации рецепта
                Gson gson = new Gson();

                //получаем объект-рецепт, на который нажал пользователь
                ReceptBluda recept = (ReceptBluda) ( (ListView) findViewById(R.id.spisok) ).getSelectedItem();

                //сериализуем объект recept в строку gson
                String receptJson = gson.toJson(recept);

                //создаем Intent для перехода в Activity ReceprInfo
                Intent i = new Intent(MainActivity.this,ReceptInfo.class);

                Log.d("json", receptJson);

                //добавляем данные
                i.putExtra("receptJson","problem" );

                startActivity(i);
                //Log.d(LOG_TAG, "itemClick: position = " + position + ", id = "+ id);
            }
        });

    }
}
