package domain;

import exceptions.LimiteAtingidoException;

import java.util.ArrayList;
public class Estacionamento {
    private final int maxCarros = 10; // 20 carros no estacionamento condominial
    private final int maxMotos = 5; // e 10 motos
    private final int maxVeiculos = maxCarros + maxMotos;
    private ArrayList<Veiculo> veiculos;

    public Estacionamento() {
        veiculos = new ArrayList<>();
    }

    public void cadastrarVeiculo(Veiculo v) {
        int qtdCarros = 0;
        int qtdMotos = 0;

        if (veiculos.size() >= maxVeiculos) {
            throw new LimiteAtingidoException("Limite de veiculos atingido");
        }
        for (Veiculo veiculo : veiculos) {
            if (veiculo instanceof Carro){
                qtdCarros++;
            }
            if (veiculo instanceof Moto) {
                qtdMotos++;
            }
        }
        if (v instanceof Carro && qtdCarros >= maxCarros) {
            throw new LimiteAtingidoException("Limite de carros atingido");
        }
        if (v instanceof Moto && qtdMotos >= maxMotos) {
            throw new LimiteAtingidoException("Limite de motos atingido");
        }
        veiculos.add(v);
    }

    public Veiculo buscarVeiculo(String placa) {
        for (Veiculo v : veiculos) {
            if (v.getPlaca().equalsIgnoreCase(placa)) {
                return v;
            }
        }
        return null;
    }

    public ArrayList<Veiculo> getVeiculos() {
        return veiculos;
    }
}
