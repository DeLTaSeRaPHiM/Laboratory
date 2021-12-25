package lab.database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class DatabaseHandler {
    Connection connection;

    public Connection getDBConnection() throws SQLException, ClassNotFoundException {
        String url = "localhost";
        String port = "3306";
        String dbName = "laboratory";

        String connectionStr = "jdbc:mysql://" + url + ":" + port + "/" + dbName + "?serverTimezone=UTC";

        Class.forName("com.mysql.cj.jdbc.Driver");

        connection = DriverManager.getConnection(connectionStr, "root", "12345");
        return connection;
    }

    public ResultSet getUser(User user) {
        ResultSet resSet = null;

        String select = "SELECT login, password, type FROM users WHERE login =? AND password =? AND type =?";

        try {
            PreparedStatement prSt = getDBConnection().prepareStatement(select);
            prSt.setString(1, user.getUsername());
            prSt.setString(2, user.getPassword());
            prSt.setInt(3, user.getType());

            resSet = prSt.executeQuery();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return resSet;
    }

    public ObservableList<Patient> getPatients() {
        try {
            PreparedStatement prSt = getDBConnection().prepareStatement("SELECT * FROM patients");

            ResultSet result = prSt.executeQuery();
            ObservableList<Patient> list = FXCollections.observableArrayList();
            while (result.next()) { //Получение данных из столбцов базы данных
                Patient patient = new Patient("", "", "", "",
                        "", "", "", "", "", "",
                        "", "", "", "", "", "",
                        "", "", "", "", "");

                patient.setFullname(result.getString("full_name"));
                patient.setLogin(result.getString("login"));
                patient.setPwd(result.getString("pwd"));
                patient.setGuid(result.getString("guid"));
                patient.setEmail(result.getString("email"));
                patient.setSocialSecNumber(result.getString("social_sec_number"));
                patient.setEin(result.getString("ein"));
                patient.setSocialType(result.getString("social_type"));
                patient.setPhone(result.getString("phone"));
                patient.setPassport_s(result.getString("passport_s"));
                patient.setPassport_n(result.getString("passport_n"));
                patient.setBirthdate(result.getString("birthdate_timestamp"));
                patient.setId(result.getString("id"));
                patient.setCountry(result.getString("country"));
                patient.setInsuranceName(result.getString("insurance_name"));
                patient.setInsuranceAddress(result.getString("insurance_address"));
                patient.setInsuranceInn(result.getString("insurance_inn"));
                patient.setIpAddress(result.getString("ipadress"));
                patient.setInsuranceBik(result.getString("insurance_p"));
                patient.setInsuranceP(result.getString("insurance_bik"));
                patient.setUa(result.getString("ua"));

                list.add(patient);
            }
            return list;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addPatient(Patient patient) {
        String insert = "INSERT INTO patients (full_name, login, pwd, guid, " +
                "email, social_sec_number, ein, social_type, phone, passport_s, passport_n, " +
                "birthdate_timestamp, country, insurance_name, insurance_address, insurance_inn, " +
                "ipadress, insurance_p, insurance_bik, ua) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement prSt = getDBConnection().prepareStatement(insert);
            prSt.setString(1, patient.getFullname());
            prSt.setString(2, patient.getLogin());
            prSt.setString(3, patient.getPwd());
            prSt.setString(4, patient.getGuid());
            prSt.setString(5, patient.getEmail());
            prSt.setInt(6, Integer.parseInt(patient.getSocialSecNumber()));
            prSt.setString(7, patient.getEin());
            prSt.setString(8, patient.getSocialType());
            prSt.setString(9, patient.getPhone());
            prSt.setInt(10, Integer.parseInt(patient.getPassport_s()));
            prSt.setInt(11, Integer.parseInt(patient.getPassport_n()));
            prSt.setInt(12, Integer.parseInt(patient.getBirthdate()));
            prSt.setString(13, patient.getCountry());
            prSt.setString(14, patient.getInsuranceName());
            prSt.setString(15, patient.getInsuranceAddress());
            prSt.setInt(16, Integer.parseInt(patient.getInsuranceInn()));
            prSt.setString(17, patient.getIpAddress());
            prSt.setInt(18, Integer.parseInt(patient.getInsuranceP()));
            prSt.setInt(19, Integer.parseInt(patient.getInsuranceBik()));
            prSt.setString(20, patient.getUa());

            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void deletePatient(String id) {
        String delete = "DELETE FROM patients WHERE id = ?;";
        int ID = Integer.parseInt(id);

        try {
            PreparedStatement prSt = getDBConnection().prepareStatement(delete);
            prSt.setInt(1, ID);

            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
