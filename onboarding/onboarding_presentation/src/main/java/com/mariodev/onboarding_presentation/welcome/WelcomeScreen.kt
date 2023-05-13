package com.mariodev.onboarding_presentation.welcome

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.mariodev.core.navigation.Route
import com.mariodev.core.util.UiEvent
import com.mariodev.coreui.LocalSpacing
import com.mariodev.onboarding_presentation.components.ActionButton

@Composable
fun WelcomeScreen(
    onNavigate: (UiEvent.Navigate) -> Unit
) {
    val spacing = LocalSpacing.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(spacing.spaceMedium),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = core.R.string.welcome_text),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h1
        )
        Spacer(modifier = androidx.compose.ui.Modifier.height(spacing.spaceMedium))
        ActionButton(
            text = stringResource(id = core.R.string.next),
            onClick = { onNavigate(UiEvent.Navigate(Route.GENDER)) },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}