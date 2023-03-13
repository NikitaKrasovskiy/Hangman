module com.example.hungman {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.hungman to javafx.fxml;
    exports com.example.hungman;
}