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
        System.out.println("liveCellDiesDueToUnderpopulation:");
        GameOfLife testBoard = new GameOfLife(2, 2);
        testBoard.setCellToAlive(1,1);
        testBoard.printGameboard();
        assertEquals(0, testBoard.countLiveNeighbors(1,1));
        testBoard.goToNextGeneration();
        assertEquals(0,testBoard.getCellState(1,1));
    }

    @Test
    public void liveCellDiesDueToOvercrowding(){
        System.out.println("liveCellDiesDueToOvercrowding:");
        GameOfLife testBoard = new GameOfLife(3, 3);
        testBoard.setCellToAlive(1,1);
        testBoard.setCellToAlive(0,0);
        testBoard.setCellToAlive(0,1);
        testBoard.setCellToAlive(0,2);
        testBoard.setCellToAlive(2,2);
        testBoard.printGameboard();
        assertEquals(4, testBoard.countLiveNeighbors(1,1));
        testBoard.goToNextGeneration();
        assertEquals(0,testBoard.getCellState(1,1));
    }

    @Test
    public void liveCellLivesOnToNextGeneration(){
        System.out.println("liveCellLivesOnToNextGeneration:");
        GameOfLife testBoard = new GameOfLife(3, 3);
        testBoard.setCellToAlive(1,1);
        testBoard.setCellToAlive(0,0);
        testBoard.setCellToAlive(0,1);
        testBoard.setCellToAlive(0,2);
        testBoard.printGameboard();
        assertEquals(3, testBoard.countLiveNeighbors(1,1));
        testBoard.goToNextGeneration();
        assertEquals(1,testBoard.getCellState(1,1));
    }

    @Test
    public void deadCellComesToLife(){
        System.out.println("deadCellComesToLife:");
        GameOfLife testBoard = new GameOfLife(3, 3);
        testBoard.setCellToAlive(0,0);
        testBoard.setCellToAlive(0,1);
        testBoard.setCellToAlive(0,2);
        testBoard.printGameboard();
        assertEquals(3, testBoard.countLiveNeighbors(1,1));
        testBoard.goToNextGeneration();
        assertEquals(1,testBoard.getCellState(1,1));
    }

    @Test
    public void edgeTestBirth(){
        System.out.println("edgeTestBirth:");
        GameOfLife testBoard = new GameOfLife(2, 3);
        testBoard.setCellToAlive(0,0);
        testBoard.setCellToAlive(0,2);
        testBoard.setCellToAlive(1,0);
        testBoard.printGameboard();
        assertEquals(3, testBoard.countLiveNeighbors(0,1));
        testBoard.goToNextGeneration();
        assertEquals(1, testBoard.getCellState(0,1));
    }

    @Test
    public void edgeTestDeath(){
        System.out.println("edgeTestDeath:");
        GameOfLife testBoard = new GameOfLife(3, 3);
        testBoard.setCellToAlive(0,0);
        testBoard.setCellToAlive(0,1);
        testBoard.setCellToAlive(0,2);
        testBoard.setCellToAlive(1,0);
        testBoard.setCellToAlive(1,1);
        testBoard.setCellToAlive(1,2);
        testBoard.printGameboard();
        assertEquals(5, testBoard.countLiveNeighbors(0,1));
        testBoard.goToNextGeneration();
        assertEquals(0, testBoard.getCellState(0,1));
    }

    @Test
    public void cornerTestBirth(){
        System.out.println("cornerTestBirth:");
        GameOfLife testBoard = new GameOfLife(2, 2);
        testBoard.setCellToAlive(0,1);
        testBoard.setCellToAlive(1,0);
        testBoard.setCellToAlive(1,1);
        testBoard.printGameboard();
        assertEquals(3, testBoard.countLiveNeighbors(0,0));
        testBoard.goToNextGeneration();
        assertEquals(1, testBoard.getCellState(0,0));
    }

    @Test
    public void cornerTestDeath(){
        System.out.println("cornerTestDeath:");
        GameOfLife testBoard = new GameOfLife(2, 2);
        testBoard.setCellToAlive(0,0);
        testBoard.printGameboard();
        assertEquals(0, testBoard.countLiveNeighbors(0,0));
        testBoard.goToNextGeneration();
        assertEquals(0, testBoard.getCellState(0,0));
    }
}
