package com.example.butcehesap.Model;

public class Yillikitem {
    private String ayAdi;
    private int gider;
    private int gelir;
    private int market;
    private int  akaryakit;
    private int giyim;
    private int fatura ;
    private int  diger;
    private int digerGelir;
    private int mass;

    public Yillikitem(String ayAdi, int gider, int gelir, int market, int akaryakit, int giyim, int fatura, int diger, int digerGelir, int mass) {
        this.ayAdi = ayAdi;
        this.gider = gider;
        this.gelir = gelir;
        this.market = market;
        this.akaryakit = akaryakit;
        this.giyim = giyim;
        this.fatura = fatura;
        this.diger = diger;
        this.digerGelir = digerGelir;
        this.mass = mass;
    }

    public String getAyAdi() {
        return ayAdi;
    }

    public void setAyAdi(String ayAdi) {
        this.ayAdi = ayAdi;
    }

    public int getGider() {
        return gider;
    }

    public void setGider(int gider) {
        this.gider = gider;
    }

    public int getGelir() {
        return gelir;
    }

    public void setGelir(int gelir) {
        this.gelir = gelir;
    }

    public int getMarket() {
        return market;
    }

    public void setMarket(int market) {
        this.market = market;
    }

    public int getAkaryakit() {
        return akaryakit;
    }

    public void setAkaryakit(int akaryakit) {
        this.akaryakit = akaryakit;
    }

    public int getGiyim() {
        return giyim;
    }

    public void setGiyim(int giyim) {
        this.giyim = giyim;
    }

    public int getFatura() {
        return fatura;
    }

    public void setFatura(int fatura) {
        this.fatura = fatura;
    }

    public int getDiger() {
        return diger;
    }

    public void setDiger(int diger) {
        this.diger = diger;
    }

    public int getDigerGelir() {
        return digerGelir;
    }

    public void setDigerGelir(int digerGelir) {
        this.digerGelir = digerGelir;
    }

    public int getMass() {
        return mass;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }
}
