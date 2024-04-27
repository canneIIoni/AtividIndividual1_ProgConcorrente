class Conta {
    private double saldo;

    public Conta(double valorInicial) {
        this.saldo = valorInicial;
    }

    public double getSaldo() {
        return saldo;
    }

    public void sacar(double valor) {
        saldo -= valor;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public void transferir(Conta destino, double valor) {
        // Saca valor da Conta atual e deposita valor na Conta destino.
        sacar(valor);
        destino.depositar(valor);
    }
}
