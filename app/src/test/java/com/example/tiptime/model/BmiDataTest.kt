package com.example.tiptime.model

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test

/**
 * Unit tests untuk BmiData dan UnitSystem
 *
 * Test coverage:
 * - BmiData data class properties
 * - UnitSystem enum values
 * - Data class equality
 */
class BmiDataTest {

    // ==================== Test BmiData Creation ====================

    @Test
    fun bmiData_creation_withValidValues() {
        val bmiData = BmiData(
            bmi = 22.5,
            category = BmiCategory.NORMAL,
            healthyWeightRange = "56-76 kg"
        )

        assertEquals(22.5, bmiData.bmi, 0.0)
        assertEquals(BmiCategory.NORMAL, bmiData.category)
        assertEquals("56-76 kg", bmiData.healthyWeightRange)
    }

    @Test
    fun bmiData_underweight_hasCorrectProperties() {
        val bmiData = BmiData(
            bmi = 17.5,
            category = BmiCategory.UNDERWEIGHT,
            healthyWeightRange = "50-68 kg"
        )

        assertEquals(17.5, bmiData.bmi, 0.0)
        assertEquals(BmiCategory.UNDERWEIGHT, bmiData.category)
        assertEquals("50-68 kg", bmiData.healthyWeightRange)
    }

    @Test
    fun bmiData_overweight_hasCorrectProperties() {
        val bmiData = BmiData(
            bmi = 27.5,
            category = BmiCategory.OVERWEIGHT,
            healthyWeightRange = "55-75 kg"
        )

        assertEquals(27.5, bmiData.bmi, 0.0)
        assertEquals(BmiCategory.OVERWEIGHT, bmiData.category)
        assertEquals("55-75 kg", bmiData.healthyWeightRange)
    }

    @Test
    fun bmiData_obese_hasCorrectProperties() {
        val bmiData = BmiData(
            bmi = 32.0,
            category = BmiCategory.OBESE,
            healthyWeightRange = "58-79 kg"
        )

        assertEquals(32.0, bmiData.bmi, 0.0)
        assertEquals(BmiCategory.OBESE, bmiData.category)
        assertEquals("58-79 kg", bmiData.healthyWeightRange)
    }

    // ==================== Test Data Class Equality ====================

    @Test
    fun bmiData_equality_sameValues_areEqual() {
        val bmiData1 = BmiData(22.5, BmiCategory.NORMAL, "56-76 kg")
        val bmiData2 = BmiData(22.5, BmiCategory.NORMAL, "56-76 kg")

        assertEquals(bmiData1, bmiData2)
    }

    @Test
    fun bmiData_equality_differentBmi_areNotEqual() {
        val bmiData1 = BmiData(22.5, BmiCategory.NORMAL, "56-76 kg")
        val bmiData2 = BmiData(23.5, BmiCategory.NORMAL, "56-76 kg")

        assertNotEquals(bmiData1, bmiData2)
    }

    @Test
    fun bmiData_equality_differentCategory_areNotEqual() {
        val bmiData1 = BmiData(22.5, BmiCategory.NORMAL, "56-76 kg")
        val bmiData2 = BmiData(22.5, BmiCategory.OVERWEIGHT, "56-76 kg")

        assertNotEquals(bmiData1, bmiData2)
    }

    // ==================== Test Copy Function ====================

    @Test
    fun bmiData_copy_modifyBmi_createsNewInstance() {
        val original = BmiData(22.5, BmiCategory.NORMAL, "56-76 kg")
        val copied = original.copy(bmi = 25.0)

        assertEquals(25.0, copied.bmi, 0.0)
        assertEquals(BmiCategory.NORMAL, copied.category)
        assertEquals("56-76 kg", copied.healthyWeightRange)
        assertNotEquals(original, copied)
    }

    @Test
    fun bmiData_copy_modifyCategory_createsNewInstance() {
        val original = BmiData(22.5, BmiCategory.NORMAL, "56-76 kg")
        val copied = original.copy(category = BmiCategory.OVERWEIGHT)

        assertEquals(22.5, copied.bmi, 0.0)
        assertEquals(BmiCategory.OVERWEIGHT, copied.category)
        assertEquals("56-76 kg", copied.healthyWeightRange)
    }
}

