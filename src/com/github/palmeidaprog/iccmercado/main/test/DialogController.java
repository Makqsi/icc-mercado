package com.github.palmeidaprog.iccmercado.main.test;

import com.github.palmeidaprog.iccmercado.main.Controller;

/**
 * Created by paulo on 10/27/16.
 */
public class DialogController {

    //--Singleton pattern--------------------------------------------------
    private static volatile DialogController instance = null;
    private Controller c = Controller.getInstance();

    // constructor
    private DialogController() { }
    public synchronized static DialogController getInstance() {
        if(instance == null) {
            instance = new DialogController();
        }
        return instance;
    }

    //--Events-----------------------------------------------------------

    public void okClick() {
        c.disable(false);
        c.dError.close();
    }
}
