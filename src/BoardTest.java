
import model.Board;
import model.Space;

public class BoardTest {

    public static void main(String[] args) {

        Board board = new Board();

        // Solucao completa fornecida pela DIO
        int[][] solution = {
                {4, 7, 9, 5, 8, 6, 2, 3, 1},
                {1, 3, 5, 4, 7, 2, 8, 9, 6},
                {2, 6, 8, 9, 1, 3, 7, 4, 5},
                {5, 1, 3, 7, 6, 4, 9, 8, 2},
                {8, 9, 7, 1, 2, 5, 3, 6, 4},
                {6, 4, 2, 3, 9, 8, 1, 5, 7},
                {7, 5, 4, 2, 3, 9, 6, 1, 8},
                {9, 8, 1, 6, 4, 7, 5, 2, 3},
                {3, 2, 6, 8, 5, 1, 4, 7, 9}
        };

        // Cria um tabuleiro de teste com casas fixas
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {

                boolean fixed = (row + column) % 3 == 0;

                board.setSpace(
                        row,
                        column,
                        new Space(solution[row][column], fixed)
                );
            }
        }

        // TESTE 1: Jogo inicialmente incompleto
        check(!board.isComplete(), "Jogo inicia incompleto");
        check(!board.hasErrors(), "Jogo inicia sem erros");

        // TESTE 2: Inserir numero incorreto
        board.insertNumber(0, 1, 5);
        check(board.hasErrors(), "Identifica numero incorreto");

        // TESTE 3: Corrigir o numero
        board.insertNumber(0, 1, 7);
        check(!board.hasErrors(), "Reconhece a correcao");

        // TESTE 4: Completar o tabuleiro
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {

                if (!board.getSpace(row, column).isFixed()) {
                    board.insertNumber(
                            row,
                            column,
                            solution[row][column]
                    );
                }
            }
        }

        check(board.isComplete(), "Tabuleiro completo");
        check(!board.hasErrors(), "Tabuleiro sem erros");

        if (board.isComplete() && !board.hasErrors()) {
            System.out.println("PARABENS! VITORIA VALIDADA!");
        }

        // TESTE 5: Reiniciar o tabuleiro
        board.resetBoard();

        check(!board.isComplete(), "Reinicio limpa o jogo");
        check(!board.hasErrors(), "Reinicio sem erros");

        check(
                board.getSpace(0, 0).getActual().equals(4),
                "Reinicio preserva os numeros fixos"
        );

        check(
                board.getSpace(0, 1).getActual() == null,
                "Reinicio remove os numeros inseridos"
        );

        System.out.println("TODOS OS TESTES PASSARAM!");
    }

    private static void check(boolean condition, String message) {

        if (!condition) {
            throw new AssertionError("FALHOU: " + message);
        }

        System.out.println("OK - " + message);
    }
}
