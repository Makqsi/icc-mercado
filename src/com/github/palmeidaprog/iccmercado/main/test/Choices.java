package com.github.palmeidaprog.iccmercado.main.test;

/**
 * Created by paulo on 11/13/16.
 */
public class Choices {
    private int hardware = 0, lideranca = 0, logicaAbs = 0, ensino = 0;
    private int criatividade = 0, pesquisa = 0, comunicacao = 0;

    // Singleton contructor
    private Choices() { }
    private volatile static Choices instance = null;
    public synchronized static Choices getInstance() {
        if(instance == null) {
            instance = new Choices();
        }
        return instance;
    }


    //--Set and get methods--------------------------------------------------

    public void setHardware(int h) {
        hardware = h;
    }

    public int getHardware() {
        return hardware;
    }

    public void compare(int[] profession) {

    }

}
