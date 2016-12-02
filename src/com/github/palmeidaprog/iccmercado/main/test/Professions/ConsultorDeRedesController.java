/*
* Mercado de TI
* @author Paulo R. Almeida Filho
* pauloalmeidaf@gmail.com
* */

package com.github.palmeidaprog.iccmercado.main.test.Professions;


import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class ConsultorDeRedesController {

    //--Singleton pattern--------------------------------------------------
    private static volatile ConsultorDeRedesController instance = null;

    // constructor
    private ConsultorDeRedesController() { }
    public synchronized static ConsultorDeRedesController getInstance() {
        if(instance == null) {
            instance = new ConsultorDeRedesController();
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
                if (Desktop.isDesktopSupported()) {
                    // open in a new thread
                    // abre numa nova thread
                    new Thread(() -> {
                        try {
                            Desktop.getDesktop().browse(link.toURI());
                        } catch (IOException | URISyntaxException e1) {
                            e1.printStackTrace();
                        }
                    }).start();
                }
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void getYoutube() {
        openLink(ConsultorDeRedes.getInstance().getYoutube());
    }

    public void getWiki() {
        openLink(ConsultorDeRedes.getInstance().getWiki());
    }

    public void getGoogle() {
        openLink(ConsultorDeRedes.getInstance().getSearch());
    }


}
