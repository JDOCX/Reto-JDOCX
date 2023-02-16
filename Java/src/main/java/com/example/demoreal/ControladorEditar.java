package com.example.demoreal;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.paint.Paint;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ControladorEditar {

    public Button botonBuscar;
    public TextField txtBuscar;
    public Button atras;
    public TextField bNombre;
    public TextField bApellido1;
    public TextField bApellido2;
    public TextField bEmail;
    public TextField bDni;
    public Button botonConfirmar;
    public TextField bId;
    public ListView<String> listView;
    public Button seleccion;
    public TextField bTelefono;
    public ComboBox<String> comboEditar;
    public Label labelEditar;
    public String campo;

    public ComboBox<String> comboEditarZona;
    public ComboBox<String> comboEditarAsiento;
    public int asientoSocio;
    public ArrayList<String> asientosOcupados = new ArrayList<>();
    public ArrayList<String> asientosLibres = new ArrayList<>();

    public void clickBuscar(ActionEvent event) {
        if (event.getSource() == botonBuscar) { //Si el resultado que devuelve la query está vacío realizar un ALERT
           try{
            String dni = null;
            String nombre = null;
            String primerApellido = null;
            String segundoApellido = null;
            switch (campo){ //Dependiendo del campo seleccionado en el filtro ejecutamos la query a la BBDD
                case "dni":
                    try {
                        Conexion con = new Conexion();
                        Statement st = con.conexion().createStatement();
                        ResultSet rs = st.executeQuery("select dni, nombre, primerApellido, segundoApellido from socios where dni = '" + txtBuscar.getText() + "';");

                        while (rs.next()) {
                            dni = rs.getString("dni");
                            nombre = rs.getString("nombre");
                            primerApellido = rs.getString("primerApellido");
                            segundoApellido = rs.getString("segundoApellido");

                            //Agregamos el resultado devuelto por la query a la ListView
                            listView.getItems().add(nombre + " " + primerApellido + " " + segundoApellido + " DNI -> " + dni);

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
                        ResultSet rs = st.executeQuery("select dni, nombre, primerApellido, segundoApellido from socios where nombre = '" + txtBuscar.getText() + "';");

                        while (rs.next()) {
                            dni = rs.getString("dni");
                            nombre = rs.getString("nombre");
                            primerApellido = rs.getString("primerApellido");
                            segundoApellido = rs.getString("segundoApellido");

                            listView.getItems().add(nombre + " " + primerApellido + " " + segundoApellido + " DNI -> " + dni);

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
                        ResultSet rs = st.executeQuery("select dni, nombre, primerApellido, segundoApellido from socios where primerApellido = '" + txtBuscar.getText() + "';");

                        while (rs.next()) {
                            dni = rs.getString("dni");
                            nombre = rs.getString("nombre");
                            primerApellido = rs.getString("primerApellido");
                            segundoApellido = rs.getString("segundoApellido");

                            listView.getItems().add(nombre + " " + primerApellido + " " + segundoApellido + " DNI -> " + dni);

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
                        ResultSet rs = st.executeQuery("select dni, nombre, primerApellido, segundoApellido from socios where segundoApellido = '" + txtBuscar.getText() + "';");

                        while (rs.next()) {
                            dni = rs.getString("dni");
                            nombre = rs.getString("nombre");
                            primerApellido = rs.getString("primerApellido");
                            segundoApellido = rs.getString("segundoApellido");

                            listView.getItems().add(nombre + " " + primerApellido + " " + segundoApellido + " DNI -> " + dni);

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
                        ResultSet rs = st.executeQuery("select dni, nombre, primerApellido, segundoApellido from socios where correo = '" + txtBuscar.getText() + "';");

                        while (rs.next()) {
                            dni = rs.getString("dni");
                            nombre = rs.getString("nombre");
                            primerApellido = rs.getString("primerApellido");
                            segundoApellido = rs.getString("segundoApellido");

                            listView.getItems().add(nombre + " " + primerApellido + " " + segundoApellido + " DNI -> " + dni);

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

    public void pulsarAtras(ActionEvent event) {
        Stage stage = (Stage) this.atras.getScene().getWindow();
        stage.close();
    }

    public void keyPressed(KeyEvent keyEvent) {
        if(keyEvent.getCode() == KeyCode.ENTER){
            String id = "", nombre = "", dni = "", primerApellido = "", segundoApellido = "", email = "";
            try{
                Conexion con = new Conexion();
                Statement st = con.conexion().createStatement();
                ResultSet rs = st.executeQuery("select * from socios where dni = '" + bDni.getText() + "'");

                while (rs.next()){
                    bId.setText(rs.getString("id"));
                    bNombre.setText(rs.getString("nombre"));
                    bDni.setText(rs.getString("dni"));
                    bApellido1.setText(rs.getString("primerApellido"));
                    bApellido2.setText(rs.getString("segundoApellido"));
                    bEmail.setText(rs.getString("correo"));
                }

            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void pulsarConfirmar(ActionEvent event) {
        if(event.getSource() == botonConfirmar) {
            ArrayList<String> dniS = new ArrayList<>();
            boolean dniRepetido = false;
            try {
                Conexion con = new Conexion();
                Statement statement = con.conexion().createStatement();
                ResultSet rs = statement.executeQuery("select dni from socios");
                //Guardamos todos los dniS existentes en la base de datos en el ArrayList (dniS)
                while (rs.next()) {
                    dniS.add(rs.getString("dni"));
                }
                //Comprobamos que el dni introducido no se encuentra en la base de datos (evita que se repitan dniS)
                for (int i = 0; i < dniS.size(); i++) {
                    if (dniS.get(i).equals(bDni.getText())) {
                        dniRepetido = true;
                        break;
                    }
                }

                if (validarDni(bDni.getText()) && (!bNombre.getText().equals("") && (!bApellido1.getText().equals("") && (!bApellido2.getText().equals("") && (!bDni.getText().equals("") && (!bId.getText().equals("") && (!bEmail.getText().equals("")))))))) {
                    String dni = bDni.getText();

                    Statement st = con.conexion().createStatement();
                    int update = st.executeUpdate("UPDATE socios SET nombre = '" + bNombre.getText() + "', primerApellido = '" + bApellido1.getText() + "', segundoApellido = '" + bApellido2.getText() + "', telefono = '" + bTelefono.getText() + "', correo = '" + bEmail.getText() + "' where dni = '" + dni + "'");

                    con.closeConnection();

                }else {
                    alertWarning("Revise que todos los campos estén rellenos");
                }


            } catch (SQLException | StringIndexOutOfBoundsException e) {
                alertWarning("Revise que todos los campos estén rellenos");
            }
            try{
                int idZona = 0;
                if(comboEditarZona.getSelectionModel().getSelectedItem().equals("Norte")){
                    idZona = 1;
                }
                if (comboEditarZona.getSelectionModel().getSelectedItem().equals("Sur")){
                    idZona = 2;
                }
                if(comboEditarZona.getSelectionModel().getSelectedItem().equals("Este")){
                    idZona = 3;
                }
                if(comboEditarZona.getSelectionModel().getSelectedItem().equals("Oeste")){
                    idZona = 4;
                }
                Conexion con = new Conexion();
                Statement st = con.conexion().createStatement();
                int update = st.executeUpdate("UPDATE abonos SET idZona = '" + idZona + "', asiento = '" + String.valueOf(comboEditarAsiento.getSelectionModel().getSelectedItem() + "' where idSocio = '" + bId.getText() + "'"));
                alertInfo("Cambio realizado con éxito");
            }catch (SQLException | NullPointerException e){

            }

        }
    }

    public void rellenar(KeyEvent keyEvent) {
        if(keyEvent.getCode() == KeyCode.ENTER){
            //nombre + " " +  primerApellido + " " + segundoApellido + " DNI ->" + dni
            String nombre = null;
            String dni = null;
            String lista = (listView.getItems().get(listView.getEditingIndex()));
            String nombreZona = "";
            int idZona = 0;
            int asiento = 0;

            for (int i = 0; i < lista.length(); i++){
                if(lista.charAt(i) == ' '){
                    nombre = lista.substring(0,i);
                    break;
                }
            }
            int index = lista.lastIndexOf(" ");
            dni = lista.substring(index+1);


            //Codigo para pillar de la base de Datos
            int id = 0;
            try{
                Conexion con = new Conexion();
                Statement st = con.conexion().createStatement();
                ResultSet rs = st.executeQuery("select nombre, primerApellido, segundoApellido, dni, id, correo, telefono from socios where nombre = '" + nombre + "' and dni = '" + dni + "'");
                while (rs.next()){
                    String nombre1 = rs.getString("nombre");
                    String primerApellido = rs.getString("primerApellido");
                    String segundoApellido = rs.getString("segundoApellido");
                    String dNi = rs.getString("dni");
                         id = rs.getInt("id");
                    String correo = rs.getString("correo");
                    String telefono = rs.getString("telefono");

                    bNombre.setText(nombre1);
                    bApellido1.setText(primerApellido);
                    bApellido2.setText(segundoApellido);
                    bDni.setText(dNi);
                    bId.setText(String.valueOf(id));
                    bEmail.setText(correo);
                    bTelefono.setText(telefono);
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            //Carga la informacion de la tabla zona y abonos

            try {
                Conexion con = new Conexion();
                Statement st = con.conexion().createStatement();
                ResultSet rs2 = st.executeQuery("select asiento, idZona from abonos where idSocio = '" + id + "'");


                while (rs2.next()) {
                    asiento = rs2.getInt("asiento");
                    idZona = rs2.getInt("idZona");
                }
                con.closeConnection();
            }catch (SQLException e){
                e.printStackTrace();
            }

            try {
                Conexion con = new Conexion();
                Statement st = con.conexion().createStatement();
                ResultSet rs3 = st.executeQuery("select nombre from zona where id = '" + idZona + "'");


                while (rs3.next()) {
                    nombreZona = rs3.getString("nombre");
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
            //Convierte asiento a String para visualizarlo en el ComboBox
            String asiento1 = String.valueOf(asiento);

            comboEditarZona.getSelectionModel().select(nombreZona);
            comboEditarAsiento.getSelectionModel().select(asiento1);


        }
    }

    public void clickSeleccionar(ActionEvent event) {
        if(event.getSource() == seleccion) {

            //nombre + " " +  primerApellido + " " + segundoApellido + " DNI ->" + dni
            String nombre = null;
            String lista = "";
            String dni = null;
            String nombreZona = "";
            int idZona = 0;
            int asiento = 0;

            if (listView.getEditingIndex() == -1) {

            } else {
                lista = (listView.getItems().get(listView.getEditingIndex()));
            }

            for (int i = 0; i < lista.length(); i++) {
                if (lista.charAt(i) == ' ') {
                    nombre = lista.substring(0, i);
                    break;
                }
            }
            int index = lista.lastIndexOf(" ");
            dni = lista.substring(index + 1);
            int id = 0;
            //Codigo para pillar de la base de Datos
            try {
                Conexion con = new Conexion();
                Statement st = con.conexion().createStatement();
                ResultSet rs = st.executeQuery("select nombre, primerApellido, segundoApellido, dni, id, correo, telefono from socios where nombre = '" + nombre + "' and dni = '" + dni + "'");
                while (rs.next()) {
                    String nombre1 = rs.getString("nombre");
                    String primerApellido = rs.getString("primerApellido");
                    String segundoApellido = rs.getString("segundoApellido");
                    String dNi = rs.getString("dni");
                    id = rs.getInt("id");
                    String correo = rs.getString("correo");
                    String telefono = rs.getString("telefono");

                    bNombre.setText(nombre1);
                    bApellido1.setText(primerApellido);
                    bApellido2.setText(segundoApellido);
                    bDni.setText(dNi);
                    bId.setText(String.valueOf(id));
                    bEmail.setText(correo);
                    bTelefono.setText(telefono);
                }
                con.closeConnection();
            } catch(SQLException e){
                    e.printStackTrace();
                }
            //Carga la informacion de la tabla zona y abonos

            try {
                Conexion con = new Conexion();
                Statement st = con.conexion().createStatement();
                ResultSet rs2 = st.executeQuery("select asiento, idZona from abonos where idSocio = '" + id + "'");


                while (rs2.next()) {
                    asiento = rs2.getInt("asiento");
                    idZona = rs2.getInt("idZona");
                }
                con.closeConnection();
            }catch (SQLException e){
                e.printStackTrace();
            }

            try {
                Conexion con = new Conexion();
                Statement st = con.conexion().createStatement();
                ResultSet rs3 = st.executeQuery("select nombre from zona where id = '" + idZona + "'");


                while (rs3.next()) {
                    nombreZona = rs3.getString("nombre");
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
                //Convierte asiento a String para visualizarlo en el ComboBox
                String asiento1 = String.valueOf(asiento);

                comboEditarZona.getSelectionModel().select(nombreZona);
                comboEditarAsiento.getSelectionModel().select(asiento1);


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

    public static boolean validarDni(String dniVal){
        boolean valido = false;
        int dniCliente = 0;
        try {
            dniCliente = Integer.parseInt(dniVal.substring(0, dniVal.length() - 1));
        }catch (NumberFormatException | StringIndexOutOfBoundsException e){

        }
        int resto = 0;
        String letra = "";
        String[] letraCorrecta = {"T","R","W","A","G","M","Y","F","P","D","X","B","N","J","Z","S","Q","V","H","L","C","K","E"};

        resto = dniCliente % 23;
        letra = letraCorrecta[resto];

        if(Character.compare(dniVal.charAt(dniVal.length()-1), letra.charAt(0)) == 0){
            valido = true;
        }else
            valido = false;

        if(dniVal.length() != 9){
            valido = false;
        }

        return valido;
    }

    public void onShowEditar(Event event) {
        ObservableList<String> items = FXCollections.observableArrayList();
        items.addAll("DNI", "Nombre", "Primer Apellido", "Segundo Apellido", "Email");
        comboEditar.setItems(items);
    }

    public void comoSelectEditar(ActionEvent event) {
        try {
            if (comboEditar.getSelectionModel().getSelectedItem().equals("DNI")) {
                labelEditar.setText("DNI");
                txtBuscar.setPromptText("DNI");
                campo = "dni";
            } else if (comboEditar.getSelectionModel().getSelectedItem().equals("Nombre")) {
                labelEditar.setText("Nombre");
                txtBuscar.setPromptText("Nombre");
                campo = "nombre";
            } else if (comboEditar.getSelectionModel().getSelectedItem().equals("Primer Apellido")) {
                labelEditar.setText("Primer Apellido");
                txtBuscar.setPromptText("Primer Apellido");
                campo = "primerApellido";
            } else if (comboEditar.getSelectionModel().getSelectedItem().equals("Segundo Apellido")) {
                labelEditar.setText("Segundo Apellido");
                txtBuscar.setPromptText("Segundo Apellido");
                campo = "segundoApellido";
            } else if (comboEditar.getSelectionModel().getSelectedItem().equals("Email")) {
                labelEditar.setText("Email");
                txtBuscar.setPromptText("Email");
                campo = "correo";
            }
        }catch (NullPointerException e){

        }
    }

    public void keyBuscarEditar(KeyEvent keyEvent) {
        if(keyEvent.getCode() == KeyCode.ENTER){ //Búsqueda en la Base de Datos segun el campo dado
            try{
            String dni = null;
            String nombre = null;
            String primerApellido = null;
            String segundoApellido = null;
            switch (campo){
                case "dni": //Campo DNI
                    try {
                        Conexion con = new Conexion();
                        Statement st = con.conexion().createStatement();
                        ResultSet rs = st.executeQuery("select dni, nombre, primerApellido, segundoApellido from socios where dni = '" + txtBuscar.getText() + "';");

                        while (rs.next()) {
                            dni = rs.getString("dni");
                            nombre = rs.getString("nombre");
                            primerApellido = rs.getString("primerApellido");
                            segundoApellido = rs.getString("segundoApellido");

                            listView.getItems().add(nombre + " " + primerApellido + " " + segundoApellido + " DNI -> " + dni);

                        }
                        con.closeConnection();

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case "nombre": //Campo Nombre

                    try {
                        Conexion con = new Conexion();
                        Statement st = con.conexion().createStatement();
                        ResultSet rs = st.executeQuery("select dni, nombre, primerApellido, segundoApellido from socios where nombre = '" + txtBuscar.getText() + "';");

                        while (rs.next()) {
                            dni = rs.getString("dni");
                            nombre = rs.getString("nombre");
                            primerApellido = rs.getString("primerApellido");
                            segundoApellido = rs.getString("segundoApellido");

                            listView.getItems().add(nombre + " " + primerApellido + " " + segundoApellido + " DNI -> " + dni);

                        }
                        con.closeConnection();

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case "primerApellido": //Campo Primer Apellido
                    try {
                        Conexion con = new Conexion();
                        Statement st = con.conexion().createStatement();
                        ResultSet rs = st.executeQuery("select dni, nombre, primerApellido, segundoApellido from socios where primerApellido = '" + txtBuscar.getText() + "';");

                        while (rs.next()) {
                            dni = rs.getString("dni");
                            nombre = rs.getString("nombre");
                            primerApellido = rs.getString("primerApellido");
                            segundoApellido = rs.getString("segundoApellido");

                            listView.getItems().add(nombre + " " + primerApellido + " " + segundoApellido + " DNI -> " + dni);

                        }
                        con.closeConnection();

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case "segundoApellido": //Campo Segundo Apellido
                    try {
                        Conexion con = new Conexion();
                        Statement st = con.conexion().createStatement();
                        ResultSet rs = st.executeQuery("select dni, nombre, primerApellido, segundoApellido from socios where segundoApellido = '" + txtBuscar.getText() + "';");

                        while (rs.next()) {
                            dni = rs.getString("dni");
                            nombre = rs.getString("nombre");
                            primerApellido = rs.getString("primerApellido");
                            segundoApellido = rs.getString("segundoApellido");

                            listView.getItems().add(nombre + " " + primerApellido + " " + segundoApellido + " DNI -> " + dni);

                        }
                        con.closeConnection();

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case "correo": //Campo Correo
                    try {
                        Conexion con = new Conexion();
                        Statement st = con.conexion().createStatement();
                        ResultSet rs = st.executeQuery("select dni, nombre, primerApellido, segundoApellido from socios where correo = '" + txtBuscar.getText() + "';");

                        while (rs.next()) {
                            dni = rs.getString("dni");
                            nombre = rs.getString("nombre");
                            primerApellido = rs.getString("primerApellido");
                            segundoApellido = rs.getString("segundoApellido");

                            listView.getItems().add(nombre + " " + primerApellido + " " + segundoApellido + " DNI -> " + dni);

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

    public void clickComboZona(ActionEvent event) {

    }

    public void clickComboAsiento(ActionEvent event) {

    }

    public void showZona(Event event) {
        ObservableList<String> zona = FXCollections.observableArrayList();
        zona.addAll("Norte", "Sur", "Este", "Oeste");
        comboEditarZona.setItems(zona);
    }

    public void showAsiento(Event event) {
        int idZona = 0;
        asientosLibres.clear();
        if(comboEditarZona.getSelectionModel().getSelectedItem().equals("Norte")){
            idZona = 1;
        }
        if(comboEditarZona.getSelectionModel().getSelectedItem().equals("Sur")){
            idZona = 2;
        }
        if(comboEditarZona.getSelectionModel().getSelectedItem().equals("Este")){
            idZona = 3;
        }
        if(comboEditarZona.getSelectionModel().getSelectedItem().equals("Oeste")){
            idZona = 4;
        }

        try{
            Conexion con = new Conexion();
            Statement st = con.conexion().createStatement();
            ResultSet rs = st.executeQuery("select asiento from abonos where idZona = '" + idZona + "';");
            while (rs.next()){
                asientosOcupados.add(String.valueOf(rs.getInt("asiento")));
            }

            //Tenemos 1000 asientos en cada lado del campo
            for (int i = 0; i < 1000; i++){
                asientosLibres.add(String.valueOf(i));
            }
            //Removemos los asientos ocupados de la lista de asientos desocupados
            asientosLibres.removeAll(asientosOcupados);


            con.closeConnection();
        }catch (SQLException e){
            e.printStackTrace();
        }

        ObservableList<String> items = FXCollections.observableArrayList();
        items.addAll(asientosLibres);
        comboEditarAsiento.setItems(items);


    }

}
