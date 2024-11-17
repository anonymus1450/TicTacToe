package be.bnp.tictactoe

import be.bnp.tictactoe.model.Player
import be.bnp.tictactoe.viewmodel.TicTacToeViewModel
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class TicTacToeViewModelTest{

    private lateinit var viewModel: TicTacToeViewModel

    @Before
    fun setUp() {
        viewModel = TicTacToeViewModel()
    }

    @Test
    fun when_gameStarts_then_XPlaysFirst() {
        assertEquals(Player.X, viewModel.currentPlayer)
    }

    @Test
    fun when_XPlays_then_XIsMarked_And_OPlays(){
        viewModel.onBoardClick(0,0)
        assertEquals(Player.O, viewModel.currentPlayer)
        assertEquals(viewModel.board[0][0], Player.X)
        viewModel.onBoardClick(0,1)
        assertEquals(Player.X, viewModel.currentPlayer)
        assertEquals(viewModel.board[0][1], Player.O)
    }

    @Test
    fun when_boardButtonIsClicked_then_boardButtonShouldBePlayable() {
        viewModel.onBoardClick(0,0)
        viewModel.onBoardClick(0,0)
        assertEquals(Player.X, viewModel.board[0][0])
        assertEquals(Player.O, viewModel.currentPlayer)
    }

    @Test
    fun when_resetGameButtonIsClicked_then_gameShouldBeReset() {
        viewModel.onBoardClick(0,0)
        viewModel.onBoardClick(0,1)
        viewModel.onResetClick()
        assertEquals(viewModel.board[0][0], Player.EMPTY)
        assertEquals(viewModel.board[0][1], Player.EMPTY)
        assertEquals(Player.X, viewModel.currentPlayer)
    }

    @Test
    fun when_boardIsFilledAndNoWinnerDetected_then_shouldBeDraw() {
        viewModel.onBoardClick(0,0) // X
        viewModel.onBoardClick(0,1) // O
        viewModel.onBoardClick(1,0) // X
        viewModel.onBoardClick(2,0) // O
        viewModel.onBoardClick(1,1) // X
        viewModel.onBoardClick(2,2) // O
        viewModel.onBoardClick(0,2) // X
        viewModel.onBoardClick(2,1) // O
        viewModel.onBoardClick(1,2) // X

        assertEquals(Player.DRAW, viewModel.currentPlayer)
    }

}