package pl.kaczorowski.sudoku;

import java.util.Scanner;

public class Processor {

    private final Board board;
    private final Algorithm algorithm;

    private boolean endChangeValue = false;
    private boolean endLoop = false;
    private String sudoku = "SUDOKU";
    public static int SIZE = 9;


    Scanner scanner = new Scanner(System.in);

    public Processor() {
        this.board = new Board();
        this.algorithm = new Algorithm(board);
    }

    public void game() {
        this.openGame();
        while (!this.endLoop) {
            this.loopGame();
        }
    }

    public void loopGame() {
        while (!this.endChangeValue)
            this.changeValue();

        if (algorithm.checkSudokuSolved()) {
            System.out.println("SOLUTION:");
            System.out.println(board);
            endLoop = true;
        } else {
            System.out.println("Too little data to find a solution.");
            System.out.println("If you want entry more data press 1");
            System.out.println("If you want complete board random data press 2");
            System.out.println("If you want quit press 3");
            String userInput = scanner.nextLine();

            if (userInput.equals("1")) {
                System.out.println("You can continue entering data: ");
                this.endChangeValue = false;

            } else if (userInput.equals("2")) {
                Board copyBoard = algorithm.createDeepCopy();
                algorithm.createRandomData();


            } else if (userInput.equals("3")) {
                System.out.println(3);
                System.out.println("Sudoku Solver ended work ");
                System.out.println("Bye bye, see you next time :)");
                this.endChangeValue = true;
                this.endLoop = true;

            }
        }
    }

    public void openGame() {
        System.out.println("Welcome in Sudoku Solution Program:");
        System.out.println("Instruction:\nIf you want solve sudoku, enter data first.");
        System.out.println("First number-column, Second number-row, Third number - value");
        System.out.println("For example 3 5 4  3-column number, 5-row number, 4-value in SUDOKU");
        System.out.println("When data are complete, write 'SUDOKU' to get solution of sudoku");
        System.out.println(board + "\n");
    }


    public void changeValue() {
        String userInput = scanner.nextLine();
        String userInputToUpperCase = userInput.toUpperCase();

        try {
            if (userInputToUpperCase.equals(sudoku)) {
                algorithm.solveSudoku();
                this.endChangeValue = true;
            } else {

                String[] splitValue = userInput.split(" ");

                int column = Integer.parseInt(splitValue[0]);
                int row = Integer.parseInt(splitValue[1]);
                int value = Integer.parseInt(splitValue[2]);

                board.getRowList().get(column - 1).getElementList().get(row - 1).setValue(value);
                System.out.println("Your values have been entered into sudoku. Column " + column + " Row " + row + " Value " + value);
                System.out.println(board);
            }
        } catch (NumberFormatException e) {
            System.out.println("The entered value is not correct. If you want solve sudoku-please write SUDOKU, " +
                    "If you want complete fields, please write: number of Column, number of Row, value in field");
        }

    }
}

