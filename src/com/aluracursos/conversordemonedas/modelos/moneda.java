package com.aluracursos.conversordemonedas.modelos;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Map;

public class moneda {

   private String result;
   private String base_code;
   //private ArrayList equivalenciaMonedaDestino;
   private Map <String, Double> conversionRates;
   Double wonKoreano;
public moneda(){

}
   public moneda (divisaEquivalente miDivisaEquivalente){
        this.result = miDivisaEquivalente.result();
        this.base_code = miDivisaEquivalente.base_code();
        this.conversionRates= miDivisaEquivalente.conversion_rates();
    }

    @Override
    public String toString() {

        return "result=" + (String) result +
                ", base_code=" + (String) base_code +
                ", equivalenciaMonedaDestino=" + conversionRates.get("KRW");


    }


}
