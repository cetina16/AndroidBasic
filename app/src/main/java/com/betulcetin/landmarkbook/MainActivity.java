package com.betulcetin.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
//deneme

public class MainActivity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

       final ArrayList <String> heads = new ArrayList<>();
        heads.add("Planlama yapıyorum");
        heads.add("Dikkatimi dağıtmıyorum");
        heads.add("Etkili molalar veriyorum");
        heads.add("Hedefsiz çalışmıyorum");
        heads.add("Çay-kahve bahanesi üretmiyorum");


        final ArrayList <String> texts = new ArrayList<>();
        texts.add("Çalışmaya başlamadan önce mutlaka günümü planlıyorum, neye ne kadar zaman vereceğimi önceden belirlemek çok işe yarıyor.");
        texts.add("Kronometre kullanmak ve çalışma alanımı sakin tutmak dikkatim dağılmasına engel oluyor.");
        texts.add("Molalarımda ekrana bakmamaya ve temiz hala almak için pencereye/balkona çıkmaya özen gösteriyorum.");
        texts.add("Her zaman ulaşmam gereken bir amaç var çünkü hedefsiz motive olamıyorum.");
        texts.add("Sık sık kahve/çay için kalkma ihtiyacı hissetsem de günlük çay/kahve miktarımı sınırlamaya gayret ediyorum, onun yerine masamda her zaman su bulunduruyorum.");

        Bitmap plan = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.plan);
        Bitmap tel = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.tel);
        Bitmap breakfoto = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.breakfoto);
        Bitmap hedef = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.hedef);
        Bitmap bahane = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.bahane);

        final ArrayList<Bitmap> images = new ArrayList<>();
        images.add(plan);
        images.add(tel);
        images.add(breakfoto);
        images.add(hedef);
        images.add(bahane);



        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,heads);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(),DetailActivity.class);
                intent.putExtra("name",heads.get(i));
                intent.putExtra("text1",texts.get(i));

                Singleton singleton = Singleton.getInstance();
                singleton.setChosenImage(images.get(i));

                startActivity(intent);
            }
        });
    }
}