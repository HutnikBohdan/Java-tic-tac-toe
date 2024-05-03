package tictactoe;

import java.util.Scanner;

public class tictactoe {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[][] gameMatrix = {
            {" "," ", " ", " ", " "},
            {"|"," ", " ", " ", "|"},
            {"|"," ", " ", " ", "|"},
            {"|"," ", " ", " ", "|"}
        };

        loadGame(gameMatrix);

        printGame(gameMatrix);

        MoveX(gameMatrix);

        printGame(gameMatrix);

        MoveX(gameMatrix);

        printGame(gameMatrix);

        Wins(gameMatrix);


        input.close();
        
    }
    

    public static void loadGame (String[][] g) {
        Scanner input = new Scanner(System.in);
        String game = input.nextLine();

        if (!game.isEmpty() || game.length() < 8) {
            if (game.length() < 9) {
                for (int i = game.length(); i < 9; i++) {
                    game += "_";
                }
            }
            int numLenGame = 0;
            for (int i = 1; i < g.length; i++) {
                for (int j = 1; j < g[i].length - 1; j++) {
                    g[i][j] = String.valueOf(game.charAt(numLenGame));
                    numLenGame++;

                }
            }
        }
    }


    public static void printGame(String[][] gameArray){

        System.out.println("---------");
        for (int i = 1; i < gameArray.length; i++) {
            for (int j = 0; j < gameArray[i].length; j++) {
                System.out.print(gameArray[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("---------");
        
    }


    public static void MoveX( String[][] gameArray) {
        Scanner input = new Scanner(System.in);
        
        boolean numInputFlag;
        int moveY = 0;
        int moveX = 0;
        
        do {
            numInputFlag = true;
            if (input.hasNextInt()) {

                moveX = input.nextInt();
                moveY = input.nextInt();

                if (moveX > 3 || moveX < 0 || moveY > 3 || moveY < 0) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else if ("X".equals(gameArray[moveX][moveY]) || "O".equals(gameArray[moveX][moveY])) {
                    System.out.println("This cell is occupied! Choose another one!");
                }
                

            } else {
                System.out.println("You should enter numbers!");
                numInputFlag = false;
                input.nextLine();
            }

        } while (moveX > 3 || moveX < 0 || moveY > 3 || moveY < 0 || "X".equals(gameArray[moveX][moveY]) || "O".equals(gameArray[moveX][moveY]) || !numInputFlag);
        gameArray[moveX][moveY] = "X";
    }


    public static void Wins (String[][] g) {
        String g1 = g[1][0];
        String g2 = g[1][1];
        String g3 = g[1][2];
        String g4 = g[2][0];
        String g5 = g[2][1];
        String g6 = g[2][2];
        String g7 = g[3][0];
        String g8 = g[3][1];
        String g9 = g[3][2];

        boolean xWin = false;
        if ("XXX".equals(g1 + g2 + g3) || "XXX".equals(g4 + g5 + g6) || "XXX".equals(g7 + g8 + g9) || "XXX".equals(g1 + g5 + g9)) {
            xWin = true;
        } else if ("XXX".equals(g3 + g5 + g7) || "XXX".equals(g1 + g4 + g7) || "XXX".equals(g2 + g5 + g8) || "XXX".equals(g3 + g6 + g9)) {
            xWin = true;
        }

        boolean oWin = false;
        if ("OOO".equals(g1 + g2 + g3) || "OOO".equals(g4 + g5 + g6) || "OOO".equals(g7 + g8 + g9) || "OOO".equals(g1 + g5 + g9)) {
            oWin = true;
        } else if ("OOO".equals(g3 + g5 + g7)|| "OOO".equals(g1 + g4 + g7) || "OOO".equals(g2 + g5 + g8) || "OOO".equals(g3 + g6 + g9)) {
            oWin = true;
        }

        int count_O = 0;
        int count_X = 0;
        int Impossible_O_X = 0;
        boolean gameNotFinished = false;
        for (int i = 1; i < g.length; i++) {
            for (int j = 0; j < g[i].length; j++) {
                if (g[i][j].equals("_")) gameNotFinished = true;
                if (g[i][j].equals("X")) count_X++;
                if (g[i][j].equals("O")) count_O++;
            }
        }
        Impossible_O_X = Math.abs(count_X - count_O);


        if ((Impossible_O_X >= 2) && (gameNotFinished && !xWin && !oWin) || (xWin && oWin)) {
            System.out.println("Impossible");
        } else if (gameNotFinished && !xWin && !oWin) {
            System.out.println("Game not finished");
        } else if (!gameNotFinished && !xWin && !oWin) {
            System.out.println("Draw");
        } else if (xWin == true) {
            System.out.println("X wins");
        } else if (oWin == true) {
            System.out.println("O wins");
        }
    }
}


/* package tictactoe;

import java.util.Scanner;

public class tictactoe {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        String game = input.nextLine();

        char g0 = game.charAt(0);
        char g1 = game.charAt(1);
        char g2 = game.charAt(2);
        char g3 = game.charAt(3);
        char g4 = game.charAt(4);
        char g5 = game.charAt(5);
        char g6 = game.charAt(6);
        char g7 = game.charAt(7);
        char g8 = game.charAt(8);


        int count_X = 0;
        boolean xWin = (g0 == 'X' && g1 == g0 && g1 == g2) ? true : (g3 == 'X' && g4 == g3 && g4 == g5) ? true :
        (g6 == 'X' && g7 == g6 && g7 == g8) ? true : false;
        if ((g0 == 'X' && g4 == g0 && g4 == g8) || (g2 == 'X' && g4 == g2 && g4 == g6) ||
        (g0 == 'X' && g3 == g0 && g3 == g6) || (g1 == 'X' && g4 == g1 && g4 == g7) || (g2 == 'X' && g5 == g2 && g5 == g8)) {
            xWin = true;
        }


        int count_O = 0;
        boolean oWin = (g0 == 'O' && g1 == g0 && g1 == g2) ? true : (g3 == 'O' && g4 == g3 && g4 == g5) ? true :
        (g6 == 'O' && g7 == g6 && g7 == g8) ? true : false;
        if ((g0 == 'O' && g4 == g0 && g4 == g8) || (g2 == 'O' && g4 == g2 && g4 == g6) ||
        (g0 == 'O' && g3 == g0 && g3 == g6) || (g1 == 'O' && g4 == g1 && g4 == g7) || (g2 == 'O' && g5 == g2 && g5 == g8)) {
            oWin = true;
        }

        boolean gameNotFinished = false;

        String[][] g = {
            {" ", " ", " "},
            {" ", " ", " "},
            {" ", " ", " "}
        };

        int numLenGame = 0;
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[i].length; j++) {
                g[i][j] = String.valueOf(game.charAt(numLenGame));
                numLenGame++;

            }
        }


        System.out.println("---------");
        for (int i = 0; i < g.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < g[i].length; j++) {
                if (g[i][j].equals("_")) {
                    gameNotFinished = true;
                    
                }
                if (g[i][j].equals("X")) {
                    count_X++;
                } else if (g[i][j].equals("O")) {
                    count_O++;
                }

                System.out.print(g[i][j] + " ");
            }
            System.out.print("|\n");
        }
        System.out.println("---------");


        if ((((count_X - count_O) >= 2 || (count_O - count_X) >= 2)) && (gameNotFinished && !xWin && !oWin) || (xWin && oWin)) {
            System.out.println("Impossible");
        } else if (gameNotFinished && !xWin && !oWin) {
            System.out.println("Game not finished");
        } else if (!gameNotFinished && !xWin && !oWin) {
            System.out.println("Draw");
        } else if (xWin == true) {
            System.out.println("X wins");
        } else if (oWin == true) {
            System.out.println("O wins");
        }

        input.close();
    }
}
 */


/*
package tictactoe;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        String game = input.nextLine();
        String[][] g = {
            {"|", " ", " ", " ", "|"},
            {"|", " ", " ", " ", "|"},
            {"|", " ", " ", " ", "|"}
        };


        char g0 = game.charAt(0);
        char g1 = game.charAt(1);
        char g2 = game.charAt(2);
        char g3 = game.charAt(3);
        char g4 = game.charAt(4);
        char g5 = game.charAt(5);
        char g6 = game.charAt(6);
        char g7 = game.charAt(7);
        char g8 = game.charAt(8);

        boolean xWin = (g0 == 'X' && g1 == g0 && g1 == g2) ? true : (g3 == 'X' && g4 == g3 && g4 == g5) ? true : (g6 == 'X' && g7 == g6 && g7 == g8) ? true : false;
        boolean yWin = (g0 == 'O' && g1 == g0 &&  g1 == g2) ? true : (g3 == 'O' && g4 == g3 && g4 == g5) ? true : (g6 == 'O' && g7 == g6 && g7 == g8) ? true : false;
        if ((g0 == 'X' && g4 == g0 && g4 == g8) || (g2 == 'X' && g4 == g2 && g4 == g6) || (g0 == 'X' && g3 == g0 && g3 == g6) || (g1 == 'X' && g4 == g1 && g4 == g7) || (g2 == 'X' && g5 == g2 && g5 == g8)) {
            xWin = true;
        }
        if ((g0 == 'O' && g4 == g0 && g4 == g8) || (g2 == 'O' && g4 == g2 && g4 == g6) || (g0 == 'O' && g3 == g0 && g3 == g6) || (g1 == 'O' && g4 == g1 && g4 == g7) || (g2 == 'O' && g5 == g2 && g5 == g8)) {
            yWin = true;
        }

        boolean gameNotFinished = false;
        int count_X = 0;
        int count_O = 0;

        int numLenGame = 0;
        for (int i = 0; i < g.length; i++) {
            for (int j = 1; j < g[i].length - 1; j++) {
                g[i][j] = String.valueOf(game.charAt(numLenGame));
                numLenGame++;

            }
        }

        System.out.println("---------");
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[i].length; j++) {
                if (g[i][j].equals("_")) {
                    gameNotFinished = true;
                    
                }
                if (g[i][j].equals("X")) {
                    count_X++;
                } else if (g[i][j].equals("O")) {
                    count_O++;
                }

                System.out.print(g[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("---------");

        if ((((count_X - count_O) >= 2 || (count_O - count_X) >= 2)) && (gameNotFinished && !xWin && !yWin) || (xWin && yWin)) {
            System.out.println("Impossible");
        } else if (gameNotFinished && !xWin && !yWin) {
            System.out.println("Game not finished");
        } else if (!gameNotFinished && !xWin && !yWin) {
            System.out.println("Draw");
        } else if (xWin == true) {
            System.out.println("X wins");
        } else if (yWin == true) {
            System.out.println("O wins");
        }



        input.close();
    }
}


 */