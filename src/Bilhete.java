import java.util.Random;

public class Bilhete {

    int id;
    double saldo;
    Usuario usuario;

    final double tarifaBase = 5.20;

    public Bilhete(Usuario usuario){
        id = gerarID();
        this.usuario = usuario;
    }

    public int gerarID(){
        Random rd = new Random();
        return random.nextInt(1000, 10000);
    }

    public void porSaldo(double valor){
        saldo += valor;
    }

    public double cadeSaldo(){
        return saldo;
    }

    public void passarCatraca(){
        double debito;
        if (usuario.tipoTarifa.equalsIgnoreCase("normal")){
            debito = tarifaBase;
        }
        else {
            debito = tarifaBase * 0.5;
        }

        if (saldo >= debito){
            saldo -= debito;
        }
    }
}
