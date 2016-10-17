package com.github.palmeidaprog.iccmercado.main;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.effect.Glow;
import javafx.scene.layout.VBox;

public class Controller {
    @FXML private Label tituloLbl;
    @FXML private VBox testVB, homeVB, educacaoVB, leiVB;
    @FXML private int currentMenu = 1;
    private boolean blinkFlag;
    private Glow glow = new Glow(0.20);
    private AnimationTimer anim = new AnimationTimer() {
        @Override
        public void handle(long now) {
            tituloLbl.setEffect(glow);
            for(int i = 1; i <= 7; ++i) {
                glow.setLevel(glow.getLevel() + (double) i / 10);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    private String tituloAntigo = "Mercado de Trabalho de TI";

    public void closeAction() {
        Main.primaryStage.close();
    }

    public void testeMouseEnterAction() {
        if(currentMenu != 2) {
            tituloLbl.setText("Teste de Aptidão");
            //anim.start();
            testVB.setOpacity(0.8);
            /*tituloLbl.setEffect(glow);
            for(int i = 1; i <= 7; ++i) {
                glow.setLevel(glow.getLevel() + (double) i / 10);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }*/
            /*blinkFlag = true;
            boolean plus = true;
            while(blinkFlag) {
                if(plus) {
                    plus = false;
                }
                else {
                    plus = true;
                }
                for(int i = 1; i <= 5; ++i) {
                    if(!plus) {
                        testVB.setOpacity(testVB.getOpacity() - (double) i / 10);
                    }
                    else {
                        testVB.setOpacity(testVB.getOpacity() + (double) i / 10);
                    }

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }*/
        }
    }

    public void homeMouseEnterAction() {
        if(currentMenu != 1) {
            tituloLbl.setText("Mercado de Trabalho de TI");
            homeVB.setOpacity(0.8);
        }
    }

    public void educacaoMouseEnterAction() {
        if(currentMenu != 3) {
            tituloLbl.setText("Educação para TI");
            educacaoVB.setOpacity(0.8);
        }
    }

    // volta todos os botoes para a cor padrao (não selecionado)
    private void normalColors() {
        homeVB.setStyle("-fx-background-color: #d086f5");
        testVB.setStyle("-fx-background-color: #e7655a");
        educacaoVB.setStyle("-fx-background-color: #fcc666");
        leiVB.setStyle("-fx-background-color: #06e3bd");
    }

    public void homeClickAction() {
        normalColors(); // todos botoes para a cor padrão
        homeVB.setStyle("-fx-background-color: #52596b");
        tituloAntigo = "Mercado de Trabalho de TI";
        tituloLbl.setText(tituloAntigo);
        currentMenu = 1;
    }

    public void testClickAction() {
        normalColors(); // todos botoes para a cor padrão
        testVB.setStyle("-fx-background-color: #52596b");
        tituloAntigo = "Educação para TI";
        tituloLbl.setText(tituloAntigo);
        currentMenu = 2;
    }

    public void educacaoClickAction() {
        normalColors(); // todos botoes para a cor padrão
        educacaoVB.setStyle("-fx-background-color: #52596b");
        tituloAntigo = "Educação para TI";
        tituloLbl.setText(tituloAntigo);
        currentMenu = 3;
    }

    public void leiClickAction() {
        normalColors(); // todos botoes para a cor padrão
        leiVB.setStyle("-fx-background-color: #52596b");
        tituloAntigo = "Leis sobre Mercado de TI";
        tituloLbl.setText(tituloAntigo);
        currentMenu = 4;
    }


    public void leiMouseEnterAction() {
        if(currentMenu != 4) {
            tituloLbl.setText("Leis sobre Mercado de TI");
            leiVB.setOpacity(0.8);
        }
    }

    public void mouseExitAction() {
        tituloLbl.setText(tituloAntigo);
        testVB.setOpacity(1.0);
        homeVB.setOpacity(1.0);
        educacaoVB.setOpacity(1.0);
        leiVB.setOpacity(1.0);
        //blinkFlag = false;
    }

}
