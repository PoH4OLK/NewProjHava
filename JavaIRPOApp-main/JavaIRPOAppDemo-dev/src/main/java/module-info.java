module sample.irpoappdemo {
    requires javafx.controls;
    requires javafx.fxml;


    opens sample.irpoappdemo to javafx.fxml;
    exports sample.irpoappdemo;
    exports sample.irpoappdemo.Calculating;
    opens sample.irpoappdemo.Calculating to javafx.fxml;
    exports sample.irpoappdemo.Controllers;
    opens sample.irpoappdemo.Controllers to javafx.fxml;
}