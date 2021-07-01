package com.example.adapterpersonalizat2;

import java.io.Serializable;

public class AgentVanzari implements Serializable {
    private String nume;
    private String oras;
    private boolean barbat;
    private int procent_vanzari;
    private int ora_incepere;

    public AgentVanzari(String nume, String oras, boolean barbat, int procent_vanzari, int ora_incepere) {
        this.nume = nume;
        this.oras = oras;
        this.barbat = barbat;
        this.procent_vanzari = procent_vanzari;
        this.ora_incepere = ora_incepere;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getOras() {
        return oras;
    }

    public void setOras(String oras) {
        this.oras = oras;
    }

    public boolean isBarbat() {
        return barbat;
    }

    public void setBarbat(boolean barbat) {
        this.barbat = barbat;
    }

    public int getProcent_vanzari() {
        return procent_vanzari;
    }

    public void setProcent_vanzari(int procent_vanzari) {
        this.procent_vanzari = procent_vanzari;
    }

    public int getOra_incepere() {
        return ora_incepere;
    }

    public void setOra_incepere(int ora_incepere) {
        this.ora_incepere = ora_incepere;
    }

    @Override
    public String toString() {
        return "AgentVanzari{" +
                "nume='" + nume + '\'' +
                ", oras='" + oras + '\'' +
                ", barbat=" + barbat +
                ", procent_vanzari=" + procent_vanzari +
                ", ora_incepere=" + ora_incepere +
                '}';
    }
}
