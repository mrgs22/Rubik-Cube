package Main;

public class Main {
    public static void main(String[] args) {
        int[][][] cube = new int[6][3][3];
        //6 sides 3 row 3 columns
        permutations perm = new permutations();
        perm.setSolvedCube(cube);

        //==========[moves below]=================
        //add coments for types of moves on cube
        //also need to test the moves for any error with rotation especially on side 4
        Move move = new Move(cube);
        move.zeroC();
        move.zeroCC();
        move.oneC();
        move.oneCC();
        move.twoC();
        move.twoCC();
        move.threeC();
        move.threeCC();
        move.fourC();
        move.fourCC();
        move.fiveC();
        //===========[terminal below]================
        cube = move.cube;

        console terminal = new console();
        terminal.dump(cube);
    }
}