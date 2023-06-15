package Main;

public class Move {
    static int[][][] cube = new int[6][3][3];
    public Move(int[][][] cubeIn){
        //cube = cubeIn;
        copyCubeArray(cubeIn, cube);
    }


    //below are methods for array manipulations :)

    public void swapPos(int side1, int row1, int column1, int side2, int row2, int column2){

        int temp = 0;
        temp = cube[side1][row1][column1];
        cube[side1][row1][column1] = cube[side2][row2][column2];
        cube[side2][row2][column2] = temp;
    }
    public void rotateFaceClockwise(int[][][] cubePermBefore, int face){
        int[][][] cubePermAfter = new int[6][3][3];
        copyCubeArray(cubePermBefore, cubePermAfter);

        cubePermAfter[face][0][0] = cubePermBefore[face][2][0];
        cubePermAfter[face][0][1] = cubePermBefore[face][1][0];
        cubePermAfter[face][0][2] = cubePermBefore[face][0][0];

        cubePermAfter[face][1][0] = cubePermBefore[face][2][1];
        cubePermAfter[face][1][1] = cubePermBefore[face][1][1];
        cubePermAfter[face][1][2] = cubePermBefore[face][0][1];

        cubePermAfter[face][2][0] = cubePermBefore[face][2][0];
        cubePermAfter[face][2][1] = cubePermBefore[face][1][0];
        cubePermAfter[face][2][2] = cubePermBefore[face][0][0];

        cube = cubePermAfter;
    }

    public void rotateFaceCClockwise(int[][][] cubePermBefore, int face){
        int[][][] cubePermAfter = new int[6][3][3];
        copyCubeArray(cubePermBefore, cubePermAfter);

        cubePermAfter[face][0][0] = cubePermBefore[face][0][2];
        cubePermAfter[face][0][1] = cubePermBefore[face][1][2];
        cubePermAfter[face][0][2] = cubePermBefore[face][2][2];

        cubePermAfter[face][1][0] = cubePermBefore[face][0][1];
        cubePermAfter[face][1][1] = cubePermBefore[face][1][1];
        cubePermAfter[face][1][2] = cubePermBefore[face][2][1];

        cubePermAfter[face][2][0] = cubePermBefore[face][0][0];
        cubePermAfter[face][2][1] = cubePermBefore[face][1][0];
        cubePermAfter[face][2][2] = cubePermBefore[face][2][0];

        cube = cubePermAfter;
    }

    public void copyCubeArray(int[][][] source, int[][][] dest){

        for(int i = 0 ; i < source.length; i++){
            for(int j = 0 ; j < source[0].length; j++){
                for(int k = 0 ; k < source[0][0].length; k++){
                    dest[i][j][k] = source[i][j][k];
                }
            }
        }

    }

    public void swapRow(int[][][] cubePermBefore, int sourceFace, int sourceRow, int targetFace, int targetRow){

        int[][][] cubePermAfterSR;
        cubePermAfterSR = new int[6][3][3];
        copyCubeArray(cubePermBefore, cubePermAfterSR);

        cubePermAfterSR[sourceFace][sourceRow] = cubePermBefore[targetFace][targetRow];
        cubePermAfterSR[targetFace][targetRow] = cubePermBefore[sourceFace][sourceRow];

        cube = cubePermAfterSR;
    }

    public void swapColumn(int[][][] cubePermBefore, int sourceFace, int sourceCol, int targetFace, int targetCol){

        int[][][] cubePermAfterSC = new int [6][3][3];
        copyCubeArray(cubePermBefore, cubePermAfterSC);

        cubePermAfterSC[sourceFace][0][sourceCol] = cubePermBefore[targetFace][0][targetCol];
        cubePermAfterSC[sourceFace][1][sourceCol] = cubePermBefore[targetFace][1][targetCol];
        cubePermAfterSC[sourceFace][2][sourceCol] = cubePermBefore[targetFace][2][targetCol];

        cubePermAfterSC[targetFace][0][targetCol] = cubePermBefore[sourceFace][0][sourceCol];
        cubePermAfterSC[targetFace][1][targetCol] = cubePermBefore[sourceFace][1][sourceCol];
        cubePermAfterSC[targetFace][2][targetCol] = cubePermBefore[sourceFace][2][sourceCol];

        cube = cubePermAfterSC;
    }

    //Below are physically combinations that are performable on the cube itself, constructed using the methods above

    public void zeroC(){

        rotateFaceClockwise(cube, 0);
        swapRow(cube, 1,0,4,0);
        swapRow(cube, 1,0,3,0);
        swapRow(cube, 1,0,2,0);
    }

    public void zeroCC(){

        rotateFaceCClockwise(cube, 0);
        swapRow(cube, 4,0,1,0);
        swapRow(cube, 4,0,2,0);
        swapRow(cube, 4,0,3,0);
    }

    public void oneC(){

        rotateFaceClockwise(cube ,1);

        swapColumn(cube, 0, 0, 2, 0);
        swapColumn(cube, 0, 0, 5, 0);


        swapPos(0,0,0,4,2,2);
        swapPos(0,1,0,4,1,2);
        swapPos(0,2,0,4,0,2);
    }

    public void oneCC(){

        oneC();
        oneC();
        oneC();
    }

    public void twoC(){

        rotateFaceClockwise(cube ,2);

        swapPos(0,2,0,3,2,0);
        swapPos(0,2,1,3,1,0);
        swapPos(0,2,2,3,0,0);

        swapPos(0,2,0,1,2,2);
        swapPos(0,2,1,1,1,2);
        swapPos(0,2,2,1,0,2);

        swapPos(1,0,2,5,0,0);
        swapPos(1,1,2,5,0,1);
        swapPos(1,2,2,5,0,2);
    }

    public void twoCC(){

        twoC();
        twoC();
        twoC();
    }

    public void threeC(){

        rotateFaceClockwise(cube, 3);
        swapColumn(cube, 0,2, 2,2);
        swapColumn(cube, 2,2,5,2);

        swapPos(4,0,0,5,2,2);
        swapPos(4,1,0,5,1,2);
        swapPos(4,2,0,5,0,2);
    }

    public void threeCC(){
        threeC();
        threeC();
        threeC();
    }

    public void fourC(){

        rotateFaceClockwise(cube, 4);

        swapPos(0,0,0,3,0,2);
        swapPos(0,0,1,3,1,2);
        swapPos(0,0,2,3,2,2);

        swapPos(3,0,2,1,2,0);
        swapPos(3,1,2,1,1,0);
        swapPos(3,2,2,1,0,0);

        swapPos(3,0,2,5,2,2);
        swapPos(3,1,2,5,2,1);
        swapPos(3,2,2,5,2,0);
    }

    public void fourCC(){

        fourC();
        fourC();
        fourC();
    }

    public void fiveC(){

        rotateFaceClockwise(cube, 5);
        swapRow(cube, 1,2,2,2);
        swapRow(cube,1,2,3,2);
        swapRow(cube, 1,2,4,2);
    }

    public void fiveCC(){

        fiveC();
        fiveC();
        fiveC();
    }

    public void zeroC2(){

        zeroC();
        zeroC();
    }

    public void oneC2(){

        oneC();
        oneC();
    }

    public void twoC2(){

        twoC();
        twoC();
    }

    public void threeC2(){

        threeC();
        threeC();
    }

    public void fourC2(){

        fourC();
        fourC();
    }

    public void fiveC2(){

        fiveC();
        fiveC();
    }

}
