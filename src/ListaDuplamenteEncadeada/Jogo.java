package ListaDuplamenteEncadeada;

public class Jogo {
    private Card head;
    private Card tail;
    private int length;
    public Jogo(){
        this.head = null;
        this.tail = null;
        this.length = 0;
    }
    public void add(int value){
        if(value > 12 || value < 0){
            System.out.println("Valor inválido");
            return;
        }
        if(this.head == null){
            Card newCard = new Card(value);
            this.head = newCard;
            this.tail = newCard;
            length++;
            return;
        }
        Card newCard = new Card(value);
        newCard.prev = this.tail;
        this.tail.next = newCard;
        this.tail = newCard;
        length++;
    }
    public void remove(int index){
        if(this.head == null){ return; }
        if(index > this.length){ return; }
        if(index == 0){
            this.head = this.head.next;
            if(length == 1){ this.tail = null; }
            this.length--;
        }
        Card actual = this.head;
        for(int i=0; i<index; i++){
           actual = actual.next;
        }
        actual.next.prev = actual.prev;
        actual.prev.next = actual.next;
        this.length--;
    }
    public void reorder(int index, Ordem direction){
        if(index >= this.length) return;
        if(index == 0 && direction == Ordem.BACKWARD) return;
        if(index == this.length-1 && direction == Ordem.NEXT) return;
        if(index == 0){
            int oldValue = this.head.value;
            this.head.value = this.head.next.value;
            this.head.next.value = oldValue;
            return;
        } else if (index == this.length-1) {
            Card current = this.head;
            for(int i=0; i<this.length-2; i++){
                current = current.next;
            }
            int oldValue = current.value;
            current.value = current.next.value;
            current.next.value = oldValue;
            return;
        }
        Card current = this.head;
        for(int i=0; i<index; i++){
            if(current.next == null) return;
            current = current.next;
        }
        if(direction == Ordem.NEXT){
            int oldValue = current.value;
            current.value = current.next.value;
            current.next.value = oldValue;
            return;
        }
        int oldValue = current.value;
        current.value = current.prev.value;
        current.prev.value = oldValue;

    }
    enum Ordem{
        NEXT,
        BACKWARD
    }
    public void print(){
        System.out.println("-----------");
        System.out.println("Mão");
        System.out.println("-----------");
        Card actual = this.head;
        for(int i = 0; i < this.length; i++){
            if(actual == null){ break; }
            System.out.println(i+ ": "+ actual.value);
            actual = actual.next;
        }
        System.out.println("-----------");
    }
    class Card{
        int value;
        Card next;
        Card prev;
        public Card(int value){
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }

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
