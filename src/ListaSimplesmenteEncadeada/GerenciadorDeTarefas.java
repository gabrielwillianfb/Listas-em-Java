package ListaSimplesmenteEncadeada;

@SuppressWarnings("unused")
public class GerenciadorDeTarefas {
    private Tarefa head;
    private int length;
    public GerenciadorDeTarefas(){
        this.length = 0;
        this.head = null;
    }

    public void addTask(String nome){
        if(this.head == null){
            this.head = new Tarefa(nome);
            return;
        }
        Tarefa current = this.head;
        while(current.next != null){
            current = current.next;
        }
        current.next = new Tarefa(nome);

    }

    public boolean removeTask(int index){
        if(index == 0){
            this.head = this.head.next;
            return true;
        }
        Tarefa current = this.head;
        for(int i = 1; i < index; i++){
            if(current.next == null){
                return false;
            }
            current = current.next;
        }
        current.next = current.next.next;
        this.length -= 1;
        return true;
    }
    public String getTask(int index){
       if(index ==0) return this.head.nome;
       Tarefa current = this.head;
       int counter = 0;
       while(current.next != null){
           if(counter == index){
               return current.nome;
           }
           index++;
           current = current.next;
       }
       throw new RuntimeException("Index out bound");
    }
    public void concluirTask(int index){
        if(index == 0){
            this.head.estado = true;
            return;
        }
        Tarefa current = this.head.next;
        int counter = 1;
        while(current.next != null){
            if(counter == index){
                current.estado = true;
                return;
            }
            index++;
            current = current.next;
        }
        throw new RuntimeException("Index out bound");
    }
    public boolean estadoTask(int index){
        if(index ==0) return this.head.estado;
        Tarefa current = this.head;
        int counter = 0;
        while(current.next != null){
            if(counter == index){
                return current.estado;
            }
            index++;
            current = current.next;
        }
        throw new RuntimeException("Index out bound");
    }
    public void printTasks(){
        if(this.head == null){
            throw new RuntimeException("Linked List Empty");
        }
        System.out.println("--------------------------");
        System.out.println("Printando Lista de Tarefas");
        System.out.println("--------------------------");
        Tarefa current = this.head;
        while(current.next != null){
            String state = current.estado ? "Feito" : "Tem que Fazer";
            System.out.println(current.nome + ": " + state);
            System.out.println();
            current = current.next;
        }
        String state = current.estado ? "Feito" : "Tem que Fazer";
        System.out.println(current.nome + ": " + state);
        System.out.println("--------------------------");
    }

    class Tarefa{
       public String nome;
       public boolean estado;
       public Tarefa next;
       public Tarefa(String nome){
           this.nome = nome;
           this.estado = false;
           this.next = null;
       }
    }

    public static void main(String[] args) {
        GerenciadorDeTarefas lista = new GerenciadorDeTarefas();
        lista.addTask("Acordar");
        lista.addTask("Estudar");
        lista.addTask("Codar");
        lista.addTask("Jogar");
        lista.addTask("Dormir");
        lista.concluirTask(0);
        lista.concluirTask(1);
        lista.printTasks();
        lista.removeTask(3);
        lista.printTasks();
    }
}
