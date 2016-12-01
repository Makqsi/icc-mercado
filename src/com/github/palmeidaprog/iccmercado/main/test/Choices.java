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

    //--Test Result algorithm-----------------------------------------------------

    public void resetTest() {
        hardware = 0;
        lideranca = 0;
        criatividade = 0;
        ensino = 0;
        relacionamento = 0;
        pesquisa = 0;
        matematica = 0;
        logica = 0;
        problemas = 0;
        design = 0;
        Hardware.getInstance().setStars(0);
        Lideranca.getInstance().setStars(0);
        Criatividade.getInstance().setStars(0);
        Ensino.getInstance().setStars(0);
        Relacionamento.getInstance().setStars(0);
        Pesquisa.getInstance().setStars(0);
        Matematica.getInstance().setStars(0);
        Logica.getInstance().setStars(0);
        Problemas.getInstance().setStars(0);
        Design.getInstance().setStars(0);
    }

    public void calculateProfessions() {
        for(Professionable p : professionsList) {
           calculatePercentual(p);
        }
    }

    // BubbleSort
    public void orderingProfessions() {
        for(int i = 0; i < professionsList.size() / 2; i++) {
            for(int j = 0; j < professionsList.size() - 1; j++) {
                if(professionsList.get(j).getPercentual() < professionsList.get(j + 1)
                        .getPercentual()) {
                    Professionable aux = professionsList.get(j); // auxiliar temp object
                    professionsList.set(j, professionsList.get(j + 1));
                    professionsList.set(j + 1, aux);
                }
            }
        }
    }

    // calcula os percentuais de compatibildade com cada profissões
    // calculate compatibility percentage with each profession
    private void calculatePercentual(Professionable p) {
        double percPart = 100.0 / p.getNumber();
        double total = 0;
        int[] array_prof = p.getArray();
        int[] ar = getArray();

        for(int i = 0; i < ar.length; i++) {
            if(array_prof[i] != 0 && ar[i] >= array_prof[i]) {
                total = total + percPart;

                // reduz 10% caso seja uma habilidade importante na profissao e o usuario nao tenha
                // escolhido como área de maior interesse
                // reduce 10% if the important skill (4) and user didnt choose as their favorite area
                if(array_prof[i] == 4 && ar[i] < 5) {
                    total = total - percPart * 0.1;
                }
            }
        }
        p.setPercentual(roundNumber(total));
    }

    // round number to intenger
    // aredonda numero para inteiro
    private int roundNumber(double d) {
        double decimal;

        decimal = d - (int) d;
        if(decimal <= 0.5) {
            return (int) d;
        }
        else {
            return (int) d + 1;
        }
    }


}
