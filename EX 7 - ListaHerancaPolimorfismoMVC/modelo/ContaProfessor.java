package modelo;

public class ContaProfessor extends ContaAluno {

    private String nivel;
    private double limite;

    public ContaProfessor() {
        super();
    }

    public ContaProfessor(String nivel) {
        super();
        this.nivel = nivel;
        identificarLimite(nivel);
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    private void identificarLimite(String nivel) {
        if ("D1".equals(nivel)) {
            this.limite = 100;
        }
        if ("D2".equals(nivel)) {
            this.limite = 200;
        }
        if ("D3".equals(nivel)) {
            this.limite = 300;
        }
        if ("D4".equals(nivel)) {
            this.limite = 400;
        }
    }

    @Override
    public void sacar(double saque) throws SaqueInvalidoException, ValorNegativoException {
        if (saque < 0) {
            throw new ValorNegativoException("NAO SE PODE INSERIR UM VALOR NEGATIVO PARA O SAQUE!!");
        } else if (saque > super.getSaldo() + this.limite) {
            throw new SaqueInvalidoException("NAO PODE SACAR UM VALOR MAIOR QUE SEU SALDO + LIMITE!!");
        } else {
            if(super.getSaldo()>saque){
                super.setSaldo(super.getSaldo() - saque);
            }
            else{
                super.setSaldo(0);
                this.limite = (super.getSaldo()+this.limite) - saque; 
            }
        }
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public double getLimite() {
        return limite;
    }

    @Override
    public String toString() {
        return "ContaProfessor{" + super.toString() + "nivel=" + nivel + '}';
    }

}
