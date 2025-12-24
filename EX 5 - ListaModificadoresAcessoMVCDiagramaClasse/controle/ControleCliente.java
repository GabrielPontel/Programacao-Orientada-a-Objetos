package controle;

import controle.excecao.IdentificadorClasseExistenteException;
import controle.excecao.IdentificadorClasseInexistenteException;
import java.util.ArrayList;
import java.util.List;
import modelo.Cliente;

public class ControleCliente {

    private static List<Cliente> clientes = new ArrayList<>();
    
    public ControleCliente() {
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        ControleCliente.clientes = clientes;
    }

    public void addCliente(Cliente cliente) throws IdentificadorClasseExistenteException {
        for (Cliente c : clientes) {
            if (c.getCpf().equals(cliente.getCpf())) {
                throw new IdentificadorClasseExistenteException("CPF JA CADASTRADO !!");
            }
        }
        clientes.add(cliente);
    }

    public Cliente buscarCliente(String cpf) throws IdentificadorClasseInexistenteException {
        for (Cliente c : clientes) {
            if (c.getCpf().equals(cpf)) {
                return c;
            }
        }
        throw new IdentificadorClasseInexistenteException("ESSE CPF INEXISTENTE!!");
    }

    public void removeCliente(Cliente cliente) {
        clientes.remove(cliente);
    }
}
