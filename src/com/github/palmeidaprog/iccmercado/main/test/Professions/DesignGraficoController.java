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

public class DesignGraficoController {

    //--Singleton pattern--------------------------------------------------
    private static volatile DesignGraficoController instance = null;

    // constructor
    private DesignGraficoController() { }
    public synchronized static DesignGraficoController getInstance() {
        if(instance == null) {
            instance = new DesignGraficoController();
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
        openLink(DesignGrafico.getInstance().getYoutube());
    }

    public void getWiki() {
        openLink(DesignGrafico.getInstance().getWiki());
    }

    public void getGoogle() {
        openLink(DesignGrafico.getInstance().getSearch());
    }


}
