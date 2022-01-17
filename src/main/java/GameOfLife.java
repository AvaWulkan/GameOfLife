
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
        GameOfLife tempGameBoard = new GameOfLife(numberOfColumns(), numberOfRows());
        for (int i = 0; i < numberOfColumns(); i++) {
            for (int j = 0; j < numberOfRows(); j++) {
                int numberOfLivingNeighbors = countLiveNeighbors(i, j);
                if (getCellState(i,j).equals("ALIVE")){
                    if (numberOfLivingNeighbors == 2 || numberOfLivingNeighbors == 3){
                        tempGameBoard.setCellToAlive(i, j);
                    }else{
                        tempGameBoard.setCellToDead(i, j);
                    }
                }else if (getCellState(i,j).equals("DEAD") && numberOfLivingNeighbors == 3){
                    tempGameBoard.setCellToAlive(i, j);
                }
            }
        }
        gameBoard = tempGameBoard.gameBoard;
        System.out.println(printGameBoard());
    }

    private int numberOfRows() {
        return gameBoard[0].length;
    }

    private int numberOfColumns() {
        return gameBoard.length;
    }

    public String printGameBoard() {
        StringBuilder gameBoardString = new StringBuilder();
        for (int i = 0; i < numberOfColumns(); i++) {
            for (int j = 0; j < numberOfRows(); j++) {
                gameBoardString.append(gameBoard[i][j]).append(" ");
            }
            gameBoardString.append("\n");
        }
        gameBoardString.append("\n");
        return gameBoardString.toString();
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

    public String getCellState(int column, int row) {
        return switch (gameBoard[column][row]) {
            case 1 -> "ALIVE";
            case 0 -> "DEAD";
            default -> "something went wrong";
        };
    }
}
