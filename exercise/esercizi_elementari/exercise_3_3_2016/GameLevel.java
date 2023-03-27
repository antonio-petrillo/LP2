import java.util.LinkedList;

public class GameLevel {

    private int height, width;
    private boolean board[];

    public GameLevel(int height, int width) {
        this.height = height;
        this.width = width;
        board = new boolean[height * width];
        for (int i = 0; i < height * width; i++) {
            board[i] = true;
        }
    }

    private int getIndex(int x, int y) {
        return x * height + y;
    }

    public void removeWall(int x, int y) {
        board[getIndex(x, y)] = true;
    }

    public void setWall(int x, int y) {
        board[getIndex(x, y)] = false;
    }

    public void printBoard() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(board[getIndex(i, j)] + ", ");
            }
            System.out.println("");
        }
    }

    public boolean areConnected(int x1, int y1, int x2, int y2) {
        boolean[] visited = new boolean[height * width];
        if (!board[getIndex(x1, y1)]) {
            System.out.println("start pos not usable");
            return false;
        }
        int start = getIndex(x1, y1);
        visited[start] = true;
        LinkedList<Integer> q = new LinkedList<>();
        q.addLast(start);
        while (!q.isEmpty()) {
            int pos = q.removeFirst();
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    int x = pos / height + i;
                    int y = pos % width + j;
                    if (x >= 0 && x < height && y >= 0 && y < width) {
                        int neighPos = getIndex(x, y);
                        if (!visited[neighPos] && board[neighPos]) {
                            q.addLast(neighPos);
                            visited[neighPos] = true;
                        }
                    }
                }
            }
        }
        return visited[getIndex(x2, y2)];
    }

    public static void main(String[] args) {
        var gl = new GameLevel(3, 3);
        System.out.println(gl.areConnected(0, 0, 2, 2));
        gl.setWall(0, 1);
        gl.setWall(1, 1);
        System.out.println(gl.areConnected(0, 0, 2, 2));
        gl.setWall(2, 1);
        System.out.println(gl.areConnected(0, 0, 2, 2));
    }

}
