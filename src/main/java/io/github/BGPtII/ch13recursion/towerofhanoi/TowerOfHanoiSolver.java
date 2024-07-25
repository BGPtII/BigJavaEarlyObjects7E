package bigjavaearlyobjectsexercisesprojects.chapterthirteen.programmingprojects.towerofhanoi;

import java.util.ArrayList;

public class TowerOfHanoiSolver {

    private TowerOfHanoi puzzle;
    private ArrayList<String> visualizedMoves;
    private int moveIndex;

    public TowerOfHanoiSolver(TowerOfHanoi puzzle) {
        this.puzzle = puzzle;
        visualizedMoves = new ArrayList<>();
        moveIndex = 0;
        solve(puzzle.getDiskCount(), 0, 2, 1);
    }

    public boolean hasMoreMoves() {
        return moveIndex < visualizedMoves.size();
    }

    public String getNextMove() {
        if (hasMoreMoves()) {
            return visualizedMoves.get(moveIndex++);
        }
        return null;
    }

    private void solve(int diskCount, int fromTowerIndex, int toTowerIndex, int auxTowerIndex) {
        if (diskCount == 1) {
            Disk movedDisk = puzzle.moveDisk(fromTowerIndex, toTowerIndex);
            if (movedDisk != null) {
                visualizedMoves.add("Moved disk " + movedDisk.getSize() + " from tower " + (fromTowerIndex + 1) + " to tower " + (toTowerIndex + 1) + ".");
                visualizedMoves.add(puzzle.getStringRepresentation());
            }
            return;
        }
        solve(diskCount - 1, fromTowerIndex, auxTowerIndex, toTowerIndex);
        Disk movedDisk = puzzle.moveDisk(fromTowerIndex, toTowerIndex);
        if (movedDisk != null) {
            visualizedMoves.add("Moved disk " + movedDisk.getSize() + " from tower " + (fromTowerIndex + 1) + " to tower " + (toTowerIndex + 1) + ".");
            visualizedMoves.add(puzzle.getStringRepresentation());
        }
        solve(diskCount - 1, auxTowerIndex, toTowerIndex, fromTowerIndex);
    }

    public static void main(String[] args) {
        TowerOfHanoi puzzle1 = new TowerOfHanoi(3);
        System.out.println(puzzle1.getStringRepresentation());
        TowerOfHanoiSolver solver1 = new TowerOfHanoiSolver(puzzle1);
        while (solver1.hasMoreMoves()) {
            System.out.println(solver1.getNextMove());
        }
        System.out.println();

        TowerOfHanoi puzzle2 = new TowerOfHanoi(6);
        System.out.println(puzzle2.getStringRepresentation());
        TowerOfHanoiSolver solver2 = new TowerOfHanoiSolver(puzzle2);
        while (solver2.hasMoreMoves()) {
            System.out.println(solver2.getNextMove());
        }

    }

}
