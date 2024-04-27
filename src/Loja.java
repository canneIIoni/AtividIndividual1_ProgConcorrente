class Loja {
    private Banco banco;
    private Conta conta;
    private Funcionario[] funcionarios;

    public Loja(Banco banco, Conta conta, Funcionario[] funcionarios) {
        this.banco = banco;
        this.conta = conta;
        this.funcionarios = funcionarios;
    }

    public synchronized void pagarSalarios() {
        double saldoDisponivel = conta.getSaldo();
        double totalSalarios = funcionarios.length * Funcionario.SALARIO;

        // caso o saldo é suficiente para o deposito do salário de TODOS os funcionários
        if (saldoDisponivel >= totalSalarios) {
            for (Funcionario funcionario : funcionarios) {
                banco.controleTransferencia(Funcionario.SALARIO, funcionario.getContaSal(), conta);
                funcionario.investir();
                System.out.println("Salário pago a " + funcionario.getName());
            }
        // caso o saldo não é suficiente para o deposito do salário de TODOS os funcionários
        } else {
            System.out.println("A loja não possui saldo suficiente para pagar todos os salários.");

            // for para tentar depositar o salário para o número possível de funcionários
            for (Funcionario funcionario : funcionarios) {
                if (saldoDisponivel >= Funcionario.SALARIO) {
                    banco.controleTransferencia(Funcionario.SALARIO, funcionario.getContaSal(), conta);
                    funcionario.investir();
                    System.out.println("Salário pago a " + funcionario.getName());
                    saldoDisponivel -= Funcionario.SALARIO;
                } else {
                    System.out.println("Saldo insuficiente para pagar o salário de " + funcionario.getName());
                }
            }
        }
    }
}