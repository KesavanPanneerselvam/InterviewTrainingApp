package com.interview.interviewtrainingapp.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.interview.interviewtrainingapp.ui.components.BaseScreen
import com.interview.interviewtrainingapp.ui.components.CardLayout
import com.interview.interviewtrainingapp.ui.components.ColumnSpaceMedium
import com.interview.interviewtrainingapp.ui.components.LabelContent
import com.interview.interviewtrainingapp.ui.components.LabelHeading
import com.interview.interviewtrainingapp.utils.UIState
import com.interview.interviewtrainingapp.utils.getColors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel(), navController: NavHostController) {

    BaseScreen(viewModel = viewModel, isScrollable = true) {

        when (val result = viewModel.userItems.collectAsState().value) {
            is UIState.Success -> {
                result.data.forEach {
                    CardLayout {
                        Row {
                            Image(
                                painter = rememberAsyncImagePainter("https://picsum.photos/id/${it.id}/180/180"),
                                contentDescription = null,
                                modifier = Modifier
                                    .height(90.dp)
                                    .width(90.dp)
                                    .shadow(elevation = 8.dp, RoundedCornerShape(64.dp))
                            )
                            Column(modifier = Modifier.padding(16.dp)) {
                                LabelHeading(it.name)
                                LabelContent(it.address)
                                LabelContent(it.country)
                            }
                        }
                    }
                    ColumnSpaceMedium()
                }
            }

            else -> {}
        }
    }
}