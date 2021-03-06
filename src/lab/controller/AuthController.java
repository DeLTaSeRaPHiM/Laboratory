package lab.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import lab.database.DatabaseHandler;
import lab.database.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthController {
    boolean isDisabled = true;

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordFieldHidden;

    @FXML
    private TextField passwordField;

    @FXML
    private Label errorLabel;

    @FXML
    void authButton(ActionEvent event) {
        DatabaseHandler dbHandler = new DatabaseHandler();
        User user = new User("", "", 1);
        user.setUsername(loginField.getText());
        user.setPassword(passwordFieldHidden.getText());
        ResultSet result = dbHandler.getUser(user);

        try {
            if (result.next()) {
                loginField.getScene().getWindow().hide();

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/lab/fxml/order.fxml"));

                try {
                    loader.load();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setTitle("Laboratory #20 - Лаборант");
                stage.setResizable(false);
                stage.getIcons().add(new Image("lab\\assets\\logo.png"));
                OrderController orderController = loader.getController();
                orderController.initiatize();
                stage.show();

            } else {
                errorLabel.setVisible(true);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void togglePassword(ActionEvent event) {
        String password = passwordFieldHidden.getText();
        if (isDisabled) {
            passwordField.setText(password);
            passwordField.toFront();
            isDisabled = false;
        } else {
            password = passwordField.getText();
            passwordFieldHidden.setText(password);
            passwordFieldHidden.toFront();
            isDisabled = true;
        }
    }

}