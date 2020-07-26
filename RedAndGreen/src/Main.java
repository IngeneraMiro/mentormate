import classes.NewGenerationInterface;
import classes.NextGeneration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] size = br.readLine().split(",");
        int x = Integer.parseInt(size[0]);
        int y = Integer.parseInt(size[1]);
        int[][] matrix = new int[x][y];
        for (int i = 0; i < x; i++) {
          matrix[i] =  Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }
        int[] data = Arrays.stream(br.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int[] point = {data[1],data[0]};
        int n = data[2];

        NewGenerationInterface nextGeneration = new NextGeneration(matrix,point);
        for (int i = 0; i < n; i++) {
            nextGeneration.goToNextGeneration();
        }
        System.out.println(nextGeneration.getCounter());
    }
}
