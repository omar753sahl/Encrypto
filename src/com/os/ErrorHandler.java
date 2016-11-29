package com.os;

import javafx.scene.control.Alert;
import javafx.scene.control.Dialog;

import java.util.Optional;

public class ErrorHandler {

    public static void showErrorDialog(String header, String message){

        Alert dialog = new Alert(Alert.AlertType.ERROR);
        dialog.setHeaderText(header);
        dialog.setTitle("Error");
        dialog.setContentText(message);
        dialog.showAndWait();

    }

}
