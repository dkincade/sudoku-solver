package com.dmk.puzzle.sudoku;

public class Sudoku {
    public static void main(String [] args) {
        SudokuBoard initialBoard = new SudokuBoard();
        initialBoard.setCell(0, 2, '7');
        initialBoard.setCell(0, 3, '4');
        initialBoard.setCell(0, 7, '1');
        initialBoard.setCell(0, 8, '9');
        initialBoard.setCell(1, 0, '4');
        initialBoard.setCell(1, 3, '1');
        initialBoard.setCell(1, 4, '2');
        initialBoard.setCell(1, 5, '9');
        initialBoard.setCell(1, 7, '3');
        initialBoard.setCell(2, 5, '3');
        initialBoard.setCell(2, 6, '4');
        initialBoard.setCell(2, 8, '8');
        initialBoard.setCell(4, 5, '7');
        initialBoard.setCell(4, 8, '1');
        initialBoard.setCell(5, 0, '7');
        initialBoard.setCell(5, 1, '6');
        initialBoard.setCell(5, 2, '9');
        initialBoard.setCell(6, 5, '8');
        initialBoard.setCell(6, 6, '1');
        initialBoard.setCell(6, 7, '9');
        initialBoard.setCell(6, 8, '4');
        initialBoard.setCell(7, 1, '3');
        initialBoard.setCell(7, 8, '7');
        initialBoard.setCell(8, 0, '8');
        initialBoard.setCell(8, 1, '4');
        initialBoard.setCell(8, 2, '1');
        initialBoard.setCell(8, 3, '7');
        initialBoard.setCell(8, 8, '3');

        System.out.println(initialBoard);
        System.out.println("isValid() = " + initialBoard.isValid());
    }
}
