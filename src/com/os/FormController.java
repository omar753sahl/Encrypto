package com.os;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
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
    void encrypt(ActionEvent event) {



    }


}
