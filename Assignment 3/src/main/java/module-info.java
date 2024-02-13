module mvh.app {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.junit.jupiter.api;
    opens mvh.app to javafx.fxml;
    exports mvh.app;
}