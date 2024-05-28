package com.duoc.bankboston.entidades;

import com.duoc.bankboston.utilitarios.Utilitarios;
import com.duoc.bankboston.utilitarios.VerDatos;
import java.text.NumberFormat;
import java.util.Locale;

public class Cliente implements VerDatos{
    private String rut;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String domicilio;
    private String comuna;
    private String telefono;
    private int tipoCuenta;
    private int numeroCuenta;
    
    public Cliente(String rut, String nombre, String apellidoPaterno, String apellidoMaterno, String domicilio, String comuna, String telefono, int tipoCuenta, int numeroCuenta){
        this.rut = rut;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.domicilio = domicilio;
        this.comuna = comuna;
        this.telefono = telefono;
        this.tipoCuenta = tipoCuenta;
        this.numeroCuenta = numeroCuenta;
    }
    
    @Override
    public void verDatos(Cliente C, int saldoCuenta){
        String[] arrayOpciones = {"CUENTA DE AHORRO", "CUENTA CORRIENTE", "CUENTA DE CREDITO"};
        NumberFormat formato = NumberFormat.getInstance(new Locale("es", "CL"));
        formato.setGroupingUsed(true);
                
        Utilitarios.limpiaPantalla();
        System.out.println("** DATOS DEL CLIENTE **");
        System.out.println("");
        System.out.println("RUT:              "+C.getRut());
        System.out.println("NOMBRE:           "+C.getNombre().toUpperCase());
        System.out.println("APELLIDO PATERNO: "+C.getApellidoPaterno().toUpperCase());
        System.out.println("APELLIDO MATERNO: "+C.getApellidoMaterno().toUpperCase());
        System.out.println("DOMICILIO:        "+C.getDomicilio().toUpperCase());
        System.out.println("COMUNA:           "+C.getComuna().toUpperCase());
        System.out.println("TELEFONO:         "+C.getTelefono().toUpperCase());
        System.out.println("TIPO CUENTA:      "+arrayOpciones[(C.tipoCuenta - 1)]);
        System.out.println("NUMERO CUENTA:    "+C.getNumeroCuenta());
        System.out.println("SALDO CUENTA:     $"+formato.format(saldoCuenta));
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(int tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }
}
