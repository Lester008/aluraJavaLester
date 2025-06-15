public class Compra implements Comparable<Compra>{
    private double purchaseValue;
    private String description;

    public Compra(double purchaseValue, String description) {
        this.purchaseValue = purchaseValue;
        this.description = description;
    }

    public double getPurchaseValue() {
        return purchaseValue;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Compra: purchaseValue= " + purchaseValue +
                ", description='" + description;
    }

    @Override
    public int compareTo(Compra otraCompra) {
        return Double.valueOf(this.purchaseValue).compareTo(Double.valueOf(otraCompra.getPurchaseValue()));
    }
}
