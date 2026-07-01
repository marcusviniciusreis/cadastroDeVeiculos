package domain;

public abstract class Veiculo {
    private String placa;
    private String modelo;
    private String proprietario;

    public Veiculo(String placa, String modelo, String proprietario) {
        this.placa = placa;
        this.modelo = modelo;
        this.proprietario = proprietario;
    }

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public String getProprietario() {
        return proprietario;
    }

    @Override
    public String toString() {
        return placa + ";" + modelo + ";" + proprietario;
    }

    

}
