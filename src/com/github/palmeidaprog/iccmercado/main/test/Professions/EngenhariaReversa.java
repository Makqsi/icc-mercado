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

public class EngenhariaReversa implements Professionable, Linkable {
    // Links
    private URL youtube;
    private URL wikipedia;
    private URL google;

    // Requirements4	0	0	0	0	4	4	4	4	0
    private int hardware = 4;
    private int lideranca = 0;
    private int criatividade = 0;
    private int ensino = 0;
    private int relacionamento = 0;
    private int pesquisa = 4;
    private int matematica = 4;
    private int logica = 4;
    private int problemas = 4;
    private int design = 0;
    private int number = 5;
    private int[] array = {hardware, lideranca, criatividade, ensino, relacionamento,
            pesquisa, matematica, logica, problemas, design};
    private int percentual = 0;

    private final String AREA = "Programação / Cracking";
    private final String PROFESSION = "Egenharia Reversa (Hacking)";


    //--Singleton pattern--------------------------------------------------
    private static volatile EngenhariaReversa instance = null;

    // constructor
    private EngenhariaReversa() {
        try {
            youtube = new URL("https://www.youtube.com/watch?v=lOf5kqilcSE");
            wikipedia = new URL("https://pt.wikipedia.org/wiki/Engenharia_reversa");
            google = new URL("https://www.google.com.br/?gfe_rd=cr&ei=oS09WPKkDeOp8weRzaPQDA&gws_rd" +
                    "=ssl#safe=off&q=%22engenharia+reversa%22");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public synchronized static EngenhariaReversa getInstance() {
        if(instance == null) {
            instance = new EngenhariaReversa();
        }
        return instance;
    }

    //--Professionable methods----------------------------------------------------

    @Override
    public int[] getArray() {
        array[0] = hardware;
        array[1] = lideranca;
        array[2] = criatividade;
        array[3] = ensino;
        array[4] = relacionamento;
        array[5] = pesquisa;
        array[6] = matematica;
        array[7] = logica;
        array[8] = problemas;
        array[9] = design;
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
 public void page2() {


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
        FXMLLoader loaderResult = new FXMLLoader(getClass().getResource("engenharia_reversa.fxml"));
        loaderResult.setController(EngenhariaReversaController.getInstance());
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

    @Override
    public void setPercentual(int p) {
        percentual = p;
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
