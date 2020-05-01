package pl.kaczorowski.sudoku;


import org.junit.Assert;
import org.junit.Test;

public class SudokuTestSuite {

    @Test
    public void exampleSolutionTest() {
        //Given
        Board sudokuBoard = new Board();
        Algorithm algorithm = new Algorithm(sudokuBoard);

        //Then
        System.out.println("Sudoku board, before entered data");
        System.out.println(sudokuBoard+"\n");

        sudokuBoard.getRowList().get(0).getElementList().get(0).setValue(2);
        sudokuBoard.getRowList().get(0).getElementList().get(2).setValue(6);
        sudokuBoard.getRowList().get(0).getElementList().get(3).setValue(8);
        sudokuBoard.getRowList().get(0).getElementList().get(4).setValue(3);
        sudokuBoard.getRowList().get(0).getElementList().get(7).setValue(1);
        sudokuBoard.getRowList().get(1).getElementList().get(0).setValue(5);
        sudokuBoard.getRowList().get(1).getElementList().get(3).setValue(7);
        sudokuBoard.getRowList().get(1).getElementList().get(6).setValue(4);
        sudokuBoard.getRowList().get(1).getElementList().get(7).setValue(2);
        sudokuBoard.getRowList().get(2).getElementList().get(0).setValue(1);
        sudokuBoard.getRowList().get(2).getElementList().get(3).setValue(9);
        sudokuBoard.getRowList().get(2).getElementList().get(4).setValue(2);
        sudokuBoard.getRowList().get(2).getElementList().get(6).setValue(8);
        sudokuBoard.getRowList().get(2).getElementList().get(7).setValue(7);
        sudokuBoard.getRowList().get(2).getElementList().get(8).setValue(6);
        sudokuBoard.getRowList().get(3).getElementList().get(0).setValue(9);
        sudokuBoard.getRowList().get(3).getElementList().get(4).setValue(1);
        sudokuBoard.getRowList().get(3).getElementList().get(5).setValue(7);
        sudokuBoard.getRowList().get(3).getElementList().get(7).setValue(5);
        sudokuBoard.getRowList().get(4).getElementList().get(1).setValue(5);
        sudokuBoard.getRowList().get(4).getElementList().get(3).setValue(3);
        sudokuBoard.getRowList().get(5).getElementList().get(0).setValue(3);
        sudokuBoard.getRowList().get(5).getElementList().get(1).setValue(2);
        sudokuBoard.getRowList().get(5).getElementList().get(5).setValue(8);
        sudokuBoard.getRowList().get(5).getElementList().get(6).setValue(6);
        sudokuBoard.getRowList().get(5).getElementList().get(8).setValue(1);
        sudokuBoard.getRowList().get(6).getElementList().get(1).setValue(4);
        sudokuBoard.getRowList().get(6).getElementList().get(2).setValue(2);
        sudokuBoard.getRowList().get(6).getElementList().get(4).setValue(5);
        sudokuBoard.getRowList().get(6).getElementList().get(7).setValue(3);
        sudokuBoard.getRowList().get(7).getElementList().get(1).setValue(9);
        sudokuBoard.getRowList().get(7).getElementList().get(3).setValue(4);
        sudokuBoard.getRowList().get(7).getElementList().get(4).setValue(7);
        sudokuBoard.getRowList().get(7).getElementList().get(5).setValue(3);
        sudokuBoard.getRowList().get(8).getElementList().get(1).setValue(1);
        sudokuBoard.getRowList().get(8).getElementList().get(2).setValue(3);
        sudokuBoard.getRowList().get(8).getElementList().get(4).setValue(8);
        sudokuBoard.getRowList().get(8).getElementList().get(5).setValue(2);
        sudokuBoard.getRowList().get(8).getElementList().get(6).setValue(9);
        sudokuBoard.getRowList().get(8).getElementList().get(8).setValue(5);

        System.out.println("Sudoku board, with entered date");
        System.out.println(sudokuBoard);
        System.out.println();
        algorithm.solveSudoku();
        System.out.println("Sudoku board, after solve algorithm");
        System.out.println(sudokuBoard);
        /*  Data to copy sudoku, after program run. Please remember copy with last line with enter
1 1 2
1 3 6
1 4 8
1 5 3
1 8 1
2 1 5
2 4 7
2 7 4
2 8 2
3 1 1
3 4 9
3 5 2
3 7 8
3 8 7
3 9 6
4 1 9
4 5 1
4 6 7
4 8 5
5 2 5
5 4 3
6 1 3
6 2 2
6 6 8
6 7 6
6 9 1
7 2 4
7 3 2
7 5 5
7 8 3
8 2 9
8 4 4
8 5 7
8 6 3
9 2 1
9 3 3
9 5 8
9 6 2
9 7 9
9 9 5
        */
        //When
        Assert.assertEquals(1, sudokuBoard.getRowList().get(0).getElementList().get(1).getValue());
        Assert.assertEquals(9, sudokuBoard.getRowList().get(1).getElementList().get(2).getValue());
        Assert.assertEquals(3, sudokuBoard.getRowList().get(2).getElementList().get(1).getValue());
        Assert.assertEquals(4, sudokuBoard.getRowList().get(3).getElementList().get(8).getValue());
        Assert.assertEquals(9, sudokuBoard.getRowList().get(4).getElementList().get(4).getValue());
        Assert.assertEquals(7, sudokuBoard.getRowList().get(5).getElementList().get(2).getValue());
        Assert.assertEquals(8, sudokuBoard.getRowList().get(6).getElementList().get(8).getValue());
        Assert.assertEquals(1, sudokuBoard.getRowList().get(7).getElementList().get(6).getValue());
        Assert.assertEquals(4, sudokuBoard.getRowList().get(8).getElementList().get(7).getValue());

    }
}