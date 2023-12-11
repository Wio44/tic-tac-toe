import java.util.*;

/**
 * This class represents classical game - Tic Tac Toe with two players.
 */

public class TicTacToe {
    static String player1name = "";
    static String player2name = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Player 1 enter your name: ");
        player1name = scanner.next();

        System.out.println("Player 2 enter your name: ");
        player2name = scanner.next();
        scanner.nextLine();

        char[][] gameBoard =
                {{' ', ' ', ' '},
                        {' ', ' ', ' '},
                        {' ', ' ', ' '}};

        printGameBoard(gameBoard);

        while (true) {
            player1Turn(gameBoard, scanner, player1name);
            if (isGameOver(gameBoard)) {
                break;
            }
            printGameBoard(gameBoard);
            player2Turn(gameBoard, scanner, player2name);
            if (isGameOver(gameBoard)) {
                break;
            }
            printGameBoard(gameBoard);
        }

        scanner.close();
    }

    public static boolean isGameOver(char[][] gameBoard) {

        if (hasWon(gameBoard, 'X')) {
            printGameBoard(gameBoard);
            System.out.println("\n" + player1name + ", you win!");
            return true;
        }

        if (hasWon(gameBoard, 'O')) {
            printGameBoard(gameBoard);
            System.out.println("\n" + player2name + ", you win!");
            return true;
        }


        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                if (gameBoard[i][j] == ' ') {
                    return false;
                }
            }
        }
        printGameBoard(gameBoard);
        System.out.println("The game ended in a draw!");
        return true;
    }

    public static boolean hasWon(char[][] gameBoard, char playerEmblem) {
        return (gameBoard[0][0] == playerEmblem && gameBoard[0][1] == playerEmblem && gameBoard[0][2] == playerEmblem) ||
                (gameBoard[1][0] == playerEmblem && gameBoard[1][1] == playerEmblem && gameBoard[1][2] == playerEmblem) ||
                (gameBoard[2][0] == playerEmblem && gameBoard[2][1] == playerEmblem && gameBoard[2][2] == playerEmblem) ||

                (gameBoard[0][0] == playerEmblem && gameBoard[1][0] == playerEmblem && gameBoard[2][0] == playerEmblem) ||
                (gameBoard[0][1] == playerEmblem && gameBoard[1][1] == playerEmblem && gameBoard[2][1] == playerEmblem) ||
                (gameBoard[0][2] == playerEmblem && gameBoard[1][2] == playerEmblem && gameBoard[2][2] == playerEmblem) ||

                (gameBoard[0][0] == playerEmblem && gameBoard[1][1] == playerEmblem && gameBoard[2][2] == playerEmblem) ||
                (gameBoard[0][2] == playerEmblem && gameBoard[1][1] == playerEmblem && gameBoard[2][0] == playerEmblem);
    }

    public static boolean isValidMove(char[][] gameBoard, String position) {
        return switch (position) {
            case "1" -> gameBoard[0][0] == ' ';
            case "2" -> gameBoard[0][1] == ' ';
            case "3" -> gameBoard[0][2] == ' ';
            case "4" -> gameBoard[1][0] == ' ';
            case "5" -> gameBoard[1][1] == ' ';
            case "6" -> gameBoard[1][2] == ' ';
            case "7" -> gameBoard[2][0] == ' ';
            case "8" -> gameBoard[2][1] == ' ';
            case "9" -> gameBoard[2][2] == ' ';
            default -> false;
        };
    }

    public static void player1Turn(char[][] gameBoard, Scanner scanner, String player1Name) {
        String userInput;
        while (true) {
            System.out.println(player1Name + " : Enter your placement (from 1 to 9)");
            userInput = scanner.nextLine();
            if (isValidMove(gameBoard, userInput)) {
                break;
            } else {
                System.out.println(userInput + " is not valid move!");
            }
        }
        placeMove(gameBoard, userInput, 'X');
    }

    public static void player2Turn(char[][] gameBoard, Scanner scanner, String player2name) {
        String userInput;
        while (true) {
            System.out.println(player2name + " : Enter your placement (from 1 to 9)");
            userInput = scanner.nextLine();
            if (isValidMove(gameBoard, userInput)) {
                break;
            } else {
                System.out.println(userInput + " is not valid move!");
            }
        }
        placeMove(gameBoard, userInput, 'O');
    }

    public static void placeMove(char[][] gameBoard, String position, char playerEmblem) {
        switch (position) {
            case "1":
                gameBoard[0][0] = playerEmblem;
                break;
            case "2":
                gameBoard[0][1] = playerEmblem;
                break;
            case "3":
                gameBoard[0][2] = playerEmblem;
                break;
            case "4":
                gameBoard[1][0] = playerEmblem;
                break;
            case "5":
                gameBoard[1][1] = playerEmblem;
                break;
            case "6":
                gameBoard[1][2] = playerEmblem;
                break;
            case "7":
                gameBoard[2][0] = playerEmblem;
                break;
            case "8":
                gameBoard[2][1] = playerEmblem;
                break;
            case "9":
                gameBoard[2][2] = playerEmblem;
                break;
            default:
                System.out.println("Invalid input!");
                break;
        }
    }

    public static void printGameBoard(char[][] gameBoard) {
        System.out.println(gameBoard[0][0] + "|" + gameBoard[0][1] + "|" + gameBoard[0][2]);
        System.out.println("-+-+-");
        System.out.println(gameBoard[1][0] + "|" + gameBoard[1][1] + "|" + gameBoard[1][2]);
        System.out.println("-+-+-");
        System.out.println(gameBoard[2][0] + "|" + gameBoard[2][1] + "|" + gameBoard[2][2]);
    }
}
