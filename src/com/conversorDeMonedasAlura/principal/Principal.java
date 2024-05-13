package com.conversorDeMonedasAlura.principal;

import com.conversorDeMonedasAlura.modelos.Moneda;
import com.conversorDeMonedasAlura.modelos.MonedaConvertida;
import com.conversorDeMonedasAlura.servicios.ConsultaApi;
import com.conversorDeMonedasAlura.servicios.GeneradorDeArchivo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        List<MonedaConvertida> historial = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String menuDeOpciones = """
                Sea bienvenido al conversor de monedas. Elija una de las siguientes opciones:
                                
                1) Dólar -> Peso argentino
                2) Peso argentino -> Dólar
                3) Dólar -> Real brasileño
                4) Real brasileño -> Dólar
                5) Dólar -> Peso colombiano
                6) Peso colombiano -> Dólar
                7) Otro tipo de Cambio
                8) Salir
                """;

        ConsultaApi consultaApi = new ConsultaApi();
        GeneradorDeArchivo generadorDeArchivo = new GeneradorDeArchivo();

        while (true) {
            double cantidad;
            String input;
            System.out.println(menuDeOpciones);
            String opcion = scanner.next();

            if (opcion.equals("8")) {
                System.out.println("Finalizando la ejecución del programa");
                break;
            }

            String monedaActual = "", monedaObtenida = "";

            switch (opcion) {
                case "1":
                    monedaActual = "USD";
                    monedaObtenida = "ARS";
                    break;
                case "2":
                    monedaActual = "ARS";
                    monedaObtenida = "USD";
                    break;
                case "3":
                    monedaActual = "USD";
                    monedaObtenida = "BRL";
                    break;
                case "4":
                    monedaActual = "BRL";
                    monedaObtenida = "USD";
                    break;
                case "5":
                    monedaActual = "USD";
                    monedaObtenida = "COP";
                    break;
                case "6":
                    monedaActual = "COP";
                    monedaObtenida = "USD";
                    break;
                case "7":
                    System.out.println("Indique la moneda a convertir (En Currency Code)");
                    monedaActual = scanner.next();
                    System.out.println("Indique la moneda convertida (En Currency Code)");
                    monedaObtenida = scanner.next();
                    break;
                default:
                    System.out.println("Opción no válida. Escoja nuevamente!");
                    continue;
            }



            do{
                System.out.println("Indique cantidad a convertir");
                input = scanner.next();
                try {
                    // Intenta convertir el input a double
                    cantidad = Double.parseDouble(input);
                } catch (NumberFormatException e) {
                    // Si no se puede convertir a double, muestra un mensaje de error
                    System.out.println("¡Error! Debes ingresar un número válido.");
                    cantidad = Double.NaN; // Establece un valor que no es un número (NaN)
                }
            }while (Double.isNaN(cantidad));

            scanner.nextLine(); // Consumir la nueva línea

            try {
                Moneda moneda = consultaApi.convertirMoneda(monedaActual, monedaObtenida, cantidad);
                MonedaConvertida monedaConvertida = new MonedaConvertida(moneda);
                generadorDeArchivo.guardarJson(monedaConvertida, historial);
            } catch (RuntimeException | IOException e) {
                System.out.println("Error al procesar la solicitud: " + e.getMessage());
            }
        }
    }
}
