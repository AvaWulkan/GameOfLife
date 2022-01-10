// 1. Any live cell with fewer than two live neighbors dies, as if caused by
// underpopulation.
// 2. Any live cell with more than three live neighbors dies, as if by
// overcrowding.
// 3. Any live cell with two or three live neighbors lives on to the next
// generation.
// 4. Any dead cell with exactly three live neighbors becomes a live cell.

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameOfLifeTest {
    @Test
    public void liveCellDiesDueToUnderpopulation(){
        //live neighbors < 2
        GameOfLife testBoard = new GameOfLife(2, 2);
        testBoard.setCellToAlive(1,1);
        assertEquals(0, testBoard.countLiveNeighbors(1,1));
        testBoard.goToNextGeneration();
        assertEquals(0,testBoard.getCellState(1,1));
    }

    @Test
    public void liveCellDiesDueToOvercrowding(){
        //live neighbors > 3
        GameOfLife testBoard = new GameOfLife(3, 3);
        testBoard.setCellToAlive(1,1);
        testBoard.setCellToAlive(0,0);
        testBoard.setCellToAlive(0,1);
        testBoard.setCellToAlive(0,2);
        testBoard.setCellToAlive(2,2);
        assertEquals(4, testBoard.countLiveNeighbors(1,1));
        testBoard.goToNextGeneration();
        assertEquals(0,testBoard.getCellState(1,1));
    }

    @Test
    public void liveCellLivesOnToNextGeneration(){
        //live neighbors = 2 or 3
        GameOfLife testBoard = new GameOfLife(3, 3);
        testBoard.setCellToAlive(1,1);
        testBoard.setCellToAlive(0,0);
        testBoard.setCellToAlive(0,1);
        testBoard.setCellToAlive(0,2);
        assertEquals(3, testBoard.countLiveNeighbors(1,1));
        testBoard.goToNextGeneration();
        assertEquals(1,testBoard.getCellState(1,1));
    }

    @Test
    public void deadCellComesToLife(){
        //live neighbors = 3
        GameOfLife testBoard = new GameOfLife(3, 3);
        testBoard.setCellToAlive(0,0);
        testBoard.setCellToAlive(0,1);
        testBoard.setCellToAlive(0,2);
        assertEquals(3, testBoard.countLiveNeighbors(1,1));
        testBoard.goToNextGeneration();
        assertEquals(1,testBoard.getCellState(1,1));
    }


}
