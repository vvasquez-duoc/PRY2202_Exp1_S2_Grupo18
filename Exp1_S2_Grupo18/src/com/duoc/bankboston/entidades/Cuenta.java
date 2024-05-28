package com.duoc.bankboston.entidades;

public abstract class Cuenta {
    private int numero;
    private int saldo;
    
    public Cuenta(int numero, int saldo){
        this.numero = numero;
        this.saldo = saldo;
    }

    public int getNumero() {
        return numero;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
}
