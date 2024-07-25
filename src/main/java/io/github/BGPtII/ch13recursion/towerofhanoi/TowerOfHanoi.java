package bigjavaearlyobjectsexercisesprojects.chapterthirteen.programmingprojects.towerofhanoi;

public class TowerOfHanoi {

    private Tower[] towers;
    private int diskCount;

    /**
     * @param diskCount a higher value will be more resource intensive to solve - the minimum number of moves
     *                         required to solve te puzzle is 2^n - 1 (n being the number of disks); limited to 8 for
     *                           performance reasons, with a minimum of 2 (both inclusive)
     */
    public TowerOfHanoi(int diskCount) {
        if (diskCount < 2 || diskCount > 8) {
            throw new IllegalArgumentException("diskCount must be between 2 & 8 inclusive.");
        }
        this.diskCount = diskCount;
        initializeGame();
    }

    public int getDiskCount() {
        return diskCount;
    }

    /**
     * Initializes the game, the disks are all stacked on the first/leftmost tower
     */
    public void initializeGame() {
        towers = new Tower[3];
        for (int i = 0; i < 3; i++) {
            towers[i] = new Tower();
        }
        Disk[] disks = new Disk[diskCount];
        for (int i = 0; i < diskCount; i++) {
            disks[i] = new Disk();
            towers[0].addDiskToTop(disks[i]);
        }
        Disk.resetDiskSize();
    }

    public boolean isFinished() {
        return towers[0].isEmpty() && (towers[1].getSize() == diskCount || towers[2].getSize() == diskCount);
    }

    public String getStringRepresentation() {
        StringBuilder representation = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            representation.append("Tower ").append(i + 1).append(": ").append(towers[i].toString()).append(" ");
        }
        return representation.toString();
    }

    /**
     *
     * @param fromTower must be between 0 & 2 inclusive
     * @param toTower must be between 0 & 2 inclusive
     * @return if the move was successful or not
     */
    public Disk moveDisk(int fromTower, int toTower) {
        if (fromTower < 0 || fromTower > 2 || toTower < 0 || toTower > 2 || towers[fromTower].isEmpty()) {
            return null;
        }
        Disk diskToMove = towers[fromTower].checkTop();
        if (towers[toTower].isEmpty() || towers[toTower].checkTop().getSize() < diskToMove.getSize()) {
            diskToMove = towers[fromTower].removeDiskFromTop();
            towers[toTower].addDiskToTop(diskToMove);
            return diskToMove;
        }
        return null;
    }

}
