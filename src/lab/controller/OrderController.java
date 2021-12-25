package lab.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import lab.database.DatabaseHandler;
import lab.database.Patient;

//@SuppressWarnings("All")

public class OrderController {

    @FXML
    private TableColumn<Patient, String > bitrhdateCol;

    @FXML
    private TableColumn<Patient, String > countryCol;

    @FXML
    private TableColumn<Patient, String > einCol;

    @FXML
    private TableColumn<Patient, String > emailCol;

    @FXML
    private TableColumn<Patient, String > fullnameCol;

    @FXML
    private TableColumn<Patient, String > guidCol;

    @FXML
    private TableColumn<Patient, String > idCol;

    @FXML
    private TableColumn<Patient, String > insuranceAddressCol;

    @FXML
    private TableColumn<Patient, String > insuranceBIKCol;

    @FXML
    private TableColumn<Patient, String > insuranceINNCol;

    @FXML
    private TableColumn<Patient, String > insuranceNameCol;

    @FXML
    private TableColumn<Patient, String > insurancePCol;

    @FXML
    private TableColumn<Patient, String > ipCol;

    @FXML
    private TableColumn<Patient, String > passportNCol;

    @FXML
    private TableColumn<Patient, String > passportSCol;

    @FXML
    private TableColumn<Patient, String> patientLoginCol;

    @FXML
    private TableColumn<Patient, String> patientPwdCol;

    @FXML
    private TableView<Patient> patientsTable;

    @FXML
    private TableColumn<Patient, String > phoneCol;

    @FXML
    private TableColumn<Patient, String > socialsecnumberCol;

    @FXML
    private TableColumn<Patient, String > soctypeCol;

    @FXML
    private TableColumn<Patient, String > uaCol;

    @FXML
    private TextField deleteID;

    @FXML
    private Label isDeleteLabel;

    String action;
    private ObservableList<Patient> patientDB = FXCollections.observableArrayList();
    private DatabaseHandler databaseHandler = new DatabaseHandler();
    FXMLLoader loader = new FXMLLoader();
    private boolean isDeleting = true;

    @FXML
    void initiatize() {
        updateTable();
    }

    @FXML
    void addPatient(ActionEvent event) {
        action = "Добавление";
        changeScene("/lab/fxml/addPatient.fxml", action);
        AddPatientController addPatientController = loader.getController();
        addPatientController.initialize();
    }

    @FXML
    void editPatient(ActionEvent event) {
        action = "Critical error";
        changeScene("/lab/fxml/error.fxml", action);
    }

    @FXML
    void deletePatient(ActionEvent event) {
        if (isDeleting) {
            isDeleting = false;
            isDeleteLabel.setVisible(true);
            updateTable();
        } else {
            isDeleteLabel.setVisible(false);
            isDeleting = true;
            try {
                String id = deleteID.getText();
                if (!id.equals("")) {
                    databaseHandler.deletePatient(id);
                    updateTable();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void updateTable() {
        fullnameCol.setCellValueFactory(new PropertyValueFactory<>("fullname"));
        patientLoginCol.setCellValueFactory(new PropertyValueFactory<>("login"));
        patientPwdCol.setCellValueFactory(new PropertyValueFactory<>("pwd"));
        guidCol.setCellValueFactory(new PropertyValueFactory<>("guid"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        socialsecnumberCol.setCellValueFactory(new PropertyValueFactory<>("socialSecNumber"));
        einCol.setCellValueFactory(new PropertyValueFactory<>("ein"));
        soctypeCol.setCellValueFactory(new PropertyValueFactory<>("socialType"));
        phoneCol.setCellValueFactory(new PropertyValueFactory<>("phone"));
        passportSCol.setCellValueFactory(new PropertyValueFactory<>("passport_s"));
        passportNCol.setCellValueFactory(new PropertyValueFactory<>("passport_n"));
        bitrhdateCol.setCellValueFactory(new PropertyValueFactory<>("birthdate"));
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        countryCol.setCellValueFactory(new PropertyValueFactory<>("country"));
        insuranceNameCol.setCellValueFactory(new PropertyValueFactory<>("insuranceName"));
        insuranceAddressCol.setCellValueFactory(new PropertyValueFactory<>("insuranceAddress"));
        insuranceINNCol.setCellValueFactory(new PropertyValueFactory<>("insuranceInn"));
        ipCol.setCellValueFactory(new PropertyValueFactory<>("ipAddress"));
        insurancePCol.setCellValueFactory(new PropertyValueFactory<>("insuranceP"));
        insuranceBIKCol.setCellValueFactory(new PropertyValueFactory<>("insuranceBik"));
        uaCol.setCellValueFactory(new PropertyValueFactory<>("ua"));

        patientDB = databaseHandler.getPatients();
        patientsTable.setItems(patientDB);
    }

    public void changeScene(String name, String action) {
        patientsTable.getScene().getWindow().hide();

        loader.setLocation(getClass().getResource(name));

        try {
            loader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Laboratory #20 - " + action);
        stage.setResizable(false);
        stage.getIcons().add(new Image("lab\\assets\\logo.png"));
        stage.show();
    }
}
