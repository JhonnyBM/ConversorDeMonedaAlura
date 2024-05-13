package com.conversorDeMonedasAlura.servicios;

import com.conversorDeMonedasAlura.modelos.MonedaConvertida;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GeneradorDeArchivo {
    public void guardarJson(MonedaConvertida monedaConvertida, List historial) throws IOException {

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                //para mejorar visualmente el json
                .setPrettyPrinting()
                .create();

        historial.add(monedaConvertida);
        //crea un archivo .json
        FileWriter escritura = new FileWriter("HistoricoDeConsultas.json");
        escritura.write(gson.toJson(historial));
        escritura.close();
        System.out.println(historial);
    }
}
