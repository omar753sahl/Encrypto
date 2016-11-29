package com.os;

import javafx.scene.control.Alert;

public class ErrorHandler {

    public static final String DEAFAULT_MESSAGE = "Something went wrong...";

    public static void showErrorDialog(String header, String message){

        Alert dialog = new Alert(Alert.AlertType.ERROR);
        dialog.setHeaderText(header);
        dialog.setTitle("Error");
        dialog.setContentText(message);
        dialog.showAndWait();

    }

}
