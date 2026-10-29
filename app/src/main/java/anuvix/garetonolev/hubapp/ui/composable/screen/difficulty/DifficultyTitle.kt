package anuvix.garetonolev.hubapp.ui.composable.screen.difficulty

import anuvix.garetonolev.hubapp.R
import anuvix.garetonolev.hubapp.data.model.Difficulty

fun Difficulty.titleRes(): Int = when (this) {
    Difficulty.Easy -> R.string.difficulty_easy
    Difficulty.Medium -> R.string.difficulty_medium
    Difficulty.Hard -> R.string.difficulty_hard
}
