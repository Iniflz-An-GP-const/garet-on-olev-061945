package anuvix.garetonolev.hubapp.ui.composable.screen.game

import androidx.compose.ui.graphics.vector.ImageVector
import anuvix.garetonolev.hubapp.data.model.CARD_SYMBOL_COUNT
import anuvix.garetonolev.hubapp.ui.composable.screen.game.symbols.AppCardSymbols

val CardSymbols: List<ImageVector> = AppCardSymbols.also {
    check(it.size == CARD_SYMBOL_COUNT) { "A card symbol set must have CARD_SYMBOL_COUNT icons, got ${it.size}" }
}
