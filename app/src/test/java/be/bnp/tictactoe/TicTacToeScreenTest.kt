package be.bnp.tictactoe

import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onNodeWithText
import be.bnp.tictactoe.ui.TicTacToeScreen
import be.bnp.tictactoe.viewmodel.TicTacToeViewModel
import org.junit.Rule
import org.junit.Test

class TicTacToeScreenTest {


    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun when_gameStarts_then_XPlaysFirst() {
        composeTestRule.setContent {
            TicTacToeScreen(viewModel = TicTacToeViewModel())
        }

        // Ensure it's X's turn
        composeTestRule
            .onNodeWithText("Player X's turn")
            .assertExists()

        // Ensure 9 buttons with "-"
        composeTestRule
            .onAllNodesWithText("-")
            .assertCountEquals(9)
    }
}