# 🧩 Sudoku em Java — Desafio DIO

Projeto desenvolvido como parte de um desafio prático do Bootcamp da **Digital Innovation One (DIO)**.

O objetivo é implementar um jogo de Sudoku executado no terminal, aplicando os fundamentos de Java e Programação Orientada a Objetos.

## Funcionalidades

- Exibição do tabuleiro 9 × 9 no terminal.
- Carregamento do jogo por argumentos de execução.
- Inserção de números nas casas disponíveis.
- Remoção de números inseridos.
- Proteção das posições fixas.
- Verificação de erros e do progresso da partida.
- Validação da conclusão do jogo.
- Reinicialização do tabuleiro com confirmação.
- Menu interativo para o jogador.

## Tecnologias utilizadas

- Java
- Programação Orientada a Objetos (POO)
- IntelliJ IDEA
- Git e GitHub

O projeto utiliza Java puro, sem dependências externas.

## Estrutura do projeto

- `src/Main.java` — ponto de entrada da aplicação e menu interativo.
- `src/model/Space.java` — representa uma casa do Sudoku.
- `src/model/Board.java` — gerencia o tabuleiro e as regras do jogo.
- `src/BoardTest.java` — executa verificações automatizadas das funcionalidades.
- `arguments.txt` — contém os argumentos para inicializar o Sudoku.

## Como executar

1. Clone o repositório ou baixe o código-fonte.
2. Abra o projeto no IntelliJ IDEA.
3. Configure um JDK compatível.
4. Acesse **Run → Edit Configurations**.
5. Na configuração da classe `Main`, cole no campo **Program arguments** os 81 argumentos disponíveis em `arguments.txt`.
6. Execute o método `main()` da classe `Main`.

O tabuleiro será carregado e o menu interativo aparecerá no terminal.

## Menu do jogo

| Opção | Funcionalidade |
|---|---|
| 1 | Mostrar tabuleiro |
| 2 | Inserir número |
| 3 | Remover número |
| 4 | Verificar status do jogo |
| 5 | Finalizar jogo |
| 6 | Reiniciar partida |
| 0 | Sair |

## Testes

O projeto possui a classe `BoardTest`, que executa verificações automatizadas usando Java puro, sem JUnit.

Os testes incluem identificação de números incorretos, correção de valores, conclusão do tabuleiro e reinicialização preservando as casas fixas.

Para executá-los, basta rodar o método `main()` da classe `BoardTest`.

## Conceitos praticados

- Classes e objetos
- Encapsulamento
- Construtores
- Métodos e atributos
- Matrizes bidimensionais
- Estruturas condicionais e de repetição
- Manipulação de Strings
- Tratamento de exceções
- Validação de dados
- Versionamento com Git

## Referência

Projeto baseado no desafio de Sudoku da Digital Innovation One.

Repositório original: https://github.com/digitalinnovationone/sudoku

## Autor

Desenvolvido por **Peuvictor** como parte dos estudos em desenvolvimento Java.

GitHub: https://github.com/Peuvictor