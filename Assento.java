abstract class Assento {
    protected String classe;
    protected double precoBase;

    public Assento(String classe, double precoBase) {
        this.classe = classe;
        this.precoBase = precoBase;
    }

    public abstract double calcularPrecoFinal();
}
