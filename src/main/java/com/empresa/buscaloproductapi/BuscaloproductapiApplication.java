package com.empresa.buscaloproductapi;

import com.empresa.buscaloproductapi.config.ValidationConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.logging.Logger;

@SpringBootApplication
@EnableSwagger2
@Import(ValidationConfig.class)
public class BuscaloproductapiApplication {
    static Logger logger = Logger.getLogger(BuscaloproductapiApplication.class.getName());
    public static void main(String[] args) {
        while (true) {
            try {
                SpringApplication.run(BuscaloproductapiApplication.class, args);
                break; // Si la aplicación se inicia sin excepciones, salir del bucle
            } catch (Exception e) {
                e.printStackTrace();
                logger.info("Esperando 60 segundos antes de volver a intentar...");
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