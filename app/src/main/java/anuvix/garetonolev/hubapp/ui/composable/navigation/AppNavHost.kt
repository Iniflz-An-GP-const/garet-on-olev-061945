package anuvix.garetonolev.hubapp.ui.composable.navigation

import androidx.activity.compose.LocalActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import anuvix.garetonolev.hubapp.ui.composable.screen.about.AXOVPAboutScreen
import anuvix.garetonolev.hubapp.ui.composable.screen.game.AXOVPGameScreen
import anuvix.garetonolev.hubapp.ui.composable.screen.high_scores.AXOVPHighScoresScreen
import anuvix.garetonolev.hubapp.ui.composable.screen.main_menu.AXOVPMainMenuScreen
import anuvix.garetonolev.hubapp.ui.composable.screen.splash.AXOVPSplashScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    val activity = LocalActivity.current

    NavHost(
        navController = navController,
        startDestination = NavRoute.Splash,
        modifier = modifier,
    ) {
        composable<NavRoute.Splash> {
            AXOVPSplashScreen(
                onMainMenuScreenNavigation = {
                    navController.navigate(route = NavRoute.MainMenu) {
                        popUpTo(navController.graph.startDestinationId) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                }
            )
        }

        composable<NavRoute.MainMenu> {
            AXOVPMainMenuScreen(
                onPlayClick = { difficulty ->
                    navController.navigate(
                        route = NavRoute.Game(
                            difficulty
                        )
                    )
                },
                onHighScoresScreenNavigation = { navController.navigate(route = NavRoute.HighScores) },
                onAboutScreenNavigation = { navController.navigate(route = NavRoute.About) },
                onExit = { activity?.finishAffinity() }
            )
        }

        composable<NavRoute.Game> { backStackEntry ->
            val route = backStackEntry.toRoute<NavRoute.Game>()
            AXOVPGameScreen(
                difficulty = route.difficulty,
                onMainMenu = {
                    navController.navigate(route = NavRoute.MainMenu) {
                        popUpTo(NavRoute.MainMenu) {
                            inclusive = true
                        }
                    }
                },
                onBackClick = { navController.popBackStack() }
            )
        }

        composable<NavRoute.About> {
            AXOVPAboutScreen(onBackClick = { navController.popBackStack() })
        }

        composable<NavRoute.HighScores> {
            AXOVPHighScoresScreen(onBackClick = { navController.popBackStack() })
        }
    }
}
