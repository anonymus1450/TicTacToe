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
        composeTestRule.onNodeWithTag("0, 0").performClick()

        composeTestRule.onNodeWithTag("0, 0").assertTextEquals("X")
        composeTestRule.onNodeWithText("Player O's turn").assertExists()

        composeTestRule.onNodeWithTag("0, 1").performClick()

        composeTestRule.onNodeWithTag("0, 1").assertTextEquals("O")
        composeTestRule.onNodeWithText("Player X's turn").assertExists()
    }



}
