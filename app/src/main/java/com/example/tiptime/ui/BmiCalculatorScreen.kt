package com.example.tiptime.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Calculate
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.Height
import androidx.compose.material.icons.filled.MonitorWeight
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tiptime.model.BmiData
import com.example.tiptime.model.UnitSystem
import com.example.tiptime.ui.theme.*
import com.example.tiptime.utils.BmiCalculator
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BmiCalculatorScreen() {
    var weight by remember { mutableStateOf("") }
    var height by remember { mutableStateOf("") }
    var selectedSystem by remember { mutableStateOf(UnitSystem.METRIC) }
    var bmiResult by remember { mutableStateOf<BmiData?>(null) }
    var showError by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            "BMI Calculator",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = PrimaryBlue
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(BackgroundLight)
                .verticalScroll(rememberScrollState())
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Unit System Selector
            UnitSystemSelector(
                selectedSystem = selectedSystem,
                onSystemChange = {
                    selectedSystem = it
                    weight = ""
                    height = ""
                    bmiResult = null
                    showError = false
                }
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Input Card
            InputCard(
                weight = weight,
                height = height,
                selectedSystem = selectedSystem,
                onWeightChange = {
                    weight = it
                    showError = false
                },
                onHeightChange = {
                    height = it
                    showError = false
                }
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Calculate Button
            CalculateButton(
                onClick = {
                    if (BmiCalculator.isValidWeight(weight, selectedSystem) &&
                        BmiCalculator.isValidHeight(height, selectedSystem)) {
                        val result = BmiCalculator.calculateBmi(
                            weight.toDouble(),
                            height.toDouble(),
                            selectedSystem
                        )
                        bmiResult = result
                        showError = false
                    } else {
                        showError = true
                        val messages = BmiCalculator.getValidationMessage(selectedSystem)
                        errorMessage = when {
                            !BmiCalculator.isValidWeight(weight, selectedSystem) -> messages.first
                            !BmiCalculator.isValidHeight(height, selectedSystem) -> messages.second
                            else -> "Please enter valid values"
                        }
                        bmiResult = null
                    }
                },
                enabled = weight.isNotBlank() && height.isNotBlank()
            )

            // Error Message
            if (showError) {
                Spacer(modifier = Modifier.height(16.dp))
                ErrorMessage(errorMessage)
            }

            // Result Card
            AnimatedVisibility(
                visible = bmiResult != null,
                enter = fadeIn() + expandVertically(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )
            ) {
                bmiResult?.let { result ->
                    Column {
                        Spacer(modifier = Modifier.height(24.dp))
                        ResultCard(result)
                    }
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Info Card
            BmiInfoCard()
        }
    }
}

@Composable
fun UnitSystemSelector(
    selectedSystem: UnitSystem,
    onSystemChange: (UnitSystem) -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                "Unit System",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold,
                color = TextPrimary
            )
            Spacer(modifier = Modifier.height(12.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                UnitSystem.entries.forEach { system ->
                    FilterChip(
                        selected = selectedSystem == system,
                        onClick = { onSystemChange(system) },
                        label = { Text(system.displayName) },
                        modifier = Modifier.weight(1f),
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = PrimaryBlue,
                            selectedLabelColor = Color.White
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun InputCard(
    weight: String,
    height: String,
    selectedSystem: UnitSystem,
    onWeightChange: (String) -> Unit,
    onHeightChange: (String) -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            val weightLabel = if (selectedSystem == UnitSystem.METRIC) "Weight (kg)" else "Weight (lb)"
            val heightLabel = if (selectedSystem == UnitSystem.METRIC) "Height (cm)" else "Height (in)"

            // Weight Input
            OutlinedTextField(
                value = weight,
                onValueChange = onWeightChange,
                label = { Text(weightLabel) },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.MonitorWeight,
                        contentDescription = "Weight",
                        tint = PrimaryBlue
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = PrimaryBlue,
                    focusedLabelColor = PrimaryBlue
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Height Input
            OutlinedTextField(
                value = height,
                onValueChange = onHeightChange,
                label = { Text(heightLabel) },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Height,
                        contentDescription = "Height",
                        tint = PrimaryBlue
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = PrimaryBlue,
                    focusedLabelColor = PrimaryBlue
                )
            )
        }
    }
}

@Composable
fun CalculateButton(
    onClick: () -> Unit,
    enabled: Boolean
) {
    Button(
        onClick = onClick,
        enabled = enabled,
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = PrimaryBlue,
            disabledContainerColor = PrimaryBlue.copy(alpha = 0.5f)
        ),
        shape = RoundedCornerShape(12.dp),
        elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp)
    ) {
        Icon(
            imageVector = Icons.Default.Calculate,
            contentDescription = null,
            modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            "Calculate BMI",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
fun ErrorMessage(message: String) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFEE2E2)
        ),
        shape = RoundedCornerShape(12.dp)
    ) {
        Text(
            text = message,
            modifier = Modifier.padding(16.dp),
            color = Color(0xFFDC2626),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
fun ResultCard(result: BmiData) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "Your BMI Result",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = TextPrimary
            )

            Spacer(modifier = Modifier.height(24.dp))

            // BMI Value with gradient background
            Box(
                modifier = Modifier
                    .size(140.dp)
                    .clip(RoundedCornerShape(70.dp))
                    .background(
                        Brush.radialGradient(
                            colors = listOf(
                                result.category.color.copy(alpha = 0.3f),
                                result.category.color.copy(alpha = 0.1f)
                            )
                        )
                    ),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = String.format(Locale.US, "%.1f", result.bmi),
                        fontSize = 42.sp,
                        fontWeight = FontWeight.Bold,
                        color = result.category.color
                    )
                    Text(
                        text = "BMI",
                        fontSize = 14.sp,
                        color = TextSecondary
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Category Badge
            Surface(
                color = result.category.color,
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                Text(
                    text = result.category.displayName,
                    modifier = Modifier.padding(horizontal = 24.dp, vertical = 12.dp),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            HorizontalDivider()

            Spacer(modifier = Modifier.height(20.dp))

            // Healthy Weight Range
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "Healthy Weight:",
                    style = MaterialTheme.typography.bodyLarge,
                    color = TextSecondary
                )
                Text(
                    result.healthyWeightRange,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.SemiBold,
                    color = TextPrimary
                )
            }
        }
    }
}

@Composable
fun BmiInfoCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = PrimaryBlue.copy(alpha = 0.05f)
        ),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                "BMI Categories",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold,
                color = TextPrimary
            )
            Spacer(modifier = Modifier.height(12.dp))
            BmiCategoryRow("Underweight", "< 18.5", UnderweightColor)
            BmiCategoryRow("Normal", "18.5 - 24.9", NormalColor)
            BmiCategoryRow("Overweight", "25.0 - 29.9", ObeseColor)
            BmiCategoryRow("Obese", "≥ 30.0", ObeseColor)
        }
    }
}

@Composable
fun BmiCategoryRow(category: String, range: String, color: Color) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(12.dp)
                    .clip(RoundedCornerShape(6.dp))
                    .background(color)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                category,
                style = MaterialTheme.typography.bodyMedium,
                color = TextPrimary
            )
        }
        Text(
            range,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Medium,
            color = TextSecondary
        )
    }
}