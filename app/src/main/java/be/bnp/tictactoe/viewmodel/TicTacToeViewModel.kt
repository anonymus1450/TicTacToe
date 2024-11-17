package be.bnp.tictactoe.viewmodel


import be.bnp.tictactoe.model.Player
import be.bnp.tictactoe.model.TicTacToeState

class TicTacToeViewModel {
    private val gameState: TicTacToeState = TicTacToeState()
    val currentPlayer: Player
        get() = if (gameState.moveCount % 2 == 0) Player.X else Player.X
}