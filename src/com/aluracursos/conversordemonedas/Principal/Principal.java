package com.aluracursos.conversordemonedas.Principal;

import java.sql.ClientInfoStatus;
import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

import com.aluracursos.conversordemonedas.modelos.codigos;
import com.aluracursos.conversordemonedas.modelos.divisaEquivalente;
import com.google.gson.*;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;

import com.aluracursos.conversordemonedas.modelos.moneda;
import com.aluracursos.conversordemonedas.modelos.APIResponse;
/*
Gracias a:
<a href="https://www.exchangerate-api.com">Rates By Exchange Rate API</a>
Por aportar los recursos necesarios para estudiar la aplicación de APIs en este proyecto
 */


public class Principal {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        codigos listaDeCodigos = new codigos();
        int opcion=4;
        String APIKey="ac22a69c50e77b974b81be3f";
        String base_code="...";
        String divisa_objetivo="MXN";
        double monto;

        Gson gson = new GsonBuilder()
                //.setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        String apiResponse;

        while(true){
            //Muestra menú
            System.out.println("");
            System.out.println("-Conversor de divisas-");
            System.out.println("");
            System.out.println("Seleccione una opción");
            System.out.println("""
                    1. Convertir una divisa.
                    2. Consultar los códigos de las divisas disponibles.
                    3. Salir. 
                    """);


            try{
                opcion = teclado.nextInt();
            }catch(InputMismatchException e){
                System.out.println("⚠\uFE0F Solo se admiten valores numéricos ⚠\uFE0F");
                //System.out.println("error numérico "+e);
                opcion=9;
                teclado.nextLine();
            }

            if (opcion==3) {
                System.out.println(" \uD83D\uDCB1 ¡Gracias por utilizar el conversor de divisas, vuelvas prontos!. \uD83D\uDCB0");
                System.out.println("                                     \uD83D\uDE0A\uD83D\uDE0A\uD83D\uDE0A");
                break;
            } else if (opcion==2) {
                listaDeCodigos.printCodes();
            } else if(opcion==1) {

                System.out.println("¿Qué moneda desea convertir?.");
                System.out.println("Escribe un código válido como en los siguientes Ejemplos:");
                System.out.println("""
                            MXN - Peso Mexicano
                            COP - Peso Colombiano
                            USD - Dolar Estado Unidense
                            ARS - Peso Argenino
                            ...
                            """);


                base_code = teclado.next();

                //Petición al servidor
                String buscarURL = "https://v6.exchangerate-api.com/v6/" + APIKey + "/latest/" + base_code;
                APIResponse apiRquest = new APIResponse(buscarURL);

                apiResponse = apiRquest.conecta(buscarURL);
                try {
                    //Generación del Objeto JSON
                    divisaEquivalente miMoneda = gson.fromJson(apiResponse, divisaEquivalente.class);




                    if (!miMoneda.result().equals("error")) { //Si la respuessta del servidor fue exitosa, sucede lo siguiente
                        //Se adquieren los datos del JSON



                            while (true) {
                                boolean exit =false;
                                try {
                                    System.out.println("¿Cuál es el monto que deseas convertir?");
                                    monto = teclado.nextDouble();



                                    while(true)   {
                                        System.out.println("¿A qué moneda lo deseas convertir?.");
                                        System.out.println("Escribe un código de 3 letras de la lista de códigos");
                                        try{
                                            divisa_objetivo = teclado.next();
                                            divisa_objetivo= divisa_objetivo.toUpperCase();

                                            if (miMoneda.conversion_rates().containsKey(divisa_objetivo)) {
                                                System.out.println("\uD83D\uDCB2 1 " + miMoneda.base_code() + " = " + miMoneda.conversion_rates().get(divisa_objetivo) + " " + divisa_objetivo+" \uD83C\uDFE6");
                                                System.out.println("\uD83E\uDD11 "+monto + " " + base_code.toUpperCase() + " equivale a: " + monto * miMoneda.conversion_rates().get(divisa_objetivo) + " " + divisa_objetivo+" \uD83E\uDD11");
                                                exit=true;
                                                break;
                                            }else {
                                                System.out.println("");
                                                System.out.println("⚠\uFE0F El código introducido no es váido o no está disponible, por favor intente nuevamente. ⚠\uFE0F ");
                                                System.out.println("");

                                            }
                                        }catch (InputMismatchException e){
                                            System.out.println("⚠\uFE0F Por favor intente con un código válido ⚠\uFE0F");
                                        }
                                    }
                                    }catch (InputMismatchException e){
                                    System.out.println("");
                                    System.out.println("⚠\uFE0F Solo se aceptan valores numéricos. ⚠\uFE0F");
                                    System.out.println("");
                                    teclado.nextLine();
                                   }
                                if(exit = true){
                                    break;
                                }
                            }


                    } else {
                        System.out.println("\uD83D\uDEA8 Ocurrió un error, el código que solicitaste no es válido o no está disponible \uD83D\uDEA8");
                    }
                }catch(Exception e) {
                    System.out.println("");
                    System.out.println("⚠\uFE0F No se aceptan valores numéricos, por favor vuelva a intentar con un código de divisa válido ⚠\uFE0F");
                    System.out.println("");
                }
            }
        }



    }
}


