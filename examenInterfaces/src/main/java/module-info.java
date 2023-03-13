module main.exameninterfaces {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens main.exameninterfaces to javafx.fxml;
    exports main.exameninterfaces;
}