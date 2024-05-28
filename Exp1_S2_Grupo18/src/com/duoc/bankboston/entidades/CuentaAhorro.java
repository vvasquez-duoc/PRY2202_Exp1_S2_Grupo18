package com.duoc.bankboston.entidades;

public class CuentaAhorro extends Cuenta{
    private int cargoPorGiros;
    
    public CuentaAhorro(int numero, int saldo, int cargoPorGiros){
        super(numero, saldo);
        this.cargoPorGiros = cargoPorGiros;
    }

    public int getCargoPorGiros() {
        return cargoPorGiros;
    }
}
