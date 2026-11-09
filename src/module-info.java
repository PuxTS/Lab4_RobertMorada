module Lab4_RobertMorada {
    requires javafx.controls;
    requires javafx.graphics;

    opens application to javafx.graphics;
    exports application;
}