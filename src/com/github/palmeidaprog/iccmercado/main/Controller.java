/*
* Mercado de TI
* Paulo R. Almeida Filho
* pauloalmeidaf@gmail.com
* */

package com.github.palmeidaprog.iccmercado.main;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.Glow;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import javafx.animation.FadeTransition;
import java.net.URL;
import javafx.animation.Timeline;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML private Label tituloLbl;
    @FXML private VBox testVB, homeVB, educacaoVB, leiVB, mainPanel;
    @FXML private int currentMenu = 1;
    private boolean blinkFlag;
    private boolean disableEffect = false;
    private String tituloAntigo = "Mercado de Trabalho de TI";

    // navigation panels / painéis de navegação
    @FXML private VBox mainEducVB, mainTesteVB, mainLeiVB, navigationBox;


    //effects
    private FadeTransition ft, ftl;
    private boolean effectStatus = false;

    //--Initialization----------------------------------------------------------------

    public void initialize(URL u, ResourceBundle rb) {

    }


    public void closeAction() {
        Main.primaryStage.close();
    }


    //--Mouse Click Events------------------------------------------------------------

    public void homeClickAction() {
        normalColors(); // todos botoes para a cor padrão
        homeVB.setStyle("-fx-background-color: #52596b");
        tituloAntigo = "Mercado de Trabalho de TI";
        tituloLbl.setText(tituloAntigo);
        navigationBox.getChildren().set(1, mainPanel);
        currentMenu = 1;
    }

    public void testClickAction() {
        normalColors(); // todos botoes para a cor padrão
        testVB.setStyle("-fx-background-color: #52596b");
        tituloAntigo = "Educação para TI";
        tituloLbl.setText(tituloAntigo);
        navigationBox.getChildren().set(1, mainTesteVB);
        currentMenu = 2;
    }

    public void educacaoClickAction() {
        normalColors(); // todos botoes para a cor padrão
        educacaoVB.setStyle("-fx-background-color: #52596b");
        tituloAntigo = "Educação para TI";
        tituloLbl.setText(tituloAntigo);
        navigationBox.getChildren().set(1, mainEducVB);
        currentMenu = 3;
    }

    public void leiClickAction() {
        normalColors(); // todos botoes para a cor padrão
        leiVB.setStyle("-fx-background-color: #52596b");
        tituloAntigo = "Leis sobre Mercado de TI";
        tituloLbl.setText(tituloAntigo);
        navigationBox.getChildren().set(1, mainLeiVB);
        currentMenu = 4;
    }

    //--Mouse Enter and Exit Events--------------------------------------------------------

    // mouse exit menu at the left event
    // evento de saida de mouse do eventos da esquerda
    public void mouseExitAction() {
        disableEffect = true;
        tituloLbl.setText(tituloAntigo);
        fadeAnim();
        opacityFull();
    }

    public void leiMouseEnterAction() {
        if(currentMenu != 4) {
            disableEffect = false;
            tituloLbl.setText("Leis sobre Mercado de TI");
            leiVB.setOpacity(0.8);
            addBlur(true);
            //anim.stop();
            fadeAnim(leiVB, tituloLbl);
        }
    }

    public void testeMouseEnterAction() {
        if(currentMenu != 2) {
            disableEffect = false;
            tituloLbl.setText("Teste de Aptidão");
            //anim.start();
            testVB.setOpacity(0.8);
            addBlur(true);
            fadeAnim(testVB, tituloLbl);
        }
    }

    public void homeMouseEnterAction() {
        if(currentMenu != 1) {
            disableEffect = false;
            tituloLbl.setText("Mercado de Trabalho de TI");
            homeVB.setOpacity(0.8);
            addBlur(true);
            fadeAnim(homeVB, tituloLbl);
        }
    }

    public void educacaoMouseEnterAction() {
        if(currentMenu != 3) {
            disableEffect = false;
            tituloLbl.setText("Educação para TI");
            //educacaoVB.setOpacity(0.8);
            addBlur(true);
            //anim.start();
            fadeAnim(educacaoVB, tituloLbl);

        }
    }

    //--Effects------------------------------------------------------------

    // resets all menus opacity
    // reinicia a opacidade de todos menus
    private void opacityFull() {
        testVB.setOpacity(1.0);
        homeVB.setOpacity(1.0);
        educacaoVB.setOpacity(1.0);
        leiVB.setOpacity(1.0);
        tituloLbl.setOpacity(1.0);
    }

    private void fadeAnim(VBox v, Label l) { //todo: implement rest

        opacityFull(); // resets menu's opacity / reinicia opacidade dos menus
        if(ft != null) {
            ft.stop();
        }
        if(ftl != null) {
            ftl.stop();
        }

        effectStatus = true;
        ft = new FadeTransition(Duration.millis(1000), v);
        ft.setFromValue(1.0);
        ft.setToValue(0.3);
        ft.setCycleCount(Timeline.INDEFINITE);
        ft.setAutoReverse(true);
        ft.play();

        ftl = new FadeTransition(Duration.millis(750), l);
        ftl.setFromValue(1.0);
        ftl.setToValue(0.1);
        ftl.setCycleCount(Timeline.INDEFINITE);
        ftl.setAutoReverse(true);
        ftl.play();
    }

    private void fadeAnim() {
        effectStatus = false;
        ft.stop();
        ftl.stop();
    }

    // return all "buttons/VBox" to their default colors (not selected)
    // volta todos os botoes para a cor padrao (não selecionado)
    private void normalColors() {
        homeVB.setStyle("-fx-background-color: #d086f5");
        testVB.setStyle("-fx-background-color: #e7655a");
        educacaoVB.setStyle("-fx-background-color: #fcc666");
        leiVB.setStyle("-fx-background-color: #06e3bd");
    }

    // adds and remove blur and glow effect to the main panel
    // adiciona e remove efeito "blur" e "glow" ao painel de navegação
    private void addBlur(boolean b) {
        Glow glow = new Glow(0.20);
        BoxBlur blur = new BoxBlur(1.0, 1.0, 3);

        if(b) {
            mainPanel.setEffect(blur);
            mainPanel.setEffect(glow);
        }
        else {
            mainPanel.setEffect(null);
        }
        blur.setHeight(10.0);
        blur.setWidth(10.0);
        glow.setLevel(1.0);
        mainPanel.setDisable(b);
    }

    // anonymous class
    private AnimationTimer anim = new AnimationTimer() {
        @Override
        public void handle(long now) {
            Glow glow = new Glow(0.30);

            /*for(int i = 0; i < 10; i++) {
                tituloLbl.setText(tituloLbl.getText() + "a");
            }*/
            tituloLbl.setEffect(null);
            tituloLbl.setEffect(glow);
            for(int i = 1; i <= 7000000; i++) {
                if(glow.getLevel() <= 1) {
                    glow.setLevel(glow.getLevel() + (double) i / 10000000);
                    tituloLbl.setText(tituloLbl.getText() + "a");
                }
                else {
                    glow.setLevel(0.3);
                    tituloLbl.setText(tituloLbl.getText() + "a");
                }
            }
        }
    };

}
