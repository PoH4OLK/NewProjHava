package sample.irpoappdemo.Calculating;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableRow;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


import static java.lang.Math.abs;
import static java.util.Collections.min;
import static javafx.beans.binding.Bindings.isEmpty;

public class Calculate {
    public static void calculating(double h1Val, double h2Val, double dhVal, double Ze,
                                   ListView<String> lsValues, ListView<String> lsResult, ComboBox<String> cmb) {

        ObservableList<String> nums = FXCollections.observableArrayList();
        ObservableList<String> minNums = FXCollections.observableArrayList();

        double x1 = 0, x2 = 0, x3 = 0, Zpost, Z0min = 0, t1min = 0, t2min = 0, dtmin = 0;
        double [] Z = new double[6];
        double Zmin = Double.MAX_VALUE;
        double h1, h2, dh;
        Z[0] = 35;
        Zpost = Z[0];

        int selectedItem = cmb.getSelectionModel().getSelectedIndex();

        h1 = h1Val;
        h2 = h2Val;
        dh = dhVal;

        for (int i = 1; i <= 5; i++){
            switch (selectedItem){
                case 0:
                    x1 = 3.5;
                    x2 = 3.73;
                    x3 = 3.0;
                    break;
                case 1:
                    x1 = 2.7;
                    x2 = 3.71;
                    x3 = 3.5;
                    break;
                case 2:
                    x1 = 3.0;
                    x2 = 3.5;
                    x3 = 3.23;
                    break;
                case 3:
                    x1 = 3.0;
                    x2 = 3.43;
                    x3 = 2.7;
                    break;
                case 4:
                    x1 = 3.7;
                    x2 = 3.29;
                    x3 = 2.9;
                    break;
            }

            if(i > 1) {
                if(Ze > Z[0])
                {
                    Z[0] = Z[0] + (Zpost - Ze);
                    for(int t1 = 2; t1 <= 4; t1 += (int) h1){
                        for(int t2 = 5; t2 <= 15; t2 += (int) h2){
                            for(int dt = 20; dt <= 50; dt += (int) dh){
                                Z[i] = Z[0] + x1 * t1 + x2 *  t2 + x3 * dt;

                                nums.add("t1 = " + t1 + ", " + "t2 = " + t2 + ", " + "dt = " + dt + ", " + "Z[" + i + "] = " + Z[i]);
                                lsValues.setItems(nums);

                                if(abs(Z[i]) < abs(Zmin)){
                                    Zmin = Z[i];
                                    Z0min = Z[0];
                                    t1min = t1;
                                    t2min = t2;
                                    dtmin = dt;

                                    minNums.add("Zmin = " + Zmin +
                                            ", Z0min = " + Z0min +
                                            ", t1min = " + t1min +
                                            ", t2min = " + t2min +
                                            ", dtmin = " + dtmin +
                                            ", Z[" + i +"]");
                                    lsResult.setItems(minNums);
                                }
                            }
                        }
                    }
                }
                else if (Ze < Z[0]){
                    Z[0] = Z[0] - (Zpost - Ze);
                    for(int t1 = 2; t1 <= 4; t1 += (int) h1){
                        for(int t2 = 5; t2 <= 15; t2 += (int) h2){
                            for(int dt = 20; dt <= 50; dt += (int) dh){
                                Z[i] = Z[0] + x1 * t1 + x2 *  t2 + x3 * dt;

                                nums.add("t1 = " + t1 + ", " + "t2 = " + t2 + ", " + "dt = " + dt + ", " + "Z[" + i + "] = " + Z[i]);
                                lsValues.setItems(nums);

                                if(abs(Z[i]) < abs(Zmin)){
                                    Zmin = Z[i];
                                    Z0min = Z[0];
                                    t1min = t1;
                                    t2min = t2;
                                    dtmin = dt;

                                    minNums.add("Zmin = " + Zmin +
                                            ", Z0min = " + Z0min +
                                            ", t1min = " + t1min +
                                            ", t2min = " + t2min +
                                            ", dtmin = " + dtmin +
                                            ", Z[" + i +"]");
                                    lsResult.setItems(minNums);
                                }
                            }
                        }
                    }
                }
            }
            else {
                for(int t1 = 2; t1 <= 4; t1 += (int) h1){
                    for(int t2 = 5; t2 <= 15; t2 += (int) h2){
                        for(int dt = 20; dt <= 50; dt += (int) dh){
                            Z[i] = Z[0] + x1 * t1 + x2 *  t2 + x3 * dt;

                            nums.add("t1 = " + t1 + ", " + "t2 = " + t2 + ", " + "dt = " + dt + ", " + "Z[" + i + "] = " + Z[i]);
                            lsValues.setItems(nums);

                            if(abs(Z[i]) < abs(Zmin)){
                                Zmin = Z[i];
                                Z0min = Z[0];
                                t1min = t1;
                                t2min = t2;
                                dtmin = dt;

                                minNums.add("Zmin = " + Zmin +
                                        ", Z0min = " + Z0min +
                                        ", t1min = " + t1min +
                                        ", t2min = " + t2min +
                                        ", dtmin = " + dtmin +
                                        ", Z[" + i +"]");
                                lsResult.setItems(minNums);
                            }
                        }
                    }
                }
            }
        }
    }
}
