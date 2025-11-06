package com.example.tiptime.utils

import com.example.tiptime.model.BmiCategory
import com.example.tiptime.model.UnitSystem
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Unit tests untuk BmiCalculator
 *
 * Test coverage:
 * - Perhitungan BMI untuk sistem Metric
 * - Perhitungan BMI untuk sistem Imperial
 * - Kategori BMI (Underweight, Normal, Overweight, Obese)
 * - Validasi input weight dan height
 * - Perhitungan healthy weight range
 */
class BmiCalculatorTest {

    // ==================== Test Perhitungan BMI Metric ====================

    @Test
    fun calculateBmi_metric_underweight_returnsCorrectBmi() {
        // Test case: 45 kg, 170 cm -> BMI = 15.57 (Underweight)
        val result = BmiCalculator.calculateBmi(45.0, 170.0, UnitSystem.METRIC)

        assertEquals(15.57, result.bmi, 0.01)
        assertEquals(BmiCategory.UNDERWEIGHT, result.category)
    }

    @Test
    fun calculateBmi_metric_normal_returnsCorrectBmi() {
        // Test case: 70 kg, 175 cm -> BMI = 22.86 (Normal)
        val result = BmiCalculator.calculateBmi(70.0, 175.0, UnitSystem.METRIC)

        assertEquals(22.86, result.bmi, 0.01)
        assertEquals(BmiCategory.NORMAL, result.category)
    }

    @Test
    fun calculateBmi_metric_overweight_returnsCorrectBmi() {
        // Test case: 85 kg, 175 cm -> BMI = 27.76 (Overweight)
        val result = BmiCalculator.calculateBmi(85.0, 175.0, UnitSystem.METRIC)

        assertEquals(27.76, result.bmi, 0.01)
        assertEquals(BmiCategory.OVERWEIGHT, result.category)
    }

    @Test
    fun calculateBmi_metric_obese_returnsCorrectBmi() {
        // Test case: 100 kg, 170 cm -> BMI = 34.60 (Obese)
        val result = BmiCalculator.calculateBmi(100.0, 170.0, UnitSystem.METRIC)

        assertEquals(34.60, result.bmi, 0.01)
        assertEquals(BmiCategory.OBESE, result.category)
    }

    // ==================== Test Perhitungan BMI Imperial ====================

    @Test
    fun calculateBmi_imperial_normal_returnsCorrectBmi() {
        // Test case: 150 lb, 67 in -> BMI = 23.49 (Normal)
        val result = BmiCalculator.calculateBmi(150.0, 67.0, UnitSystem.IMPERIAL)

        assertEquals(23.49, result.bmi, 0.01)
        assertEquals(BmiCategory.NORMAL, result.category)
    }

    @Test
    fun calculateBmi_imperial_overweight_returnsCorrectBmi() {
        // Test case: 180 lb, 65 in -> BMI = 29.96 (Overweight)
        val result = BmiCalculator.calculateBmi(180.0, 65.0, UnitSystem.IMPERIAL)

        assertEquals(29.96, result.bmi, 0.01)
        assertEquals(BmiCategory.OVERWEIGHT, result.category)
    }

    @Test
    fun calculateBmi_imperial_obese_returnsCorrectBmi() {
        // Test case: 220 lb, 65 in -> BMI = 36.62 (Obese)
        val result = BmiCalculator.calculateBmi(220.0, 65.0, UnitSystem.IMPERIAL)

        assertEquals(36.62, result.bmi, 0.01)
        assertEquals(BmiCategory.OBESE, result.category)
    }

    // ==================== Test Boundary Cases (Batas Kategori) ====================

    @Test
    fun calculateBmi_metric_exactlyUnderweightBoundary_returnsUnderweight() {
        // Test case: BMI = 18.4 (tepat di bawah batas normal)
        val result = BmiCalculator.calculateBmi(56.0, 175.0, UnitSystem.METRIC)

        assertTrue(result.bmi < 18.5)
        assertEquals(BmiCategory.UNDERWEIGHT, result.category)
    }

