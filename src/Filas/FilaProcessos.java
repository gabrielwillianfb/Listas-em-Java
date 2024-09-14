package Filas;

public class FilaProcessos {
    private Processo head;
    private Processo tail;
    private int length;
    public FilaProcessos(){
        this.head = null;
        this.tail = null;
        this.length = 0;
    }
    public void add(String processName){
        if(this.length == 0){
            Processo processo = new Processo(processName);
            this.head = processo;
            this.tail = processo;
            this.length++;
            return;
        }
        Processo processo = new Processo(processName);
        this.tail.next = processo;
        this.tail = processo;
        this.length++;
        return;
    }
    public String remove(){
        if(this.length == 0) return "";
        String processName = this.head.name;
        this.head = this.head.next;
        this.length--;
        return processName;
    }
    public void print(){
        System.out.println("Processos prontos para execução");
        if(this.length == 0){
            System.out.println("Nenhum processo está pronto!");
            return;
        }
        Processo current = this.head;
        for(int i=0; i<this.length;i++){
            System.out.println(i+": " + current.name);
            current = current.next;
        }
        System.out.println();
    }
    class Processo{
        Processo next;
        String name;
        public Processo(String name){
            this.name = name;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        FilaProcessos fila = new FilaProcessos();
        fila.add("System34");
        fila.add("Steam");
        fila.add("Linux");
        fila.add("Youtube");
        fila.print();
        System.out.println("Executando: " + fila.remove());
        System.out.println("Executando: " + fila.remove());
        System.out.println("Executando: " + fila.remove());
        System.out.println("Executando: " + fila.remove());
    }
}
