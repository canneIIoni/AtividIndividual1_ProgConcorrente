class Loja {
    private Banco banco;
    private Conta conta;
    private Funcionario[] funcionarios;

    public Loja(Conta conta, Funcionario[] funcionarios, Banco banco) {
        this.banco = banco;
        this.conta = conta;
        this.funcionarios = funcionarios;
    }

    public synchronized void pagarSalarios() {
        if (conta.getSaldo() >= Funcionario.SALARIO) {
            banco.controleTransferencia(Funcionario.SALARIO, funcionarios[0].getContaSal(), conta);
            funcionarios[0].investir();
            System.out.println("Salário pago a " + funcionarios[0].getName());

            Funcionario temp = funcionarios[0];
            funcionarios[0] = funcionarios[1];
            funcionarios[1] = temp;
        } else {
            System.out.println("A loja não possui saldo suficiente para pagar os salários dos funcionários.");
        }
    }

    public Conta getConta() {
        return conta;
    }
}