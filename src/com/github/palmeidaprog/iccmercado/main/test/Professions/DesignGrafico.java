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

public class DesignGrafico implements Professionable, Linkable {
    // Links
    private URL youtube;
    private URL wikipedia;
    private URL google;

    // Requirements
    private int hardware = 0;
    private int lideranca = 0;
    private int criatividade = 4;
    private int ensino = 0;
    private int relacionamento = 3;
    private int pesquisa = 0;
    private int matematica = 0;
    private int logica = 0;
    private int problemas = 0;
    private int design = 4;
    private int number = 3;
    private int[] array = {hardware, lideranca, criatividade, ensino, relacionamento,
            pesquisa, matematica, logica, problemas, design};
    private int percentual = 0;

    private final String AREA = "Design/Computação Gráfica";
    private final String PROFESSION = "Design Gráfico";


    //--Singleton pattern--------------------------------------------------
    private static volatile DesignGrafico instance = null;

    // constructor
    private DesignGrafico() {
        try {
            youtube = new URL("https://www.youtube.com/watch?v=dOe6YCaMygc");
            wikipedia = new URL("https://pt.wikipedia.org/wiki/Design_gr%C3%A1fico");
            google = new URL("https://www.google.com.br/?gfe_rd=cr&ei=RFs7WPG5Ge-p8wf_mL7AAQ&gws_rd" +
                    "=ssl#safe=off&q=%22design+gr%C3%A1fico%22");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public synchronized static DesignGrafico getInstance() {
        if(instance == null) {
            instance = new DesignGrafico();
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
        FXMLLoader loaderResult = new FXMLLoader(getClass().getResource("suporte_tecnico.fxml"));
        loaderResult.setController(DesignGraficoController.getInstance());
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
