
package model;

public class Board {

    private static final int SIZE = 9;

    private final Space[][] spaces = new Space[SIZE][SIZE];

    public void setSpace(int row, int column, Space space) {
        spaces[row][column] = space;
    }

    public Space getSpace(int row, int column) {
        return spaces[row][column];
    }

    public void showBoard() {

        System.out.println("\n    1 2 3   4 5 6   7 8 9");

        for (int row = 0; row < SIZE; row++) {

            if (row % 3 == 0) {
                System.out.println("  +-------+-------+-------+");
            }

            System.out.print((row + 1) + " | ");

            for (int column = 0; column < SIZE; column++) {

                Space space = spaces[row][column];

                Integer value = space == null
                        ? null
                        : space.getActual();

                System.out.print(
                        (value == null ? "." : value) + " "
                );

                if ((column + 1) % 3 == 0) {
                    System.out.print("| ");
                }
            }

            System.out.println();
        }

        System.out.println("  +-------+-------+-------+");
    }

    public boolean insertNumber(int row, int column, int number) {

        if (row < 0 || row >= 9 ||
                column < 0 || column >= 9 ||
                number < 1 || number > 9) {
            return false;
        }

        Space space = getSpace(row, column);

        if (space == null || space.isFixed()) {
            return false;
        }

        space.setActual(number);
        return true;
    }

    public boolean removeNumber(int row, int column) {

        if (row < 0 || row >= 9 ||
                column < 0 || column >= 9) {
            return false;
        }

        Space space = getSpace(row, column);

        if (space == null ||
                space.isFixed() ||
                space.getActual() == null) {
            return false;
        }

        space.clearSpace();
        return true;
    }

    public boolean hasErrors() {

        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {

                Space space = spaces[row][column];

                if (space != null && space.getActual() != null) {

                    if (!space.getActual().equals(space.getExpected())) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean isComplete() {

        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {

                Space space = spaces[row][column];

                if (space == null || space.getActual() == null) {
                    return false;
                }
            }
        }

        return true;
    }


}
