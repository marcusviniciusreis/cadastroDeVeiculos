package domain;

public class Carro extends Veiculo{
    public Carro(String placa, String modelo, String proprietario) {
        super(placa, modelo, proprietario);
    }
    
    @Override
    public String toString() {
    return super.toString() + ";" + "CARRO";
}
}
