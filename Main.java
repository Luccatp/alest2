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
            int loop = 0;
            for (int i = 0; i < col - 1; i++) {
                for (int j = 0; j < linha - 1; j++) {
                    System.out.print(map[i][j]);
                    if (map[i][j] == '*') {
                        continue;
                    }
                    if (map[i][j] == "*") {
                        graph.addEdge();
                        loop++;
                    }
                    if (Character.isDigit(map[i][j])) {
                        graph.addEdge(map[i][j] - 0, map[i][j + 1]);
                        graph.addEdge(map[i][j] - 0, map[i + 1][j]);
                        continue;

                    }
                    graph.addEdge(map[i][j], map[i][j + 1]);
                    graph.addEdge(map[i][j], map[i + 1][j]);
                }
                System.out.println("");
            }
            CaminhamentoLargura caminhamentoLargura = new CaminhamentoLargura(graph, 1);
            System.out.println(caminhamentoLargura.pathTo(9));
            reader.close();
        } catch (

        Exception e) {
            System.out.println(e.getMessage());
        }
    }
}