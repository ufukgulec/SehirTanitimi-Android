package com.example.sehirtanitimi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.sehirtanitimi.model.mekan;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    HttpHandler httpHandler;
    ProgressDialog progressDialog;
    private static String URL="https://raw.githubusercontent.com/ufukgulec/MP/master/mekanlar.json";
    ArrayList<mekan> mekanlistesi;
    ListView liste;
    TokatAdaptorUfuk adaptor;
    mekan detayMekan=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        liste=(ListView)findViewById(R.id.liste);
        new getMekan().execute();

        liste.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent =new Intent(MainActivity.this,DetayAktiveUfuk.class);
                detayMekan=(mekan)parent.getItemAtPosition(position);
                intent.putExtra("resim",detayMekan.getResim());
                intent.putExtra("baslik",detayMekan.getBaslik());
                intent.putExtra("aciklama",detayMekan.getParagraf());//getParagraf
                startActivity(intent);
            }
        });


    }
    private class getMekan extends AsyncTask<Void,Void,Void>{
        ArrayList<mekan> mekanlistesi=new ArrayList<>();
        @Override
        protected void onPreExecute() {//İşlem başladıgında.....
            super.onPreExecute();
            progressDialog=new ProgressDialog(MainActivity.this);
            progressDialog.setMessage("Lütfen Bekleyiniz.");
            progressDialog.setCancelable((false));
            progressDialog.show();
        }


        @Override
        protected void onPostExecute(Void aVoid) {//İşlem tamamlandıgında....
            super.onPostExecute(aVoid);
            adaptor=new TokatAdaptorUfuk(MainActivity.this,mekanlistesi);
            liste.setAdapter(adaptor);
            if (progressDialog.isShowing()){
                progressDialog.dismiss();
            }
        }

        @Override
        protected Void doInBackground(Void... voids) {//İşlemin gerçekleştigi zmaan
            httpHandler=new HttpHandler();
            String json=httpHandler.makeServiceCall(URL);
            Log.d("JSON_RESPONSE",json);
            if (json!=null){

                try {
                    JSONObject jsonObject=new JSONObject(json);
                    JSONArray mekanlar=jsonObject.getJSONArray("mekanlar");

                    for (int i=0;i<mekanlar.length();i++){
                        JSONObject mekan=mekanlar.getJSONObject(i);
                        String baslik=mekan.getString("baslik");
                        String tarih=mekan.getString("tarih");
                        String aciklama=mekan.getString("aciklama");
                        String resim=mekan.getString("resim");
                        String paragraf=mekan.getString("paragraf");//********************
                        mekan mkn=new mekan(baslik,tarih,aciklama,resim,paragraf);//***************
                        mekanlistesi.add(mkn);
                    }
                }catch (Exception e){

                }
            }else Log.d("JSON_RESPONSE","Sayfa kaynagı bos");
            return null;
        }
    }
}
