package ru.tiayeah.matrixprint;

public interface IDrawer {
    void drawRow(int row, IVector vector);
    void drawCell(int value, int i, int j);

    void drawBorder(IMatrix matrix);
}
