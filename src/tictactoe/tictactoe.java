package tictactoe;

import java.util.Scanner;

public class tictactoe {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[][] gameMatrix = {
            {" "," ", " ", " ", " "},
            {"|","_", "_", "_", "|"},
            {"|","_", "_", "_", "|"},
            {"|","_", "_", "_", "|"}
        };

        loadGame(gameMatrix);

        printGame(gameMatrix);

        // MoveX(gameMatrix);

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
        int Impossible_O_X = 0;
        String controlGameStr = "";
        boolean gameNotFinished = false;
        for (int i = 1; i < g.length; i++) {
            for (int j = 1; j < g[i].length - 1; j++) {
                controlGameStr  += g[i][j];
                if (g[i][j].equals("_")) gameNotFinished = true;
                Impossible_O_X = (g[i][j].equals("X")) ? --Impossible_O_X : (g[i][j].equals("O")) ? ++Impossible_O_X : Impossible_O_X + 0;
            }
        }
        
        String[] controlGameList = controlGameStr.split("");
        String[] controlWin = "012345678048246036147258".split("");
        boolean xWin = false;
        boolean oWin = false;
        
        for (int i = 0; i < 24; i+= 3) { {
            controlGameStr = "";
            for (int j = i; j < i + 3; j++) {
                controlGameStr += controlGameList[Integer.parseInt(controlWin[j])];
            }
            if ("XXX".equals(controlGameStr)) {
                xWin = true;
            } if ("OOO".equals(controlGameStr)) {
                oWin = true;
            }
        }
            
        }

        if ((Math.abs(Impossible_O_X) >= 2) && (gameNotFinished && !xWin && !oWin) || (xWin && oWin)) {
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