package mg;


import java.util.Random;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        // write your code here

        //TicToe ticToe = new TicToe();
        //ticToe.gameStart();

        Advance advance = new Advance();
        advance.showMenu();
    }
}

    class TicToe {
        Scanner scanner = new Scanner(System.in);

        char[][] board = {{' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}};

        char symbol = ' ';

        int counterX = 0;
        int counterO = 0;

        int x = 0;
        int y = 0;

        public void gameStart() {

            while (true) {
                boardDraw(board);
                userMove(board, scanner);
                if (isGameFinished()) {
                    break;
                }
                boardDraw(board);
                computerMove(board);
                if (isGameFinished()) {
                    break;
                }
            }

        }

        private void boardDraw(char[][] board) {
            System.out.println("---------");
            for (int i = 0; i < 3; i++) {
                System.out.print("| ");
                for (int j = 0; j < 3; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.print("|");
                System.out.println();
            }
            System.out.println("---------");
        }

        private void startTurn(char[][] board, Scanner scanner) {
            System.out.println("Enter the cells: ");
            String startTurn = scanner.nextLine();
            char[] array = startTurn.toCharArray();

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    board[i][j] = array[i * 3 + j];
                }
            }
        }

        private boolean hasOnlyNumbers(String string) {
            char tmp;
            for (int i = 0; i < string.length(); i++) {
                tmp = string.charAt(i);
                if (Character.isDigit(tmp) == false) {
                    return false;
                }
            }
            return true;
        }

        private void userMove(char[][] board, Scanner scanner) {

            boolean flag;
            do {

                System.out.println("Enter the coordinates: ");
                String userInput = scanner.nextLine();
                String tmp = userInput.replace(" ", "");
                if (hasOnlyNumbers(tmp) == false) {
                    System.out.println("You should enter numbers!");
                    flag = true;
                } else {
                    String[] temp = userInput.split(" ");
                    x = Integer.parseInt(temp[0]);
                    y = Integer.parseInt(temp[1]);

                    if (x > 3 || x < 1 || y > 3 || y < 1) {
                        System.out.println("Coordinates should be from 1 to 3!");
                        flag = true;
                    } else {
                        if (board[x - 1][y - 1] == 'X' || board[x - 1][y - 1] == 'O') {
                            System.out.println("This cell is occupied! Choose another one!");
                            flag = true;
                        } else {
                            placeMove('X', x, y);
                            flag = false;
                        }
                    }
                }
            }
            while (flag);
        }

        private void computerMove(char[][] board) {
            Random random = new Random();
            int computerMoveX;
            int computerMoveY;
            while (true) {
                computerMoveX = random.nextInt(3) + 1;
                computerMoveY = random.nextInt(3) + 1;
                if (board[computerMoveX - 1][computerMoveY - 1] != 'X' && board[computerMoveX - 1][computerMoveY - 1] != 'O') {
                    System.out.println("Making move level 'easy' ");
                    placeMove('O', computerMoveX, computerMoveY);
                    break;

                }
            }
        }

        private void placeMove(char symbol, int Cordx, int Cordy) {

            board[Cordx - 1][Cordy - 1] = symbol;
        }

        private boolean isGameOver() {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == '_') {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean isItWon(char[][] board, char symbol) {
            if ((board[0][0] == symbol && board[0][1] == symbol && board[0][2] == symbol) ||
                    (board[1][0] == symbol && board[1][1] == symbol && board[1][2] == symbol) ||
                    (board[2][0] == symbol && board[2][1] == symbol && board[2][2] == symbol) ||

                    (board[0][0] == symbol && board[1][0] == symbol && board[2][0] == symbol) ||
                    (board[0][1] == symbol && board[1][1] == symbol && board[2][1] == symbol) ||
                    (board[0][2] == symbol && board[1][2] == symbol && board[2][2] == symbol) ||

                    (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
                    (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol)) {
                return true;
            }
            return false;

        }

        private void whatSymbol(char[][] board) {


            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == 'X') {
                        counterX++;
                    } else if (board[i][j] == 'O') {
                        counterO++;
                    }
                }
            }
            if (counterX <= counterO) {
                symbol = 'X';
            } else if (counterO < counterX) {
                symbol = 'O';
            }
        }

        private boolean isGameFinished() {
            if (isItWon(board, 'X')) {
                boardDraw(board);
                System.out.println("X wins");
                return true;
            }

            if (isItWon(board, 'O')) {
                boardDraw(board);
                System.out.println("O wins");
                return true;
            }
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == ' ') {
                        return false;
                    }
                }
            }
            boardDraw(board);
            System.out.println("The game ended in a tie!");
            return true;
        }

    }

    class Advance {
    Scanner scanner = new Scanner(System.in);
        char[][] board = {{' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}};
        String input;
        char symbol;


     void showMenu() {

        boolean option = true;
        do {
            System.out.println("Input command: ");
            input = scanner.nextLine();

            switch (input){
                case "start":
                    System.out.println("Bad parameters!");
                    option = true;
                    break;
                case "start easy":
                    System.out.println("Bad parameters!");
                    option = true;
                    break;
                case "start user":
                    System.out.println("Bad parameters!");
                    option = true;
                    break;

                case "start easy easy":

                    while (true) {
                        boardDraw(board);
                        easyEasy('X');
                        if (isGameFinished()) {
                            break;
                        }
                        boardDraw(board);
                        easyEasy('O');
                        if (isGameFinished()) {
                            break;
                        }
                    }

                    option = true;
                    break;

                case "start user easy":

                    while (true) {
                        boardDraw(board);
                        userUser('X');
                        if (isGameFinished()) {
                            break;
                        }
                        boardDraw(board);
                        easyEasy('O');
                        if (isGameFinished()) {
                            break;
                        }
                    }
                    option = true;
                    break;

                case "start easy user":

                    while (true) {
                        boardDraw(board);
                        easyEasy('X');
                        if (isGameFinished()) {
                            break;
                        }
                        boardDraw(board);
                        userUser('O');
                        if (isGameFinished()) {
                            break;
                        }
                    }
                    option = true;
                    break;

                case "start user user":

                    while (true) {
                        boardDraw(board);
                        userUser('X');
                        if (isGameFinished()) {
                            break;
                        }
                        boardDraw(board);
                        userUser('O');
                        if (isGameFinished()) {
                            break;
                        }
                    }
                    option = true;
                    break;
                case "exit":
                    option = false;
                    break;
            }


        }
        while (option == true);

     }

     private void boardDraw(char[][] board) {
            System.out.println("---------");
            for (int i = 0; i < 3; i++) {
                System.out.print("| ");
                for (int j = 0; j < 3; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.print("|");
                System.out.println();
            }
            System.out.println("---------");
        }

     private void whatSymbol() {

         if (input == "start easy easy") {

         }
     }

     private void placeMove(char symbol, int Cordx, int Cordy) {

            board[Cordx - 1][Cordy - 1] = symbol;
        }

     private void easyEasy(char symbol) {
             Random random = new Random();
             int computerMoveX;
             int computerMoveY;
             while (true) {
                 computerMoveX = random.nextInt(3) + 1;
                 computerMoveY = random.nextInt(3) + 1;
                 if (board[computerMoveX - 1][computerMoveY - 1] != 'X' && board[computerMoveX - 1][computerMoveY - 1] != 'O') {
                     System.out.println("Making move level 'easy' ");
                     placeMove(symbol, computerMoveX, computerMoveY);
                     break;

                 }
             }
         }

     private void userUser (char symbol) {
            int x;
            int y;
            boolean flag;
             do {

                 System.out.println("Enter the coordinates: ");
                 String userInput = scanner.nextLine();
                 String tmp = userInput.replace(" ", "");
                 if (hasOnlyNumbers(tmp) == false) {
                     System.out.println("You should enter numbers!");
                     flag = true;
                 } else {
                     String[] temp = userInput.split(" ");
                     x = Integer.parseInt(temp[0]);
                     y = Integer.parseInt(temp[1]);

                     if (x > 3 || x < 1 || y > 3 || y < 1) {
                         System.out.println("Coordinates should be from 1 to 3!");
                         flag = true;
                     } else {
                         if (board[x - 1][y - 1] == 'X' || board[x - 1][y - 1] == 'O') {
                             System.out.println("This cell is occupied! Choose another one!");
                             flag = true;
                         } else {
                             placeMove(symbol, x, y);
                             flag = false;
                         }
                     }
                 }
             }
             while (flag);
         }



         private boolean isGameFinished() {
            if (isItWon(board, 'X')) {
                boardDraw(board);
                System.out.println("X wins");
                return true;
            }

            if (isItWon(board, 'O')) {
                boardDraw(board);
                System.out.println("O wins");
                return true;
            }
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == ' ') {
                        return false;
                    }
                }
            }
            boardDraw(board);
            System.out.println("The game ended in a tie!");
            return true;
        }

        private boolean isItWon(char[][] board, char symbol) {
            if ((board[0][0] == symbol && board[0][1] == symbol && board[0][2] == symbol) ||
                    (board[1][0] == symbol && board[1][1] == symbol && board[1][2] == symbol) ||
                    (board[2][0] == symbol && board[2][1] == symbol && board[2][2] == symbol) ||

                    (board[0][0] == symbol && board[1][0] == symbol && board[2][0] == symbol) ||
                    (board[0][1] == symbol && board[1][1] == symbol && board[2][1] == symbol) ||
                    (board[0][2] == symbol && board[1][2] == symbol && board[2][2] == symbol) ||

                    (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
                    (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol)) {
                return true;
            }
            return false;

        }

        private boolean hasOnlyNumbers(String string) {
            char tmp;
            for (int i = 0; i < string.length(); i++) {
                tmp = string.charAt(i);
                if (Character.isDigit(tmp) == false) {
                    return false;
                }
            }
            return true;
        }





        }