    @Test
    fun calculateBmi_metric_exactlyNormalLowerBoundary_returnsNormal() {
        // Test case: BMI = 18.5 (batas bawah normal)
        val result = BmiCalculator.calculateBmi(56.64, 175.0, UnitSystem.METRIC)

        assertTrue(result.bmi >= 18.5 && result.bmi < 25.0)
        assertEquals(BmiCategory.NORMAL, result.category)
    }

    @Test
    fun calculateBmi_metric_exactlyOverweightLowerBoundary_returnsOverweight() {
        // Test case: BMI = 25.0 (batas bawah overweight)
        val result = BmiCalculator.calculateBmi(76.56, 175.0, UnitSystem.METRIC)

        assertTrue(result.bmi >= 25.0 && result.bmi < 30.0)
        assertEquals(BmiCategory.OVERWEIGHT, result.category)
    }

    @Test
    fun calculateBmi_metric_exactlyObeseLowerBoundary_returnsObese() {
        // Test case: BMI = 30.0 (batas bawah obese)
        val result = BmiCalculator.calculateBmi(91.88, 175.0, UnitSystem.METRIC)

        assertTrue(result.bmi >= 30.0)
        assertEquals(BmiCategory.OBESE, result.category)
    }

    // ==================== Test Validasi Weight ====================

    @Test
    fun isValidWeight_metric_validWeight_returnsTrue() {
        assertTrue(BmiCalculator.isValidWeight("70", UnitSystem.METRIC))
        assertTrue(BmiCalculator.isValidWeight("50.5", UnitSystem.METRIC))
        assertTrue(BmiCalculator.isValidWeight("1", UnitSystem.METRIC))
        assertTrue(BmiCalculator.isValidWeight("500", UnitSystem.METRIC))
    }

    @Test
    fun isValidWeight_metric_invalidWeight_returnsFalse() {
        assertFalse(BmiCalculator.isValidWeight("0", UnitSystem.METRIC))
        assertFalse(BmiCalculator.isValidWeight("-10", UnitSystem.METRIC))
        assertFalse(BmiCalculator.isValidWeight("501", UnitSystem.METRIC))
        assertFalse(BmiCalculator.isValidWeight("abc", UnitSystem.METRIC))
        assertFalse(BmiCalculator.isValidWeight("", UnitSystem.METRIC))
    }

    @Test
    fun isValidWeight_imperial_validWeight_returnsTrue() {
        assertTrue(BmiCalculator.isValidWeight("150", UnitSystem.IMPERIAL))
        assertTrue(BmiCalculator.isValidWeight("100.5", UnitSystem.IMPERIAL))
        assertTrue(BmiCalculator.isValidWeight("2", UnitSystem.IMPERIAL))
        assertTrue(BmiCalculator.isValidWeight("1100", UnitSystem.IMPERIAL))
    }

    @Test
    fun isValidWeight_imperial_invalidWeight_returnsFalse() {
        assertFalse(BmiCalculator.isValidWeight("0", UnitSystem.IMPERIAL))
        assertFalse(BmiCalculator.isValidWeight("-5", UnitSystem.IMPERIAL))
        assertFalse(BmiCalculator.isValidWeight("1101", UnitSystem.IMPERIAL))
        assertFalse(BmiCalculator.isValidWeight("xyz", UnitSystem.IMPERIAL))
    }

    // ==================== Test Validasi Height ====================

    @Test
    fun isValidHeight_metric_validHeight_returnsTrue() {
        assertTrue(BmiCalculator.isValidHeight("175", UnitSystem.METRIC))
        assertTrue(BmiCalculator.isValidHeight("160.5", UnitSystem.METRIC))
        assertTrue(BmiCalculator.isValidHeight("50", UnitSystem.METRIC))
        assertTrue(BmiCalculator.isValidHeight("300", UnitSystem.METRIC))
    }

    @Test
    fun isValidHeight_metric_invalidHeight_returnsFalse() {
        assertFalse(BmiCalculator.isValidHeight("0", UnitSystem.METRIC))
        assertFalse(BmiCalculator.isValidHeight("-100", UnitSystem.METRIC))
        assertFalse(BmiCalculator.isValidHeight("301", UnitSystem.METRIC))
        assertFalse(BmiCalculator.isValidHeight("abc", UnitSystem.METRIC))
        assertFalse(BmiCalculator.isValidHeight("", UnitSystem.METRIC))
    }

