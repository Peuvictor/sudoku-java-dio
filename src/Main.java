
import model.Board;
import model.Space;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        if (args.length != 81) {
            System.out.println("Esperados 81 argumentos.");
            return;
        }

        Board board = new Board();

        // Carrega as 81 casas do Sudoku
        for (String arg : args) {

            String[] parts = arg.split(";");
            String[] position = parts[0].split(",");
            String[] value = parts[1].split(",");

            int column = Integer.parseInt(position[0]);
            int row = Integer.parseInt(position[1]);

            int expected = Integer.parseInt(value[0]);
            boolean fixed = Boolean.parseBoolean(value[1]);

            if (row < 0 || row >= 9 ||
                    column < 0 || column >= 9 ||
                    expected < 1 || expected > 9) {
                throw new IllegalArgumentException(
                        "Argumento invalido: " + arg
                );
            }

            if (board.getSpace(row, column) != null) {
                throw new IllegalArgumentException(
                        "Posicao duplicada: " + arg
                );
            }

            board.setSpace(row, column, new Space(expected, fixed));
        }

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Bem-vindo ao Sudoku DIO!");

        while (running) {

            System.out.println("\n===== MENU SUDOKU =====");
            System.out.println("1 - Mostrar tabuleiro");
            System.out.println("2 - Inserir numero");
            System.out.println("3 - Remover numero");
            System.out.println("4 - Verificar status do jogo");
            System.out.println("5 - Finalizar jogo");
            System.out.println("6 - Reiniciar partida");
            System.out.println("0 - Sair");

            System.out.print("Escolha uma opcao: ");

            String option = scanner.nextLine().trim();

            switch (option) {

                case "1" -> board.showBoard();

                case "2" -> {

                    int row = readNumber(scanner, "Linha (1-9): ") - 1;
                    int column = readNumber(scanner, "Coluna (1-9): ") - 1;
                    int number = readNumber(scanner, "Numero (1-9): ");

                    if (board.insertNumber(row, column, number)) {
                        System.out.println("Numero inserido!");
                    } else {
                        System.out.println("Nao foi possivel inserir!");
                    }
                }

                case "3" -> {

                    int row = readNumber(scanner, "Linha (1-9): ") - 1;
                    int column = readNumber(scanner, "Coluna (1-9): ") - 1;

                    if (board.removeNumber(row, column)) {
                        System.out.println("Numero removido!");
                    } else {
                        System.out.println("Nao foi possivel remover!");
                    }
                }

                case "4" -> {

                    if (board.hasErrors()) {
                        System.out.println("O jogo possui numeros incorretos!");
                    } else if (!board.isComplete()) {
                        System.out.println("Jogo incompleto, mas sem erros ate agora!");
                    } else {
                        System.out.println("Tabuleiro completo e correto!");
                    }
                }

                case "5" -> {

                    if (!board.isComplete()) {
                        System.out.println("Ainda existem casas vazias!");
                    } else if (board.hasErrors()) {
                        System.out.println("Existem numeros incorretos!");
                    } else {
                        System.out.println("Parabens! Voce venceu o Sudoku!");
                        running = false;
                    }
                }

                case "6" -> {

                    System.out.print(
                            "Tem certeza que deseja reiniciar? (s/n): "
                    );

                    String confirmation = scanner.nextLine().trim();

                    if (confirmation.equalsIgnoreCase("s")) {

                        board.resetBoard();

                        System.out.println("Partida reiniciada!");
                        board.showBoard();

                    } else {
                        System.out.println("Reinicio cancelado!");
                    }
                }


                case "0" -> {
                    System.out.println("Ate a proxima!");
                    running = false;
                }

                default -> System.out.println("Opcao invalida!");
            }
        }

        scanner.close();
    }

    private static int readNumber(Scanner scanner, String message) {

        while (true) {
            System.out.print(message);

            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Digite um numero inteiro valido!");
            }
        }
    }
}
