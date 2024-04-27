import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Conta {
    private Lock lock = new ReentrantLock();
    private double saldo;

    public Conta(double valorInicial) {
        this.saldo = valorInicial;
    }

    public double getSaldo() {
        return saldo;
    }

    public void sacar(double valor) {
        lock.lock();
        try {
            saldo -= valor;
        }
        finally {
            lock.unlock();
        }
    }

    public void depositar(double valor) {
        lock.lock();
        try {
            saldo += valor;
        }
        finally {
            lock.unlock();
        }
    }

    public void transferir(Conta destino, double valor) {
        // Saca valor da Conta atual e deposita valor na Conta destino.
        lock.lock();
        try {
            sacar(valor);
            destino.depositar(valor);
        }
        finally {
            lock.unlock();
        }
    }
}
