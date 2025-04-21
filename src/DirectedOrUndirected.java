public class DirectedOrUndirected {
    public static String checkType(boolean[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                    return "The matrix represents a directed graph.";
                }
            }
        }
        return "The matrix represents an undirected graph.";
    }

    public static void main(String[] args) {
        boolean[][] matrix1 = {
                {true, false, false},
                {false, false, true},
                {true, true, true}
        };

        boolean[][] matrix2 = {
                {true, false, true},
                {false, false, true},
                {true, true, true}
        };

        System.out.println(checkType(matrix1));
        System.out.println(checkType(matrix2));
    }
}
