package be.bnp.tictactoe.model


data class TicTacToeState (
    val board: Array<Array<Player>> = Array(3) {Array(3) { Player.EMPTY }},
    val moveCount: Int = 0
) {}