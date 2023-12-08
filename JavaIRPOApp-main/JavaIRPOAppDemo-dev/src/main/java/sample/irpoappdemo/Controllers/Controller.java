package sample.irpoappdemo.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

import static sample.irpoappdemo.Calculating.Calculate.valueEquation;

public class Controller implements Initializable {
    @FXML
    private ListView<String> LsMin;

    @FXML
    private ComboBox<String> CbEquation;

    @FXML
    private ListView<String> ListBxResult;

    @FXML
    private TextField TxtT1;

    @FXML
    private TextField TxtT2;

    @FXML
    private TextField TxtDt;

    @FXML
    private TextField TxtZ;


    @FXML
    public  void onClickExit() {
        System.exit(0);
    }

    @FXML
    public void onClickResult() {
        String t1String = TxtT1.getText();
        String t2String = TxtT2.getText();
        String dtString = TxtDt.getText();
        String zeString = TxtZ.getText();

        if(dtString.isEmpty()) {
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setTitle("Ошибка");
            error.setHeaderText("Ошибка ввода");
            error.setContentText("Не введено значение dt");
            error.showAndWait();
        }
        else if (t1String.isEmpty()) {
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setTitle("Ошибка");
            error.setHeaderText("Ошибка ввода");
            error.setContentText("Не введено значение t1");
            error.showAndWait();
        }
        else if (t2String.isEmpty()) {
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setTitle("Ошибка");
            error.setHeaderText("Ошибка ввода");
            error.setContentText("Не введено значение t2");
            error.showAndWait();
        }
        else if (zeString.isEmpty()) {
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setTitle("Ошибка");
            error.setHeaderText("Ошибка ввода");
            error.setContentText("Не введено значение Ze");
            error.showAndWait();
        }

        else {
            double h1 = Double.parseDouble(t1String);
            double h2 = Double.parseDouble(t2String);
            double dh = Double.parseDouble(dtString);
            double Ze = Double.parseDouble(zeString);

            valueEquation(h1, h2, dh, Ze,
                    ListBxResult, LsMin, CbEquation);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String [] items = {"x1 = 3.5, x2 = 3.73, x3 = 3",
                "x1 = 2.7, x2 = 3.71, x3 = 3.5",
                "x1 = 3, x2 = 3.5, x3 = 3.23",
                "x1 = 3, x2 = 3.43, x3 = 2.7",
                "x1 = 3.7, x2 = 3.29, x3 = 2.9"};
        CbEquation.getItems().addAll(items);
    }
}