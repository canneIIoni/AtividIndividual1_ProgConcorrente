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

    public void run() {
        while (conta.getSaldo() > 0) {
            double valorCompra = valorCompras[(int) (Math.random() * valorCompras.length)];

            synchronized (conta) { // Sincronização para garantir operações seguras
                realizarCompra(valorCompra, lojas[0].getConta());
            }

            lojas[0].pagarSalarios();

            Loja temp = lojas[0];
            lojas[0] = lojas[1];
            lojas[1] = temp;
        }
    }

    public Conta getConta() {
        return conta;
    }

    public synchronized void realizarCompra(double valor, Conta contaDestino) {
        if (conta.getSaldo() >= valor) {
            banco.controleTransferencia(valor, contaDestino, conta);
            System.out.println(Thread.currentThread().getName() + " realizou uma compra de R$" + valor + ".");
        } else {
            System.out.println(Thread.currentThread().getName() + " não possui saldo suficiente para realizar a compra de R$" + valor + ".");
        }
    }

}

