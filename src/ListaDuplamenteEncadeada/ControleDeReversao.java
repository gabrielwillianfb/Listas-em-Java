package ListaDuplamenteEncadeada;

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
        Version newData = new Version(this.head.data + data);
        this.head.next = newData;
        newData.back = this.head;
        this.head = newData;
    }
    public String get(){
        if(this.head == null){
            return "";
        }
        return this.head.data;
    }
    public void undo(){
        if(this.head == null){ return ; }
        if(this.head.back == null){
            this.head = null;
            return;
        }
        this.head = this.head.back;
    }
    public void redo(){
        if(this.head == null){ return ; }
        if(this.head.next == null){ return ;}
        this.head = this.head.next;
    }

    class Version{
        Version next;
        Version back;
        String data;
        public Version(String data){
            this.next = null;
            this.back = null;
            this.data = data;
        }
    }

    public static void main(String[] args) {
        try (Scanner myScan = new Scanner(System.in)) {
            ControleDeReversao controle = new ControleDeReversao();
            boolean condition = true;
            while(condition){
                System.out.println("Texto: " + controle.get());
                System.out.println("Digite 1 para sair");
                System.out.println("Digite 2 para redo");
                System.out.println("Digite 3 para undo");
                System.out.println("Digite 4 para modificar o texto");
                System.out.print("Escolha: ");
                int escolha = myScan.nextInt();
                System.out.println();
                switch (escolha){
                    case 1:
                        condition = false;
                        break;
                    case 2:
                        controle.redo();
                        break;
                    case 3:
                        controle.undo();
                        break;
                    case 4:
                        myScan.nextLine();
                        System.out.print(controle.get());
                        String newData = myScan.nextLine();
                        controle.add(newData);
                        break;
                }
            }
        }
    }
}
