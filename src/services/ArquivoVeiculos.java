package services;

import domain.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

// usei uma classe que manipula arquivos que a Professora usou numa atividade como repertorio 
public class ArquivoVeiculos {
    private String nomeArquivo = "reservas.txt";
    private Formatter gravador;
    private Scanner leitor;

    public void abrirArquivoParaGravacao() {
        try {
            this.gravador = new Formatter(nomeArquivo);
        } catch (FileNotFoundException e) {
            System.err.println("Nao foi possivel criar o arquivo");
            e.printStackTrace();
        }
    }

    public void salvarReservas(ArrayList<Veiculo> reservas) { 
        abrirArquivoParaGravacao();
        if (gravador != null) {
            for (Veiculo r : reservas) {
                gravador.format("%s\n", r);
            }
            gravador.flush();
        }
        fecharArquivoGravacao();
    }

    public void fecharArquivoGravacao() {
        if (gravador != null) {
            gravador.close();
        }
    }

    public void abrirArquivoLeitura() {
        try {
            leitor = new Scanner(new File(nomeArquivo));
        } catch (FileNotFoundException ex) {
            System.err.println("O arquivo nao pode ser aberto para leitura.");
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    public ArrayList<String> lerArquivo() {
        abrirArquivoLeitura();
        ArrayList<String> retorno = new ArrayList<>();
        if (leitor != null) {
            while (leitor.hasNext()) {
                retorno.add(leitor.nextLine());
            }
        }
        fecharArquivoLeitura();
        return retorno;
    }

    public void fecharArquivoLeitura() {
        if (leitor != null) {
            leitor.close();
        }
    }

    public ArrayList<Veiculo> listarTodas() {
        ArrayList<Veiculo> veiculos = new ArrayList<>();
        ArrayList<String> linhas = lerArquivo();
        for (String linha : linhas) {
        String[] dados = linha.split(";");
        String placa = dados[0];
        String modelo = dados[1];
        String proprietario = dados[2];
        String tipo = dados[3];
        
        Veiculo v = null;
        if(tipo.equals("CARRO")){
            v = new Carro(placa, modelo, proprietario); 
        }else{
            v = new Moto(placa, modelo, proprietario);
        }
        veiculos.add(v); // adiciona na lista
}
        return veiculos;
    }
}
