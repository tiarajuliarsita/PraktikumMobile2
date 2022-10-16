package com.f55121053_tiara.f55121053;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private String[]data_Name;
    private String[]datadescription;
    private TypedArray dataphoto;
    private HeroAdapter adapter;
    private ArrayList<Hero> heroes;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new HeroAdapter(this);
        ListView listView = findViewById(R.id.lv_list);
        listView.setAdapter(adapter);
        prepare();
        additems();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?>adapterView, View view, int i, long l){
                Toast.makeText(MainActivity.this,heroes.get(i).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void prepare(){
        data_Name=getResources().getStringArray(R.array.data_name);
        datadescription=getResources().getStringArray(R.array.data_description);
        dataphoto=getResources().obtainTypedArray(R.array.data_photo);
    }

    private void additems(){
        heroes= new ArrayList<>();

        for (int i =0; i< data_Name.length; i++){
            Hero hero = new Hero();
            hero.setPhoto(dataphoto.getResourceId(i, -1));
            hero.setName(data_Name[i]);
            hero.setDescription(datadescription[i]);
            heroes.add(hero);


        }
        adapter.setHeroes(heroes);



    }



}