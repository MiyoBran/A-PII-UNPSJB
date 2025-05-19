package com.CIOTech.controller; // Controlador en su propio subpaquete

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button; // Si añadieras un botón
import javafx.event.ActionEvent;    // Para el evento del botón

public class PrimaryController {

    @FXML
    private Label infoLabel;// Coincide con fx:id="infoLabel"
   
    @FXML
    private Button miBoton; // Si tuvieras un botón con fx:id="miBoton"


    @FXML
    public void initialize() {
        // Este método se llama después de que los elementos FXML son inyectados.
        infoLabel.setText("Controlador inicializado y listo.");
        System.out.println("PrimaryController ha sido inicializado.");
    }

    // Ejemplo de manejador de evento si tuvieras un botón
    @FXML
    private void handleMiBotonClick(ActionEvent event) {
        infoLabel.setText("¡El botón ha sido presionado!");
    }
    
}