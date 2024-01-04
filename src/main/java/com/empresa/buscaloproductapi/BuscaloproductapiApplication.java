package com.empresa.buscaloproductapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BuscaloproductapiApplication {
    public static void main(String[] args) {
        while (true) {
            try {
                SpringApplication.run(BuscaloproductapiApplication.class, args);
                break; // Si la aplicación se inicia sin excepciones, salir del bucle
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Esperando 60 segundos antes de volver a intentar...");
                sleep(60000); // Retardo de 60 segundos
            }
        }
    }

    private static void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}