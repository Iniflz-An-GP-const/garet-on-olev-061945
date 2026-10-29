package anuvix.garetonolev.hubapp.ui.composable.approot.background.points

import androidx.compose.ui.unit.dp
import anuvix.garetonolev.hubapp.ui.composable.approot.background.BackgroundPattern
import anuvix.garetonolev.hubapp.ui.composable.approot.background.gridAnchors

/** Few large icons in a loose 3 x 5 grid — an airy backdrop. */
val AppBackgroundPattern = BackgroundPattern(
    anchors = gridAnchors(columns = 3, rows = 5),
    iconSize = 44.dp,
)
