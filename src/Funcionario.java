class Funcionario extends Thread {
    private Conta contaSal;
    private Conta contaInvest;
    public static final double SALARIO = 1400.0;

    public Funcionario(Conta contaSal, Conta contaInvest) {
        this.contaSal = contaSal;
        this.contaInvest = contaInvest;
    }
}
