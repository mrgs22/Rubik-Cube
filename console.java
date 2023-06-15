package Main;
import java.util.Scanner;

public class console {
    int[][][] empty = new int[6][3][3];

    public void dump(int[][][] cubePerm){
        int[][] sequence = {{-1, 0, -1, -1}, {1, 2, 3, 4}, {-1, 5, -1, -1}};
        String dump;
        System.out.println("*===============[Cube permutation]=================*");
        for(int i = 0; i < 3; i++){
            for(int i2 = 0; i2 < 3; i2++) {
                dump = "";
                for (int j = 0; j < 4; j++) {
                    if (sequence[i][j] == -1){
                        dump = dump + ("~ ~ ~   ");
                    } else {
                        dump = dump + (cubePerm[sequence[i][j]][i2][0] + " " + cubePerm[sequence[i][j]][i2][1] + " " + cubePerm[sequence[i][j]][i2][2] + "   ");
                    }
                }
                System.out.println(dump);
            }
        }
        System.out.println("*==================================================*");
    }
}
