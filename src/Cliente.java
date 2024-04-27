class Cliente extends Thread {
    private Banco banco;
    private Conta conta;
    private Loja[] lojas;
    private static final double[] valorCompras = {100.0, 200.0}; // Enunciado pede compras de 100.0 ou 200.0

    public Cliente(Conta conta, Loja[] lojas, Banco banco) {
        this.banco = banco;
        this.conta = conta;
        this.lojas = lojas;
    }
}
