import javax.swing.*;
import java.awt.*;

public class TicTacToeApp extends JFrame {
    private enum Cell { X, O, EMPTY }
    private final Cell[][] board = new Cell[3][3];
    private boolean xTurn = true;
    private final JButton[][] buttons = new JButton[3][3];

    public TicTacToeApp() {
        setTitle("TicTacToe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLayout(new GridLayout(3, 3));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = Cell.EMPTY;
                JButton btn = new JButton("");
                buttons[i][j] = btn;
                int row = i, col = j;
                btn.addActionListener(e -> Move(row, col));
                add(btn);
            }
        }
    }

    private void Move(int row, int col) {
        if (board[row][col] != Cell.EMPTY) return;
        board[row][col] = xTurn ? Cell.X : Cell.O;
        buttons[row][col].setText(xTurn ? "X" : "O");
        Cell winner = checkWinner();
        if (winner != null) {
            JOptionPane.showMessageDialog(this, "Победил игрок: " + (winner == Cell.X ? "1" : "2"));
            resetGame();
        } else if (isDraw()) {
            JOptionPane.showMessageDialog(this, "Ничья");
            resetGame();
        } else {
            xTurn = !xTurn;
        }
    }

    private Cell checkWinner() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != Cell.EMPTY &&
                    board[i][0] == board[i][1] && board[i][1] == board[i][2])
                return board[i][0];
            if (board[0][i] != Cell.EMPTY &&
                    board[0][i] == board[1][i] && board[1][i] == board[2][i])
                return board[0][i];
        }
        if (board[0][0] != Cell.EMPTY &&
                board[0][0] == board[1][1] && board[1][1] == board[2][2])
            return board[0][0];
        if (board[0][2] != Cell.EMPTY &&
                board[0][2] == board[1][1] && board[1][1] == board[2][0])
            return board[0][2];
        return null;
    }

    private boolean isDraw() {
        if (checkWinner() != null) return false;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j] == Cell.EMPTY)
                    return false;
        return true;
    }

    private void resetGame() {
        xTurn = true;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                board[i][j] = Cell.EMPTY;
                buttons[i][j].setText("");
            }
    }

    static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TicTacToeApp game = new TicTacToeApp();
            game.setVisible(true);
        });
    }
}
