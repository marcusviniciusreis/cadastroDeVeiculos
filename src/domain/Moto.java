package domain;

public class Moto extends Veiculo{
    public Moto(String placa, String modelo, String proprietario) {
        super(placa, modelo, proprietario);
    }
    
    @Override
public String toString() {
    return super.toString() + ";" + "MOTO";
}
}
