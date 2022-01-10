
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
    
    public void goToNextGeneration(){
        GameOfLife tempGameBoard = new GameOfLife(gameBoard.length,gameBoard[0].length);
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                if (gameBoard[i][j] == 1){
                    if (countLiveNeighbors(i, j) < 2){
                        tempGameBoard.setCellToDead(i, j);
                    }
                    if (countLiveNeighbors(i,j) > 3){
                        tempGameBoard.setCellToDead(i, j);
                    }
                }
            }
        }
        gameBoard = tempGameBoard.gameBoard;
    }

    private int countLiveNeighbors(int column, int row) {
        int numberOfLivingNeighbors = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                int x = (i + column + gameBoard.length) % gameBoard.length;
                int y = (j + row + gameBoard[0].length) % gameBoard[0].length;
                numberOfLivingNeighbors += gameBoard[x][y];
            }
        }
        numberOfLivingNeighbors -= gameBoard[column][row];
        return numberOfLivingNeighbors;
    }

    public int getCellState(int column, int row) {
        return gameBoard[column][row];
    }
}
