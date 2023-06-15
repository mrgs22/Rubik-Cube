package Main;

public class permutations {
    int[][][] cube = new int[6][3][3];
    int[][][] solvedCube = new int[6][3][3];

    public void setSolvedCube(int[][][] cubePerm){
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 3; j++){
                for(int k = 0; k < 3; k++){
                    cubePerm[i][j][k] = i;
                }
            }
        }
    }



}
