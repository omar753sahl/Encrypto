package com.os;

import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.ResourceBundle;


public class FormController implements Initializable {

    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private Label encryptedPasswordLabel;

    @FXML
    private Label yourPasswordLabel;

    @FXML
    private Button encryptButton;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        BooleanBinding emptyTextFields = new BooleanBinding() {
            {
                super.bind(usernameTextField.textProperty(), passwordTextField.textProperty());
            }

            @Override
            protected boolean computeValue() {
                return (usernameTextField.getText().trim().isEmpty() || passwordTextField.getText().trim().isEmpty());
            }
        };

        encryptButton.disableProperty().bind(emptyTextFields);
    }


    @FXML
    private void encrypt(ActionEvent event) {

        String password = passwordTextField.getText();
        yourPasswordLabel.setText(password);

        String encryptedPassword = generateHash(password);
        if (encryptedPassword != null) {
            encryptedPasswordLabel.setText(encryptedPassword);
        } else {
            encryptedPasswordLabel.setText("Opps! Something went wrong!");
        }
    }

    private String generateHash(String password) {

        StringBuilder sb = null;

        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Add password bytes to digest
            md.update(password.getBytes());

            // Get the hash's bytes
            byte[] hashBytes = md.digest();
            System.out.println("hashBytes: " + Arrays.toString(hashBytes));

            // This bytes[] has bytes in decimal format;
            // Convert it to hexadecimal format
            sb = new StringBuilder();
            System.out.print("Hex values: ");
            for (byte i : hashBytes) {
                String s = Integer.toString((i & 0xff) + 0x100, 16).substring(1);
                System.out.print(s + " ");
                sb.append(s);
            }

            System.out.println();
            System.out.println(sb.toString());

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            ErrorHandler.showErrorDialog(ErrorHandler.DEAFAULT_MESSAGE, e.getMessage());
        }

        if (sb != null) {
            return sb.toString();
        } else {
            return null;
        }
    }


}
