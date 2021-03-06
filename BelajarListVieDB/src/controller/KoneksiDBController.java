/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import db.koneksi;
import java.io.FileInputStream;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author kuupie
 */
public class KoneksiDBController implements Initializable {

    @FXML
    private JFXTextField server;
    @FXML
    private JFXTextField port;
    @FXML
    private JFXTextField database;
    @FXML
    private JFXTextField password;
    @FXML
    private JFXTextField username;
    @FXML
    private JFXButton simpanKoneksi;

    
      @FXML
    private void handleTestKoneksi(ActionEvent event) {
        String server_text = server.getText();
        String port_text = port.getText();
        String database_text = database.getText();
        String password_text = password.getText();
        String username_text = username.getText();
        koneksi kon = new koneksi();
        kon.testKoneksi(server_text, port_text, database_text, username_text, password_text);
    }

    @FXML
    private void handleSimpanKoneksi(ActionEvent event) {
        String server_text = server.getText();
        String port_text = port.getText();
        String database_text = database.getText();
        String password_text = password.getText();
        String username_text = username.getText();
        koneksi kon = new koneksi();
        kon.simpanKoneksi(server_text, port_text, database_text, username_text, password_text);
    }
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("setting.properties"));
            String username_prop = properties.getProperty("user");
            String password_prop = properties.getProperty("password");
            String server_prop = properties.getProperty("serverName");
            String database_prop = properties.getProperty("databaseName");
            String port_prop = properties.getProperty("port");
            server.setText(server_prop);
            port.setText(port_prop);
            database.setText(database_prop);
            username.setText(username_prop);
            password.setText(password_prop);
            
        } catch (Exception e) {
        }
    }    

  
    
}
