package ru.tiayeah.matrixprint;

import java.util.Random;

public class MatrixInitializer {
    private static final Random random = new Random();

    public static void fillMatrix(IMatrix matrix, int nonZeroCountt, int maxElement) {
        int counter = 0;

        while (counter < nonZeroCountt) {
            for (int i = 0; i < matrix.getRows(); i++) {
                for (int j = 0; j < matrix.getCols(); j++) {
                    if (counter == nonZeroCountt) break;
                    if (random.nextDouble() < 0.3) {
                        int randomElement = random.nextInt(maxElement);
                        if (randomElement != 0 && matrix.getValue(i, j) == 0) {
                            counter++;
                            matrix.setValue(i, j, randomElement);
                        }
                    }
                }
            }
        }
    }
}
