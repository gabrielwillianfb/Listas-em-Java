package Filas;

// Classe que gerencia uma fila de documentos para impressão
public class GerenciamentoImpressao {
    private Print head; // Referência para o primeiro documento na fila
    private Print tail; // Referência para o último documento na fila
    private int length; // Quantidade de documentos na fila

    // Construtor que inicializa a fila de impressão vazia
    public GerenciamentoImpressao(){
        this.length = 0; // A fila começa com tamanho zero
        this.head = null; // Não há documentos na cabeça da fila
        this.tail = null; // Não há documentos na cauda da fila
    }

    // Método para adicionar um documento à fila de impressão
    public void add(String documento){
        // Se a fila estiver vazia, o novo documento se torna o primeiro e último
        if(length == 0){
            Print print = new Print(documento); // Cria um novo documento para impressão
            this.head = print; // O documento é a cabeça da fila
            this.tail = print; // O documento também é a cauda da fila
            this.length++; // Incrementa o tamanho da fila
            return; // Encerra o método
        }
        // Caso a fila não esteja vazia, adiciona o novo documento ao final
        Print print = new Print(documento); // Cria um novo documento para impressão
        this.tail.next = print; // O último documento aponta para o novo documento
        this.tail = print; // O novo documento se torna a nova cauda da fila
    }

    // Método para remover e retornar o primeiro documento da fila
    public String remove(){
        // Armazena o nome do documento a ser removido
        String documento = this.head.documento;
        this.head = this.head.next; // A cabeça da fila passa a ser o próximo documento
        this.length--; // Diminui o tamanho da fila
        return documento; // Retorna o nome do documento removido
    }

    // Método para executar a impressão de todos os documentos na fila
    public void execute(){
        // Enquanto houver documentos na fila, imprime e remove o primeiro
        while(this.head != null){
            System.out.println("Imprimindo: " + this.remove()); // Imprime o documento
        }
        System.out.println("Nenhum documento na Fila"); // Mensagem quando a fila estiver vazia
    }

    // Método para exibir todos os documentos atualmente na fila
    public void printFila(){
        // Se a fila estiver vazia, encerra o método
        if(this.length == 0) return;
        
        Print current = this.head; // Começa no primeiro documento
        int counter = 0; // Contador para indicar a posição de cada documento na fila
        // Percorre a fila e imprime o nome de cada documento
        while(current != null){
            System.out.println(counter + ": " + current.documento); // Imprime a posição e o nome do documento
            current = current.next; // Avança para o próximo documento
            counter++; // Incrementa o contador
        }
    }

    // Classe interna que representa um documento na fila de impressão
    class Print{
        Print next; // Referência para o próximo documento na fila
        String documento; // Nome do documento

        // Construtor que inicializa o documento com seu nome
        public Print(String documento){
            this.next = null; // O próximo documento é inicialmente nulo
            this.documento = documento; // Define o nome do documento
        }
    }

    // Método principal para testar a fila de gerenciamento de impressão
    public static void main(String[] args) {
        GerenciamentoImpressao fila = new GerenciamentoImpressao(); // Cria uma nova fila de impressão
        fila.add("Trabalho Desafios-Listas-em-Java"); // Adiciona o documento "Trabalho Desafios-Listas-em-Java"
        fila.add("Finanças.XLSX"); // Adiciona o documento "Finanças.XLSX"
        fila.add("Plano de viagem"); // Adiciona o documento "Plano de viagem"
        fila.printFila(); // Exibe a fila de documentos
        fila.execute(); // Executa a impressão dos documentos
    }
}
