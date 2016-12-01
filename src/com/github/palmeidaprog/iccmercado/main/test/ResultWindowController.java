/*
* Mercado de TI
* @author Paulo R. Almeida Filho
* pauloalmeidaf@gmail.com
* */

package com.github.palmeidaprog.iccmercado.main.test;


import com.github.palmeidaprog.iccmercado.main.Interfaces.Professionable;
import com.github.palmeidaprog.iccmercado.main.Main;
import com.github.palmeidaprog.iccmercado.main.UIEffects;
import com.github.palmeidaprog.iccmercado.main.test.Professions.AnalistaDeSistema;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ResultWindowController implements Initializable {
    @FXML private Label prof1, area1, perc1, prof2, area2, perc2, prof3, area3, perc3,
            prof4, area4, perc4, prof5, area5, perc5, prof6, area6, perc6, prof7, area7, perc7,
            prof8, area8, perc8;
    @FXML private ProgressBar bar1, bar2, bar3, bar4, bar5, bar6, bar7, bar8;
    @FXML private Button btn1;
    @FXML public VBox resultPage2, resultPage1, resultPage3;
    @FXML public BorderPane mainPaneResult;
    private Stage details = new Stage();
    private List<Professionable> l = Choices.getInstance().getList();

    //--Singleton pattern--------------------------------------------------
    private static volatile ResultWindowController instance = null;

    // constructor
    private ResultWindowController() {
    }

    public synchronized static ResultWindowController getInstance() {
        if (instance == null) {
            instance = new ResultWindowController();
        }
        return instance;
    }

    //-Initialize----------------------------------------------------------

    public void initialize(URL u, ResourceBundle rb) {

        // load page2
        FXMLLoader res2 = new FXMLLoader(getClass().getResource("result_window2.fxml"));
        res2.setController(ResultWindowController2.getInstance());
        try {
            resultPage2 = res2.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //load page3
        FXMLLoader res2 = new FXMLLoader(getClass().getResource("result_window2.fxml"));
        res2.setController(ResultWindowController2.getInstance());
        try {
            resultPage2 = res2.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //---------------------------------------------------------------------

    private void professionPosition(Label pr, Label ar, Label pe, ProgressBar pB, Professionable p) {
        pr.setText(p.getProfession());
        ar.setText(p.getArea());
        pe.setText(p.getPercentual() + "%");
        pB.setProgress(p.getPercentual() / 100.0);
    }

    public void update() {
        professionPosition(prof1, area1, perc1, bar1, l.get(0));
        professionPosition(prof2, area2, perc2, bar2, l.get(1));
        professionPosition(prof3, area3, perc3, bar3, l.get(2));
        professionPosition(prof4, area4, perc4, bar4, l.get(3));
        professionPosition(prof5, area5, perc5, bar5, l.get(4));
        professionPosition(prof6, area6, perc6, bar6, l.get(5));
        professionPosition(prof7, area7, perc7, bar7, l.get(6));
        professionPosition(prof8, area8, perc8, bar8, l.get(7));
    }

    private void getIcon() {
        try {
            Image f = new Image(Main.class.getResourceAsStream("favicon.png"));
            details.getIcons().add(f);
        } catch (Exception e) {
        }
    }

    private void buttonClick(Professionable p) {
        details.setScene(p.getDetails());
        getIcon();
        details.setTitle("Detalhes: " + p.getProfession());
        details.show();
    }

    //--Button Click Events-----------------------------------------------------

    public void btn1Click() {
        buttonClick(l.get(0));
    }

    public void btn2Click() {
        buttonClick(l.get(1));
    }

    public void btn3Click() {

        buttonClick(l.get(2));
    }

    public void btn4Click() {
        buttonClick(l.get(3));
    }

    public void btn5Click() {
        buttonClick(l.get(4));
    }

    public void btn6Click() {
        buttonClick(l.get(5));
    }

    public void btn7Click() {
        buttonClick(l.get(6));
    }

    public void btn8Click() {
        buttonClick(l.get(7));
    }

    public void page2() {
        ResultWindowController2.getInstance().update();
        UIEffects.getInstance().fadeBoxes(mainPaneResult.getCenter(), 1);
        mainPaneResult.setCenter(resultPage2);
        UIEffects.getInstance().fadeBoxes(mainPaneResult.getCenter(), 0);
    }

    public void page1() {
        UIEffects.getInstance().fadeBoxes(mainPaneResult.getCenter(), 1);
        mainPaneResult.setCenter(resultPage1);
        UIEffects.getInstance().fadeBoxes(mainPaneResult.getCenter(), 0);
    }

    public void page3() {
        ResultWindowController3.getInstance().update();
        /*UIEffects.getInstance().fadeBoxes(mainPaneResult.getCenter(), 1);
        mainPaneResult.setCenter(resultPage1);
        UIEffects.getInstance().fadeBoxes(mainPaneResult.getCenter(), 0);*/
    }




}
