package tictactoe;

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
        boolean xWin = (g0 == 'X' && g1 == g0 && g1 == g2) ? true : (g3 == 'X' && g4 == g3 && g4 == g5) ? true : (g6 == 'X' && g7 == g6 && g7 == g8) ? true : false;
        if ((g0 == 'X' && g4 == g0 && g4 == g8) || (g2 == 'X' && g4 == g2 && g4 == g6) || (g0 == 'X' && g3 == g0 && g3 == g6) || (g1 == 'X' && g4 == g1 && g4 == g7) || (g2 == 'X' && g5 == g2 && g5 == g8)) {
            xWin = true;
        }

        int count_O = 0;
        boolean oWin = (g0 == 'O' && g1 == g0 && g1 == g2) ? true : (g3 == 'O' && g4 == g3 && g4 == g5) ? true : (g6 == 'O' && g7 == g6 && g7 == g8) ? true : false;
        if ((g0 == 'O' && g4 == g0 && g4 == g8) || (g2 == 'O' && g4 == g2 && g4 == g6) || (g0 == 'O' && g3 == g0 && g3 == g6) || (g1 == 'O' && g4 == g1 && g4 == g7) || (g2 == 'O' && g5 == g2 && g5 == g8)) {
            oWin = true;
        }

        boolean gameNotFinished = false;

        String[][] g = {
            {"|", " ", " ", " ", "|"},
            {"|", " ", " ", " ", "|"},
            {"|", " ", " ", " ", "|"}
        };

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