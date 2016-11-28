/*
* Mercado de TI
* @author Paulo R. Almeida Filho
* pauloalmeidaf@gmail.com
* */

package com.github.palmeidaprog.iccmercado.main.test.Professions;


import java.io.IOException;
import java.net.URL;

public class EngenheiroEletronicoController {

    //--Singleton pattern--------------------------------------------------
    private static volatile EngenheiroEletronicoController instance = null;

    // constructor
    private EngenheiroEletronicoController() { }
    public synchronized static EngenheiroEletronicoController getInstance() {
        if(instance == null) {
            instance = new EngenheiroEletronicoController();
        }
        return instance;
    }

    //--Click on links events--------------------------------------------------------------------

    private void openLink(URL link) {
        String os = System.getProperty("os.name").toLowerCase();

        // open default browser depending the OS
        // abrir o navegador padrão dependendo do OS
        try {
            if(os.contains("linux")) {
                new ProcessBuilder("sensible-browser", link.toString()).start();
            }
            else if(os.contains("mac")) {
                new ProcessBuilder("open", link.toString()).start();
            }
            else {
                new ProcessBuilder("start", link.toString()).start();
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void getYoutube() {
        openLink(EngenheiroEletronico.getInstance().getYoutube());
    }

    public void getWiki() {
        openLink(EngenheiroEletronico.getInstance().getWiki());
    }

    public void getGoogle() {
        openLink(EngenheiroEletronico.getInstance().getSearch());
    }


}
