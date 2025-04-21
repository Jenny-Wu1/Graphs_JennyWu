public class DirectedOrUndirected {
    public static String checkType(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                    return "The matrix represents a directed graph.";
                }
            }
        }
        return "The matrix represents an undirected graph.";
    }
}
