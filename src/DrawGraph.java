import java.util.ArrayList;
import java.util.List;

public class DrawGraph {
    static class Vertex {
        String name;
        int distance;

        Vertex(String name, int distance) {
            this.name = name;
            this.distance = distance;
        }
    }

    public static int[][] buildMatrix(String input, List<String> names) {
        input = input.replaceAll("[\\[\\](){}]", "").replace(" ", "");
        if (input.isEmpty()) {
            return  new int[0][0];
        }
        String[] parts = input.split(",");
        List<Vertex> vertices = new ArrayList<>();

        for (int i = 0; i < parts.length; i += 2) {
            String name = parts[i];
            int distance = Integer.parseInt(parts[i + 1]);
            vertices.add(new Vertex(name, distance));
            names.add(name);
        }

        int[][] matrix = new int[vertices.size()][vertices.size()];
        for (int i = 0; i < vertices.size(); i++) {
            Vertex v = vertices.get(i);
            int left = (i - v.distance + vertices.size()) % vertices.size();
            int right = (i + v.distance) % vertices.size();

            matrix[i][left] = 1;
            matrix[i][right] = 1;
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix, List<String> names) {
        System.out.print("    ");
        for (String name : names) {
            System.out.print(name + "  ");
        }
        System.out.println();
        for (int i = 0; i < matrix.length; i++) {
            System.out.print(names.get(i) + "  ");
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(" " + matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String input = "[ (I, 2) , (A, 5) , (E, 4) , (F,2) , (T, 2) , (S, 3) ]";
        List<String> names = new ArrayList<>();
        int[][] matrix = buildMatrix(input, names);
        printMatrix(matrix, names);
    }
}
