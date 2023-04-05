public class Tetris {

    public static void main(String[] args) {
        boolean board[][] = new boolean[5][12];
        Piece p1 = new T();
        p1.put(board, 0, 0);
        Piece p2 = new L();
        p2.put(board, 0, 4);
        printBoard(board);
        p2.rotate();
        p2.put(board, 2, 7);
        printBoard(board);
    }

    public static void printBoard(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean column : row) {
                if (column) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
    }

}

abstract class Piece {

    protected boolean[][] piece;

    public final void put(boolean[][] board, int x, int y) {
        for (int i = 0; i < piece.length; i++) {
            for (int j = 0; j < piece[i].length; j++) {
                if (board[x + i][y + j] && piece[i][j]) {
                    throw new IllegalArgumentException();
                }
                board[x + i][y + j] = piece[i][j];
            }
        }
    }

    public final void rotate() {
        for (int i = 0; i < piece.length; i++) {
            for (int j = 0; j < i; j++) {
                boolean tmp = piece[i][j];
                piece[i][j] = piece[j][i];
                piece[j][i] = tmp;
            }
        }

        int columnsNum = piece[0].length;
        for (int j = 0; j < columnsNum / 2; j++) {
            for (int i = 0; i < piece.length; i++) {
                boolean tmp = piece[i][j];
                piece[i][j] = piece[i][columnsNum - 1 - j];
                piece[i][columnsNum - 1 - j] = tmp;
            }
        }
    }

}

class T extends Piece {

    public T() {
        boolean[][] piece = { { false, true, false }, { true, true, true }, { false, false, false } };
        super.piece = piece;
    }

}

class L extends Piece {

    public L() {
        boolean[][] piece = { { true, false, false }, { true, false, false }, { true, true, false } };
        super.piece = piece;
    }

}
