package com.example.demoreal;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

public class ControladorBorrar {

    public Button buscarBorrar;
    public TextField txtDniBorrar;
    public Button atrasBorrar;
    public ListView<String> listViewBorrar;
    public Button eliminar;
    public TextField txtBusqueda;
    public Label labelBorrar;
    public ComboBox<String> comboBorrar;
    public String campo;
    public String idUsuario;
    public static String nombreSocioBorrar;

    public void clickBuscarBorrar(ActionEvent event) {
        if (event.getSource() == buscarBorrar) { //Si el resultado que devuelve la query está vacío realizar un ALERT
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
                        ResultSet rs = st.executeQuery("select idUsuario, dni, nombre, primerApellido, segundoApellido from socios where dni = '" + txtBusqueda.getText() + "';");

                        while (rs.next()) {
                            idUsuario = rs.getString("idUsuario");
                            dni = rs.getString("dni");
                            nombre = rs.getString("nombre");
                            primerApellido = rs.getString("primerApellido");
                            segundoApellido = rs.getString("segundoApellido");

                            listViewBorrar.getItems().add(nombre + " " + primerApellido + " " + segundoApellido + " DNI -> " + dni);

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
                        ResultSet rs = st.executeQuery("select idUsuario, dni, nombre, primerApellido, segundoApellido from socios where nombre = '" + txtBusqueda.getText() + "';");

                        while (rs.next()) {
                            idUsuario = rs.getString("idUsuario");
                            dni = rs.getString("dni");
                            nombre = rs.getString("nombre");
                            primerApellido = rs.getString("primerApellido");
                            segundoApellido = rs.getString("segundoApellido");

                            listViewBorrar.getItems().add(nombre + " " + primerApellido + " " + segundoApellido + " DNI -> " + dni);

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
                        ResultSet rs = st.executeQuery("select idUsuario, dni, nombre, primerApellido, segundoApellido from socios where primerApellido = '" + txtBusqueda.getText() + "';");

                        while (rs.next()) {
                            idUsuario = rs.getString("idUsuario");
                            dni = rs.getString("dni");
                            nombre = rs.getString("nombre");
                            primerApellido = rs.getString("primerApellido");
                            segundoApellido = rs.getString("segundoApellido");

                            listViewBorrar.getItems().add(nombre + " " + primerApellido + " " + segundoApellido + " DNI -> " + dni);

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
                        ResultSet rs = st.executeQuery("select idUsuario, dni, nombre, primerApellido, segundoApellido from socios where segundoApellido = '" + txtBusqueda.getText() + "';");

                        while (rs.next()) {
                            idUsuario = rs.getString("idUsuario");
                            dni = rs.getString("dni");
                            nombre = rs.getString("nombre");
                            primerApellido = rs.getString("primerApellido");
                            segundoApellido = rs.getString("segundoApellido");

                            listViewBorrar.getItems().add(nombre + " " + primerApellido + " " + segundoApellido + " DNI -> " + dni);

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
                        ResultSet rs = st.executeQuery("select idUsuario, dni, nombre, primerApellido, segundoApellido from socios where correo = '" + txtBusqueda.getText() + "';");

                        while (rs.next()) {
                            idUsuario = rs.getString("idUsuario");
                            dni = rs.getString("dni");
                            nombre = rs.getString("nombre");
                            primerApellido = rs.getString("primerApellido");
                            segundoApellido = rs.getString("segundoApellido");

                            listViewBorrar.getItems().add(nombre + " " + primerApellido + " " + segundoApellido + " DNI -> " + dni);

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


    public void clickAtrasBorrar(ActionEvent event) {
        Stage stage = (Stage) this.atrasBorrar.getScene().getWindow();
        stage.close();
    }

    public void clickEliminar(ActionEvent event) {
        if(event.getSource() == eliminar) {
            if (!txtBusqueda.getText().equals("")) {
                if (alertConfirmation().get() == ButtonType.OK) {
                }
                //nombre + " " +  primerApellido + " " + segundoApellido + " DNI ->" + dni
                String nombre = null;
                String lista = "";
                String dni = null;

                if (listViewBorrar.getEditingIndex() == -1) {

                } else {
                    lista = listViewBorrar.getItems().get(listViewBorrar.getEditingIndex()); //Toma el elemento en el indice que se ha pulsado doble click sobre el.
                }

                for (int i = 0; i < lista.length(); i++) { //Subcadena del elemento de la ListView para obtener el nombre del Socio
                    if (lista.charAt(i) == ' ') {
                        nombre = lista.substring(0, i);
                        break;
                    }
                }
                int index = lista.lastIndexOf(" ");
                dni = lista.substring(index + 1); // Subcadena para obtener el dni

                //Codigo para pillar de la base de Datos
                try {
                    Conexion con = new Conexion();
                    //Elimina al socio de la base de datos
                    PreparedStatement ps = con.conexion().prepareStatement("delete from socios where nombre = '" + nombre + "' and dni = '" + dni + "';");
                    ps.executeUpdate();

                    listViewBorrar.getItems().remove(listViewBorrar.getEditingIndex());

                    //Actualiza el valor del campo esSocio de la tabla usuariosWeb cuando se elimina a un socio
                    PreparedStatement ps2 = con.conexion().prepareStatement("update usuariosweb set esSocio = false where id = '" + idUsuario + "'");
                    ps2.executeUpdate();
                    alertInfo("Eliminado con éxito");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    alertWarning("No se ha podido eliminar");
                }
            }

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

    public void clickComboBorrar(ActionEvent event) {
        try {
            if (comboBorrar.getSelectionModel().getSelectedItem().equals("DNI")) {
                labelBorrar.setText("DNI");
                txtBusqueda.setPromptText("DNI");
                campo = "dni";
            } else if (comboBorrar.getSelectionModel().getSelectedItem().equals("Nombre")) {
                labelBorrar.setText("Nombre");
                txtBusqueda.setPromptText("Nombre");
                campo = "nombre";
            } else if (comboBorrar.getSelectionModel().getSelectedItem().equals("Primer Apellido")) {
                labelBorrar.setText("Primer Apellido");
                txtBusqueda.setPromptText("Primer Apellido");
                campo = "primerApellido";
            } else if (comboBorrar.getSelectionModel().getSelectedItem().equals("Segundo Apellido")) {
                labelBorrar.setText("Segundo Apellido");
                txtBusqueda.setPromptText("Segundo Apellido");
                campo = "segundoApellido";
            } else if (comboBorrar.getSelectionModel().getSelectedItem().equals("Email")) {
                labelBorrar.setText("Email");
                txtBusqueda.setPromptText("Email");
                campo = "correo";
            }
        }catch (NullPointerException e){

        }
    }

    public void showBorrar(Event event) {
        ObservableList<String> items = FXCollections.observableArrayList();
        items.addAll("DNI", "Nombre", "Primer Apellido", "Segundo Apellido", "Email");
        comboBorrar.setItems(items);
    }

    public static Optional<ButtonType> alertConfirmation(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Confirmación");
        alert.setContentText("¿Está seguro que desea eliminar al socio seleccionado?"); //Añadir nombre de Socio a eliminar
        Optional<ButtonType> action = alert.showAndWait();
        
        return action;
    }
}


