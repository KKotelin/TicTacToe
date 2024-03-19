import java.util.Scanner;
class Player {
    public String name;
    private char symbol;

    public Player(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol(){
        return symbol;
    }

    public String getName(){
        return name;
    }

    public String setName(String name){
        this.name = name;
        return name;
    }


    public void makeMove(Board board) {
        Scanner scanner = new Scanner(System.in);
        int row, col;
        do {
            System.out.print("Введи два числа (1-3) через пробел: ");
            row = scanner.nextInt() - 1;
            col = scanner.nextInt() - 1;
        } while (!isValidMove(row, col, board));
        board.setMove(row, col, symbol);


    }

    private boolean isValidMove(int row, int col, Board board) {
        if (row < 0 || row >= Board.SIZE || col < 0 || col >= Board.SIZE) {
            System.out.println("Неверные координаты. Попробуй еще раз");
            return false;
        }
        if (!board.isCellEmpty(row, col)) {
            System.out.println("Поле заполнено");
            return false;
        }
        return true;
    }
}