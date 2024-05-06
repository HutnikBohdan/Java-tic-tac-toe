package tictactoe;

import java.util.Scanner;

public class tictactoe {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[][] gameMatrix = {
                { " ", " ", " ", " ", " " },
                { "|", "_", "_", "_", "|" },
                { "|", "_", "_", "_", "|" },
                { "|", "_", "_", "_", "|" }
        };
        System.out.println("\n\nEnter 1 if you want to play as 'X' then the second player will play as 'O'. \nOr enter 2 to play as 'O' then the second player will play as 'X':\n");
        int player = input.nextInt();
        
        printGame(gameMatrix);
        endGame:
        switch (player) {
            case 1: {
                while (!Wins(gameMatrix)) {
                    MoveX(gameMatrix);
                    printGame(gameMatrix);
                    if (Wins(gameMatrix)) {
                        break endGame;
                    }
                    MoveO(gameMatrix);
                    printGame(gameMatrix);
                    if (Wins(gameMatrix)) {
                        break endGame;
                    }
                }
            }
            case 2: {
                while (!Wins(gameMatrix)) {
                    MoveO(gameMatrix);
                    printGame(gameMatrix);
                    if (Wins(gameMatrix)) {
                        break endGame;
                    }
                    MoveX(gameMatrix);
                    printGame(gameMatrix);
                    if (Wins(gameMatrix)) {
                        break endGame;
                    }
                
                }
            }
        }

        input.close();

    }

    public static void printGame(String[][] gameArray) {

        System.out.println("---------");
        for (int i = 1; i < gameArray.length; i++) {
            for (int j = 0; j < gameArray[i].length; j++) {
                System.out.print(gameArray[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("---------");

    }

    public static void MoveX(String[][] gameArray) {
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
        } while (moveX > 3 || moveX < 0 || moveY > 3 || moveY < 0 || "X".equals(gameArray[moveX][moveY])
                || "O".equals(gameArray[moveX][moveY]) || !numInputFlag);
        gameArray[moveX][moveY] = "X";
    }

    public static void MoveO(String[][] gameArray) {
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
        } while (moveX > 3 || moveX < 0 || moveY > 3 || moveY < 0 || "X".equals(gameArray[moveX][moveY])
                || "O".equals(gameArray[moveX][moveY]) || !numInputFlag);
        gameArray[moveX][moveY] = "O";
    }

    public static boolean Wins(String[][] g) {
        boolean gameEnd = false;
        boolean xWin = false;
        boolean oWin = false;
        String[] controlWin = "012345678048246036147258".split("");
        String gamMatStr = "";
        int Impossible_O_X = 0;

        for (int i = 1; i < g.length; i++) {
            for (int j = 1; j < g[i].length - 1; j++) {
                gamMatStr += g[i][j];
                Impossible_O_X = (g[i][j].equals("X")) ? ++Impossible_O_X : g[i][j].equals("O") ? ++Impossible_O_X : Impossible_O_X + 0;
            }
        }
        String[] newList = gamMatStr.split("");

        for (int i = 0; i < 24; i += 3) {
            gamMatStr = "";
            for (int j = i; j < i + 3; j++) {
                gamMatStr += newList[Integer.parseInt(controlWin[j])];
            }
            if ("XXX".equals(gamMatStr)) {
                xWin = true;
            }
            if (gamMatStr.equals("OOO")) {
                oWin = true;
            }
        }

        if (Impossible_O_X == 9 && !xWin && !oWin) {
            System.out.println("Draw");
            gameEnd = true;
        }
        if (xWin == true) {
            System.out.println("X wins");
            gameEnd = true;
        } else if (oWin == true) {
            System.out.println("O wins");
            gameEnd = true;
        }
        return (gameEnd);
        
    }
}