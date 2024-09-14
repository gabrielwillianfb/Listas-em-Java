package ListaSimplesmenteEncadeada;

public class HistoricoDeNavegacao {
    private Url head;
    private int maxSize;
    private int length;
    public HistoricoDeNavegacao(int maxSize){
        this.head = null;
        this.length = 0;
        this.maxSize = maxSize;
    }
    public void add(String url){
        if(this.head == null){
            this.head = new Url(url);
            this.length = 1;
            return;
        }
        if(length == maxSize){
            System.out.println("Limite alcançado, deletando primeiro URL");
            this.head = this.head.next;
            length--;
        }
        Url current = this.head;
        while(current.next != null){
            current = current.next;
        }
        current.next = new Url(url);
        this.length++;
        return;
    }
    public void remove(int index){
        if(index == 0){
            this.head = this.head.next;
            this.length--;
            return;
        }
        Url current = this.head;
        for(int i=1; i<index; i++){
            if(current.next == null){
                throw new RuntimeException("Index out of bound");
            }
            current = current.next;
        }
        current.next = current.next.next;
        this.length--;
        return;
    }
    public String get(int index){
        if(index == 0){
            return this.head.data;
        }
        Url current = this.head;
        for(int i=0; i<index; i++){
            if(current.next == null){
                throw new RuntimeException("Index out of bound");
            }
            current = current.next;
        }
        return current.data;
    }
    public void printHistorico(){
        if(this.head == null){
            throw new RuntimeException("Lista vazia");
        }
        Url current = this.head;
        while(current.next != null){
            System.out.println(current.data);
            current = current.next;
        }
        System.out.println(current.data);
        return;
    }
    class Url{
        String data;
        Url next;
        public Url(String data){
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
       HistoricoDeNavegacao historico = new HistoricoDeNavegacao(5);
       historico.add("tiktok.com");
       historico.add("stackoverflow.com");
       historico.add("github.com");
       historico.add("web.dio.me");
       historico.add("linkedin.com");
       historico.add("classroom.google.com");
       historico.printHistorico();
       System.out.println("Buscando histórico do index 1: " + historico.get(1));
       System.out.println("Deletando histórico index 3");
       historico.remove(3);
       historico.printHistorico();
    }
}
