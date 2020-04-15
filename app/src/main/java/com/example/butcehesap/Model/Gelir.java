package com.example.butcehesap.Model;

public class Gelir {
    private int id;
    private String aciklama;
    private String kategori;
    private int tutar;
    private String tarih;

    public Gelir(String aciklama, String kategori, int tutar, String tarih) {
        this.aciklama = aciklama;
        this.kategori = kategori;
        this.tutar = tutar;
        this.tarih = tarih;
    }

    public Gelir(int id, String aciklama, String kategori, int tutar, String tarih) {
        this.id = id;
        this.aciklama = aciklama;
        this.kategori = kategori;
        this.tutar = tutar;
        this.tarih = tarih;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public int getTutar() {
        return tutar;
    }

    public void setTutar(int tutar) {
        this.tutar = tutar;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }
}
