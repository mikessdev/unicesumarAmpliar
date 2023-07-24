import java.util.Stack;

public class EditorTexto {
    private String textoAtual;
    private Stack<String> pilhaDesfazer;
    private Stack<String> pilhaRefazer;

    public EditorTexto() {
        textoAtual = "";
        pilhaDesfazer = new Stack<>();
        pilhaRefazer = new Stack<>();
    }

    public void inserirTexto(String texto) {
        pilhaDesfazer.push(textoAtual); // Armazena o estado atual antes da inserção
        textoAtual += texto;
        pilhaRefazer.clear(); // Limpa a pilha de refazer, pois novas alterações invalidam o refazer
    }

    public void desfazer() {
        if (!pilhaDesfazer.isEmpty()) {
            pilhaRefazer.push(textoAtual); // Armazena o estado atual antes do desfazer
            textoAtual = pilhaDesfazer.pop();
        }
    }

    public void refazer() {
        if (!pilhaRefazer.isEmpty()) {
            pilhaDesfazer.push(textoAtual); // Armazena o estado atual antes do refazer
            textoAtual = pilhaRefazer.pop();
        }
    }

    public String getTextoAtual() {
        return textoAtual;
    }

    public static void main(String[] args) {
        EditorTexto editor = new EditorTexto();

        editor.inserirTexto("Olá, ");
        editor.inserirTexto("mundo!");

        System.out.println(editor.getTextoAtual()); // Saída: "Olá, mundo!"

        editor.desfazer();
        System.out.println(editor.getTextoAtual()); // Saída: "Olá, "

        editor.refazer();
        System.out.println(editor.getTextoAtual()); // Saída: "Olá, mundo!"
    }
}
