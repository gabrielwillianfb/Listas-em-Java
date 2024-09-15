package ListaDuplamenteEncadeada;

import java.util.Scanner;

// Classe que controla o versionamento de um texto, permitindo undo e redo
public class ControleDeReversao {
    Version head; // Referência para a versão atual do texto
    int length;   // Tamanho da lista de versões (não está sendo utilizado diretamente)

    // Construtor que inicializa o controle de reversão sem nenhuma versão
    public ControleDeReversao(){
        this.head = null;  // Não há versões no início
        this.length = 0;   // O tamanho é inicialmente zero
    }

    // Método para adicionar uma nova versão do texto
    public void add(String data){
        // Se não houver versões, cria a primeira versão
        if(this.head == null){
            this.head = new Version(data); // A versão inicial recebe o texto
            return;
        }
        // Cria uma nova versão concatenando o texto da versão atual com o novo texto
        Version newData = new Version(this.head.data + data); 
        this.head.next = newData;   // Define a nova versão como próxima da versão atual
        newData.back = this.head;   // A nova versão aponta para a anterior
        this.head = newData;        // A nova versão se torna a versão atual (cabeça)
    }

    // Método que retorna o texto da versão atual
    public String get(){
        // Se não houver versões, retorna uma string vazia
        if(this.head == null){
            return "";
        }
        return this.head.data; // Retorna o texto da versão atual
    }

    // Método para desfazer a última modificação (voltar para a versão anterior)
    public void undo(){
        // Se não houver versões ou não for possível desfazer, não faz nada
        if(this.head == null) { return; }
        if(this.head.back == null) { 
            this.head = null; // Se for a primeira versão, limpa o texto
            return;
        }
        this.head = this.head.back; // Volta para a versão anterior
    }

    // Método para refazer a última modificação desfeita (avançar para a próxima versão)
    public void redo(){
        // Se não houver versões ou não for possível refazer, não faz nada
        if(this.head == null) { return; }
        if(this.head.next == null) { return; }
        this.head = this.head.next; // Avança para a próxima versão
    }

    // Classe interna que representa uma versão do texto
    class Version{
        Version next;  // Referência para a próxima versão
        Version back;  // Referência para a versão anterior
        String data;   // Texto da versão atual

        // Construtor que inicializa uma versão com o texto fornecido
        public Version(String data){
            this.next = null;  // Não há próxima versão inicialmente
            this.back = null;  // Não há versão anterior inicialmente
            this.data = data;  // Texto da versão
        }
    }

    // Método principal para interagir com o sistema de controle de reversão
    public static void main(String[] args) {
        try (Scanner myScan = new Scanner(System.in)) {
            ControleDeReversao controle = new ControleDeReversao(); // Cria uma instância do controle de reversão
            boolean condition = true; // Variável de controle para o loop
            while(condition){
                System.out.println("Texto: " + controle.get()); // Exibe o texto atual
                System.out.println("Digite 1 para sair");
                System.out.println("Digite 2 para redo (refazer texto)");
                System.out.println("Digite 3 para undo (desfazer texto)");
                System.out.println("Digite 4 para modificar o texto");
                System.out.print("Escolha: ");
                int escolha = myScan.nextInt(); // Lê a escolha do usuário
                System.out.println();
                
                // Switch para tratar as diferentes ações do usuário
                switch (escolha){
                    case 1: // Sair do programa
                        condition = false;
                        break;
                    case 2: // Refazer a última ação
                        controle.redo();
                        break;
                    case 3: // Desfazer a última ação
                        controle.undo();
                        break;
                    case 4: // Modificar o texto atual
                        myScan.nextLine(); // Limpa o buffer de entrada
                        System.out.print(controle.get()); // Mostra o texto atual
                        String newData = myScan.nextLine(); // Lê o novo texto do usuário
                        controle.add(newData); // Adiciona o novo texto à versão atual
                        break;
                }
            }
        }
    }
}
