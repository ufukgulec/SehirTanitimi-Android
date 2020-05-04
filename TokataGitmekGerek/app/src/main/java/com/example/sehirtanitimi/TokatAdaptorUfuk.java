package com.example.sehirtanitimi;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sehirtanitimi.model.mekan;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class TokatAdaptorUfuk extends BaseAdapter {
    Context context;
    ArrayList<mekan> mekanlar;
    LayoutInflater inflater;


    public TokatAdaptorUfuk(Activity activity,ArrayList<mekan> mekanlar){
    this.context=activity;
    this.mekanlar=mekanlar;
    this.inflater=(LayoutInflater)context.getSystemService(Service.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        //listviewde gösterilecek satır sayısı
        return mekanlar.size();
    }

    @Override
    public Object getItem(int position) {
        //position ile sırası gelen eleman döner
        return mekanlar.get(position);
    }

    @Override
    public long getItemId(int position) {
        //varsa niteliyeci id bilgisi
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //position ile sırası gelen satır için bir view döndürür
        inflater=LayoutInflater.from(context);
        View satirlarim= inflater.inflate(R.layout.satirlarim,null);
        ImageView resim=(ImageView)satirlarim.findViewById(R.id.kResim);
        TextView baslik=(TextView)satirlarim.findViewById(R.id.baslik);
        TextView tarih=(TextView)satirlarim.findViewById(R.id.tarih);
        TextView aciklama=(TextView)satirlarim.findViewById(R.id.aciklama);
        TextView paragraf=(TextView)satirlarim.findViewById(R.id.paragraf1);//****************
        baslik.setText(mekanlar.get(position).getBaslik());
        tarih.setText(mekanlar.get(position).getTarih());
        aciklama.setText(mekanlar.get(position).getAciklama());
        paragraf.setText(mekanlar.get(position).getParagraf());//*******************
        Picasso.with(context).load(mekanlar.get(position).getResim()).into(resim);
       // Picasso.get().load(mekanlar.get(position).getResim()).into(resim);
        return satirlarim;
    }

}
