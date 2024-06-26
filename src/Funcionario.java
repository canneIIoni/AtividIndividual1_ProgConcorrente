class Funcionario extends Thread {
    private Conta contaSal;
    public Conta contaInvest;
    public static final double SALARIO = 1400.0;

    public Funcionario(Conta contaSal, Conta contaInvest) {
        this.contaSal = contaSal;
        this.contaInvest = contaInvest;
    }

    public Conta getContaSal() {
        return contaSal;
    }

    public Conta getContaInvest() {
        return contaInvest;
    }

    public void investir() {
        double valorInvestido = SALARIO * 0.2;
        contaSal.transferir(contaInvest, valorInvestido);
        System.out.println(Thread.currentThread().getName() + " investiu R$" + valorInvestido + " na conta de investimentos.");
    }
}
