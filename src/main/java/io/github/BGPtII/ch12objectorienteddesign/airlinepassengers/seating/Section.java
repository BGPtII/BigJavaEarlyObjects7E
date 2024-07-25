package io.github.BGPtII.ch12objectorienteddesign.airlinepassengers.seating;

import java.util.List;

public class Section {

    private List<Row> rows;
    private SectionClass sectionClass;

    public Section(List<Row> rows, SectionClass sectionClass) {
        this.rows = rows;
        this.sectionClass = sectionClass;
    }

    public List<Row> getRows() {
        return rows;
    }

    public SectionClass getSectionClass() {
        return sectionClass;
    }

}
