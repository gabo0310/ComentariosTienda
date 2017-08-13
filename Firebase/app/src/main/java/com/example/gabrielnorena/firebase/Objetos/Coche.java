package com.example.gabrielnorena.firebase.Objetos;

/**
 * Created by gabrielnorena on 10/08/17.
 */
public class Coche {
    String marca;
    String dueno;
    int puertas;
    int ruedas;

    //Constructor sin parametros para la clase coche
    public Coche() {
    }

    //Constructor con todos los parametros de la clase coche
    public Coche(String marca, String dueno, int puertas, int ruedas) {
        this.marca = marca;
        this.dueno = dueno;
        this.puertas = puertas;
        this.ruedas = ruedas;
    }

    //Retorna el valor del atributo marca
    public String getMarca() {
        return marca;
    }

    //Cambia el valor del atrubuto marca
    public void setMarca(String marca) {
        this.marca = marca;
    }

    //Retorna el valor del atributo dueno
    public String getDueno() {
        return dueno;
    }

    //Cambia el valor del atrubuto marca
    public void setDueno(String dueno) {
        this.dueno = dueno;
    }

    //Retorna el valor del atributo puertas
    public int getPuertas() {
        return puertas;
    }

    //Cambia el valor del atrubuto marca
    public void setPuertas(int puertas) {
        this.puertas = puertas;
    }

    //Retorna el valor del atributo reudas
    public int getRuedas() {
        return ruedas;
    }

    //Cambia el valor del atrubuto marca
    public void setRuedas(int ruedas) {
        this.ruedas = ruedas;
    }
}
