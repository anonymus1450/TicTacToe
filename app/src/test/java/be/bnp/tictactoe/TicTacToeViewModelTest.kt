package be.bnp.tictactoe

import be.bnp.tictactoe.model.Player
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class TicTacToeViewModelTest() {

    private lateinit var viewModel: TicTacToeViewModel

    @Before
    fun setUp() {
        viewModel = TicTacToeViewModel()
    }

    @Test
    fun when_gameStarts_then_XPlaysFirst() {
        assertEquals(Player.X, viewModel.currentPlayer)
    }
}