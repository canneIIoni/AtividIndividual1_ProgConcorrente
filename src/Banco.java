import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Banco {
    private Lock lock = new ReentrantLock();

    public synchronized void controleTransferencia(double valor, Conta destino, Conta origem) {
        lock.lock();
        try {
            if (origem.getSaldo() >= valor) {
                origem.sacar(valor);
                destino.depositar(valor);
                System.out.println("Transferência de R$" + valor + " realizada da conta de " + origem + " para a conta de " + destino + ".");
            } else {
                System.out.println("Saldo insuficiente!\n" + origem + " necessita de mais R$" + (valor - origem.getSaldo()) + " para realizar essa transferência.");
            }
        }
        finally {
            lock.unlock();
        }
    }
}
