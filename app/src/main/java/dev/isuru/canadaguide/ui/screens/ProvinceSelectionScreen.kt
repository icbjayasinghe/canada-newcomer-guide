package dev.isuru.canadaguide.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.Explore
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.isuru.canadaguide.data.ProvinceOld
import dev.isuru.canadaguide.data.ProvincesData
import dev.isuru.canadaguide.data.model.Province
import dev.isuru.canadaguide.data.model.CountryDocument
import dev.isuru.canadaguide.data.model.ProvinceActivity
import dev.isuru.canadaguide.ui.theme.CanadaGuideTheme

@Composable
fun ProvinceSelectionScreen(
    viewModel: ProvinceViewModel,
    onProvinceSelected: (Province) -> Unit
) {
    val country by viewModel.countryDocument.collectAsState()
    val loading by viewModel.loading.collectAsState()
    val error by viewModel.error.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadCountry()
    }

    ProvinceSelectionContent(
        country = country,
        loading = loading,
        error = error,
        onProvinceSelected = onProvinceSelected
    )
}

@Composable
fun ProvinceSelectionContent(
    country: CountryDocument?,
    loading: Boolean,
    error: String?,
    onProvinceSelected: (Province) -> Unit
) {
    Scaffold { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            contentPadding = PaddingValues(
                start = 20.dp,
                end = 20.dp,
                top = innerPadding.calculateTopPadding() + 32.dp,
                bottom = 32.dp
            ),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item {
                HeaderBlock()
                Spacer(modifier = Modifier.height(8.dp))
            }
            items(items = country?.provinces ?: emptyList()) { province ->
                ProvinceRow(province = province, onClick = { onProvinceSelected(province) })
//            items(ProvincesData.all, key = { it.id }) { province ->
//                ProvinceRow(provinceOld = province, onClick = { onProvinceSelected(province) })
            }
        }
    }
}

@Composable
private fun HeaderBlock() {
    Column {
        Box(
            modifier = Modifier
                .size(52.dp)
                .background(MaterialTheme.colorScheme.primaryContainer, CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Filled.Explore,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Welcome to Canada",
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.onBackground
        )
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = "Select the province or territory you're settling in, and we'll " +
                "walk you through everything you need to set up.",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "PROVINCE OR TERRITORY",
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.tertiary
        )
    }
}

@Composable
private fun ProvinceRow(province: Province, onClick: (activities: List<ProvinceActivity>) -> Unit) {
    Card(
        onClick = { onClick(province.activities)
                  },
        modifier = Modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(MaterialTheme.colorScheme.secondaryContainer, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = province.abbreviation,
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                    textAlign = TextAlign.Center
                )
            }
            Spacer(modifier = Modifier.width(14.dp))
            Text(
                text = province.name,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.weight(1f)
            )
            Icon(
                imageVector = Icons.Filled.ChevronRight,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.outline
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProvinceSelectionScreenPreview() {
    CanadaGuideTheme {
        ProvinceSelectionContent(
            country = CountryDocument(
                provinces = listOf(
                    Province(id = "1", name = "Ontario", abbreviation = "ON"),
                    Province(id = "2", name = "British Columbia", abbreviation = "BC"),
                    Province(id = "3", name = "Quebec", abbreviation = "QC")
                )
            ),
            loading = false,
            error = null,
            onProvinceSelected = {}
        )
    }
}
