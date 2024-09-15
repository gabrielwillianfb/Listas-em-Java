package ListaSimplesmenteEncadeada;

@SuppressWarnings("unused")
public class GerenciadorDeTarefas {
    private Tarefa head;  // Referência para o início da lista
    private int length;   // Número de tarefas na lista

    // Construtor que inicializa a lista vazia
    public GerenciadorDeTarefas(){
        this.length = 0;
        this.head = null;
    }

    // Método que adiciona uma nova tarefa ao final da lista
    public void addTask(String nome){
        if(this.head == null){  // Se a lista está vazia, cria a primeira tarefa
            this.head = new Tarefa(nome);
            return;
        }
        Tarefa current = this.head;
        while(current.next != null){  // Percorre até o final da lista
            current = current.next;
        }
        current.next = new Tarefa(nome);  // Adiciona a nova tarefa ao final
    }

    // Método que remove uma tarefa pelo índice
    public boolean removeTask(int index){
        if(index == 0){  // Remove a primeira tarefa
            this.head = this.head.next;
            return true;
        }
        Tarefa current = this.head;
        for(int i = 1; i < index; i++){  // Encontra o índice da tarefa a ser removida
            if(current.next == null){
                return false;
            }
            current = current.next;
        }
        current.next = current.next.next;  // Remove a tarefa ao ajustar a referência
        this.length -= 1;
        return true;
    }

    // Método que retorna o nome da tarefa pelo índice
    public String getTask(int index){
        if(index == 0) return this.head.nome;  // Se for a primeira tarefa
        Tarefa current = this.head;
        int counter = 0;
        while(current.next != null){  // Percorre a lista até encontrar o índice
            if(counter == index){
                return current.nome;
            }
            index++;
            current = current.next;
        }
        throw new RuntimeException("Index out of bounds");
    }

    // Método que marca uma tarefa como concluída
    public void concluirTask(int index){
        if(index == 0){  // Marca a primeira tarefa como concluída
            this.head.estado = true;
            return;
        }
        Tarefa current = this.head.next;
        int counter = 1;
        while(current.next != null){  // Percorre até encontrar a tarefa pelo índice
            if(counter == index){
                current.estado = true;
                return;
            }
            index++;
            current = current.next;
        }
        throw new RuntimeException("Index out of bounds");
    }

    // Método que retorna o estado da tarefa (se está concluída ou não)
    public boolean estadoTask(int index){
        if(index == 0) return this.head.estado;
        Tarefa current = this.head;
        int counter = 0;
        while(current.next != null){  // Percorre a lista até encontrar o índice
            if(counter == index){
                return current.estado;
            }
            index++;
            current = current.next;
        }
        throw new RuntimeException("Index out of bounds");
    }

    // Método que imprime todas as tarefas com seus estados (se estão concluídas ou não)
    public void printTasks(){
        if(this.head == null){  // Se a lista estiver vazia, lança uma exceção
            throw new RuntimeException("Linked List Empty");
        }
        System.out.println("--------------------------");
        System.out.println("Printando Lista de Tarefas");
        System.out.println("--------------------------");
        Tarefa current = this.head;
        while(current.next != null){  // Percorre e imprime todas as tarefas
            String state = current.estado ? "Feito" : "Tem que Fazer";
            System.out.println(current.nome + ": " + state);
            System.out.println();
            current = current.next;
        }
        // Imprime a última tarefa
        String state = current.estado ? "Feito" : "Tem que Fazer";
        System.out.println(current.nome + ": " + state);
        System.out.println("--------------------------");
    }

    // Classe interna que representa uma tarefa
    class Tarefa{
        public String nome;     // Nome da tarefa
        public boolean estado;  // Estado da tarefa (concluída ou não)
        public Tarefa next;     // Próxima tarefa na lista

        // Construtor da tarefa
        public Tarefa(String nome){
            this.nome = nome;
            this.estado = false;
            this.next = null;
        }
    }

    // Método principal que cria e manipula tarefas
    public static void main(String[] args) {
        GerenciadorDeTarefas lista = new GerenciadorDeTarefas();
        lista.addTask("Acordar");
        lista.addTask("Estudar");
        lista.addTask("Codar");
        lista.addTask("Jogar");
        lista.addTask("Dormir");
        lista.concluirTask(0);  // Marca a tarefa "Acordar" como concluída
        lista.concluirTask(1);  // Marca a tarefa "Estudar" como concluída
        lista.printTasks();     // Imprime a lista de tarefas
        lista.removeTask(3);    // Remove a tarefa "Jogar"
        lista.printTasks();     // Imprime a lista de tarefas novamente
    }
}
