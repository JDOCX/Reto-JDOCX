module com.example.demoreal {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires java.desktop;
    requires java.sql;
    requires java.mail;
    requires mysql.connector.j;

    opens com.example.demoreal to javafx.fxml;
    exports com.example.demoreal;
}