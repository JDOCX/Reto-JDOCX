package com.example.demoreal;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import javax.mail.MessagingException;
import javax.swing.*;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ControladorGestionNormalUser {
    public Button busqueda;
    public Button addUser;
    public TextField txtNombre;
    public TextField txtApellido1;
    public TextField txtApellido2;
    public TextField txtDni;
    public TextField txtFecha;
    public TextField txtEmail;
    public TextField txtTelefono;





    public void buscarSocio(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("buscar.fxml"));
        Parent root = loader.load();
        ControladorBuscar controller = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.getIcons().add(new Image("C:\\Users\\Diego\\IdeaProjects\\demoReal\\src\\main\\resources\\com\\example\\demoreal\\coding.png"));
        stage.setTitle("Buscar Socio");
        stage.setScene(scene);
        stage.show();
    }

    public void agregarSocio(ActionEvent event) { //Arreglar ahora tiene mas campos
        if(event.getSource() == addUser){ //Fix if textFields are Empty
            boolean altaRealizada = false;
            String dni = "";
            int idUser = 0;
            String id = "", nombre = "", primerApellido = "", segundoApellido = "", fechaNacimiento = "", contrasena = "";
            ArrayList<String> dniS = new ArrayList<>();

            //Insertando los datos correspondientes en la tabla socios y comprobando que no se repita ningun dni.
            try{
                Conexion con = new Conexion();
                Statement statement = con.conexion().createStatement();
                ResultSet rs = statement.executeQuery("select dni from socios");
                while(rs.next()){
                    dniS.add(rs.getString("dni"));
                }

                ResultSet rs1 = statement.executeQuery("select id from usuariosWeb where correo = '" + txtEmail.getText() + "';");
                while(rs1.next()){
                    idUser = rs1.getInt("id");
                }

                boolean dniRepetido = false;
                for(int i = 0; i < dniS.size(); i++){
                    if(dniS.get(i).equals(txtDni.getText())){
                        dniRepetido = true;
                        break;
                    }
                }

                if(validarDni(txtDni.getText())&&(!txtNombre.getText().equals("")&&(!txtApellido1.getText().equals("")&&(!txtApellido2.getText().equals("")&&(!txtDni.getText().equals("")&&(!txtFecha.getText().equals("")&&(!txtEmail.getText().equals("")&&(!dniRepetido)))))))) {
                    String telefono;
                    String email;
                    if(txtTelefono.getText().equals("")){
                        telefono = "null";
                    }else {
                        telefono = txtTelefono.getText();
                    }
                    int update = statement.executeUpdate("INSERT INTO socios (dni, nombre, primerApellido, segundoApellido, correo, contrasena, fechaNacimiento, telefono, idUsuario) VALUES ('" + txtDni.getText() + "','" + txtNombre.getText() + "','" + txtApellido1.getText() + "','" + txtApellido2.getText() + "','" + txtEmail.getText() + "','" + generarContrasena() + "','" + txtFecha.getText() + "','" + telefono + "','" + idUser + "');");
                    dni = txtDni.getText();
                    email = txtEmail.getText();
                    int update2 = statement.executeUpdate("UPDATE usuariosWeb SET esSocio = true where correo = '" + email + "';");
                    altaRealizada = true;

                }else {
                    JOptionPane.showMessageDialog(null, "Asegúrese de no haber dejado ningún campo requerido en blanco, haber colocado correctamente el DNI, o que no este registrado anteriormente.", "Aviso", 1);
                    altaRealizada = false;
                }
            }catch (IndexOutOfBoundsException | SQLException ex){
                JOptionPane.showMessageDialog(null, "Rellene los campos que están vacíos");
            };

            //Enviar Mail de Alta
            boolean mailEnviado = false;
            if(altaRealizada) {
                alertInfo("Dado de alta satisfactoriamente");
                try{
                    Conexion con = new Conexion();
                    Statement st = con.conexion().createStatement();
                    ResultSet rs = st.executeQuery("select * from socios where dni = '" + dni + "'");
                    while (rs.next()){
                        id = rs.getString("id");
                        nombre = rs.getString("nombre");
                        primerApellido = rs.getString("primerApellido");
                        segundoApellido = rs.getString("segundoApellido");
                        fechaNacimiento = rs.getString("fechaNacimiento") ;
                        contrasena = rs.getString("contrasena");
                    }
                    Mailto mail = new Mailto("config/configuracion.prop");
                    mail.enviarEmail("Equipo de JDOCX", "ID: " + id + "\nNombre: " + nombre + "\nPrimer Apellido: " + primerApellido + "\nSegundo Apellido: " + segundoApellido + "\nFecha de Nacimiento: " + fechaNacimiento + "\nA continuación verá la contraseña que se le ha asignado por defecto por favor asegúrese de cambiarla por su seguridad.\nContraseña: " + contrasena, txtEmail.getText());
                    con.closeConnection();
                    mailEnviado = true;
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
            if(mailEnviado){
                txtNombre.setText("");
                txtApellido1.setText("");
                txtApellido2.setText("");
                txtDni.setText("");
                txtFecha.setText("");
                txtEmail.setText("");
                txtTelefono.setText("");
            }
        }
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

    private String generarContrasena(){
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 10; i++){
            int rd = 0;
            rd = (int)(Math.random() * chars.length());
            sb.append(chars.charAt(rd));
        }
        return sb.toString();
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

    private String generarNumero(){
        String numero = "";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 8; i++){
            int x;
            x = (int) (Math.random() * 10);
            sb.append(x);
        }

        numero = sb.toString();
        return numero;
    }



}
