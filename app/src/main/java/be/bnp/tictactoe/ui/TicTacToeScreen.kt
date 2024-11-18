package be.bnp.tictactoe.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import be.bnp.tictactoe.viewmodel.TicTacToeViewModel
import be.bnp.tictactoe.model.Player

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
                        val cellValue = viewModel.board[row][col]
                        Button(onClick = {  }) {
                            Text(text = if (cellValue == Player.EMPTY) "-" else cellValue.name)
                        }
                    }
                }
            }
        }
    }


}


