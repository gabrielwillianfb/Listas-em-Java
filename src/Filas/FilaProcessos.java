package Filas;

// Classe que representa uma fila de processos prontos para execução
public class FilaProcessos {
    private Processo head; // Referência para o primeiro processo da fila
    private Processo tail; // Referência para o último processo da fila
    private int length;    // Tamanho da fila (quantidade de processos)

    // Construtor que inicializa a fila de processos vazia
    public FilaProcessos(){
        this.head = null;  // A fila começa sem nenhum processo (cabeça nula)
        this.tail = null;  // A fila começa sem nenhum processo (cauda nula)
        this.length = 0;   // O tamanho da fila é inicialmente zero
    }

    // Método para adicionar um novo processo à fila
    public void add(String processName){
        // Se a fila estiver vazia, o processo se torna o primeiro e último da fila
        if(this.length == 0){
            Processo processo = new Processo(processName); // Cria um novo processo
            this.head = processo;  // O novo processo é a cabeça da fila
            this.tail = processo;  // O novo processo é também a cauda da fila
            this.length++;         // Incrementa o tamanho da fila
            return;                // Encerra o método
        }
        // Caso a fila não esteja vazia, o novo processo é adicionado ao final
        Processo processo = new Processo(processName);  // Cria um novo processo
        this.tail.next = processo;                      // O último processo aponta para o novo processo
        this.tail = processo;                           // Atualiza a cauda da fila
        this.length++;                                  // Incrementa o tamanho da fila
    }

    // Método para remover e retornar o primeiro processo da fila (executar o processo)
    public String remove(){
        // Se a fila estiver vazia, retorna uma string vazia
        if(this.length == 0) return "";
        
        String processName = this.head.name;  // Armazena o nome do processo que será removido
        this.head = this.head.next;           // A cabeça da fila agora aponta para o próximo processo
        this.length--;                        // Diminui o tamanho da fila
        return processName;                   // Retorna o nome do processo removido (executado)
    }

    // Método para imprimir os processos na fila
    public void print(){
        System.out.println("Processos prontos para execução");
        // Se não houver processos na fila, imprime uma mensagem e encerra
        if(this.length == 0){
            System.out.println("Nenhum processo está pronto!");
            return;
        }
        // Percorre a fila e imprime cada processo
        Processo current = this.head;  // Começa pelo primeiro processo
        for(int i = 0; i < this.length; i++){
            System.out.println(i + ": " + current.name);  // Imprime o índice e o nome do processo
            current = current.next;  // Avança para o próximo processo
        }
        System.out.println();  // Linha em branco para separar a saída
    }

    // Classe interna que representa um processo na fila
    class Processo{
        Processo next;  // Referência para o próximo processo na fila
        String name;    // Nome do processo

        // Construtor que inicializa o processo com um nome e próximo processo como nulo
        public Processo(String name){
            this.name = name;
            this.next = null;
        }
    }

    // Método principal para testar a classe FilaProcessos
    public static void main(String[] args) {
        FilaProcessos fila = new FilaProcessos(); // Cria uma nova fila de processos
        fila.add("System34");  // Adiciona o processo "System34"
        fila.add("Steam");     // Adiciona o processo "Steam"
        fila.add("Linux");     // Adiciona o processo "Linux"
        fila.add("Youtube");   // Adiciona o processo "Youtube"
        fila.print();          // Imprime a fila de processos
        System.out.println("Executando: " + fila.remove());  // Remove (executa) o primeiro processo
        System.out.println("Executando: " + fila.remove());  // Remove o próximo processo
        System.out.println("Executando: " + fila.remove());  // Remove o próximo processo
        System.out.println("Executando: " + fila.remove());  // Remove o próximo processo
    }
}
