module com.example.wei_007_lab4 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.wei_007_lab4 to javafx.fxml;
    exports com.example.wei_007_lab4;
}