# Projeto de Desafios sobre Listas em Java

## Descrição

Este projeto consiste em uma série de desafios sobre estruturas de dados em Java, com foco em listas. O objetivo é proporcionar uma compreensão prática do funcionamento e da manipulação de listas encadeadas e duplamente encadeadas, bem como o uso de filas e controle de versão. Cada desafio é apresentado como uma classe independente com exemplos de implementação e métodos de teste.

## Estruturas e Funcionalidades

O projeto inclui as seguintes classes e suas respectivas funcionalidades:

**Filas:**

- **`FilaBanco`**: Implementa uma fila simples de clientes em um banco. Permite adicionar clientes, remover o cliente da frente da fila e imprimir a lista de clientes.
- **`FilaProcessos`**: Gerencia uma fila de processos para execução. Permite adicionar processos, remover o processo da frente da fila e imprimir a lista de processos.
- **`GerenciamentoImpressao`**: Gerencia uma fila de documentos para impressão. Permite adicionar documentos, remover e imprimir a lista de documentos.
  **Lista Duplamente Encadeada:**
- **`ControleDeReversao`**: Implementa um controle de versão simples, com operações de adicionar, obter, desfazer e refazer alterações em um texto.
- **`Jogo`**: Simula um jogo com cartas, permitindo adicionar, remover e reordenar cartas na mão do jogador. Utiliza uma lista duplamente encadeada para gerenciar as cartas.

\*_Lista Simplesmente Encadeada_:\*

- **`ControleDeReversao`**: Similar ao controle de versão acima, mas usando uma lista simplesmente encadeada. Permite adicionar texto, desfazer alterações e obter o texto atual.
- **`GerenciadorDeTarefas`**: Gerencia uma lista de tarefas, permitindo adicionar, remover e marcar tarefas como concluídas.
- **`HistoricoDeNavegacao`**: Gerencia um histórico de URLs navegados, implementado com uma lista simplesmente encadeada. Suporta adição, remoção e impressão do histórico de navegação.

## Como Executar

Para executar o projeto, siga os passos abaixo:

1. **Clone o Repositório**

   Clone o projeto para sua máquina local utilizando o comando:

   ```bash
   git clone <URL_DO_REPOSITORIO>
   ```

2. **Compilar e Executar**

   Navegue até o diretório onde o código-fonte está localizado e compile as classes usando o comando:

   ```bash
   javac *.java
   ```

   Para executar uma classe específica, utilize o comando:

   ```bash
   java NomeDaClasse
   ```

   Cada classe possui um método main que contém exemplos de uso.

## Tecnologias Utilizadas

- **Java 17**: Linguagem de programação usada para o desenvolvimento.
- **IntelliJ IDEA**: Ambiente de desenvolvimento integrado utilizado para escrever e gerenciar o código.
- **Paradigma de Orientação a Objetos**: Abordagem de design aplicada nas implementações das listas.

## Contribuição

Se você deseja contribuir para o projeto, por favor, siga as diretrizes abaixo:

1. Faça um fork do repositório.
2. Crie uma branch para sua feature:
   ```bash
   git checkout -b minha-nova-feature
   ```
3. Commit suas mudanças:
   ```bash
   git commit -am 'Adiciona nova feature'
   ```
4. Push para a branch:
   ```bash
   git push origin minha-nova-feature
   ```
5. Abra um pull request para revisão.

## Licença

Este projeto está licenciado sob a Licença MIT - veja o arquivo `LICENSE` para detalhes.
