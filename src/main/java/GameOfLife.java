
public class GameOfLife {
    private int[][] gameBoard;

    public GameOfLife(int columns, int rows) {
        gameBoard = new int[columns][rows];
    }

    public GameOfLife(int[][] grid) {
        gameBoard = grid;
    }

    public void setCellToAlive(int column, int row){
        gameBoard[column][row] = 1;
    }

    private void setCellToDead(int column, int row){
        gameBoard[column][row] = 0;
    }
    
    public void goToNextGeneration(){
        GameOfLife tempGameBoard = new GameOfLife(gameBoard.length, gameBoard[0].length);
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                int numberOfliveNeighbors = countLiveNeighbors(i, j);
                if (gameBoard[i][j] == 1){
                    if (numberOfliveNeighbors < 2){
                        tempGameBoard.setCellToDead(i, j);
                    }else if (numberOfliveNeighbors > 3){
                        tempGameBoard.setCellToDead(i, j);
                    }else if (numberOfliveNeighbors == 2 || numberOfliveNeighbors == 3){
                        tempGameBoard.setCellToAlive(i, j);
                    }
                }else if (numberOfliveNeighbors == 3){
                    tempGameBoard.setCellToAlive(i, j);
                }
            }
        }
        gameBoard = tempGameBoard.gameBoard;
        printGameboard();
    }

    public void printGameboard() {
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                System.out.print(gameBoard[i][j] + " ");
            }
            System.out.print("\n");
        }
        System.out.println();
    }

    public int countLiveNeighbors(int column, int row) {
        int numberOfLivingNeighbors = 0;
        for (int i = column-1; i <= column+1; i++) {
            for (int j = row-1; j <= row+1; j++) {
                if (i>=0 && i< gameBoard.length && j>=0 && j< gameBoard[0].length){
                    numberOfLivingNeighbors += gameBoard[i][j];
                }
            }
        }
        numberOfLivingNeighbors -= gameBoard[column][row];
        return numberOfLivingNeighbors;
    }

    public int getCellState(int column, int row) {
        return gameBoard[column][row];
    }
}
