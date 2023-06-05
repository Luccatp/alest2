import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("casos-cohen/mapa30.txt"));
            String[] firstLine = reader.readLine().split(" ");
            int col = Integer.parseInt(firstLine[0]);
            int linha = Integer.parseInt(firstLine[1]);
            Graph graph = new Graph(linha * col);

            char[][] map = new char[col][linha];

            for (int r = 0; r < col; r++) {
                map[r] = reader.readLine().toCharArray();
            }

            for (int i = 0; i < col; i++) {
                for (int j = 0; j < linha; j++) {
                    System.out.print(map[i][j]);
                    if (map[i][j] == '*') {
                        continue;
                    }
                    graph.addEdge(i * col + j, i * col + j + 1);
                    graph.addEdge(i * col + j, (i + 1) * col + j);
                }
                System.out.println("");
            }

            reader.close();
        } catch (

        Exception e) {
            System.out.println(e.getMessage());
        }
    }
}