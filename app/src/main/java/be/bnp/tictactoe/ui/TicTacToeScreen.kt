package be.bnp.tictactoe.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import be.bnp.tictactoe.model.Player
import be.bnp.tictactoe.viewmodel.TicTacToeViewModel

@Composable
fun TicTacToeScreen(
    modifier: Modifier = Modifier,
    viewModel: TicTacToeViewModel = TicTacToeViewModel()

) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Player ${viewModel.currentPlayer}'s turn",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Center
        )

        Column {
            for (row in 0..2) {
                Row {
                    for (col in 0..2) {
                        val buttonText = when (viewModel.board[row][col]) {
                            Player.X -> "X"
                            Player.O -> "O"
                            else -> "-"
                        }
                        BoardButton(
                            modifier = Modifier.size(80.dp).padding(4.dp),
                            text = buttonText,
                            onClick = { viewModel.onBoardClick(row, col) },
                            tag = "$col, $row"
                        )
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(32.dp))
        Button(onClick = {
            viewModel.onResetClick()
        }) {
            Text(text = "Reset Game")
        }
    }

}

@Composable
fun BoardButton(
    modifier: Modifier,
    text: String,
    onClick: () -> Unit,
    tag: String
) {
    Button(
        onClick = onClick,
        modifier = modifier.testTag(tag)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.headlineMedium
        )
    }
}


