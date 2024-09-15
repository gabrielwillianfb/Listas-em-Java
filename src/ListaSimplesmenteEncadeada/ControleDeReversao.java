package ListaSimplesmenteEncadeada;

import java.util.Scanner;

// Classe que controla a reversão de versões de um texto, usando lista simplesmente encadeada
public class ControleDeReversao {
    Version head;  // Referência para o início da lista
    int length;    // Tamanho da lista (número de versões)

    // Construtor que inicializa uma lista vazia
    public ControleDeReversao(){
        this.head = null;
        this.length = 0;
    }

    // Método que adiciona uma nova versão ao final da lista
    public void add(String data){
        if(this.head == null){
            this.head = new Version(data);  // Se não há versões, cria a primeira
            return;
        }
        // Percorre até o final da lista e adiciona uma nova versão
        Version current = this.head;
        while(current.next != null){
            current = current.next;
        }
        String newData = current.data + data;  // Nova versão é a concatenação do texto atual com o novo conteúdo
        current.next = new Version(newData);   // Adiciona nova versão ao final
    }

    // Método que retorna a última versão do texto
    public String get(){
        if(this.head == null){
            return "";
        }
        Version current = this.head;
        while(current.next != null){
            current = current.next;
        }
        return current.data;  // Retorna o dado da última versão
    }

    // Método que desfaz a última alteração removendo a última versão
    public void undo(){
        if(this.head == null){  // Se não há versões, não há o que desfazer
            return;
        }
        if(this.head.next == null){  // Se houver apenas uma versão, não desfaz
            return;
        }
        Version current = this.head;
        while(current.next.next != null){  // Percorre até o penúltimo elemento
            current = current.next;
        }
        current.next = null;  // Remove o último elemento
    }

    // Classe interna que representa uma versão do texto
    class Version {
        String data;  // O conteúdo da versão
        Version next; // Próxima versão na lista

        // Construtor que inicializa uma nova versão
        public Version(String data){
            this.data = data;
            this.next = null;
        }
    }

    // Método principal que fornece o menu interativo para o usuário
    public static void main(String[] args) {
        try (Scanner myScan = new Scanner(System.in)) {
            ControleDeReversao text = new ControleDeReversao();
            boolean condition = true;

            // Loop principal que oferece opções ao usuário
            while(condition){
                System.out.println("Texto atual");
                System.out.println(text.get());  // Exibe o texto atual
                System.out.println("Digite '0' para sair");
                System.out.println("Digite '1' para desfazer a alteração");
                System.out.println("Digite '2' para modificar o texto");
                System.out.print("Escolha: ");
                int action = myScan.nextInt();  // Captura a escolha do usuário
                switch(action){
                    case 0:
                        condition = false;  // Encerra o programa
                        break;
                    case 1:
                        text.undo();  // Desfaz a última alteração
                        break;
                    case 2:
                        myScan.nextLine();  // Captura o novo texto
                        System.out.print(text.get());  // Mostra o texto atual
                        String msg = myScan.nextLine();
                        text.add(msg);  // Adiciona a nova modificação
                }
            }
        }
    }
}
