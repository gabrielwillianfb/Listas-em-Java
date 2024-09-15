package ListaSimplesmenteEncadeada;

public class HistoricoDeNavegacao {
    private Url head;  // Referência para o primeiro elemento da lista
    private int maxSize;  // Número máximo de URLs permitidas
    private int length;  // Quantidade atual de URLs no histórico

    // Construtor para inicializar o histórico com um limite de URLs
    public HistoricoDeNavegacao(int maxSize){
        this.head = null;
        this.length = 0;
        this.maxSize = maxSize;
    }

    // Método para adicionar uma nova URL ao histórico
    public void add(String url){
        if(this.head == null){  // Se a lista está vazia, adiciona a primeira URL
            this.head = new Url(url);
            this.length = 1;
            return;
        }
        if(length == maxSize){  // Verifica se o limite foi atingido
            System.out.println("Limite alcançado, deletando primeiro URL");
            this.head = this.head.next;  // Remove o primeiro URL
            length--;
        }
        Url current = this.head;
        while(current.next != null){  // Percorre até o final da lista
            current = current.next;
        }
        current.next = new Url(url);  // Adiciona a nova URL ao final
        this.length++;
    }

    // Método para remover uma URL por índice
    public void remove(int index){
        if(index == 0){  // Remove a primeira URL
            this.head = this.head.next;
            this.length--;
            return;
        }
        Url current = this.head;
        for(int i=1; i<index; i++){  // Encontra o índice correto
            if(current.next == null){
                throw new RuntimeException("Index out of bounds");
            }
            current = current.next;
        }
        current.next = current.next.next;  // Remove o nó do índice especificado
        this.length--;
    }

    // Método para obter a URL pelo índice
    public String get(int index){
        if(index == 0){  // Retorna a primeira URL
            return this.head.data;
        }
        Url current = this.head;
        for(int i=0; i<index; i++){  // Percorre até o índice desejado
            if(current.next == null){
                throw new RuntimeException("Index out of bounds");
            }
            current = current.next;
        }
        return current.data;
    }

    // Método para imprimir todo o histórico de navegação
    public void printHistorico(){
        if(this.head == null){  // Verifica se a lista está vazia
            throw new RuntimeException("Lista vazia");
        }
        Url current = this.head;
        while(current.next != null){  // Percorre e imprime todas as URLs
            System.out.println(current.data);
            current = current.next;
        }
        System.out.println(current.data);  // Imprime a última URL
    }

    // Classe interna que representa uma URL no histórico
    class Url{
        String data;  // A URL armazenada
        Url next;  // Referência para o próximo nó

        // Construtor da URL
        public Url(String data){
            this.data = data;
            this.next = null;
        }
    }

    // Método principal para testar o histórico de navegação
    public static void main(String[] args) {
       HistoricoDeNavegacao historico = new HistoricoDeNavegacao(5);  // Limite de 5 URLs
       historico.add("tiktok.com");
       historico.add("stackoverflow.com");
       historico.add("github.com");
       historico.add("web.dio.me");
       historico.add("linkedin.com");
       historico.add("classroom.google.com");  // Esta URL excede o limite, removendo a primeira
       historico.printHistorico();  // Imprime o histórico
       System.out.println("Buscando histórico do index 1: " + historico.get(1));  // Busca URL do índice 1
       System.out.println("Deletando histórico index 3");
       historico.remove(3);  // Remove a URL do índice 3
       historico.printHistorico();  // Imprime o histórico atualizado
    }
}
