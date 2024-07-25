package bigjavaearlyobjectsexercisesprojects.chapterthirteen.programmingprojects.towerofhanoi;

import java.util.Stack;

public class Tower {

    private Stack<Disk> disks;

    public Tower() {
        disks = new Stack<>();
    }

    public void addDiskToTop(Disk disk) {
        disks.push(disk);
    }

    public Disk removeDiskFromTop() {
        return disks.pop();
    }

    public Disk checkTop() {
        return disks.peek();
    }

    public boolean isEmpty() {
        return disks.isEmpty();
    }

    public int getSize() {
        return disks.size();
    }

    @Override
    public String toString() {
        return disks.toString();
    }

}
