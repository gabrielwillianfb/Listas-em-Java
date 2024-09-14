package Filas;

public class GerenciamentoImpressao {
    private Print head;
    private Print tail;
    private int length;
    public GerenciamentoImpressao(){
        this.length = 0;
        this.head = null;
        this.tail = null;
    }
    public void add(String documento){
        if(length == 0){
            Print print = new Print(documento);
            this.head = print;
            this.tail = print;
            this.length++;
            return;
        }
        Print print = new Print(documento);
        this.tail.next = print;
        this.tail = print;
        return;
    }
    public String remove(){
        String documento = this.head.documento;
        this.head = this.head.next;
        this.length--;
        return documento;
    }
    public void execute(){
        while(this.head != null){
            System.out.println("Imprimindo: " + this.remove());
        }
        System.out.println("Nenhum documento na Fila");
    }
    public void printFila(){
        if(this.length == 0) return;
        Print current = this.head;
        int counter = 0;
        while(current != null){
            System.out.println(counter + ": " + current.documento);
            current = current.next;
            counter++;
        }
    }
    class Print{
        Print next;
        String documento;
        public Print(String documento){
            this.next = null;
            this.documento = documento;
        }
    }

    public static void main(String[] args) {
        GerenciamentoImpressao fila = new GerenciamentoImpressao();
        fila.add("Trabalho Desafios-Listas-em-Java");
        fila.add("Finanças.XLSX");
        fila.add("Plano de viagem");
        fila.printFila();
        fila.execute();
    }
}
