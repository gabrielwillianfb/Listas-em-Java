package ListaSimplesmenteEncadeada;

import java.util.Scanner;

public class ControleDeReversao {
    Version head;
    int length;
    public ControleDeReversao(){
        this.head = null;
        this.length = 0;
    }
    public void add(String data){
        if(this.head == null){
            this.head = new Version(data);
            return;
        }
        Version current = this.head;
        while(current.next != null){
            current = current.next;
        }
        String newData = current.data + data;
        current.next = new Version(newData);
    }
    public String get(){
        if(this.head == null){
            return "";
        }
        Version current = this.head;
        while(current.next != null){
            current = current.next;
        }
        return current.data;
    }
    public void undo(){
        if(this.head == null){
            return;
        }
        if(this.head.next == null){
            return;
        }
        Version current = this.head;
        while(current.next.next != null){
            current = current.next;
        }
        current.next = null;

    }
    class Version{
        String data;
        Version next;
        public Version(String data){
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        try (Scanner myScan = new Scanner(System.in)) {
            ControleDeReversao text = new ControleDeReversao();
            boolean condition = true;
            while(condition){
                System.out.println("Texto atual");
                System.out.println(text.get());
                System.out.println("Digite '0' para sair");
                System.out.println("Digite '1' para desfazer a alteração");
                System.out.println("Digite '2' para modificar o texto");
                System.out.print("Escolha: ");
                int action = myScan.nextInt();
                switch(action){
                    case 0:
                        condition = false;
                        break;
                    case 1:
                        text.undo();
                        break;
                    case 2:
                        myScan.nextLine();
                        System.out.print(text.get());
                        String msg = myScan.nextLine();
                        text.add(msg);
                }
            }
        }
    }
}
