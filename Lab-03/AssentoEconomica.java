class AssentoEconomica extends Assento {
    public AssentoEconomica() {
        super("Econômica", 500.00);
    }
    public double calcularPrecoFinal() {
        return precoBase;
    }
}
