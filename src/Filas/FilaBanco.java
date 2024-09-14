package Filas;

public class FilaBanco {
    private Client head;
    private Client tail;
    private int length;
    public FilaBanco(){
        this.head = null;
        this.tail = null;
        this.length = 0;
    }
    public void add(String name){
        if(this.length == 0){
            Client newClient = new Client(name);
            this.head = newClient;
            this.tail = newClient;
            this.length++;
            return;
        }
        Client newClient = new Client(name);
        this.tail.next = newClient;
        this.tail = newClient;
        this.length++;
        return;
    }
    public String remove(){
        if(this.length == 0) return "";
        String clientName = this.head.name;
        this.head = this.head.next;
        this.length--;
        return clientName;
    }
    public void print(){
        System.out.println("Printando Lista de Clientes");
        if(this.length == 0){
            System.out.println("Lista Vazia!");
            System.out.println();
            return;
        }
        Client current = this.head;
        for(int i=0; i<this.length;i++){
            System.out.println(i + ": " + current.name);
            current = current.next;
        }
        System.out.println();
    }
    class Client{
        Client next;
        String name;
        public Client(String name){
            this.name = name;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        FilaBanco fila = new FilaBanco();
        fila.add("Cliente 1");
        fila.print();
        System.out.println("Atendendo: " + fila.remove());
        fila.add("Cliente 2");
        fila.add("Cliente 3");
        fila.add("Cliente 4");
        fila.print();
        System.out.println("Atendendo: "+ fila.remove());
        System.out.println("Atendendo: "+ fila.remove());
        System.out.println("Atendendo: "+ fila.remove());
        fila.print();
    }
}
