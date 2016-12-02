/*
* Mercado de TI
* @author Paulo R. Almeida Filho
* pauloalmeidaf@gmail.com
* */

package com.github.palmeidaprog.iccmercado.main.test.Professions;


import java.io.IOException;
import java.net.URL;

public class AdministradorDeBancoDadosController {

    //--Singleton pattern--------------------------------------------------
    private static volatile AdministradorDeBancoDadosController instance = null;

    // constructor
    private AdministradorDeBancoDadosController() { }
    public synchronized static AdministradorDeBancoDadosController getInstance() {
        if(instance == null) {
            instance = new AdministradorDeBancoDadosController();
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
                new ProcessBuilder(link.toString()).start();
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void getYoutube() {
        openLink(AdministradorDeBancoDados.getInstance().getYoutube());
    }

    public void getWiki() {
        openLink(AdministradorDeBancoDados.getInstance().getWiki());
    }

    public void getGoogle() {
        openLink(AdministradorDeBancoDados.getInstance().getSearch());
    }


}
