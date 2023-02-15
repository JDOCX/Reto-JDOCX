package com.example.demoreal;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ControladorLogin {

    public Hyperlink lostPasswd;
    public TextField user;
    public PasswordField passwd;
    public Button enter;


    public void onLostClick(ActionEvent event) throws IOException {
        lostPasswd.setVisited(false);
        FXMLLoader fxmlLoader = new FXMLLoader(GestionSocios.class.getResource("lostPasswd.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 224);
        Stage stage = new Stage();
        stage.getIcons().add(new Image("C:\\Users\\Diego\\IdeaProjects\\demoReal\\src\\main\\resources\\com\\example\\demoreal\\coding.png"));
        stage.setTitle("Olvidé mi contraseña");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    public void onEnterClick(ActionEvent event) {
       validarUsuario();
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

    public void onKeyUser(KeyEvent keyEvent) {
        if(keyEvent.getCode() == KeyCode.ENTER) {
            validarUsuario();
        }
    }

    public void onKeyPass(KeyEvent keyEvent) {
        if(keyEvent.getCode() == KeyCode.ENTER) {
            validarUsuario();
        }
    }

    public void validarUsuario(){
        boolean esAdmin = false;
        String usuario = null;
        String contrasena = null;
        try{
            Conexion con = new Conexion();
            Statement st = con.conexion().createStatement();                                                                                                            //Hash
            ResultSet rs = st.executeQuery("select usuario, contrasena, esAdmin from gestores where usuario = '" + user.getText() + "' and contrasena = '" + getMD5(passwd.getText()) + "';");
            while (rs.next()){
                usuario = rs.getString("usuario");
                contrasena = rs.getString("contrasena");
                esAdmin = rs.getBoolean("esAdmin");
            }

            if((esAdmin) && (usuario.equals(user.getText())) && (contrasena.equals(getMD5(passwd.getText())))){
                FXMLLoader fxmlLoader = new FXMLLoader(GestionSocios.class.getResource("gestionAdmin.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 1000, 670);
                Stage stage = new Stage();
                stage.getIcons().add(new Image("C:\\Users\\Diego\\IdeaProjects\\demoReal\\src\\main\\resources\\com\\example\\demoreal\\coding.png"));
                stage.setTitle("Gestion de Socios");
                stage.setResizable(false);
                stage.setScene(scene);
                stage.show();
                alertInfo("Bienvenido\nHa iniciado sesión como administrador");
                Stage stage1 = (Stage) this.enter.getScene().getWindow();
                stage1.close();

            }else if((!esAdmin) && (usuario.equals(user.getText())) && (contrasena.equals(getMD5(passwd.getText())))) {
                FXMLLoader fxmlLoader = new FXMLLoader(GestionSocios.class.getResource("gestionUsuarioNormal.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 1000, 670);
                Stage stage = new Stage();
                stage.getIcons().add(new Image("C:\\Users\\Diego\\IdeaProjects\\demoReal\\src\\main\\resources\\com\\example\\demoreal\\coding.png"));
                stage.setTitle("Gestion de Socios");
                stage.setResizable(false);
                stage.setScene(scene);
                stage.show();
                alertInfo("Bienvenido\nHa iniciado sesión como usuario sin permisos de administrador");
                Stage stage1 = (Stage) this.enter.getScene().getWindow();
                stage1.close();
            }else{
                alertWarning("Acceso Denegado");
            }

        }catch (SQLException | NoSuchAlgorithmException | IOException | NullPointerException e){
            alertWarning("Acceso Denegado");
        }
    }
}
