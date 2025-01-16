package br.com.brq.samplesdui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import br.com.brq.samplesdui.presentation.ButtonComposeBuilder
import br.com.brq.samplesdui.presentation.SampleSDUIComposeViewModel
import com.github.codandotv.craftd.compose.builder.CraftDBuilderManager
import com.github.codandotv.craftd.compose.ui.CraftDynamic

@Composable
fun StartScreen(
    vm: SampleSDUIComposeViewModel
) {
    val properties by vm.properties.collectAsStateWithLifecycle()
    val craftdBuilderManager = remember {
        CraftDBuilderManager().add(
            ButtonComposeBuilder(),
        )
    }
    LaunchedEffect(Unit) {
        vm.loadProperties()
    }

    CraftDynamic(
        properties = properties,
        craftDBuilderManager = craftdBuilderManager
    ) {
        println(
            ">>>> category ${it.analytics?.category} -" + " action ${it.analytics?.action} -" + " label  ${it.analytics?.label} -" + " deeplink ${it.deeplink}"
        )
    }
}