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

public class DesenvolvHard implements Professionable, Linkable {
    // Links
    private URL youtube;
    private URL wikipedia;
    private URL google;

    // Requirements 4440423230
    private int hardware = 4;
    private int lideranca = 4;
    private int criatividade = 4;
    private int ensino = 0;
    private int relacionamento = 4;
    private int pesquisa = 2;
    private int matematica = 3;
    private int logica = 2;
    private int problemas = 3;
    private int design = 0;
    private int number = 8;
    private int[] array = {hardware, lideranca, criatividade, ensino, relacionamento,
            pesquisa, matematica, logica, problemas, design};
    private int percentual = 0;

    private final String AREA = "Empreendedorismo / Hardware";
    private final String PROFESSION = "Desenvolvilmento de Hardware";


    //--Singleton pattern--------------------------------------------------
    private static volatile DesenvolvHard instance = null;

    // constructor
    private DesenvolvHard() {
        try {
            youtube = new URL("https://www.youtube.com/watch?v=honhnz_G84Q");
            wikipedia = new URL("https://pt.wikipedia.org/wiki/Hardware_livre");
            google = new URL("https://www.google.com.br/webhp?sourceid=chrome-instant&ion=1&espv=2&ie" +
                    "=UTF-8#q=%22desenvolvedor%20de%20hardware%22");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public synchronized static DesenvolvHard getInstance() {
        if(instance == null) {
            instance = new DesenvolvHard();
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
        FXMLLoader loaderResult = new FXMLLoader(getClass().getResource("desenvolv_hard.fxml"));
        loaderResult.setController(DesenvolvHardController.getInstance());
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