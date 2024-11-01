package ru.tiayeah.matrixprint;

public class ConsoleDrawer implements IDrawer {
    private int previousRow = 0;
    private int previousCol = -1;
    private boolean drawBorder = false;
    private int nonZeroCount = 0;
    private int printedCount = 0;
    private IMatrix matrix;

    @Override
    public void drawRow(int row, IVector vector) {

    }

    @Override
    public void drawCell(int value, int y, int x) {
        if (y > previousRow) {
            previousRow = y;
            if (drawBorder) {
                drawRightBorder();
            }
            previousCol = -1;
            System.out.print("\n");
            if (drawBorder) {
                drawLeftBorder();
            }
        }
        if (previousCol != -1) {
            for (int i = 0; i < x - previousCol - 1; i++) {
                System.out.print("  ");
            }
        } else {
            for (int i = 0; i < x; i++) {
                System.out.print("  ");
            }
        }
        //System.out.print(" ");
        previousCol = x;
        System.out.print(value + " ");
        printedCount++;
            nonZeroCount--;
        if (drawBorder && (nonZeroCount == 0 || printedCount == matrix.getCols() * matrix.getRows())) {
            drawRightBorder();
            System.out.print("\n-");
            for (int i = 0; i < matrix.getCols(); i++) {
                System.out.print("--");
            }
            System.out.print("-");
        }
    }

    private void drawRightBorder() {
        for (int i = previousCol; i < matrix.getCols() - 1; i++) {
            System.out.print("  ");
        }
        System.out.print("|");
    }

    private void drawLeftBorder() {
        System.out.print("|");
    }

    @Override
    public void drawBorder(IMatrix matrix) {
        drawBorder = true;
        nonZeroCount = new MatrixStatistics(matrix).getNonZeroCount();
        this.matrix = matrix;

        System.out.print("-");
        for (int i = 0; i < matrix.getCols(); i++) {
            System.out.print("--");
        }
        System.out.print("-");
        System.out.print("\n|");
    }


}
