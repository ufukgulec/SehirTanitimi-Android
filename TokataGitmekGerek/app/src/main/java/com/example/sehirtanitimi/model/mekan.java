package com.example.sehirtanitimi.model;

public class mekan {
    private String baslik;
    private String tarih;
    private String aciklama;
    private String resim;
    private String paragraf;
    public mekan(){}

    public mekan(String baslik, String tarih, String aciklama, String resim, String paragraf) {
        this.baslik = baslik;
        this.tarih = tarih;
        this.aciklama = aciklama;
        this.resim = resim;
        this.paragraf = paragraf;
    }

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public String getResim() {
        return resim;
    }

    public void setResim(String resim) {
        this.resim = resim;
    }

    public String getParagraf() {
        return paragraf;
    }

    public void setParagraf(String paragraf) {
        this.paragraf = paragraf;
    }
}
