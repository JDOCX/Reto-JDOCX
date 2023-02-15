package com.example.demoreal;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import javax.mail.MessagingException;
import java.io.IOException;

public class GestionSocios extends Application {
    @Override
    public void start(Stage stage) throws IOException, MessagingException {
        FXMLLoader fxmlLoader = new FXMLLoader(GestionSocios.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.getIcons().add(new Image("C:\\Users\\Diego\\IdeaProjects\\demoReal\\src\\main\\resources\\com\\example\\demoreal\\coding.png"));
        stage.setTitle("Gestion de Socios");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}