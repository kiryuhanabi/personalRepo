module com.example.table {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.table to javafx.fxml;
    exports com.example.table;
}