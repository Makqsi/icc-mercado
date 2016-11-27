package com.github.palmeidaprog.iccmercado.main.test.Professions;

import com.github.palmeidaprog.iccmercado.main.Interfaces.Linkable;
import com.github.palmeidaprog.iccmercado.main.Interfaces.Professionable;
import java.net.MalformedURLException;
import java.net.URL;

/*
* Mercado de TI
* Paulo R. Almeida Filho
* pauloalmeidaf@gmail.com
* */

public class AnalistaDeSistema implements Professionable, Linkable {
    private URL youtube;
    private URL wikipedia;
    private URL google;

    // Requirements
    private int hardware = 3;
    private int lideranca = 3;
    private int criatividade = 3;
    private int ensino = 3;
    private int relacionamento = 4;
    private int pesquisa = 3;
    private int matematica = 0;
    private int logica = 0;
    private int problemas = 3;
    private int design = 0;
    private int number = 7;
    private int[] array = {hardware, lideranca, criatividade, ensino, relacionamento,
            pesquisa, matematica, logica, problemas, design};

    //--Singleton pattern--------------------------------------------------
    private static volatile AnalistaDeSistema instance = null;

    // constructor
    private AnalistaDeSistema() {
        try {
            youtube = new URL("https://www.youtube.com/watch?v=T-7ykWKbrc8");
            wikipedia = new URL("https://pt.wikipedia.org/wiki/Relacionamento");
            google = new URL("https://www.google.com.br/?gfe_rd=cr&ei=eE04WNf4IOPM8Afs0q24CA#s" +
                    "afe=off&q=%22relacionamento+interpessoal+no+trabalho%22");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public synchronized static AnalistaDeSistema getInstance() {
        if(instance == null) {
            instance = new AnalistaDeSistema();
        }
        return instance;
    }

    //--Professionable methods----------------------------------------------------

    public int[] getArray() {
        return array;
    }

    public int getNumber() {
        return number;
    }

    public int getHardware() {
        return hardware;
    }

    public int getLideranca() {
        return lideranca;
    }

    public int getCriatividade() {
        return criatividade;
    }

    public int getEnsino() {
        return ensino;
    }

    public int getRelacionamento() {
        return relacionamento;
    }

    public int getPesquisa() {
        return pesquisa;
    }

    public int getMatematica() {
        return matematica;
    }

    public int getLogica() {
        return logica;
    }

    public int getProblemas() {
        return problemas;
    }

    public int getDesign() {
        return design;
    }

    //--Linkable methods----------------------------------------------------

    public URL getYoutube() {
        return youtube;
    }

    public URL getWiki() {
        return wikipedia;
    }

    public URL getSearch() {
        return google;
    }

}
