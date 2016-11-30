package com.github.palmeidaprog.iccmercado.main.Interfaces;

/*
* Mercado de TI
* @author Paulo R. Almeida Filho
* pauloalmeidaf@gmail.com
* */

import javafx.scene.Scene;

import java.util.ArrayList;

public interface Professionable {
    int[] getArray();
    int getNumber();
    int getHardware();
    int getLideranca();
    int getCriatividade();
    int getEnsino();
    int getRelacionamento();
    int getPesquisa();
    int getMatematica();
    int getLogica();
    int getProblemas();
    int getDesign();
    Scene getDetails();
    String getArea();
    String getProfession();
    int getPercentual();
    void setPercentual(int p);
}
