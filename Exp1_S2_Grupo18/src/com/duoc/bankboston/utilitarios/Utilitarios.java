package com.duoc.bankboston.utilitarios;

import com.duoc.bankboston.app.App;
import com.duoc.bankboston.entidades.Cliente;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;
/**
 * This is a sample class.
 */
public class Utilitarios {
    public static void limpiaPantalla(){
        for(int i=0; i<30; i++){
            System.out.println("");
        }
    }
    
    public static int generarNroCtaCte(){
        int min = 100000000;
        int max = 999999999;
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
    
    public static String formatoRut(String rut){
        int R = Integer.parseInt(rut.substring(0, rut.length() - 1));
        String DV = rut.substring(rut.length() - 1, rut.length());
        
        NumberFormat formato = NumberFormat.getInstance(new Locale("es", "CL"));
        formato.setGroupingUsed(true);
        return formato.format(R)+"-"+DV;
    }
    
    public static Boolean validaRut(String rut){
        int rutNum;
        if(rut == null || rut.isEmpty() || rut.length() < 11 || rut.length() > 12) return false;
        
        rut = rut.replace(".", "");
        rut = rut.replace("-", "");
        rut = rut.toUpperCase();
        
        String R = rut.substring(0, rut.length() - 1);
        String DV = rut.substring(rut.length() - 1, rut.length());
        
        try{
            rutNum = Integer.parseInt(R);
        }catch(NumberFormatException e){
            return false;
        }
        
        return DV.toLowerCase().equals(dv(R));
    }
    
    public static String dv(String rut){
        Integer M=0,S=1,T=Integer.parseInt(rut);
        for (;T!=0;T=(int) Math.floor(T/=10))
            S=(S+T%10*(9-M++%6))%11;
        
        return ( S > 0 ) ? String.valueOf(S-1) : "k";		
    }
    
    public static boolean hayClientesRegistrados(HashMap<String, Cliente> clientesRegistrados, String mensaje){
        Scanner teclado = new Scanner(System.in);
        boolean retorno = true;
        if(clientesRegistrados.isEmpty()){
            System.out.println(mensaje);
            System.out.println("Presione ENTER para continuar...");
            teclado.nextLine();
        
            limpiaPantalla();
            retorno = false;
        }
        return retorno;
    }
    
    public static String validaClienteRegistrado(){
        Scanner teclado = new Scanner(System.in);
        boolean rutEsValido = true;    
        String RUT;    

        do{
            limpiaPantalla();
            if(rutEsValido == false) System.out.println("** EL RUT INGRESADO NO ES VALIDO **");
            System.out.println("INGRESE RUT DEL CLIENTE:");
            System.out.println("* ingrese RUT con puntos y guion. EJ: 11.222.333-4");
            RUT = teclado.nextLine();
            rutEsValido = validaRut(RUT);
        }while(rutEsValido == false);
        
        return RUT.toUpperCase();
    }
    public static boolean clienteEsUsuario(HashMap<String, Cliente> clientesRegistrados, String RUT){
        Scanner teclado = new Scanner(System.in);
        boolean retorno = true;
        if(!clientesRegistrados.containsKey(RUT)){
            limpiaPantalla();
            System.out.println("** EL RUT INGRESADO NO ES CLIENTE DEL BANCO **");
            System.out.println("** POR FAVOR, REGISTRAR PREVIAMENTE         **");
            System.out.println("Presione ENTER para continuar...");
            teclado.nextLine();

            limpiaPantalla();
            retorno = false;
        }
        return retorno;
    }
}
