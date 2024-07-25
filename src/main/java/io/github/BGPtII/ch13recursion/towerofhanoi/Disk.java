package bigjavaearlyobjectsexercisesprojects.chapterthirteen.programmingprojects.towerofhanoi;

public class Disk {

    /**
     * In order from largest to smallest
     */
    private static int nextDiskSize = 0;
    private int size;

    public Disk() {
        size = nextDiskSize++;
    }

    public int getSize() {
        return size;
    }

    public static void resetDiskSize() {
        nextDiskSize = 0;
    }

    @Override
    public String toString() {
        return "(" + getSize() + ")";
    }

}
