package com.f55121053_tiara.f55121053;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
                if (i==0){
                    //clicked Rahmad_Dg_Matutu
                    startActivity(new Intent( MainActivity.this, Tiara_053.class ));
                }
                else if (i==1){
                    //clicked Ahmad_dahlan
                    startActivity(new Intent( MainActivity.this, Ahmad_Dahlan.class ));
                }
                else if (i==2){
                    //clicked Ahmad_Yani
                    startActivity(new Intent( MainActivity.this, Ahmad_Yani.class ));
                }
                else if (i==3){
                    //clicked Bung_Tomo
                    startActivity(new Intent( MainActivity.this, Bung_Tomo.class ));
                }
                else if (i==4){
                    //clicked Gatot_Subroto
                    startActivity(new Intent( MainActivity.this, Gatot_Subroto.class ));
                }
                else if (i==5){
                    //clicked Ki_Hajar_Dewantara
                    startActivity(new Intent( MainActivity.this, Ki_Hajar_Dewantara.class ));
                }
                else if (i==6){
                    //clicked Mohammad_Hatta
                    startActivity(new Intent( MainActivity.this, Mohammad_Hatta.class ));
                }
                else if (i==7){
                    //clicked Soekarno
                    startActivity(new Intent( MainActivity.this, Soekarno.class ));
                }
                else if (i==8){
                    //clicked Sudirman
                    startActivity(new Intent( MainActivity.this, Sudirman.class ));
                }
                else if (i==9){
                    //clicked Supomo
                    startActivity(new Intent( MainActivity.this, Supomo.class ));
                }
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