package pl.kaczorowski.sudoku;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Board {

    private List<Row> rowList;

    public Board() {
        this.rowList = new ArrayList<>();
        for (int i = 0; i < Processor.SIZE; i++) {
            rowList.add(new Row());
        }
    }

    public List<Row> getRowList() {
        return rowList;
    }

    @Override
    public String toString() {
        return rowList.stream()
                .map(Row::toString)
                .collect(Collectors.joining("\n"));
    }


}
