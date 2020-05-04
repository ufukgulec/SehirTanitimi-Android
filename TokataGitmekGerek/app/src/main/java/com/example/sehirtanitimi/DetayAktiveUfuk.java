package com.example.sehirtanitimi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetayAktiveUfuk extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detay_aktive_ufuk);
        Intent intent=getIntent();
        String gelenaciklama=intent.getStringExtra("aciklama");
        String gelenBaslik=intent.getStringExtra("baslik");
        String gelenResim=intent.getStringExtra("resim");
        TextView aciklama=(TextView)findViewById(R.id.paragraf);
        TextView baslik=(TextView)findViewById(R.id.gelenBaslik);
        aciklama.setText(gelenaciklama);
        baslik.setText(gelenBaslik);
        ImageView bResim=(ImageView)findViewById(R.id.bResim);
        Picasso.with(this).load(gelenResim).into(bResim);
    }
}
