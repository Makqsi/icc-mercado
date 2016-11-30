package com.github.palmeidaprog.iccmercado.main.test;

import com.github.palmeidaprog.iccmercado.main.Interfaces.Professionable;
import com.github.palmeidaprog.iccmercado.main.test.Professions.AdministradorDeBancoDados;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.github.palmeidaprog.iccmercado.main.test.Professions.*;

/*
* Mercado de TI
* @author Paulo R. Almeida Filho
* pauloalmeidaf@gmail.com
* */

public class Choices {
    private int hardware = 0, lideranca = 0, criatividade = 0, ensino = 0, relacionamento = 0,
            pesquisa = 0, matematica = 0, logica = 0, problemas = 0, design = 0;

    // holds all professions objects
    // guarda todos objetos das profissoes
    private List<Professionable> professionsList = new ArrayList<>();
    private int[] array = {hardware, lideranca, criatividade, ensino, relacionamento,
            pesquisa, matematica, logica, problemas, design};

    // Singleton contructor
    private Choices() {
       professionsList.addAll(Arrays.asList(AdministradorDeBancoDados.getInstance(),
                AdminSistema.getInstance(), AnalistaDeNegocios.getInstance(),
                AnalistaDeSeguranca.getInstance(), AnalistaDeSistema.getInstance(),
                AnalistaProgramador.getInstance(), ArquitetoDeSistemas.getInstance(),
                Artista3D.getInstance(), ConsultorDeRedes.getInstance(),
                DesenvolvHard.getInstance(), DesignGrafico.getInstance(),
                EngenhariaReversa.getInstance(), EngenheiroEletronico.getInstance(),
                PesquisaCientifica.getInstance(), Professor.getInstance(),
                ProgramadorWeb.getInstance(), SuporteTecnico.getInstance(),
                TecnicoDeRede.getInstance(), WebDesigner.getInstance(),
                Youtuber.getInstance()));
    }
    private volatile static Choices instance = null;
    public synchronized static Choices getInstance() {
        if(instance == null) {
            instance = new Choices();
        }
        return instance;
    }


    //--Set and get methods--------------------------------------------------


    private int[] getArray() {
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

    public List<Professionable> getList() {
        return professionsList;
    }

    public void setHardware(int s) {
        hardware = s;
    }

    public void setLideranca(int s) {
        lideranca = s;
    }

    public void setCriatividade(int s) {
        criatividade = s;
    }

    public void setEnsino(int s) {
        ensino = s;
    }

    public void setRelacionamento(int s) {
        relacionamento = s;
    }

    public void setPesquisa(int s) {
        pesquisa = s;
    }

    public void setMatematica(int s) {
        matematica = s;
    }

    public void setLogica(int s) {
        logica = s;
    }

    public void setProblemas(int s) {
        problemas = s;
    }

    public void setDesign(int s) {
        design = s;
    }

    public void organizeProfessions() {
        calculateProfessions();

        for(Professionable x : professionsList) {
            //Choices
        }
    }

    public void calculateProfessions() {
        double percChoke;
        int
        for(Professionable p : professionsList) {
            percChoke = 100.0 / p.getNumber();

        }
    }


    public void compare(int[] profession) {

    }

}
