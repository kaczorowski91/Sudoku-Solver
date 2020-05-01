package pl.kaczorowski.sudoku;

public class Algorithm {

    final private Board board;


    public Algorithm(Board board) {
        this.board = board;
    }

    public void solveSudoku() {
        for (int i = 0; i < (Processor.SIZE * Processor.SIZE); i++) {
            this.findValueInFieldColumnAndRow();
            this.findValueInOthersColumnAndRow();
            this.checkSudokuSolved();
        }
    }

    public boolean checkSudokuSolved() {
        for (int i = 0; i < Processor.SIZE; i++) {
            for (int j = 0; j < Processor.SIZE; j++) {
                if (board.getRowList().get(i).getElementList().get(j).getValue() == -1) {
                    return false;
                }
            }
        }
        return true;
    }

    public void findValueInFieldColumnAndRow() {

        boolean endSolution = false;

        while (!endSolution) {

            for (int i = 0; i < Processor.SIZE; i++) {

                for (int j = 0; j < Processor.SIZE; j++) {

                    boolean check1 = board.getRowList().get(i).getElementList().get(j).listToSolve.size() == 1;
                    boolean check2 = board.getRowList().get(i).getElementList().get(j).getValue() == -1;

                    if (check1 && check2) {
                        int solve = board.getRowList().get(i).getElementList().get(j).getListToSolve().get(0);
                        board.getRowList().get(i).getElementList().get(j).setValue(solve);

                        i = 0;
                        j = 0;
                        this.removeValueFromListToSolve();
                    }
                }
                endSolution = true;
            }
        }
    }

    public void findValueInOthersColumnAndRow() {// Find unique value, through reviewing other fields in row and column and check that, they may have this value. If other fields count have this value, put it in correct field.

        for (int i = 0; i < Processor.SIZE; i++) {  //Column number

            for (int j = 0; j < Processor.SIZE; j++) { //Row number

                if (board.getRowList().get(i).getElementList().get(j).getValue() == -1) {   // Check that field [i,j] is empty?

                    for (int k = 0; k < board.getRowList().get(i).getElementList().get(j).listToSolve.size(); k++) { // Loop for solveList in field

                        int valueToSolve = board.getRowList().get(i).getElementList().get(j).listToSolve.get(k);// Get value from solveList

                        int rowCounter = 0;
                        int columnCounter = 0;

                        for (int l = 0; l < Processor.SIZE; l++) {    //For every field in row

                            if (board.getRowList().get(i).getElementList().get(l).getListToSolve().contains(valueToSolve)) {//check for this value is unique value in row.
                                rowCounter++;
                            }
                        }
                        if (rowCounter == 1) {
                            board.getRowList().get(i).getElementList().get(j).setValue(valueToSolve);
                        }

                        for (int l = 0; l < Processor.SIZE; l++) {    //For every field in column

                            if (board.getRowList().get(l).getElementList().get(j).getListToSolve().contains(valueToSolve)) {//check for this value is unique value in row.
                                columnCounter++;
                                this.removeValueFromListToSolve();

                            }
                        }
                        if (columnCounter == 1) {
                            board.getRowList().get(i).getElementList().get(j).setValue(valueToSolve);
                            this.removeValueFromListToSolve();

                        }
                    }
                }
            }
        }
    }

