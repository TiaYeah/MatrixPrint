package ru.tiayeah.matrixprint;

public interface IDrawer {
    void drawCell(int value, int i, int j, IMatrix matrix);
    void printResult();
    void drawBorder(IMatrix matrix);
}
