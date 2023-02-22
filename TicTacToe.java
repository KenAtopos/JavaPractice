import java.util.Scanner;

public class TicTacToe {

  static Scanner scan = new Scanner(System.in);

  public static void main(String[] args) {

    System.out.println("\nLet's play tic tac toe");

    // Task 1: Create an array with three rows of '_' characters.

    char[][] underscoreArray = new char[3][3];
    for (int i = 0; i < underscoreArray.length; i++) {
      for (int j = 0; j < underscoreArray[i].length; j++) {
        underscoreArray[i][j] = '_';
      }
    }

    // Task 2: Call the function printBoard();
    printBoard(underscoreArray);

    /*
     * { Task 3: Loop through turns.
     * 
     * if (X) turn {
     * Task 4: call askUser().
     * Task 5: populate the board using askUser's return value.
     * } else {
     * Task 4: call askUser().
     * Task 5: populate the board using askUser's return value. Then, print it.
     * 
     * }
     * 
     * Task 6 - Call the function.
     * if return value == 3 {
     * print: X wins and break the loop
     * } else if return value == -3 {
     * print: O wins and break the loop
     * }
     * 
     * }
     */

    for (int i = 0; i < 9; i++) {
      if (i % 2 == 0) {
        System.out.println("turn" + i + ": X");
        askUser(underscoreArray, 'X');
      } else {
        System.out.println("turn" + i + ": O");
        askUser(underscoreArray, 'O');
      }
      int result = checkWin(underscoreArray);
      if (result == 3) {
        System.out.println("X wins.");
      } else if (result == -3) {
        System.out.println("O wins.");
      }
    }

    scan.close();
  }

  /**
   * Task 2 - Write a function that prints the board.
   * Function name - printBoard()
   * 
   * @param board (char[][])
   * 
   *              Inside the function:
   *              1. print a new line.
   *              2. print the board.
   *              • separate each row by two lines.
   *              • each row precedes a tab of space
   *              • each character in the grid has one space from the other
   *              character
   */
  public static void printBoard(char[][] array) {
    System.out.println("\n");
    for (int i = 0; i < array.length; i++) {
      System.out.print("\t");

      for (int j = 0; j < array[i].length; j++) {
        System.out.print(array[i][j] + " ");
      }
      System.out.println("\n");
    }
  }

  /**
   * Task 4 - Write a function that lets the user choose a spot
   * Function name – askUser
   * 
   * @param board (char[][] board)
   * @return spot (int[])
   * 
   *         Inside the function
   *         1. Asks the user: - pick a row and column number:
   *         2. Check if the spot is taken. If so, let the user choose again.
   *         3. Return the row and column in an int[] array.
   * 
   */
  public static int[] askUser(char[][] board, char letter) {

    while (true) {

      System.out.println("pick a row and column number: (0 to 2)");
      int row = scan.nextInt();
      int column = scan.nextInt();

      if (board[row][column] == '_') {
        board[row][column] = letter;
        int[] spot = { row, column };
        printBoard(board);
        return spot;
      } else {
        System.out.println("Already been taken or out of range.");
        continue;
      }
    }

  }

  /**
   * Task 6 - Write a function that determines the winner
   * Function name - checkWin
   * 
   * @param board (char[][])
   * @return count (int)
   * 
   *         Inside the function:
   *         1. Make a count variable that starts at 0.
   *         2. Check every row for a straight X or straight O (Task 7).
   *         3. Check every column for a straight X or straight O (Task 8).
   *         4. Check the left diagonal for a straight X or straight O (Task 9).
   *         5. Check the right diagonal for a straight X or straight O (Task 10).
   */
  public static int checkWin(char[][] board) {

    // Check each of 3 rows
    int count = 0;

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] == 'X') {
          count++; // count each X as +1
        } else if (board[i][j] == 'O') {
          count--; // count each O as -1.
        }
      }
      if (count == 3 || count == -3) {
        return count;
      } else {
        count = 0;
      }

    }

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {

        if (board[j][i] == 'X') {
          count++; // count each X as +1
        } else if (board[j][i] == 'O') {
          count--; // count each O as -1.
        }
      }
      if (count == 3 || count == -3) {
        return count;
      } else {
        count = 0;
      }
    }

    for (int i = 0; i < 3; i++) {
      if (board[i][i] == 'X') {
        count++; // count each X as +1
      } else if (board[i][i] == 'O') {
        count--; // count each O as -1.
      }
    }

    if (count == 3 || count == -3) {
      return count;
    } else {
      count = 0;
    }

    for (int i = 0; i < 3; i++) {
      if (board[i][2 - i] == 'X') {
        count++; // count each X as +1
      } else if (board[i][2 - i] == 'O') {
        count--; // count each O as -1.
      }
    }

    return count;
  }

}
