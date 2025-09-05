class AssentoExecutiva extends Assento {
    public AssentoExecutiva() {
        super("Executiva", 1000.00);
    }
    public double calcularPrecoFinal() {
        return precoBase * 1.3;
    }
}
