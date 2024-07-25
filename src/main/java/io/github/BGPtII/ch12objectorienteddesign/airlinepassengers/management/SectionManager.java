package io.github.BGPtII.ch12objectorienteddesign.airlinepassengers.management;

import io.github.BGPtII.ch12objectorienteddesign.airlinepassengers.seating.Section;

import java.util.List;

public class SectionManager {

    private List<Section> sections;

    public SectionManager(List<Section> sections) {
        this.sections = sections;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void addSection(Section section) {
        sections.add(section);
    }

    public void removeSection(Section section) {
        sections.remove(section);
    }

}
