
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
        GameOfLife tempGameBoard = new GameOfLife(numberOfColumns(), numberOfRows());
        for (int i = 0; i < numberOfColumns(); i++) {
            for (int j = 0; j < numberOfRows(); j++) {
                int numberOfliveNeighbors = countLiveNeighbors(i, j);
                if (gameBoard[i][j] == 1){
                    if (numberOfliveNeighbors == 2 || numberOfliveNeighbors == 3){
                        tempGameBoard.setCellToAlive(i, j);
                    }else{
                        tempGameBoard.setCellToDead(i, j);
                    }
                }else if (numberOfliveNeighbors == 3){
                    tempGameBoard.setCellToAlive(i, j);
                }
            }
        }
        gameBoard = tempGameBoard.gameBoard;
        printGameboard();
    }

    private int numberOfRows() {
        return gameBoard[0].length;
    }

    private int numberOfColumns() {
        return gameBoard.length;
    }

    public void printGameboard() {
        for (int i = 0; i < numberOfColumns(); i++) {
            for (int j = 0; j < numberOfRows(); j++) {
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
                if (i >= 0 && i < numberOfColumns() && j >= 0 && j < numberOfRows()) {
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
