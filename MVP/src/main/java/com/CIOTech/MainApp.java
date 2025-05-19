package com.CIOTech; // Paquete coincide con tu mainClass

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import com.CIOTech.MVP.model.Producto;
import com.CIOTech.MVP.dao.ProductoDao;
import com.CIOTech.MVP.util.JpaUtil; // Para el shutdown
import java.math.BigDecimal;
import java.util.List;


import java.io.IOException;
import java.net.URL;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Carga el archivo FXML. Asegúrate de que la ruta sea correcta
            // Se buscará en src/main/resources/com/CIOTech/primary.fxml
            URL fxmlUrl = getClass().getResource("primary.fxml");
            if (fxmlUrl == null) {
                System.err.println("Error: No se pudo encontrar el archivo FXML 'primary.fxml' en el paquete com.CIOTech. Asegúrate de que esté en src/main/resources/com/CIOTech/");
                return;
            }
            Parent root = FXMLLoader.load(fxmlUrl);

            Scene scene = new Scene(root, 700, 500); // Tamaño inicial de la ventana

            primaryStage.setTitle("Aplicación MVP con JavaFX");
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException e) {
            System.err.println("Ocurrió un error al cargar el FXML:");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}