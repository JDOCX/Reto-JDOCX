package com.example.demoreal;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.mail.MessagingException;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControladorLostPasswd {

    public Label introMail;
    public TextField txtMail;
    public Button aceptarMail;
    public Button aceptarMail2;
    public TextField c1;
    public TextField c2;
    public TextField c3;
    public TextField c4;
    public TextField c5;
    public TextField c6;
    public Button aceptarMail3;
    public PasswordField txtPasswd1;
    public PasswordField txtPasswd2;
    public static String numeroGenerado;
    public static String email;
    //Quitar el codigo que se imprime en la consola*******************************************************************
    public void enterPressed(KeyEvent keyEvent) throws IOException {
       if(keyEvent.getCode() == KeyCode.ENTER) {
           //Enviamos un Mail con el código generado
           boolean mailEnviado = false;
           numeroGenerado = generarNumero();
           email = txtMail.getText();
        if(validarMail(txtMail.getText())) {
            try {
                Mailto mailto = new Mailto("config/configuracion.prop");
                mailto.enviarEmail("Password", numeroGenerado, email);

                mailEnviado = true;
                alertInfo("Le hemos enviado un código a su email");
            } catch (IOException | MessagingException e) {
                alertError("Error");
            }
        }else
            alertWarning("Ingrese un email válido");

        if(mailEnviado){

            Stage stage1 = new Stage();
            stage1 = (Stage) this.aceptarMail.getScene().getWindow();
            stage1.close();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("lostPasswd2.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.getIcons().add(new Image("C:\\Users\\Diego\\IdeaProjects\\demoReal\\src\\main\\resources\\com\\example\\demoreal\\coding.png"));
            stage.setTitle("Olvidé mi contraseña");
            stage.setResizable(false);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.show();

        }
       }
    }

    public void onClick(ActionEvent event) throws IOException {
        //Enviamos un Mail con el código generado
        boolean mailEnviado = false;
        numeroGenerado = generarNumero();
        email = txtMail.getText();
        if(validarMail(txtMail.getText())) {
            try {
                Mailto mailto = new Mailto("config/configuracion.prop");
                mailto.enviarEmail("Password", numeroGenerado, email);

                mailEnviado = true;
                alertInfo("Le hemos enviado un código a su email");
            } catch (IOException | MessagingException e) {
                alertError("Error");
            }
        }else
            alertWarning("Ingrese un email válido");

        if(mailEnviado){

            Stage stage1 = new Stage();
            stage1 = (Stage) this.aceptarMail.getScene().getWindow();
            stage1.close();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("lostPasswd2.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.getIcons().add(new Image("C:\\Users\\Diego\\IdeaProjects\\demoReal\\src\\main\\resources\\com\\example\\demoreal\\coding.png"));
            stage.setTitle("Olvidé mi contraseña");
            stage.setResizable(false);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.show();

        }
    }

    public void onClick2(ActionEvent event) throws IOException {
        if(event.getSource() == aceptarMail2) {
            String numeroIngresado;
            StringBuilder sb = new StringBuilder();
            sb.append(c1.getText());
            sb.append(c2.getText());
            sb.append(c3.getText());
            sb.append(c4.getText());
            sb.append(c5.getText());
            sb.append(c6.getText());

            numeroIngresado = sb.toString();


            if (numeroGenerado.equals(numeroIngresado)) {
                Stage stage2 = new Stage();
                stage2 = (Stage) this.aceptarMail2.getScene().getWindow();
                stage2.close();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("lostPasswd3.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.getIcons().add(new Image("C:\\Users\\Diego\\IdeaProjects\\demoReal\\src\\main\\resources\\com\\example\\demoreal\\coding.png"));
                stage.setTitle("Olvidé mi contraseña");
                stage.setResizable(false);
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(scene);
                stage.show();
            }else {
                c1.setText("");
                c2.setText("");
                c3.setText("");
                c4.setText("");
                c5.setText("");
                c6.setText("");
                alertWarning("Código incorrecto");
            }
        }
    }
    public void onClick3(ActionEvent event) throws NoSuchAlgorithmException {
        if(event.getSource() == aceptarMail3){
            if(txtPasswd1.getText().equals(txtPasswd2.getText())){
                String hash = getMD5(txtPasswd2.getText());

                try{
                    Conexion con = new Conexion();
                    Statement st = con.conexion().createStatement();
                    int update = st.executeUpdate("UPDATE gestores SET contrasena = '" + hash + "' where correo = '" + email + "';" );
                    alertInfo("Contraseña cambiada con éxito");
                    Stage stage = new Stage();
                    stage = (Stage)this.aceptarMail3.getScene().getWindow();
                    stage.close();
                }catch (SQLException e){
                    alertError("No se ha podido cambiar la contraseña");
                }
            }else{
                txtPasswd1.setText("");
                txtPasswd2.setText("");
                alertWarning("Asegúrese de que ambas contraseñas sean iguales");
            }
        }
    }

    private String generarNumero(){
        String numero = "";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 6; i++){
            int x;
            x = (int) (Math.random() * 10);
            sb.append(x);
        }

        numero = sb.toString();
        return numero;
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

    public static void alertError(String message){
        Alert mensaje = new Alert(Alert.AlertType.ERROR);
        mensaje.setTitle("Error");
        mensaje.setContentText(message);
        mensaje.showAndWait();
    }

    public static boolean validarMail(String mail){
        boolean valido = false;
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        Matcher mather = pattern.matcher(mail);

        if (mather.find() == true) {
            valido = true;
        } else
            valido = false;

        return valido;
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

    public void enterPressed3(KeyEvent keyEvent) throws NoSuchAlgorithmException {
        if(keyEvent.getCode() == KeyCode.ENTER) {
            if (txtPasswd1.getText().equals(txtPasswd2.getText())) {
                String hash = getMD5(txtPasswd2.getText());

                try {
                    Conexion con = new Conexion();
                    Statement st = con.conexion().createStatement();
                    int update = st.executeUpdate("UPDATE gestores SET contrasena = '" + hash + "' where correo = '" + email + "';");
                    alertInfo("Contraseña cambiada con éxito");
                    Stage stage = new Stage();
                    stage = (Stage) this.aceptarMail3.getScene().getWindow();
                    stage.close();
                } catch (SQLException e) {
                    alertError("No se ha podido cambiar la contraseña");
                }
            } else {
                txtPasswd1.setText("");
                txtPasswd2.setText("");
                alertWarning("Asegúrese de que ambas contraseñas sean iguales");
            }
        }
    }
}
