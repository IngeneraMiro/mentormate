package classes;

public class NextGeneration implements NewGenerationInterface {
    private int[][] matrix;
    private int counter = 0;
    private final int[] point;
    private final CellCheckInterface checker;

    public NextGeneration(int[][] matrix, int[] point) {
        this.matrix = matrix;
        this.point = point;
        checker = new CellChecker(matrix.length, matrix[0].length);
        if (matrix[point[0]][point[1]] == 1) {
            counter++;       // count initial zero Generation state
        }
    }

    public int getCounter() {
        return this.counter;
    }

// public method that executes single step to new Generation
    @Override
    public void goToNextGeneration() {
        int[][] modMatrix = action();
        this.matrix = modMatrix;
        if (matrix[point[0]][point[1]] == 1) {
            counter++;
        }
    }

//  create new matrix from original following given rules and returns it
    private int[][] action() {
        int x = this.matrix.length;
        int y = this.matrix[0].length;
        int[][] modMatrix = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                int gr = countGreenSurroundSells(i, j);
                if (this.matrix[i][j] == 1) {
                    if (gr == 2 || gr == 3 || gr == 6) {
                        modMatrix[i][j] = 1;
                    } else {
                        modMatrix[i][j] = 0;
                    }
                } else {
                    if (gr == 3 || gr == 6) {
                        modMatrix[i][j] = 1;
                    } else {
                        modMatrix[i][j] = 0;
                    }
                }
            }
        }
        return modMatrix;
    }

//    check if surround cells are in range and count how many of them are green
    private int countGreenSurroundSells(int x, int y) {
        int gr = 0;
        if (checker.checkCell(x - 1, y - 1)) {
            if (this.matrix[x - 1][y - 1] == 1) {
                gr++;
            }
        }

        if (checker.checkCell(x - 1, y)) {
            if (this.matrix[x - 1][y] == 1) {
                gr++;
            }
        }

        if (checker.checkCell(x - 1, y + 1)) {
            if (this.matrix[x - 1][y + 1] == 1) {
                gr++;
            }
        }

        if (checker.checkCell(x, y - 1)) {
            if (this.matrix[x][y - 1] == 1) {
                gr++;
            }
        }

        if (checker.checkCell(x, y + 1)) {
            if (this.matrix[x][y + 1] == 1) {
                gr++;
            }
        }

        if (checker.checkCell(x + 1, y - 1)) {
            if (this.matrix[x + 1][y - 1] == 1) {
                gr++;
            }
        }

        if (checker.checkCell(x + 1, y)) {
            if (this.matrix[x + 1][y] == 1) {
                gr++;
            }
        }

        if (checker.checkCell(x + 1, y + 1)) {
            if (this.matrix[x + 1][y + 1] == 1) {
                gr++;
            }
        }

        return gr;
    }

}
