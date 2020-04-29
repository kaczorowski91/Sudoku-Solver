package pl.kaczorowski.sudoku;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Row {

    List<Element> elementList;
    List<Integer> listToSolve;

    public Row() {
        elementList = new ArrayList<>();
        for (int i = 0; i < Processor.SIZE; i++) {

            listToSolve = new ArrayList<>();
            for (int j = 0; j < Processor.SIZE; j++) {
                listToSolve.add(j + 1);
            }
            elementList.add(new Element(Element.EMPTY, listToSolve));
        }
    }

    public Row(List<Element> sudokuElementList) {
        this.elementList = sudokuElementList;
    }


    public List<Element> getElementList() {
        return elementList;
    }


    @Override
    public String toString() {
        return elementList.stream()
                .map(Element::toString)
                .collect(Collectors.joining(" | "));
    }
}
