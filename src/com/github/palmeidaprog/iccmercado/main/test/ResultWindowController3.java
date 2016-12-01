/*
* Mercado de TI
* @author Paulo R. Almeida Filho
* pauloalmeidaf@gmail.com
* */

package com.github.palmeidaprog.iccmercado.main.test;


import com.github.palmeidaprog.iccmercado.main.Interfaces.Professionable;
import com.github.palmeidaprog.iccmercado.main.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.List;

public class ResultWindowController3 {
    @FXML private Label prof18, area18, perc18, prof19, area19, perc19, prof20, area20, perc20;
    @FXML private ProgressBar bar18, bar19, bar20;
    private Stage details = new Stage();
    private List<Professionable> l = Choices.getInstance().getList();

    //--Singleton pattern--------------------------------------------------
    private static volatile ResultWindowController3 instance = null;

    // constructor
    private ResultWindowController3() { }
    public synchronized static ResultWindowController3 getInstance() {
        if(instance == null) {
            instance = new ResultWindowController3();
        }
        return instance;
    }

    //---------------------------------------------------------------------

    private void professionPosition(Label pr, Label ar, Label pe, ProgressBar pB, Professionable p) {
        pr.setText(p.getProfession());
        ar.setText(p.getArea());
        pe.setText(p.getPercentual() + "%");
        pB.setProgress(p.getPercentual() / 100.0);
    }

    public void update() {
        professionPosition(prof9, area9, perc9, bar9, l.get(8));
        professionPosition(prof10, area10, perc10, bar10, l.get(9));
        professionPosition(prof11, area11, perc11, bar11, l.get(10));
        professionPosition(prof12, area12, perc12, bar12, l.get(11));
        professionPosition(prof13, area13, perc13, bar13, l.get(12));
        professionPosition(prof14, area14, perc14, bar14, l.get(13));
        professionPosition(prof15, area15, perc15, bar15, l.get(14));
        professionPosition(prof16, area16, perc16, bar16, l.get(15));
    }

    private void getIcon() {
        try {
            Image f = new Image(Main.class.getResourceAsStream("favicon.png"));
            details.getIcons().add(f);
        } catch(Exception e) { }
    }

    private void buttonClick(Professionable p) {
        details.setScene(p.getDetails());
        getIcon();
        details.setTitle("Detalhes: " + p.getProfession());
        details.show();
    }

    //--Button Click Events-----------------------------------------------------

    public void btn9Click() {
        buttonClick(l.get(8));
    }

    public void btn10Click() {
        buttonClick(l.get(9));
    }

    public void btn11Click() {
        buttonClick(l.get(10));
    }

    public void btn12Click() {
        buttonClick(l.get(11));
    }

    public void btn13Click() {
        buttonClick(l.get(12));
    }

    public void btn14Click() {
        buttonClick(l.get(13));
    }

    public void btn15Click() {
        buttonClick(l.get(14));
    }

    public void btn16Click() {
        buttonClick(l.get(15));
    }


}
