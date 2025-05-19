module ar.edu.unpsjb.hellofx {
    requires javafx.controls;
    requires javafx.fxml;

    opens ar.edu.unpsjb.hellofx to javafx.fxml;
    exports ar.edu.unpsjb.hellofx;
}
