package lab.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import lab.database.DatabaseHandler;
import lab.database.Patient;

@SuppressWarnings("All")

public class AddPatientController {

    @FXML
    private TextField countryField;

    @FXML
    private TextField dateField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField fullnameField;

    @FXML
    private TextField insuranceAddressField;

    @FXML
    private TextField insuranceBIKField;

    @FXML
    private TextField insuranceINNField;

    @FXML
    private TextField insuranceNameField;

    @FXML
    private TextField insurancePField;

    @FXML
    private TextField loginField;

    @FXML
    private TextField passportNField;

    @FXML
    private TextField passportSField;

    @FXML
    private TextField phoneField;

    @FXML
    private TextField pwdField;

    @FXML
    private TextField socialTypeField;

    @FXML
    private TextField soclalSecNumberField;

    DatabaseHandler databaseHandler = new DatabaseHandler();

    @FXML
    void initialize() {} //используется как точка загрузки окна

    @FXML
    void addPatient(ActionEvent event) {
        Patient patient = new Patient(fullnameField.getText(), loginField.getText(), pwdField.getText(), "a9d7649c-d02e-4892-9db9-e7fb184d3e74",
                emailField.getText(), soclalSecNumberField.getText(),"20-5981066", socialTypeField.getText(), phoneField.getText(),
                passportSField.getText(), passportNField.getText(), dateField.getText(),"", countryField.getText(), insuranceNameField.getText(),
                insuranceAddressField.getText(), insuranceINNField.getText(), "68.246.8.73", insurancePField.getText(), insuranceBIKField.getText(),
                "Mozilla/5.0 (X11; Linux i686) AppleWebKit/535.11 (KHTML, like Gecko) Chrome/17.0.963.66 Safari/535.11");

        databaseHandler.addPatient(patient);

        dateField.getScene().getWindow().hide();
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
    }
}
