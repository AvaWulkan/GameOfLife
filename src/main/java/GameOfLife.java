
public class GameOfLife {
    private int[][] gameBoard;

    public GameOfLife(int columns, int rows) {
        gameBoard = new int[columns][rows];
    }

    public void setCellToAlive(int column, int row){
        gameBoard[column][row] = 1;
    }
    private void setCellToDead(int column, int row){
        gameBoard[column][row] = 0;
    }
    private int countLiveNeighbors() {
        return 0;
    }

    public void goToNextGeneration(){
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                if (gameBoard[i][j] == 1){
                    if (countLiveNeighbors() < 2){
                        setCellToDead(i, j);
                    }
                }
            }
        }
        countLiveNeighbors();
    }

    public int getCellState(int column, int row) {
        return gameBoard[column][row];
    }
}
