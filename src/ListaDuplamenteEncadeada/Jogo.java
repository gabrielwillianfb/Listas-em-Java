package ListaDuplamenteEncadeada;

// Classe que representa um jogo de cartas utilizando uma lista duplamente encadeada
public class Jogo {
    private Card head;  // Referência para o primeiro card (cabeça da lista)
    private Card tail;  // Referência para o último card (cauda da lista)
    private int length; // Contador para o número de cards no jogo

    // Construtor que inicializa o jogo sem nenhum card
    public Jogo(){
        this.head = null;
        this.tail = null;
        this.length = 0;  // Lista começa vazia
    }

    // Método para adicionar um novo card ao final da lista
    public void add(int value){
        // Verifica se o valor do card é válido (entre 0 e 12)
        if(value > 12 || value < 0){
            System.out.println("Valor inválido");
            return;
        }

        // Se a lista estiver vazia, adiciona o primeiro card
        if(this.head == null){
            Card newCard = new Card(value); // Cria o novo card
            this.head = newCard;  // Define o novo card como a cabeça da lista
            this.tail = newCard;  // E também como a cauda da lista
            length++;  // Aumenta o tamanho da lista
            return;
        }

        // Adiciona um novo card ao final da lista
        Card newCard = new Card(value);  
        newCard.prev = this.tail;  // O novo card aponta para o card anterior
        this.tail.next = newCard;  // O último card atualiza seu próximo para o novo card
        this.tail = newCard;       // O novo card se torna o último
        length++;  // Aumenta o tamanho da lista
    }

    // Método para remover um card em uma posição específica da lista
    public void remove(int index){
        // Se a lista estiver vazia ou o índice for maior que o tamanho, retorna
        if(this.head == null) { return; }
        if(index >= this.length) { return; }

        // Se for o primeiro card, atualiza a cabeça da lista
        if(index == 0){
            this.head = this.head.next;
            if(length == 1) { this.tail = null; }  // Se houver apenas um card, limpa a cauda
            this.length--;  // Diminui o tamanho da lista
            return;
        }

        // Navega até o card a ser removido
        Card actual = this.head;
        for(int i = 0; i < index; i++){
            actual = actual.next;
        }

        // Remove o card da lista ajustando as referências dos vizinhos
        actual.next.prev = actual.prev;
        actual.prev.next = actual.next;
        this.length--;  // Diminui o tamanho da lista
    }

    // Método para trocar a posição de um card com seu vizinho na direção dada
    public void reorder(int index, Ordem direction){
        // Verifica se o índice está dentro dos limites da lista
        if(index >= this.length) return;

        // Se o card está no início e a direção é para trás, ou no final e a direção é para frente, retorna
        if(index == 0 && direction == Ordem.BACKWARD) return;
        if(index == this.length - 1 && direction == Ordem.NEXT) return;

        // Se for o primeiro card, troca com o segundo
        if(index == 0){
            int oldValue = this.head.value;
            this.head.value = this.head.next.value;
            this.head.next.value = oldValue;
            return;
        } 
        // Se for o último card, troca com o penúltimo
        else if (index == this.length - 1) {
            Card current = this.head;
            for(int i = 0; i < this.length - 2; i++){
                current = current.next;
            }
            int oldValue = current.value;
            current.value = current.next.value;
            current.next.value = oldValue;
            return;
        }

        // Caso geral, navega até o card e troca com o anterior ou próximo
        Card current = this.head;
        for(int i = 0; i < index; i++){
            if(current.next == null) return;
            current = current.next;
        }

        // Se a direção for para frente, troca com o próximo
        if(direction == Ordem.NEXT){
            int oldValue = current.value;
            current.value = current.next.value;
            current.next.value = oldValue;
            return;
        }

        // Se a direção for para trás, troca com o anterior
        int oldValue = current.value;
        current.value = current.prev.value;
        current.prev.value = oldValue;
    }

    // Enum que define as direções para reorder (próximo ou anterior)
    enum Ordem{
        NEXT,      // Próximo
        BACKWARD   // Anterior
    }

    // Método para imprimir todos os cards na mão (lista)
    public void print(){
        System.out.println("-----------");
        System.out.println("Mão");
        System.out.println("-----------");

        // Navega pela lista e imprime os valores dos cards
        Card actual = this.head;
        for(int i = 0; i < this.length; i++){
            if(actual == null) { break; }
            System.out.println(i + ": " + actual.value);
            actual = actual.next;
        }
        System.out.println("-----------");
    }

    // Classe interna que representa um card com valor, e referências para o próximo e anterior card
    class Card{
        int value;    // Valor do card
        Card next;    // Próximo card na lista
        Card prev;    // Card anterior na lista

        // Construtor que inicializa o card com um valor
        public Card(int value){
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }

    // Método principal para executar o jogo de cartas
    public static void main(String[] args) {
        Jogo baralho = new Jogo();
        baralho.add(11);
        baralho.add(5);
        baralho.add(2);
        baralho.add(4);
        baralho.print();
        baralho.remove(1);
        baralho.reorder(0, Ordem.NEXT);
        baralho.print();
        baralho.reorder(2, Ordem.BACKWARD);
        baralho.print();
        baralho.reorder(1, Ordem.BACKWARD);
        baralho.print();
    }
}
