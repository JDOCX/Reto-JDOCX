package com.example.demoreal;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.plaf.nimbus.State;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class ControladorAbonos {

    public Button buttonNorte;
    public Button buttonOeste;
    public Button buttonSur;
    public Button buttonEste;
    public TextField txtAsiento;
    public ComboBox<Integer> comboAsiento;
    public Button aceptarAsiento;
    public ArrayList<Integer> asientosOcupados = new ArrayList<>();
    public static ArrayList<Integer> asientosLibres = new ArrayList<>();
    public static int asientoElegido;
    public static String zona;
    public static int idSocio;
    public static boolean sitSel = false;


    public void clickNorte(ActionEvent event) {
        if(event.getSource() == buttonNorte){
            //Zona Norte
            zona = "Norte";
            sitSel = false;
            try{
                Conexion con = new Conexion();
                Statement st = con.conexion().createStatement();
                ResultSet rs = st.executeQuery("select asiento from abonos where idZona = 1");
                while (rs.next()){
                    asientosOcupados.add(rs.getInt("asiento"));
                }

                //Tenemos 1000 asientos en cada lado del campo
                for (int i = 0; i < 1000; i++){
                    asientosLibres.add(i);
                }
                //Removemos los asientos ocupados de la lista de asientos desocupados
                asientosLibres.removeAll(asientosOcupados);


                //Cargamos la ventana para elegir el asiento
                FXMLLoader fxmlLoader = new FXMLLoader(GestionSocios.class.getResource("asiento.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 600, 175);
                Stage stage = new Stage();
                stage.getIcons().add(new Image("C:\\Users\\Diego\\IdeaProjects\\demoReal\\src\\main\\resources\\com\\example\\demoreal\\coding.png"));
                stage.setTitle("Selección de asiento");
                stage.setResizable(false);
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(scene);
                stage.showAndWait();


                sitSel = true;
                Stage stage1 = (Stage) this.buttonNorte.getScene().getWindow();
                stage1.close();

                con.closeConnection();
            }catch (SQLException | IOException e){
                alertWarning("Se ha producido un error");
            }



        }
    }

    public void clickOeste(ActionEvent event) {
        if(event.getSource() == buttonOeste){
            zona = "Oeste";
            sitSel = false;
           //Zona Oeste
            try{
                Conexion con = new Conexion();
                Statement st = con.conexion().createStatement();
                ResultSet rs = st.executeQuery("select asiento from abonos where idZona = 4");
                while (rs.next()){
                    asientosOcupados.add(rs.getInt("asiento"));
                }
                System.out.println(asientosOcupados);
                //Tenemos 1000 asientos en cada lado del campo
                for (int i = 0; i < 1000; i++){
                    asientosLibres.add(i);
                }
                //Removemos los asientos ocupados de la lista de asientos desocupados
                asientosLibres.removeAll(asientosOcupados);


                //Cargamos la ventana para elegir el asiento
                FXMLLoader fxmlLoader = new FXMLLoader(GestionSocios.class.getResource("asiento.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 600, 175);
                Stage stage = new Stage();
                stage.getIcons().add(new Image("C:\\Users\\Diego\\IdeaProjects\\demoReal\\src\\main\\resources\\com\\example\\demoreal\\coding.png"));
                stage.setTitle("Selección de asiento");
                stage.setResizable(false);
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(scene);
                stage.showAndWait();

                sitSel = true;
                Stage stage1 = (Stage) this.buttonNorte.getScene().getWindow();
                stage1.close();

                con.closeConnection();
            }catch (SQLException | IOException e){
                alertWarning("Se ha producido un error");
            }
        }
    }

    public void clickSur(ActionEvent event) {
        if(event.getSource() == buttonSur){
            zona = "Sur";
            sitSel = false;
            //Zona Sur
            try{
                Conexion con = new Conexion();
                Statement st = con.conexion().createStatement();
                ResultSet rs = st.executeQuery("select asiento from abonos where idZona = 2");
                while (rs.next()){
                    asientosOcupados.add(rs.getInt("asiento"));
                }

                //Tenemos 1000 asientos en cada lado del campo
                for (int i = 0; i < 1000; i++){
                    asientosLibres.add(i);
                }
                //Removemos los asientos ocupados de la lista de asientos desocupados
                asientosLibres.removeAll(asientosOcupados);


                //Cargamos la ventana para elegir el asiento
                FXMLLoader fxmlLoader = new FXMLLoader(GestionSocios.class.getResource("asiento.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 600, 175);
                Stage stage = new Stage();
                stage.getIcons().add(new Image("C:\\Users\\Diego\\IdeaProjects\\demoReal\\src\\main\\resources\\com\\example\\demoreal\\coding.png"));
                stage.setTitle("Selección de asiento");
                stage.setResizable(false);
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(scene);
                stage.showAndWait();

                sitSel = true;
                Stage stage1 = (Stage) this.buttonNorte.getScene().getWindow();
                stage1.close();

                con.closeConnection();
            }catch (SQLException | IOException e){
                alertWarning("Se ha producido un error");
            }
        }
    }

    public void clickEste(ActionEvent event) {
        if(event.getSource() == buttonEste){
            zona = "Este";
            sitSel = false;
            //Zona Este
            try{
                Conexion con = new Conexion();
                Statement st = con.conexion().createStatement();
                ResultSet rs = st.executeQuery("select asiento from abonos where idZona = 3 ");
                while (rs.next()){
                    asientosOcupados.add(rs.getInt("asiento"));
                }

                //Tenemos 1000 asientos en cada lado del campo
                for (int i = 0; i < 1000; i++){
                    asientosLibres.add(i);
                }
                //Removemos los asientos ocupados de la lista de asientos desocupados
                asientosLibres.removeAll(asientosOcupados);


                //Cargamos la ventana para elegir el asiento
                FXMLLoader fxmlLoader = new FXMLLoader(GestionSocios.class.getResource("asiento.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 600, 175);
                Stage stage = new Stage();
                stage.getIcons().add(new Image("C:\\Users\\Diego\\IdeaProjects\\demoReal\\src\\main\\resources\\com\\example\\demoreal\\coding.png"));
                stage.setTitle("Selección de asiento");
                stage.setResizable(false);
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(scene);
                stage.showAndWait();

                sitSel = true;
                Stage stage1 = (Stage) this.buttonNorte.getScene().getWindow();
                stage1.close();

                con.closeConnection();
            }catch (SQLException | IOException e){
                alertWarning("Se ha producido un error");
            }
        }
    }
    public void onSelectAsiento(ActionEvent event) {
        txtAsiento.setText(String.valueOf(comboAsiento.getSelectionModel().getSelectedItem()));
    }

    public void showAsientos(Event event) {
        //Mostramos los asiento en el ComboBox de la ventana
        ObservableList<Integer> items = FXCollections.observableArrayList();
        items.addAll(asientosLibres);
        comboAsiento.setItems(items);
    }

    public void onClickAceptar(ActionEvent event) {
        if(event.getSource() == aceptarAsiento){
          asientoElegido = Integer.parseInt(txtAsiento.getText());

          if(zona.equals("Norte")){
              //Insertamos los datos en la tabla de abonos con el id de zona Norte
              int idZona = 0;
              try{
                  Conexion con = new Conexion();
                  //Sacamos la edad para saber a que categoría pertenece

                  int edad = obtenerEdad();
                  int opcion = 0;
                  int importe = 0;


                  if(edad < 25){ //esJoven
                      opcion = 1;
                      importe = 150;
                  }else if(edad > 25 && edad < 60){ //esAdulto
                      opcion = 2;
                      importe = 200;
                  }else if(edad > 60){ //esJubilado
                      opcion = 3;
                      importe = 100;
                  }

                  //Obtenemos el id de la zona
                  Statement st = con.conexion().createStatement();
                  ResultSet rs = st.executeQuery("select id from zona where nombre = 'Norte';");
                  while (rs.next()){
                      idZona = rs.getInt("id");
                  }


                  switch (opcion){
                      case 1:
                          PreparedStatement ps = con.conexion().prepareStatement("INSERT INTO abonos (importe, esJoven, asiento, idSocio, idZona) VALUES ('" + importe + "', true, '" + asientoElegido + "','" + obtenerIdSocio() + "','" + idZona + "');");
                          ps.executeUpdate();
                          break;

                      case 2:
                          PreparedStatement ps2 = con.conexion().prepareStatement("INSERT INTO abonos (importe, esAdulto, asiento, idSocio, idZona) VALUES ('" + importe + "', true, '" + asientoElegido + "','" + obtenerIdSocio() + "','" + idZona + "');");
                          ps2.executeUpdate();
                          break;

                      case 3:
                          PreparedStatement ps3 = con.conexion().prepareStatement("INSERT INTO abonos (importe, esJubilado, asiento, idSocio, idZona) VALUES ('" + importe + "', true, '" + asientoElegido + "','" + obtenerIdSocio() + "','" + idZona + "');");
                          ps3.executeUpdate();
                          break;
                  }

                  //Cerramos la ventana
                  Stage stage = (Stage) this.aceptarAsiento.getScene().getWindow();
                  stage.close();



              }catch (SQLException e){
                  e.printStackTrace();
                  alertWarning("Se ha producido un error");
              }


          }
          if(zona.equals("Oeste")){
              int idZona = 0;
              //Insertamos los datos en la tabla de abonos con el id de zona Oeste
              try{
                  Conexion con = new Conexion();
                  //Sacamos la edad para saber a que categoría pertenece

                  int edad = obtenerEdad();
                  int opcion = 0;
                  int importe = 0;


                  if(edad < 25){ //esJoven
                      opcion = 1;
                      importe = 150;
                  }else if(edad > 25 && edad < 60){ //esAdulto
                      opcion = 2;
                      importe = 200;
                  }else if(edad > 60){ //esJubilado
                      opcion = 3;
                      importe = 100;
                  }

                  //Obtenemos el id de la zona
                  Statement st = con.conexion().createStatement();
                  ResultSet rs = st.executeQuery("select id from zona where nombre = 'Oeste';");
                  while (rs.next()){
                      idZona = rs.getInt("id");
                  }


                  switch (opcion){
                      case 1:
                          PreparedStatement ps = con.conexion().prepareStatement("INSERT INTO abonos (importe, esJoven, asiento, idSocio, idZona) VALUES ('" + importe + "', true, '" + asientoElegido + "','" + obtenerIdSocio() + "','" + idZona + "');");
                          ps.executeUpdate();
                          break;

                      case 2:
                          PreparedStatement ps2 = con.conexion().prepareStatement("INSERT INTO abonos (importe, esAdulto, asiento, idSocio, idZona) VALUES ('" + importe + "', true, '" + asientoElegido + "','" + obtenerIdSocio() + "','" + idZona + "');");
                          ps2.executeUpdate();
                          break;

                      case 3:
                          PreparedStatement ps3 = con.conexion().prepareStatement("INSERT INTO abonos (importe, esJubilado, asiento, idSocio, idZona) VALUES ('" + importe + "', true, '" + asientoElegido + "','" + obtenerIdSocio() + "','" + idZona + "');");
                          ps3.executeUpdate();
                          break;
                  }

                  //Cerramos la ventana
                  Stage stage = (Stage) this.aceptarAsiento.getScene().getWindow();
                  stage.close();


              }catch (SQLException e){
                  alertWarning("Se ha producido un error");
              }

          }
          if(zona.equals("Sur")){
              int idZona = 0;
              //Insertamos los datos en la tabla de abonos con el id de zona Sur
              try{
                  Conexion con = new Conexion();
                  //Sacamos la edad para saber a que categoría pertenece

                  int edad = obtenerEdad();
                  int opcion = 0;
                  int importe = 0;


                  if(edad < 25){ //esJoven
                      opcion = 1;
                      importe = 150;
                  }else if(edad > 25 && edad < 60){ //esAdulto
                      opcion = 2;
                      importe = 200;
                  }else if(edad > 60){ //esJubilado
                      opcion = 3;
                      importe = 100;
                  }

                  //Obtenemos el id de la zona
                  Statement st = con.conexion().createStatement();
                  ResultSet rs = st.executeQuery("select id from zona where nombre = 'Sur';");
                  while (rs.next()){
                      idZona = rs.getInt("id");
                  }


                  switch (opcion){
                      case 1:
                          PreparedStatement ps = con.conexion().prepareStatement("INSERT INTO abonos (importe, esJoven, asiento, idSocio, idZona) VALUES ('" + importe + "', true, '" + asientoElegido + "','" + obtenerIdSocio() + "','" + idZona + "');");
                          ps.executeUpdate();
                          break;

                      case 2:
                          PreparedStatement ps2 = con.conexion().prepareStatement("INSERT INTO abonos (importe, esAdulto, asiento, idSocio, idZona) VALUES ('" + importe + "', true, '" + asientoElegido + "','" + obtenerIdSocio() + "','" + idZona + "');");
                          ps2.executeUpdate();
                          break;

                      case 3:
                          PreparedStatement ps3 = con.conexion().prepareStatement("INSERT INTO abonos (importe, esJubilado, asiento, idSocio, idZona) VALUES ('" + importe + "', true, '" + asientoElegido + "','" + obtenerIdSocio() + "','" + idZona + "');");
                          ps3.executeUpdate();
                          break;
                  }

                  //Cerramos la ventana
                  Stage stage = (Stage) this.aceptarAsiento.getScene().getWindow();
                  stage.close();


              }catch (SQLException e){
                  alertWarning("Se ha producido un error");
              }
          }

        }
        if(zona.equals("Este")){
            int idZona = 0;
            //Insertamos los datos en la tabla de abonos con el id de zona Este
            try{
                Conexion con = new Conexion();
                //Sacamos la edad para saber a que categoría pertenece
                int edad = obtenerEdad();
                int opcion = 0;
                int importe = 0;


                if(edad < 25){ //esJoven
                    opcion = 1;
                    importe = 150;
                }else if(edad > 25 && edad < 60){ //esAdulto
                    opcion = 2;
                    importe = 200;
                }else if(edad > 60){ //esJubilado
                    opcion = 3;
                    importe = 100;
                }

                //Obtenemos el id de la zona
                Statement st = con.conexion().createStatement();
                ResultSet rs = st.executeQuery("select id from zona where nombre = 'Este';");
                while (rs.next()){
                    idZona = rs.getInt("id");
                }


                switch (opcion){
                    case 1:
                        PreparedStatement ps = con.conexion(). prepareStatement("INSERT INTO abonos (importe, esJoven, asiento, idSocio, idZona) VALUES ('" + importe + "', true, '" + asientoElegido + "','" + obtenerIdSocio() + "','" + idZona + "');");
                        ps.executeUpdate();
                        break;

                    case 2:
                        PreparedStatement ps2 = con.conexion().prepareStatement("INSERT INTO abonos (importe, esAdulto, asiento, idSocio, idZona) VALUES ('" + importe + "', true, '" + asientoElegido + "','" + obtenerIdSocio() + "','" + idZona + "');");
                        ps2.executeUpdate();
                        break;

                    case 3:
                        PreparedStatement ps3 = con.conexion().prepareStatement("INSERT INTO abonos (importe, esJubilado, asiento, idSocio, idZona) VALUES ('" + importe + "', true, '" + asientoElegido + "','" + obtenerIdSocio() + "','" + idZona + "');");
                        ps3.executeUpdate();
                        break;
                }

                //Cerramos la ventana
                Stage stage = (Stage) this.aceptarAsiento.getScene().getWindow();
                stage.close();


            }catch (SQLException e){
                alertWarning("Se ha producido un error");
            }

        }
    }

    public static int obtenerEdad(){
        int edad = 0;
        try{
            Conexion con = new Conexion();
            Statement st = con.conexion().createStatement();
            ResultSet rs = st.executeQuery("select fechaNacimiento from socios where id = (select MAX(id) from socios)");
            String fecha = null;

            while (rs.next()){
                fecha = rs.getString("fechaNacimiento");
            }

            LocalDate date = LocalDate.parse(fecha);
            edad = Period.between(date, LocalDate.now()).getYears();

            con.closeConnection();

        }catch (SQLException e){
            alertWarning("Se ha producido un error");
        }

        return edad;
    }

    public static int obtenerIdSocio(){
        try{
            Conexion con = new Conexion();
            Statement st = con.conexion().createStatement();
            ResultSet rs = st.executeQuery("select id from socios where id = (select MAX(id) from socios);");

            while (rs.next()){
                idSocio = rs.getInt("id");
            }
        }catch (SQLException e){
            alertWarning("Se ha producido un error");
        }
        return idSocio;
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
