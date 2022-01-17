import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameOfLifeTest {
    @Test
    public void liveCellDiesDueToUnderpopulation(){
        System.out.println("liveCellDiesDueToUnderpopulation:");
        GameOfLife testBoard = new GameOfLife(2, 2);
        testBoard.setCellToAlive(1,1);
        System.out.println(testBoard.printGameBoard());
        assertEquals(0, testBoard.countLiveNeighbors(1,1));
        testBoard.goToNextGeneration();
        assertEquals("DEAD",testBoard.getCellState(1,1));
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
        System.out.println(testBoard.printGameBoard());
        assertEquals(4, testBoard.countLiveNeighbors(1,1));
        testBoard.goToNextGeneration();
        assertEquals("DEAD",testBoard.getCellState(1,1));
    }

    @Test
    public void liveCellLivesOnToNextGeneration(){
        System.out.println("liveCellLivesOnToNextGeneration:");
        GameOfLife testBoard = new GameOfLife(3, 3);
        testBoard.setCellToAlive(1,1);
        testBoard.setCellToAlive(0,0);
        testBoard.setCellToAlive(0,1);
        testBoard.setCellToAlive(0,2);
        System.out.println(testBoard.printGameBoard());
        assertEquals(3, testBoard.countLiveNeighbors(1,1));
        testBoard.goToNextGeneration();
        assertEquals("ALIVE",testBoard.getCellState(1,1));
    }

    @Test
    public void deadCellComesToLife(){
        System.out.println("deadCellComesToLife:");
        GameOfLife testBoard = new GameOfLife(3, 3);
        testBoard.setCellToAlive(0,0);
        testBoard.setCellToAlive(0,1);
        testBoard.setCellToAlive(0,2);
        System.out.println(testBoard.printGameBoard());
        assertEquals(3, testBoard.countLiveNeighbors(1,1));
        testBoard.goToNextGeneration();
        assertEquals("ALIVE",testBoard.getCellState(1,1));
    }

    @Test
    public void deadCellStayDead(){
        System.out.println("deadCellStayDead:");
        GameOfLife testBoard = new GameOfLife(3, 3);
        System.out.println(testBoard.printGameBoard());
        testBoard.goToNextGeneration();
        assertEquals("DEAD",testBoard.getCellState(1,1));
    }

    @Test
    public void edgeTestBirth(){
        System.out.println("edgeTestBirth:");
        GameOfLife testBoard = new GameOfLife(2, 3);
        testBoard.setCellToAlive(0,0);
        testBoard.setCellToAlive(0,2);
        testBoard.setCellToAlive(1,0);
        System.out.println(testBoard.printGameBoard());
        assertEquals(3, testBoard.countLiveNeighbors(0,1));
        testBoard.goToNextGeneration();
        assertEquals("ALIVE", testBoard.getCellState(0,1));
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
        System.out.println(testBoard.printGameBoard());
        assertEquals(5, testBoard.countLiveNeighbors(0,1));
        testBoard.goToNextGeneration();
        assertEquals("DEAD", testBoard.getCellState(0,1));
    }

    @Test
    public void cornerTestBirth(){
        System.out.println("cornerTestBirth:");
        GameOfLife testBoard = new GameOfLife(2, 2);
        testBoard.setCellToAlive(0,1);
        testBoard.setCellToAlive(1,0);
        testBoard.setCellToAlive(1,1);
        System.out.println(testBoard.printGameBoard());
        assertEquals(3, testBoard.countLiveNeighbors(0,0));
        testBoard.goToNextGeneration();
        assertEquals("ALIVE", testBoard.getCellState(0,0));
    }

    @Test
    public void cornerTestDeath(){
        System.out.println("cornerTestDeath:");
        GameOfLife testBoard = new GameOfLife(2, 2);
        testBoard.setCellToAlive(0,0);
        System.out.println(testBoard.printGameBoard());
        assertEquals(0, testBoard.countLiveNeighbors(0,0));
        testBoard.goToNextGeneration();
        assertEquals("DEAD", testBoard.getCellState(0,0));
    }

    @Test
    public void printGameBoardTest(){
        GameOfLife testBoard = new GameOfLife(3,3);
        testBoard.setCellToAlive(0,1);
        testBoard.setCellToAlive(2,0);
        testBoard.setCellToAlive(1,1);
        assertEquals("0 1 0 \n0 1 0 \n1 0 0 \n\n", testBoard.printGameBoard());
    }

}
