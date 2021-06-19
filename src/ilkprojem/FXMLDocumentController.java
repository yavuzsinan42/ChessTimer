/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ilkprojem;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author Yavuz Sinan
 */
public class FXMLDocumentController implements Initializable {

    int dakika = 0;
    int dakika2 = 0;
    static int miliSaniye = 0;
    static int miliSaniye2 = 0;
    static int saniye = 0;
    static int saniye2 = 0;
    static boolean kontrol = false;

    @FXML
    private Label label;
    @FXML
    private Button button;
    int x = 0;
    int k1 = 0, k2 = 0;
    @FXML
    private Label label2;
    @FXML
    private TextField textfield;
    @FXML
    private Label label3;
    @FXML
    private Button button1;
    @FXML
    private Label h1;
    @FXML
    private Label h2;

    private boolean statu = false;

    @FXML
    private void handleButtonAction(ActionEvent event) {
    

        if (!textfield.getText().isEmpty()) {
            x++;
            if (statu) {
                h1.setStyle("-fx-background-color : #16a085");
                h2.setStyle("-fx-background-color :  #FF0000");
                statu = false;
            } else {
                h1.setStyle("-fx-background-color : #FF0000");
                h2.setStyle("-fx-background-color :  #16a085");
                statu = true;
            }

            if (x % 2 == 0) {
                k1++;

            } else if (x % 2 == 1) {
                k2++;

            }
            kontrol = false;

            Thread t = new Thread(new progress());

            //System.out.println("You clicked me!");
            t.start();
        }

    }

    @FXML
    private void handleButtonAction2(ActionEvent event) {
        if (kontrol == false) {
            kontrol = true;

        } else {
            kontrol = false;
        }

    }

    public class progress implements Runnable {

        @Override
        public void run() {

            if (x == 1) {
                try {
                    dakika = Integer.parseInt(textfield.getText());
                } catch (NumberFormatException e) {
                    System.out.println("Sayı Girilmedi....");

                }
                dakika2 = dakika;
            }

            Timer myTimer = new Timer();
            TimerTask gorev = new TimerTask() {

                @Override
                public void run() {
                    if (kontrol == true) {

                        Platform.runLater(() -> {
                            button.setText("Başlat");
                        });
                        myTimer.cancel();
                    }
                    Platform.runLater(() -> {
                        h2.setText(Integer.toString(k2));
                        h1.setText(Integer.toString(k1));
                    });
                    if (x % 2 == 0) {

                        //myTimer.cancel();
                        if (dakika == 0 && saniye == 0) {
                            myTimer.cancel();
                        }

                        //System.out.println("Sayac: "+dakika +" "+saniye+ " "+miliSaniye);
                        if (miliSaniye2 == 1000) {
                            miliSaniye2 = 0;
                            if (saniye2 == 0) {
                                dakika2--;
                                saniye2 = 59;
                            } else {
                                saniye2--;
                            }

                        }
                        miliSaniye2++;
                        Platform.runLater(() -> {
                            h2.setText(Integer.toString(k2));
                            if (kontrol != true) {
                                button.setText("Değiştir");
                            }

                            label2.setText(Integer.toString(x));
                            label3.setText("Sayac: " + dakika2 + " " + saniye2 + " " + miliSaniye2);
                        });

                    } else {

                        if (dakika == 0 && saniye == 0) {
                            myTimer.cancel();
                        }

                        //System.out.println("Sayac: "+dakika +" "+saniye+ " "+miliSaniye);
                        if (miliSaniye == 1000) {
                            miliSaniye = 0;
                            if (saniye == 0) {
                                dakika--;
                                saniye = 59;
                            } else {
                                saniye--;
                            }

                        }
                        miliSaniye++;

                        Platform.runLater(() -> {
                            h1.setText(Integer.toString(k1));
                            if (kontrol != true) {
                                button.setText("Değiştir");
                            }

                            label2.setText(Integer.toString(x));
                            label.setText("Sayac: " + dakika + " " + saniye + " " + miliSaniye);
                        });
                    }

                }

            };
            myTimer.schedule(gorev, 0, 1);

        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        textfield.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                textfield.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
    }

}
