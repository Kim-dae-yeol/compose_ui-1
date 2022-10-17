@file:OptIn(ExperimentalMaterial3Api::class)

package com.kdy_soft.ui_coding.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.decode.ImageSource
import com.kdy_soft.ui_coding.R
import com.kdy_soft.ui_coding.ui.widget.SubtitleText
import com.kdy_soft.ui_coding.ui.widget.TitleText

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
) {
    val scrollState = rememberScrollState()
    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .scrollable(
                state = scrollState,
                orientation = Orientation.Vertical
            ),
        topBar = { MainTopBar() }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {

        }
    }
}

@Composable
fun MainTopBar(
    modifier: Modifier = Modifier,
    profilePainter: Painter = painterResource(id = R.drawable.ic_launcher_background),
    profileDesc: String? = null,
    welcomeMessage: String = "Welcome Back!",
    userName: String = "Faiza Mubarak"
) {

    Row(
        modifier
            .padding(top = 16.dp, start = 8.dp, end = 8.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row {
            //profile Image
            Image(
                painter = profilePainter,
                contentDescription = profileDesc,
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(8.dp))

            //welcome message
            Column(Modifier.width(IntrinsicSize.Max)) {
                TitleText(modifier = Modifier.fillMaxWidth(), text = welcomeMessage, maxLines = 1)
                SubtitleText(modifier = Modifier.fillMaxWidth(), text = userName, maxLines = 1)
            }
        }

        //notification
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Outlined.Notifications,
                contentDescription = stringResource(id = R.string.cd_notification)
            )
        }
    }
}

@Preview
@Composable
fun PreviewHomeScreen() {
    HomeScreen()
}