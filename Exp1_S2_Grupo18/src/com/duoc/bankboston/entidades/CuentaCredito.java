package com.duoc.bankboston.entidades;

public class CuentaCredito extends Cuenta{
    private double interesUso;

    public CuentaCredito(int numero, int saldo, double interesUso){
        super(numero, saldo);
        this.interesUso = interesUso;
    }
    
    public double getInteresUso() {
        return interesUso;
    }
}