import java.util.ArrayList;
import java.util.List;

public class TarjetaDeCredito {
        private double limite;
        private double saldo;
        private List<Compra> listaDeCompras;
        private double valueProduct = 0;


    public TarjetaDeCredito(double limite) {
        this.limite = limite;
        this.saldo = limite;
        this.listaDeCompras = new ArrayList<>();
    }

    public boolean makePurchase(Compra compra){
        if (this.saldo >= compra.getPurchaseValue()){
            this.saldo -= compra.getPurchaseValue();
            this.listaDeCompras.add(compra);
            return true;
        }
        //System.out.println("Saldo insuficiente");
        return false;
    }

    public double getLimite() {
        return limite;
    }

    public double getSaldo() {
        return saldo;
    }

    public List<Compra> getListaDeCompras() {
        return listaDeCompras;
    }

    public double getValueProduct() {
        return valueProduct;
    }
}
