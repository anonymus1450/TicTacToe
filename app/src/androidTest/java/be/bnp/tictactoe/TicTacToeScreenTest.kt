package be.bnp.tictactoe

import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import be.bnp.tictactoe.ui.TicTacToeScreen
import be.bnp.tictactoe.viewmodel.TicTacToeViewModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class TicTacToeScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setUp() {
        composeTestRule.setContent {
            TicTacToeScreen(
                viewModel = TicTacToeViewModel()
            )
        }
    }

    @Test
    fun when_gameStarts_then_XPlaysFirst() {

        // Ensure it's X's turn
        composeTestRule
            .onNodeWithText("Player X's turn")
            .assertExists()

        // Ensure 9 buttons with "-"
        composeTestRule
            .onAllNodesWithText("-")
            .assertCountEquals(9)
    }

    @Test
    fun when_XPlays_then_XIsMarked_And_OShouldPlays() {
        // click on board[0,0]
        composeTestRule.onNodeWithTag("0, 0").performClick()

        // Ensure O is displayed board[0,0] and it's O's turn
        composeTestRule.onNodeWithTag("0, 0").assertTextEquals("X")
        composeTestRule.onNodeWithText("Player O's turn").assertExists()

        // click on board[0,1]
        composeTestRule.onNodeWithTag("0, 1").performClick()

        // Ensure O is displayed board[0,1] and it's X's turn
        composeTestRule.onNodeWithTag("0, 1").assertTextEquals("O")
        composeTestRule.onNodeWithText("Player X's turn").assertExists()
    }

    @Test
    fun when_boardButtonIsClicked_then_boardButtonShouldBePlayable() {
        // X clicks on board[0,0] then O clicks on board[0,0]
        composeTestRule.onNodeWithTag("0, 0").performClick()
        composeTestRule.onNodeWithTag("0, 0").performClick()

        // Ensure X is displayed board[0,0] and it's O's turn
        composeTestRule.onNodeWithTag("0, 0").assertTextEquals("X")
        composeTestRule.onNodeWithText("Player O's turn").assertExists()
    }

    @Test
    fun when_resetGameButtonIsClicked_then_gameShouldBeReset() {
        // click on board[0,0], then board[0,1], then restart game

        composeTestRule.onNodeWithTag("0, 0").performClick()
        composeTestRule.onNodeWithTag("0, 1").performClick()
        composeTestRule.onNodeWithText("Reset Game").performClick()

        composeTestRule.onNodeWithTag("0, 0").assertTextEquals("-")
        composeTestRule.onNodeWithTag("0, 1").assertTextEquals("-")

    }

    @Test
    fun when_boardIsFilledAndNoWinnerDetected_then_shouldBeDraw() {
        composeTestRule.onNodeWithTag("0, 0").performClick()
        composeTestRule.onNodeWithTag("0, 1").performClick()
        composeTestRule.onNodeWithTag("0, 2").performClick()
        composeTestRule.onNodeWithTag("1, 1").performClick()
        composeTestRule.onNodeWithTag("2, 1").performClick()
        composeTestRule.onNodeWithTag("1, 0").performClick()
        composeTestRule.onNodeWithTag("1, 2").performClick()
        composeTestRule.onNodeWithTag("2, 2").performClick()
        composeTestRule.onNodeWithTag("2, 0").performClick()

        composeTestRule.onNodeWithText("It's a draw").assertExists()

    }

}
