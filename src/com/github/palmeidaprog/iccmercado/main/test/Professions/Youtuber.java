package com.github.palmeidaprog.iccmercado.main.test.Professions;

import com.github.palmeidaprog.iccmercado.main.Interfaces.Linkable;
import com.github.palmeidaprog.iccmercado.main.Interfaces.Professionable;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/*
* Mercado de TI
* Paulo R. Almeida Filho
* pauloalmeidaf@gmail.com
* */

public class Youtuber implements Professionable, Linkable {
    // Links
    private URL youtube;
    private URL wikipedia;
    private URL google;

    // Requirements
    private int hardware = 0;
    private int lideranca = 0;
    private int criatividade = 4;
    private int ensino = 0;
    private int relacionamento = 4;
    private int pesquisa = 0;
    private int matematica = 0;
    private int logica = 0;
    private int problemas = 0;
    private int design = 4;
    private int number = 3;
    private int[] array = {hardware, lideranca, criatividade, ensino, relacionamento,
            pesquisa, matematica, logica, problemas, design};
    private int percentual = 0;

    private final String AREA = "Empreendedorismo / Internet";
    private final String PROFESSION = "Youtuber / Blogger";


    //--Singleton pattern--------------------------------------------------
    private static volatile Youtuber instance = null;

    // constructor
    private Youtuber() {
        try {
            youtube = new URL("https://www.youtube.com/watch?v=sYu7MjuxnpY");
            wikipedia = new URL("https://pt.wikipedia.org/wiki/Blogger");
            google = new URL("https://www.google.com.br/?gfe_rd=cr&ei=lvg7WMLnDOmp8wf-9pnoAQ&gws_rd=ssl#" +
                    "safe=off&q=blogger+youtuber+defini%C3%A7%C3%A3o");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public synchronized static Youtuber getInstance() {
        if(instance == null) {
            instance = new Youtuber();
        }
        return instance;
    }

    //--Professionable methods----------------------------------------------------

    @Override
    public int[] getArray() {
        return array;
    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public int getHardware() {
        return hardware;
    }

    @Override
    public int getLideranca() {
        return lideranca;
    }

    @Override
    public int getCriatividade() {
        return criatividade;
    }

    @Override
    public int getEnsino() {
        return ensino;
    }

    @Override
    public int getRelacionamento() {
        return relacionamento;
    }

    @Override
    public int getPesquisa() {
        return pesquisa;
    }

    @Override
    public int getMatematica() {
        return matematica;
    }

    @Override
    public int getLogica() {
        return logica;
    }

    @Override
    public int getProblemas() {
        return problemas;
    }

    @Override
    public int getDesign() {
        return design;
    }

    @Override
    public Scene getDetails() {
        FXMLLoader loaderResult = new FXMLLoader(getClass().getResource("youtuber.fxml"));
        loaderResult.setController(YoutuberController.getInstance());
        Parent root = null;
        try {
            root = loaderResult.load();
        } catch(IOException e) {
            e.printStackTrace();
        }

        Scene sceneReturn = new Scene(root, 750, 600);

        return sceneReturn;
    }

    @Override
    public String getArea() {
        return AREA;
    }

    @Override
    public String getProfession() {
        return PROFESSION;
    }

    @Override
    public int getPercentual() {
        return percentual;
    }

    //--Linkable methods----------------------------------------------------

    @Override
    public URL getYoutube() {
        return youtube;
    }

    @Override
    public URL getWiki() {
        return wikipedia;
    }

    @Override
    public URL getSearch() {
        return google;
    }

}