    @Test
    fun isValidHeight_imperial_validHeight_returnsTrue() {
        assertTrue(BmiCalculator.isValidHeight("67", UnitSystem.IMPERIAL))
        assertTrue(BmiCalculator.isValidHeight("70.5", UnitSystem.IMPERIAL))
        assertTrue(BmiCalculator.isValidHeight("20", UnitSystem.IMPERIAL))
        assertTrue(BmiCalculator.isValidHeight("120", UnitSystem.IMPERIAL))
    }

    @Test
    fun isValidHeight_imperial_invalidHeight_returnsFalse() {
        assertFalse(BmiCalculator.isValidHeight("0", UnitSystem.IMPERIAL))
        assertFalse(BmiCalculator.isValidHeight("-10", UnitSystem.IMPERIAL))
        assertFalse(BmiCalculator.isValidHeight("121", UnitSystem.IMPERIAL))
        assertFalse(BmiCalculator.isValidHeight("xyz", UnitSystem.IMPERIAL))
    }

    // ==================== Test Healthy Weight Range ====================

    @Test
    fun calculateBmi_metric_includesHealthyWeightRange() {
        val result = BmiCalculator.calculateBmi(70.0, 175.0, UnitSystem.METRIC)

        // Untuk height 175 cm, healthy range = 56-76 kg (approx)
        assertTrue(result.healthyWeightRange.contains("kg"))
        assertTrue(result.healthyWeightRange.contains("-"))
    }

    @Test
    fun calculateBmi_imperial_includesHealthyWeightRange() {
        val result = BmiCalculator.calculateBmi(150.0, 67.0, UnitSystem.IMPERIAL)

        // Untuk height 67 in, healthy range dalam lb
        assertTrue(result.healthyWeightRange.contains("lb"))
        assertTrue(result.healthyWeightRange.contains("-"))
    }

    // ==================== Test Validation Messages ====================

    @Test
    fun getValidationMessage_metric_returnsCorrectMessages() {
        val messages = BmiCalculator.getValidationMessage(UnitSystem.METRIC)

        assertTrue(messages.first.contains("kg"))
        assertTrue(messages.second.contains("cm"))
    }

    @Test
    fun getValidationMessage_imperial_returnsCorrectMessages() {
        val messages = BmiCalculator.getValidationMessage(UnitSystem.IMPERIAL)

        assertTrue(messages.first.contains("lb"))
        assertTrue(messages.second.contains("in"))
    }

    // ==================== Test Edge Cases ====================

    @Test
    fun calculateBmi_metric_veryTallPerson_returnsCorrectBmi() {
        // Test case: 80 kg, 200 cm -> BMI = 20.0 (Normal)
        val result = BmiCalculator.calculateBmi(80.0, 200.0, UnitSystem.METRIC)

        assertEquals(20.0, result.bmi, 0.01)
        assertEquals(BmiCategory.NORMAL, result.category)
    }

    @Test
    fun calculateBmi_metric_veryShortPerson_returnsCorrectBmi() {
        // Test case: 40 kg, 150 cm -> BMI = 17.78 (Underweight)
        val result = BmiCalculator.calculateBmi(40.0, 150.0, UnitSystem.METRIC)

        assertEquals(17.78, result.bmi, 0.01)
        assertEquals(BmiCategory.UNDERWEIGHT, result.category)
    }

    @Test
    fun calculateBmi_imperial_decimalValues_returnsCorrectBmi() {
        // Test case dengan decimal: 165.5 lb, 68.5 in
        val result = BmiCalculator.calculateBmi(165.5, 68.5, UnitSystem.IMPERIAL)

        assertTrue(result.bmi > 0)
        assertTrue(result.category in listOf(
            BmiCategory.UNDERWEIGHT,
            BmiCategory.NORMAL,
            BmiCategory.OVERWEIGHT,
            BmiCategory.OBESE
        ))
    }
}

