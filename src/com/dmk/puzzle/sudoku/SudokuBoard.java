package com.dmk.puzzle.sudoku;

public class SudokuBoard {
    private char[][] board;

    public SudokuBoard() {
        board = new char[][]
                {
                        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}
                };
    }

    public SudokuBoard(SudokuBoard original) {
        board = original.board.clone();
    }

    public void setCell(int x, int y, char value) {
        if (x < 0 || x > 8) {
            throw new IllegalArgumentException("X value must be between 0 and 8");
        }
        if (y < 0 || y > 8) {
            throw new IllegalArgumentException("X value must be between 0 and 8");
        }
        if (value != ' ' && (value < '1' || value > '9')) {
            throw new IllegalArgumentException("Illegal value '" + value + "'");
        }

        board[x][y] = value;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("+---+---+---+---+---+---+---+---+---+\n");
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                s.append("| ").append(board[i][j]).append(' ');
            }
            s.append("|\n");
            s.append("+---+---+---+---+---+---+---+---+---+\n");
        }
        return s.toString();
    }

    public boolean isValid() {
        return isValidRows() && isValidColumns() && isValidSquares();
    }

    private boolean isValidRows() {
        for (int row = 0; row < 9; ++row) {
            if (!isValidSet(board[row])) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidColumns() {
        for (int col = 0; col < 9; ++col) {
            if (!isValidSet(setFromColumn(col))) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidSquares() {
        for (int square = 0; square < 9; ++square) {
            if (!isValidSet(setFromSquare(square))) {
                return false;
            }
        }
        return true;
    }

    private char[] setFromColumn(int column) {
        return new char[] {board[column][0],board[column][1],board[column][2],board[column][3],board[column][4],
                board[column][5],board[column][6],board[column][7],board[column][8]};
    }

    private char[] setFromSquare(int square) {
        int startingRow = (square / 3) * 3;
        int startingCol = 0;
        switch (square) {
            case 1:
            case 4:
            case 7:
                startingCol = 3;
                break;
            case 2:
            case 5:
            case 8:
                startingCol = 6;
                break;
        }

        return new char[] {
                board[startingRow][startingCol],
                board[startingRow][startingCol + 1],
                board[startingRow][startingCol + 2],
                board[startingRow + 1][startingCol],
                board[startingRow + 1][startingCol + 1],
                board[startingRow + 1][startingCol + 2],
                board[startingRow + 2][startingCol],
                board[startingRow + 2][startingCol + 1],
                board[startingRow + 2][startingCol + 2],
        };
    }

    private boolean isValidSet(char [] set) {
        for (int i = 0; i < 8; ++i) {
            char c = set[i];
            if (c != ' ') {
                for (int j = i + 1; j < 9; ++j) {
                    if (c == set[j]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
