package be.bnp.tictactoe.viewmodel


import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import be.bnp.tictactoe.model.Player
import be.bnp.tictactoe.model.TicTacToeState

class TicTacToeViewModel: ViewModel() {
    private val gameState = mutableStateOf(TicTacToeState())

    val state: State<TicTacToeState> = gameState

    val board: Array<Array<Player>>
        get() = state.value.board

    val currentPlayer: Player
        get() = if (state.value.moveCount == 9) Player.DRAW
                else if (state.value.moveCount % 2 == 0) Player.X
                else Player.O

    val winner: Player
        get() = state.value.winner

    fun onBoardClick(row: Int, col: Int) {
        if(board[row][col] == Player.EMPTY) {
            val newBoard = gameState.value.board.copyOf()
            newBoard[row][col] = currentPlayer

            gameState.value = gameState.value.copy(
                board = newBoard,
                moveCount = gameState.value.moveCount + 1,
                winner = checkWin(row, col)
            )
        }
    }

    private fun checkWin(row: Int, col: Int): Player {
        val board = gameState.value.board

        // Check row
        if(board[row][0] == board[row][1]
            && board[row][0] == board[row][2]) {
            return currentPlayer
        }

        // Check column

        if(board[0][col] == board[1][col]
            && board[0][col] == board[2][col]) {
            return currentPlayer
        }

        // check diagonal

        if(row == col) {
            if(board[0][0] == board[1][1]
                && board[0][0] == board[2][2]) {
                return currentPlayer
            }
        }

        // check second diagonal

        if(row + col == 2) {
            if(board[0][2] == board[1][1]
                && board[0][2] == board[2][0]) {
                return currentPlayer
            }
        }

        if (board[row].all { it == currentPlayer }) {
            return currentPlayer
        }

        // No winner
        return Player.EMPTY
    }

    fun onResetClick() {
        gameState.value = TicTacToeState()
    }
}