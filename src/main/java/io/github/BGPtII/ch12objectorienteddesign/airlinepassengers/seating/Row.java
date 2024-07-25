package io.github.BGPtII.ch12objectorienteddesign.airlinepassengers.seating;

import java.util.List;

public class Row {

    private List<RowPartition> rowPartitions;

    public Row(List<RowPartition> rowPartitions) {
        this.rowPartitions = rowPartitions;
    }

    public List<RowPartition> getRowPartitions() {
        return rowPartitions;
    }

}
