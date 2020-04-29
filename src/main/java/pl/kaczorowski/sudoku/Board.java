package pl.kaczorowski.sudoku;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Board extends Prototype {


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

    public void setRowList(List<Row> rowList) {
        this.rowList = rowList;
    }

    @Override
    public String toString() {
        return rowList.stream()
                .map(Row::toString)
                .collect(Collectors.joining("\n"));
    }

    public Board deepCopy() throws CloneNotSupportedException {
        Board clonedSudokuBoard = (Board) super.clone();
        clonedSudokuBoard.rowList = new ArrayList<>();

        for (Row theSudokuRowList : rowList) {
            Row clonedSudokuRowList = new Row();
            List<Element> clonedSudokuRowListElements = clonedSudokuRowList.getElementList();
            for (int i = 0; i < clonedSudokuRowListElements.size(); i++) {
                Element elementToCopy = theSudokuRowList.getElementList().get(i);
                clonedSudokuRowListElements.get(i).setValue(elementToCopy.getValue());
            }
            clonedSudokuBoard.getRowList().add(clonedSudokuRowList);
        }
        return clonedSudokuBoard;

    }
}
