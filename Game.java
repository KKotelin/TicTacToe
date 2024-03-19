
import java.util.Scanner;
class Game {
    private Board board;
    private Player[] players;

    public int player_1_wins;
    public int player_2_wins;
    private static final int NUM_PLAYERS = 2;
    private static final char[] SYMBOLS = {'X', 'O'};
    private int currentPlayerIndex;
    public Scanner scanner = new Scanner(System.in);

    public Game() {
        board = new Board();
        players = new Player[NUM_PLAYERS];
        players[0] = new Player(SYMBOLS[0]);
        players[1] = new Player(SYMBOLS[1]);
        currentPlayerIndex = 0;
        player_1_wins = 0;
        player_2_wins = 0;

    }

    public void startGame() {
        System.out.println("Добро пожаловать в игру Крестики нолики");
        System.out.println("Игрок 1, пожалуйста, представьтесь. Вы будете играть крестиками");
        players[0].setName(scanner.nextLine());
        System.out.println("Игрок 2, пожалуйста, представьтесь.  Вы будете играть ноликами");
        players[1].setName(scanner.nextLine());

        while (true) {
            board.displayBoard();
            while (!board.isFull()) {
                Player currentPlayer = players[currentPlayerIndex];
                System.out.println(currentPlayer.getName() + ", ваш ход");
                currentPlayer.makeMove(board);
                board.displayBoard();
                if (board.checkWin(currentPlayer.getSymbol())) {
                    System.out.println(currentPlayer.getName() + " победил!");
                    updateScore(currentPlayer);
                    displayScore();
                    break;
                }
                currentPlayerIndex = (currentPlayerIndex + 1) % NUM_PLAYERS;
            }
            if (board.isFull()) {
                System.out.println("Это ничья!");
            }

            // Очистка доски
            board.clearBoard();

            System.out.println("Хотите сыграть еще раз? (да/нет)");
            String playAgain = scanner.nextLine();
            if (!playAgain.equalsIgnoreCase("да")) {
                break;
            }
        }
    }



    public void displayScore(){
        System.out.println("Счет:");
        System.out.println(players[0].getName() + ": " + player_1_wins);
        System.out.println(players[1].getName() + ": " + player_2_wins);
    }

    public void updateScore(Player winner){
        if (winner == players[0]){
            player_1_wins++;
        } else if (winner == players[1]) {
            player_2_wins++;
        }
    }
}


















