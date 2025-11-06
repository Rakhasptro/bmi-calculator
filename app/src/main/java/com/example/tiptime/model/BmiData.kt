package com.example.tiptime.model

data class BmiData(
    val bmi: Double,
    val category: BmiCategory,
    val healthyWeightRange: String
)

/**
 * Enum class untuk kategori BMI
 */
enum class BmiCategory(val displayName: String, val color: androidx.compose.ui.graphics.Color) {
    UNDERWEIGHT(
        "Underweight",
        androidx.compose.ui.graphics.Color(0xFF3B82F6)
    ),
    NORMAL(
        "Normal Weight",
        androidx.compose.ui.graphics.Color(0xFF10B981)
    ),
    OVERWEIGHT(
        "Overweight",
        androidx.compose.ui.graphics.Color(0xFFF59E0B)
    ),
    OBESE(
        "Obese",
        androidx.compose.ui.graphics.Color(0xFFEF4444)
    );

    companion object {
        /**
         * Menentukan kategori BMI berdasarkan nilai BMI
         * Referensi: WHO BMI Classification
         */
        fun fromBmi(bmi: Double): BmiCategory {
            return when {
                bmi < 18.5 -> UNDERWEIGHT
                bmi < 25.0 -> NORMAL
                bmi < 30.0 -> OVERWEIGHT
                else -> OBESE
            }
        }
    }
}

/**
 * Enum class untuk sistem pengukuran
 */
enum class UnitSystem(val displayName: String) {
    METRIC("Metric (kg, cm)"),
    IMPERIAL("Imperial (lb, in)")
}