    public void removeValueFromListToSolve() { //Remove correct value from solution list others fields in rows, columns and squares.

        for (int i = 0; i < Processor.SIZE; i++) {

            for (int j = 0; j < Processor.SIZE; j++) {

                boolean isFieldEmpty = board.getRowList().get(i).getElementList().get(j).getValue() == -1;
                Integer toRemove = board.getRowList().get(i).getElementList().get(j).getValue();

                if (!isFieldEmpty) {
                    board.getRowList().get(i).getElementList().get(j).listToSolve.clear();

                    for (int k = 0; k < Processor.SIZE; k++) {
                        board.getRowList().get(i).getElementList().get(k).listToSolve.remove(toRemove);
                        board.getRowList().get(k).getElementList().get(j).listToSolve.remove(toRemove);
                    }
                    if (i % 3 == 0 && j % 3 == 0) {
                        board.getRowList().get(i + 1).getElementList().get(j + 1).listToSolve.remove(toRemove);
                        board.getRowList().get(i + 1).getElementList().get(j + 2).listToSolve.remove(toRemove);
                        board.getRowList().get(i + 2).getElementList().get(j + 1).listToSolve.remove(toRemove);
                        board.getRowList().get(i + 2).getElementList().get(j + 2).listToSolve.remove(toRemove);
                    }
                    if (i % 3 == 0 && j % 3 == 1) {
                        board.getRowList().get(i + 1).getElementList().get(j - 1).listToSolve.remove(toRemove);
                        board.getRowList().get(i + 1).getElementList().get(j + 1).listToSolve.remove(toRemove);
                        board.getRowList().get(i + 2).getElementList().get(j - 1).listToSolve.remove(toRemove);
                        board.getRowList().get(i + 2).getElementList().get(j + 1).listToSolve.remove(toRemove);
                    }
                    if (i % 3 == 0 && j % 3 == 2) {
                        board.getRowList().get(i + 1).getElementList().get(j - 2).listToSolve.remove(toRemove);
                        board.getRowList().get(i + 1).getElementList().get(j - 1).listToSolve.remove(toRemove);
                        board.getRowList().get(i + 2).getElementList().get(j - 2).listToSolve.remove(toRemove);
                        board.getRowList().get(i + 2).getElementList().get(j - 1).listToSolve.remove(toRemove);
                    }
                    if (i % 3 == 1 && j % 3 == 0) {
                        board.getRowList().get(i - 1).getElementList().get(j + 1).listToSolve.remove(toRemove);
                        board.getRowList().get(i - 1).getElementList().get(j + 2).listToSolve.remove(toRemove);
                        board.getRowList().get(i + 1).getElementList().get(j + 1).listToSolve.remove(toRemove);
                        board.getRowList().get(i + 1).getElementList().get(j + 2).listToSolve.remove(toRemove);
                    }
                    if (i % 3 == 1 && j % 3 == 1) {
                        board.getRowList().get(i - 1).getElementList().get(j - 1).listToSolve.remove(toRemove);
                        board.getRowList().get(i - 1).getElementList().get(j + 1).listToSolve.remove(toRemove);
                        board.getRowList().get(i + 1).getElementList().get(j - 1).listToSolve.remove(toRemove);
                        board.getRowList().get(i + 1).getElementList().get(j + 1).listToSolve.remove(toRemove);
                    }
                    if (i % 3 == 1 && j % 3 == 2) {
                        board.getRowList().get(i - 1).getElementList().get(j - 2).listToSolve.remove(toRemove);
                        board.getRowList().get(i - 1).getElementList().get(j - 1).listToSolve.remove(toRemove);
                        board.getRowList().get(i + 1).getElementList().get(j - 2).listToSolve.remove(toRemove);
                        board.getRowList().get(i + 1).getElementList().get(j - 1).listToSolve.remove(toRemove);
                    }
                    if (i % 3 == 2 && j % 3 == 0) {
                        board.getRowList().get(i - 2).getElementList().get(j + 1).listToSolve.remove(toRemove);
                        board.getRowList().get(i - 2).getElementList().get(j + 2).listToSolve.remove(toRemove);
                        board.getRowList().get(i - 1).getElementList().get(j + 1).listToSolve.remove(toRemove);
                        board.getRowList().get(i - 1).getElementList().get(j + 2).listToSolve.remove(toRemove);
                    }
                    if (i % 3 == 2 && j % 3 == 1) {
                        board.getRowList().get(i - 2).getElementList().get(j - 1).listToSolve.remove(toRemove);
                        board.getRowList().get(i - 2).getElementList().get(j + 1).listToSolve.remove(toRemove);
                        board.getRowList().get(i - 1).getElementList().get(j - 1).listToSolve.remove(toRemove);
                        board.getRowList().get(i - 1).getElementList().get(j + 1).listToSolve.remove(toRemove);
                    }
                    if (i % 3 == 2 && j % 3 == 2) {
                        board.getRowList().get(i - 2).getElementList().get(j - 2).listToSolve.remove(toRemove);
                        board.getRowList().get(i - 2).getElementList().get(j - 1).listToSolve.remove(toRemove);
                        board.getRowList().get(i - 1).getElementList().get(j - 2).listToSolve.remove(toRemove);
                        board.getRowList().get(i - 1).getElementList().get(j - 1).listToSolve.remove(toRemove);
                    }
                }
            }
        }
    }

}