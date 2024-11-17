package be.bnp.tictactoe.viewmodel


import androidx.compose.runtime.mutableStateOf
import be.bnp.tictactoe.model.Player
import be.bnp.tictactoe.model.TicTacToeState

class TicTacToeViewModel {
    private val gameState = mutableStateOf(TicTacToeState())

    val board: Array<Array<Player>>
        get() = gameState.value.board
    val currentPlayer: Player
        get() =
            if (gameState.value.moveCount == 9) Player.DRAW
            else if (gameState.value.moveCount % 2 == 0) Player.X
            else Player.O



    fun onBoardClick(row: Int, col: Int) {
        if(board[row][col] == Player.EMPTY) {
            val newBoard = gameState.value.board.copyOf()
            newBoard[row][col] = currentPlayer
            gameState.value = gameState.value.copy(
                board = newBoard,
                moveCount = gameState.value.moveCount + 1
            )
        }
    }

    fun onResetClick() {
        gameState.value = TicTacToeState()
    }
}