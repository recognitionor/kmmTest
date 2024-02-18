package com.jhlee.kmmtest.ui.main

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.jhlee.kmmtest.ui.helper.LocalSafeArea
import com.jhlee.kmmtest.ui.main.components.MainContent
import com.jhlee.kmmtest.ui.main.components.MainModalDrawerSheet
import com.jhlee.kmmtest.ui.main.store.MainStore
import kotlinx.coroutines.launch

@Composable
internal fun MainScreen(component: MainComponent) {


    val state by component.state.collectAsState()

    val items = listOf("Home" to Icons.Outlined.Home, "Favorite" to Icons.Outlined.Favorite)
    var selectedItem by remember { mutableStateOf(items[0]) }

    LaunchedEffect(selectedItem) {
        if (selectedItem.first == "Favorite") {
            component.onOutput(MainComponent.Output.TestClicked)
        }
    }

    BoxWithConstraints {
        if (maxWidth > 1199.dp) {
            MainContentLarge(
                state = state,
                onEvent = component::onEvent,
                onOutput = component::onOutput,
                items = items,
                selectedItem = selectedItem,
                updateSelectedItem = { selectedItem = it }
            )
        } else {
            MainContentDefault(
                state = state,
                onEvent = component::onEvent,
                onOutput = component::onOutput,
                items = items,
                selectedItem = selectedItem,
                updateSelectedItem = { selectedItem = it }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun MainContentDefault(
    state: MainStore.State,
    onEvent: (MainStore.Intent) -> Unit,
    onOutput: (MainComponent.Output) -> Unit,
    items: List<Pair<String, ImageVector>>,
    selectedItem: Pair<String, ImageVector>,
    updateSelectedItem: (Pair<String, ImageVector>) -> Unit
) {
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(DrawerValue.Closed)

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            MainModalDrawerSheet(
                items = items,
                selectedItem = selectedItem,
                onItemsClick = { item ->
                    scope.launch { drawerState.close() }
                    updateSelectedItem(item)
                }
            )
        },
        content = {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = {},
                        navigationIcon = {
                            IconButton(
                                onClick = {
                                    scope.launch { drawerState.open() }
                                },
                            ) {
                                Icon(Icons.Rounded.Menu, contentDescription = null)
                            }
                        },
                        colors = TopAppBarDefaults.largeTopAppBarColors(
                            containerColor = MaterialTheme.colorScheme.background
                        )
                    )
                },
                modifier = Modifier.padding(LocalSafeArea.current)
            ) { paddingValues ->
                MainContent(
                    state = state,
                    onEvent = onEvent,
                    onOutput = onOutput,
                    modifier = Modifier.padding(paddingValues)
                )
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun MainContentLarge(
    state: MainStore.State,
    onEvent: (MainStore.Intent) -> Unit,
    onOutput: (MainComponent.Output) -> Unit,
    items: List<Pair<String, ImageVector>>,
    selectedItem: Pair<String, ImageVector>,
    updateSelectedItem: (Pair<String, ImageVector>) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        MainModalDrawerSheet(
            items = items,
            selectedItem = selectedItem,
            onItemsClick = { item ->
                updateSelectedItem(item)
            }
        )

        Scaffold(
            topBar = {
                TopAppBar(
                    title = {},
                    colors = TopAppBarDefaults.largeTopAppBarColors(
                        containerColor = MaterialTheme.colorScheme.background
                    )
                )
            },
            modifier = Modifier.padding(LocalSafeArea.current)
        ) { paddingValues ->
            MainContent(
                state = state,
                onEvent = onEvent,
                onOutput = onOutput,
                modifier = Modifier.padding(paddingValues)
            )
        }
    }
}