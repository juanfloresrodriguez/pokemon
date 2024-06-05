module com.mycompany.proyectoenblanco {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.apache.logging.log4j;

    opens pokemon to javafx.fxml;
    exports pokemon;
}
