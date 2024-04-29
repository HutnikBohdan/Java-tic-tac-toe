package tictactoe;

import java.util.Scanner;

public class tictactoe {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        String game = input.nextLine();

        String Tictactoe1 = String.format("---------\n| %s %s %s |\n", game.charAt(0), game.charAt(1), game.charAt(2));
        String Tictactoe2 = String.format("| %s %s %s |\n",  game.charAt(3), game.charAt(4), game.charAt(5));
        String Tictactoe3 = String.format("| %s %s %s |\n---------",  game.charAt(6), game.charAt(7), game.charAt(8));


        System.out.println(Tictactoe1 + Tictactoe2 + Tictactoe3);

        input.close();
    }
}
