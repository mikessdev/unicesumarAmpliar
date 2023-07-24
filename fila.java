import java.util.LinkedList;
import java.util.Queue;

public class SistemaAtendimento {
    private Queue<String> filaClientes;

    public SistemaAtendimento() {
        filaClientes = new LinkedList<>();
    }

    public void adicionarCliente(String nomeCliente) {
        filaClientes.add(nomeCliente);
        System.out.println(nomeCliente + " entrou na fila.");
    }

    public void atenderProximoCliente() {
        if (!filaClientes.isEmpty()) {
            String clienteAtendido = filaClientes.poll();
            System.out.println("Atendendo o cliente: " + clienteAtendido);
        } else {
            System.out.println("Não há clientes na fila.");
        }
    }

    public void exibirFila() {
        System.out.println("Fila de clientes: " + filaClientes);
    }

    public static void main(String[] args) {
        SistemaAtendimento sistema = new SistemaAtendimento();

        sistema.adicionarCliente("João");
        sistema.adicionarCliente("Maria");
        sistema.adicionarCliente("Pedro");

        sistema.exibirFila(); // Saída: Fila de clientes: [João, Maria, Pedro]

        sistema.atenderProximoCliente(); // Saída: Atendendo o cliente: João
        sistema.atenderProximoCliente(); // Saída: Atendendo o cliente: Maria

        sistema.exibirFila(); // Saída: Fila de clientes: [Pedro]
    }
}
