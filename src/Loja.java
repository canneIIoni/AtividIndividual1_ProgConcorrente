class Loja {
    private Banco banco;
    private Conta conta;
    private Funcionario[] funcionarios;

    public Loja(Banco banco, Conta conta, Funcionario[] funcionarios) {
        this.banco = banco;
        this.conta = conta;
        this.funcionarios = funcionarios;
    }
}