package com.example.demoreal;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ControladorBuscar {

    public Button buscarBuscar;
    public ComboBox<String> comboBuscar;
    public ListView<String> listaBuscar;
    public TextField campoBusqueda;
    public Label labelBuscar;
    public String campo;
    public Button atrasBuscar;

    public void clickBuscarBuscar(ActionEvent event) { //Hacer que no se repitan elementos en la ListView
        if (event.getSource() == buscarBuscar) {
           try{
            String dni = null;
            String nombre = null;
            String primerApellido = null;
            String segundoApellido = null;
            switch (campo){
               case "dni":
                   try {
                       Conexion con = new Conexion();
                       Statement st = con.conexion().createStatement();
                       ResultSet rs = st.executeQuery("select dni, nombre, primerApellido, segundoApellido from socios where dni = '" + campoBusqueda.getText() + "';");

                       while (rs.next()) {
                           dni = rs.getString("dni");
                           nombre = rs.getString("nombre");
                           primerApellido = rs.getString("primerApellido");
                           segundoApellido = rs.getString("segundoApellido");

                           listaBuscar.getItems().add(nombre + " " + primerApellido + " " + segundoApellido + " DNI -> " + dni);

                       }
                       con.closeConnection();

                   } catch (SQLException e) {
                       e.printStackTrace();
                   }
                   break;
               case "nombre":

                   try {
                       Conexion con = new Conexion();
                       Statement st = con.conexion().createStatement();
                       ResultSet rs = st.executeQuery("select dni, nombre, primerApellido, segundoApellido from socios where nombre = '" + campoBusqueda.getText() + "';");

                       while (rs.next()) {
                           dni = rs.getString("dni");
                           nombre = rs.getString("nombre");
                           primerApellido = rs.getString("primerApellido");
                           segundoApellido = rs.getString("segundoApellido");

                           listaBuscar.getItems().add(nombre + " " + primerApellido + " " + segundoApellido + " DNI -> " + dni);

                       }
                       con.closeConnection();

                   } catch (SQLException e) {
                       e.printStackTrace();
                   }
                   break;
               case "primerApellido":
                   try {
                       Conexion con = new Conexion();
                       Statement st = con.conexion().createStatement();
                       ResultSet rs = st.executeQuery("select dni, nombre, primerApellido, segundoApellido from socios where primerApellido = '" + campoBusqueda.getText() + "';");

                       while (rs.next()) {
                           dni = rs.getString("dni");
                           nombre = rs.getString("nombre");
                           primerApellido = rs.getString("primerApellido");
                           segundoApellido = rs.getString("segundoApellido");

                           listaBuscar.getItems().add(nombre + " " + primerApellido + " " + segundoApellido + " DNI -> " + dni);

                       }
                       con.closeConnection();

                   } catch (SQLException e) {
                       e.printStackTrace();
                   }
                   break;
               case "segundoApellido":
                   try {
                       Conexion con = new Conexion();
                       Statement st = con.conexion().createStatement();
                       ResultSet rs = st.executeQuery("select dni, nombre, primerApellido, segundoApellido from socios where segundoApellido = '" + campoBusqueda.getText() + "';");

                       while (rs.next()) {
                           dni = rs.getString("dni");
                           nombre = rs.getString("nombre");
                           primerApellido = rs.getString("primerApellido");
                           segundoApellido = rs.getString("segundoApellido");

                           listaBuscar.getItems().add(nombre + " " + primerApellido + " " + segundoApellido + " DNI -> " + dni);

                       }
                       con.closeConnection();

                   } catch (SQLException e) {
                       e.printStackTrace();
                   }
                   break;
               case "correo":
                   try {
                       Conexion con = new Conexion();
                       Statement st = con.conexion().createStatement();
                       ResultSet rs = st.executeQuery("select dni, nombre, primerApellido, segundoApellido from socios where correo = '" + campoBusqueda.getText() + "';");

                       while (rs.next()) {
                           dni = rs.getString("dni");
                           nombre = rs.getString("nombre");
                           primerApellido = rs.getString("primerApellido");
                           segundoApellido = rs.getString("segundoApellido");

                           listaBuscar.getItems().add(nombre + " " + primerApellido + " " + segundoApellido + " DNI -> " + dni);

                       }
                       con.closeConnection();

                   } catch (SQLException e) {
                       e.printStackTrace();
                   }
                   break;
                default:
                    break;
           }

        }catch (NullPointerException e){
               alertWarning("Rellene el campo de búsqueda");
           }
        }
    }

    public void showingBuscar(Event event) {
        ObservableList<String> items = FXCollections.observableArrayList();
        items.addAll("DNI", "Nombre", "Primer Apellido", "Segundo Apellido","Email");
        comboBuscar.setItems(items);
    }

    public void buscarKey(KeyEvent keyEvent) {
       if(keyEvent.getCode() == KeyCode.ENTER){
           try{
           String dni = null;
        String nombre = null;
        String primerApellido = null;
        String segundoApellido = null;
        switch (campo) {
            case "dni":
                try {
                    Conexion con = new Conexion();
                    Statement st = con.conexion().createStatement();
                    ResultSet rs = st.executeQuery("select dni, nombre, primerApellido, segundoApellido from socios where dni = '" + campoBusqueda.getText() + "';");

                    while (rs.next()) {
                        dni = rs.getString("dni");
                        nombre = rs.getString("nombre");
                        primerApellido = rs.getString("primerApellido");
                        segundoApellido = rs.getString("segundoApellido");

                        listaBuscar.getItems().add(nombre + " " + primerApellido + " " + segundoApellido + " DNI -> " + dni);

                    }
                    con.closeConnection();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "nombre":

                try {
                    Conexion con = new Conexion();
                    Statement st = con.conexion().createStatement();
                    ResultSet rs = st.executeQuery("select dni, nombre, primerApellido, segundoApellido from socios where nombre = '" + campoBusqueda.getText() + "';");

                    while (rs.next()) {
                        dni = rs.getString("dni");
                        nombre = rs.getString("nombre");
                        primerApellido = rs.getString("primerApellido");
                        segundoApellido = rs.getString("segundoApellido");

                        listaBuscar.getItems().add(nombre + " " + primerApellido + " " + segundoApellido + " DNI -> " + dni);

                    }
                    con.closeConnection();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "primerApellido":
                try {
                    Conexion con = new Conexion();
                    Statement st = con.conexion().createStatement();
                    ResultSet rs = st.executeQuery("select dni, nombre, primerApellido, segundoApellido from socios where primerApellido = '" + campoBusqueda.getText() + "';");

                    while (rs.next()) {
                        dni = rs.getString("dni");
                        nombre = rs.getString("nombre");
                        primerApellido = rs.getString("primerApellido");
                        segundoApellido = rs.getString("segundoApellido");

                        listaBuscar.getItems().add(nombre + " " + primerApellido + " " + segundoApellido + " DNI -> " + dni);

                    }
                    con.closeConnection();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "segundoApellido":
                try {
                    Conexion con = new Conexion();
                    Statement st = con.conexion().createStatement();
                    ResultSet rs = st.executeQuery("select dni, nombre, primerApellido, segundoApellido from socios where segundoApellido = '" + campoBusqueda.getText() + "';");

                    while (rs.next()) {
                        dni = rs.getString("dni");
                        nombre = rs.getString("nombre");
                        primerApellido = rs.getString("primerApellido");
                        segundoApellido = rs.getString("segundoApellido");

                        listaBuscar.getItems().add(nombre + " " + primerApellido + " " + segundoApellido + " DNI -> " + dni);

                    }
                    con.closeConnection();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "correo":
                try {
                    Conexion con = new Conexion();
                    Statement st = con.conexion().createStatement();
                    ResultSet rs = st.executeQuery("select dni, nombre, primerApellido, segundoApellido from socios where correo = '" + campoBusqueda.getText() + "';");

                    while (rs.next()) {
                        dni = rs.getString("dni");
                        nombre = rs.getString("nombre");
                        primerApellido = rs.getString("primerApellido");
                        segundoApellido = rs.getString("segundoApellido");

                        listaBuscar.getItems().add(nombre + " " + primerApellido + " " + segundoApellido + " DNI -> " + dni);

                    }
                    con.closeConnection();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }
        }catch (NullPointerException e){
               alertWarning("Rellene el campo de búsqueda");
           }
       }
    }

    public void comboSelectBuscar(ActionEvent event)  {
        //DNI, Nombre, primerApellido, segundoApellido, email
        try {
            if (comboBuscar.getSelectionModel().getSelectedItem().equals("DNI")) {
                labelBuscar.setText("DNI");
                campoBusqueda.setPromptText("DNI");
                campo = "dni";
            } else if (comboBuscar.getSelectionModel().getSelectedItem().equals("Nombre")) {
                labelBuscar.setText("Nombre");
                campoBusqueda.setPromptText("Nombre");
                campo = "nombre";
            } else if (comboBuscar.getSelectionModel().getSelectedItem().equals("Primer Apellido")) {
                labelBuscar.setText("Primer Apellido");
                campoBusqueda.setPromptText("Primer Apellido");
                campo = "primerApellido";
            } else if (comboBuscar.getSelectionModel().getSelectedItem().equals("Segundo Apellido")) {
                labelBuscar.setText("Segundo Apellido");
                campoBusqueda.setPromptText("Segundo Apellido");
                campo = "segundoApellido";
            } else if (comboBuscar.getSelectionModel().getSelectedItem().equals("Email")) {
                labelBuscar.setText("Email");
                campoBusqueda.setPromptText("Email");
                campo = "correo";
            }
        }catch (NullPointerException e){

        }
    }

    public void clickAtrasBuscar(ActionEvent event) {
        if(event.getSource() == atrasBuscar){
            Stage stage = (Stage)this.atrasBuscar.getScene().getWindow();
            stage.close();
        }
    }

    public static void alertWarning(String message){
        Alert mensaje = new Alert(Alert.AlertType.WARNING);
        mensaje.setTitle("Aviso");
        mensaje.setContentText(message);
        mensaje.showAndWait();
    }

    public static void alertInfo(String message){
        Alert mensaje = new Alert(Alert.AlertType.INFORMATION);
        mensaje.setTitle("Información");
        mensaje.setContentText(message);
        mensaje.showAndWait();
    }

}
