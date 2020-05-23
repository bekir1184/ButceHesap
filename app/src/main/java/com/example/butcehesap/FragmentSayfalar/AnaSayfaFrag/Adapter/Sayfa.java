package com.example.butcehesap.FragmentSayfalar.AnaSayfaFrag.Adapter;

public class Sayfa {
    private int icon;
    private String kategori;
    private String para;

    public Sayfa(int icon, String kategori, String para) {
        this.icon = icon;
        this.kategori = kategori;
        this.para = para;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getPara() {
        return para;
    }

    public void setPara(String para) {
        this.para = para;
    }
}
