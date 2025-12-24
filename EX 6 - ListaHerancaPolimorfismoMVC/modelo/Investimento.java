
package modelo;

public abstract class Investimento {
    protected double valor;

    public Investimento() {
    }

    public Investimento(double valor) {
        this.valor = valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Investimento{" + "valor=" + valor + '}';
    }

}
