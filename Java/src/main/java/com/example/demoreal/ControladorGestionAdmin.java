package com.example.demoreal;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.mail.MessagingException;
import javax.swing.*;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static com.example.demoreal.ControladorAbonos.*;

public class ControladorGestionAdmin{


    public Button busqueda;
    public Button deleteUser;
    public Button editUser;
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
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public void agregarSocio(ActionEvent event) throws IOException { //Arreglar ahora tiene mas campos
        if(event.getSource() == addUser){ //Fix if textFields are Empty
            String passwd = null;
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

                  telefono = txtTelefono.getText();
                  passwd = generarContrasena();
                  fechaNacimiento = txtFecha.getText();
                  int update = statement.executeUpdate("INSERT INTO socios (dni, nombre, primerApellido, segundoApellido, correo, contrasena, fechaNacimiento, telefono, idUsuario) VALUES ('" + txtDni.getText() + "','" + txtNombre.getText() + "','" + txtApellido1.getText() + "','" + txtApellido2.getText() + "','" + txtEmail.getText() + "','" + getMD5(passwd) + "','" + txtFecha.getText() + "','" + telefono + "','" + idUser + "');");
                  dni = txtDni.getText();
                  email = txtEmail.getText();
                  int update2 = statement.executeUpdate("UPDATE usuariosWeb SET esSocio = true where correo = '" + email + "';");
                  altaRealizada = true;

              }else {
                  JOptionPane.showMessageDialog(null, "Asegúrese de no haber dejado ningún campo requerido en blanco, haber colocado correctamente el DNI, o que no este registrado anteriormente.", "Aviso", 1);
                  altaRealizada = false;
              }
          }catch (IndexOutOfBoundsException | SQLException | NoSuchAlgorithmException ex){
              alertWarning("Asegúrese de estar registrado en nuestra web con el mismo email o de tener todos los campos obligatorios rellenos");
          };
            //Cargamos ventana de selección de zona y asiento
            if(altaRealizada) {
                FXMLLoader fxmlLoader = new FXMLLoader(GestionSocios.class.getResource("abono.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 804, 539);
                Stage stage = new Stage();
                stage.getIcons().add(new Image("C:\\Users\\Diego\\IdeaProjects\\demoReal\\src\\main\\resources\\com\\example\\demoreal\\coding.png"));
                stage.setTitle("Gestion de Socios");
                stage.setResizable(false);
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(scene);
                stage.showAndWait();
            }else {

            }


          //Enviar Mail de Alta
          boolean mailEnviado = false;
          if(altaRealizada && sitSel) {
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
                      contrasena = passwd;
                  }
                  Mailto mail = new Mailto("config/configuracion.prop");
                  mail.enviarEmail("Equipo de JDOCX", "ID: " + id + "\nNombre: " + nombre + "\nPrimer Apellido: " + primerApellido + "\nSegundo Apellido: " + segundoApellido + "\nFecha de Nacimiento: " + fechaNacimiento + "\nA continuación verá la contraseña que se le ha asignado por defecto por favor asegúrese de cambiarla por su seguridad.\nContraseña: " + contrasena + "\nZona: " + zona + "\nAsiento: " + asientoElegido, txtEmail.getText());
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

    public void editarSocio(ActionEvent event) throws MessagingException, IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Editar.fxml"));
        Parent root = loader.load();
        ControladorEditar controller = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.getIcons().add(new Image("C:\\Users\\Diego\\IdeaProjects\\demoReal\\src\\main\\resources\\com\\example\\demoreal\\coding.png"));
        stage.setTitle("Editar Socio");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();


    }

    public void borrarSocio(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("borrar.fxml"));
        Parent root = loader.load();
        ControladorBorrar controller = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.getIcons().add(new Image("C:\\Users\\Diego\\IdeaProjects\\demoReal\\src\\main\\resources\\com\\example\\demoreal\\coding.png"));
        stage.setTitle("Borrar Socio");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
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

    public static String getMD5(String input) throws NoSuchAlgorithmException {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);

            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }


}