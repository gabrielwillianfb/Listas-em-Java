package Filas;

// Classe que representa a fila de clientes de um banco
public class FilaBanco {
    private Client head; // Referência para o primeiro cliente da fila
    private Client tail; // Referência para o último cliente da fila
    private int length;  // Tamanho da fila (quantidade de clientes)

    // Construtor da classe que inicializa uma fila vazia
    public FilaBanco(){
        this.head = null; // Fila começa sem nenhum cliente (cabeça nula)
        this.tail = null; // Fila começa sem nenhum cliente (cauda nula)
        this.length = 0;  // Tamanho da fila é zero
    }

    // Método para adicionar um cliente à fila
    public void add(String name){
        // Se a fila estiver vazia, o novo cliente se torna o primeiro e último da fila
        if(this.length == 0){
            Client newClient = new Client(name); // Cria um novo cliente
            this.head = newClient;  // O novo cliente é o primeiro da fila (cabeça)
            this.tail = newClient;  // O novo cliente é também o último (cauda)
            this.length++;          // Incrementa o tamanho da fila
            return;                 // Encerra o método
        }
        // Caso a fila não esteja vazia, o novo cliente é adicionado ao final
        Client newClient = new Client(name);  // Cria um novo cliente
        this.tail.next = newClient;           // O último cliente aponta para o novo cliente
        this.tail = newClient;                // Atualiza o último cliente da fila
        this.length++;                        // Incrementa o tamanho da fila
    }

    // Método para remover o cliente da cabeça da fila (atender o primeiro da fila)
    public String remove(){
        // Se a fila estiver vazia, retorna uma string vazia
        if(this.length == 0) return "";
        
        String clientName = this.head.name;  // Salva o nome do cliente que será removido
        this.head = this.head.next;          // A cabeça da fila agora aponta para o próximo cliente
        this.length--;                       // Diminui o tamanho da fila
        return clientName;                   // Retorna o nome do cliente removido
    }

    // Método para imprimir a fila de clientes
    public void print(){
        System.out.println("Printando Lista de Clientes");
        // Se a fila estiver vazia, imprime uma mensagem e encerra
        if(this.length == 0){
            System.out.println("Lista Vazia!");
            System.out.println();
            return;
        }
        // Caso a fila tenha clientes, percorre e imprime cada um
        Client current = this.head;  // Começa pelo primeiro cliente
        for(int i = 0; i < this.length; i++){
            System.out.println(i + ": " + current.name);  // Imprime o índice e o nome do cliente
            current = current.next;  // Avança para o próximo cliente
        }
        System.out.println();  // Linha em branco para separar a saída
    }

    // Classe interna que representa cada cliente na fila
    class Client{
        Client next;  // Referência para o próximo cliente na fila
        String name;  // Nome do cliente

        // Construtor do cliente que recebe o nome e inicializa o próximo cliente como nulo
        public Client(String name){
            this.name = name;
            this.next = null;
        }
    }

    // Método principal para testar a classe FilaBanco
    public static void main(String[] args) {
        FilaBanco fila = new FilaBanco(); // Cria uma nova fila de banco
        fila.add("Cliente 1");            // Adiciona o cliente "Cliente 1"
        fila.print();                     // Imprime a fila
        System.out.println("Atendendo: " + fila.remove());  // Remove (atende) o primeiro cliente
        fila.add("Cliente 2");            // Adiciona o cliente "Cliente 2"
        fila.add("Cliente 3");            // Adiciona o cliente "Cliente 3"
        fila.add("Cliente 4");            // Adiciona o cliente "Cliente 4"
        fila.print();                     // Imprime a fila
        System.out.println("Atendendo: " + fila.remove());  // Remove o próximo cliente
        System.out.println("Atendendo: " + fila.remove());  // Remove o próximo cliente
        System.out.println("Atendendo: " + fila.remove());  // Remove o próximo cliente
        fila.print();                     // Imprime a fila novamente
    }
}
