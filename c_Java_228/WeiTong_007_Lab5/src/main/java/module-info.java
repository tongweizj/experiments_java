module com.example.weitong_007_lab5 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.example.weitong_007_lab5 to javafx.fxml;
    exports com.example.weitong_007_lab5;
}