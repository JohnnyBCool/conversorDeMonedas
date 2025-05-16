package com.aluracursos.conversordemonedas.modelos;


import com.google.gson.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APIResponse {
    private String urlAddressReq;
    public APIResponse(String urlAddress) {
        this.urlAddressReq = urlAddress;
    }

    public String conecta (String urlAddress){
    String apiResponse;
        try{
        HttpClient client =HttpClient.newHttpClient();
        HttpRequest request =HttpRequest.newBuilder()
                .uri(URI.create(urlAddress))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        apiResponse= response.body();

           // System.out.println("Conectó correctamente");

    }catch(Exception errorGenerico){
        System.out.println("Ocurrió un error");
        System.out.println(errorGenerico);
        apiResponse= "errorGenerico";
    }

       // System.out.println("Se finalizó el proceso");
return  apiResponse;
}



}
