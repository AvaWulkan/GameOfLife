// 1. Any live cell with fewer than two live neighbors dies, as if caused by
// underpopulation.
// 2. Any live cell with more than three live neighbors dies, as if by
// overcrowding.
// 3. Any live cell with two or three live neighbors lives on to the next
// generation.
// 4. Any dead cell with exactly three live neighbors becomes a live cell.

public class GameOfLifeTest {
    // TODO liveCellDiesDueToUnderpopulation: live neighbors < 2

    // TODO liveCellDiesDueToOvercrowding: live neighbors > 3

    // TODO liveCellLivesOnToNextGeneration: live neighbors = 2 or 3

    // TODO deadCellComesToLife: live neighbors = 3
}
