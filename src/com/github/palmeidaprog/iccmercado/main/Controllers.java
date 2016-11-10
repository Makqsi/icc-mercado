package com.github.palmeidaprog.iccmercado.main;

/**
 * Created by paulo on 11/10/16.
 */
public class Controllers {

    private Controller controller = null;

    private volatile static Controllers instance = null;
    private Controllers() { }
    public synchronized static Controllers getInstance() {
        if(instance == null) {
            instance = new Controllers();
        }
        return instance;
    }

    public void setController(Controller c) {
        controller = c;
    }

    public Controller getController() {
        return controller;
    }

}
