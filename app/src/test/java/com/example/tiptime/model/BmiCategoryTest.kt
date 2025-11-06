package com.example.tiptime.model

import androidx.compose.ui.graphics.Color
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

/**
 * Unit tests untuk BmiCategory
 *
 * Test coverage:
 * - Kategori BMI berdasarkan nilai BMI
 * - Display names untuk setiap kategori
 * - Warna untuk setiap kategori
 * - Boundary values (batas antar kategori)
 */
class BmiCategoryTest {

    // ==================== Test fromBmi() Method ====================

    @Test
    fun fromBmi_underweightRange_returnsUnderweight() {
        // BMI < 18.5 harus return UNDERWEIGHT
        assertEquals(BmiCategory.UNDERWEIGHT, BmiCategory.fromBmi(10.0))
        assertEquals(BmiCategory.UNDERWEIGHT, BmiCategory.fromBmi(15.0))
        assertEquals(BmiCategory.UNDERWEIGHT, BmiCategory.fromBmi(18.0))
        assertEquals(BmiCategory.UNDERWEIGHT, BmiCategory.fromBmi(18.4))
    }

    @Test
    fun fromBmi_normalRange_returnsNormal() {
        // BMI 18.5 - 24.9 harus return NORMAL
        assertEquals(BmiCategory.NORMAL, BmiCategory.fromBmi(18.5))
        assertEquals(BmiCategory.NORMAL, BmiCategory.fromBmi(20.0))
        assertEquals(BmiCategory.NORMAL, BmiCategory.fromBmi(22.5))
        assertEquals(BmiCategory.NORMAL, BmiCategory.fromBmi(24.5))
        assertEquals(BmiCategory.NORMAL, BmiCategory.fromBmi(24.9))
    }

    @Test
    fun fromBmi_overweightRange_returnsOverweight() {
        // BMI 25.0 - 29.9 harus return OVERWEIGHT
        assertEquals(BmiCategory.OVERWEIGHT, BmiCategory.fromBmi(25.0))
        assertEquals(BmiCategory.OVERWEIGHT, BmiCategory.fromBmi(27.0))
        assertEquals(BmiCategory.OVERWEIGHT, BmiCategory.fromBmi(29.5))
        assertEquals(BmiCategory.OVERWEIGHT, BmiCategory.fromBmi(29.9))
    }

    @Test
    fun fromBmi_obeseRange_returnsObese() {
        // BMI >= 30.0 harus return OBESE
        assertEquals(BmiCategory.OBESE, BmiCategory.fromBmi(30.0))
        assertEquals(BmiCategory.OBESE, BmiCategory.fromBmi(35.0))
        assertEquals(BmiCategory.OBESE, BmiCategory.fromBmi(40.0))
        assertEquals(BmiCategory.OBESE, BmiCategory.fromBmi(50.0))
    }

    // ==================== Test Boundary Values (Nilai Batas) ====================

    @Test
    fun fromBmi_exactUnderweightBoundary_returnsUnderweight() {
        // BMI 18.49999 harus UNDERWEIGHT
        assertEquals(BmiCategory.UNDERWEIGHT, BmiCategory.fromBmi(18.49))
    }

    @Test
    fun fromBmi_exactNormalLowerBoundary_returnsNormal() {
        // BMI 18.5 (tepat) harus NORMAL
        assertEquals(BmiCategory.NORMAL, BmiCategory.fromBmi(18.5))
    }

    @Test
    fun fromBmi_exactNormalUpperBoundary_returnsNormal() {
        // BMI 24.9999 harus NORMAL
        assertEquals(BmiCategory.NORMAL, BmiCategory.fromBmi(24.99))
    }

    @Test
    fun fromBmi_exactOverweightLowerBoundary_returnsOverweight() {
        // BMI 25.0 (tepat) harus OVERWEIGHT
        assertEquals(BmiCategory.OVERWEIGHT, BmiCategory.fromBmi(25.0))
    }

    @Test
    fun fromBmi_exactOverweightUpperBoundary_returnsOverweight() {
        // BMI 29.9999 harus OVERWEIGHT
        assertEquals(BmiCategory.OVERWEIGHT, BmiCategory.fromBmi(29.99))
    }

    @Test
    fun fromBmi_exactObeseLowerBoundary_returnsObese() {
        // BMI 30.0 (tepat) harus OBESE
        assertEquals(BmiCategory.OBESE, BmiCategory.fromBmi(30.0))
    }

    // ==================== Test Display Names ====================

    @Test
    fun underweight_hasCorrectDisplayName() {
        assertEquals("Underweight", BmiCategory.UNDERWEIGHT.displayName)
    }

    @Test
    fun normal_hasCorrectDisplayName() {
        assertEquals("Normal Weight", BmiCategory.NORMAL.displayName)
    }

    @Test
    fun overweight_hasCorrectDisplayName() {
        assertEquals("Overweight", BmiCategory.OVERWEIGHT.displayName)
    }

    @Test
    fun obese_hasCorrectDisplayName() {
        assertEquals("Obese", BmiCategory.OBESE.displayName)
    }

    // ==================== Test Colors ====================

    @Test
    fun underweight_hasBlueColor() {
        // Underweight = Blue (0xFF3B82F6)
        assertEquals(Color(0xFF3B82F6), BmiCategory.UNDERWEIGHT.color)
    }

    @Test
    fun normal_hasGreenColor() {
        // Normal = Green (0xFF10B981)
        assertEquals(Color(0xFF10B981), BmiCategory.NORMAL.color)
    }

    @Test
    fun overweight_hasOrangeColor() {
        // Overweight = Orange (0xFFF59E0B)
        assertEquals(Color(0xFFF59E0B), BmiCategory.OVERWEIGHT.color)
    }

    @Test
    fun obese_hasRedColor() {
        // Obese = Red (0xFFEF4444)
        assertEquals(Color(0xFFEF4444), BmiCategory.OBESE.color)
    }

    @Test
    fun allCategories_haveNonNullColors() {
        // Pastikan semua kategori punya warna yang valid
        assertNotNull(BmiCategory.UNDERWEIGHT.color)
        assertNotNull(BmiCategory.NORMAL.color)
        assertNotNull(BmiCategory.OVERWEIGHT.color)
        assertNotNull(BmiCategory.OBESE.color)
    }

    // ==================== Test Enum Values ====================

    @Test
    fun allBmiCategories_exist() {
        // Pastikan semua 4 kategori ada
        val categories = BmiCategory.entries
        assertEquals(4, categories.size)

        // Verifikasi urutan
        assertEquals(BmiCategory.UNDERWEIGHT, categories[0])
        assertEquals(BmiCategory.NORMAL, categories[1])
        assertEquals(BmiCategory.OVERWEIGHT, categories[2])
        assertEquals(BmiCategory.OBESE, categories[3])
    }

    // ==================== Test Extreme Values ====================

    @Test
    fun fromBmi_veryLowBmi_returnsUnderweight() {
        // BMI sangat rendah (misalnya kasus ekstrem)
        assertEquals(BmiCategory.UNDERWEIGHT, BmiCategory.fromBmi(10.0))
        assertEquals(BmiCategory.UNDERWEIGHT, BmiCategory.fromBmi(5.0))
        assertEquals(BmiCategory.UNDERWEIGHT, BmiCategory.fromBmi(1.0))
    }

    @Test
    fun fromBmi_veryHighBmi_returnsObese() {
        // BMI sangat tinggi (misalnya kasus ekstrem)
        assertEquals(BmiCategory.OBESE, BmiCategory.fromBmi(40.0))
        assertEquals(BmiCategory.OBESE, BmiCategory.fromBmi(50.0))
        assertEquals(BmiCategory.OBESE, BmiCategory.fromBmi(100.0))
    }

    // ==================== Test Real-World Scenarios ====================

    @Test
    fun fromBmi_typicalUnderweightValue_returnsUnderweight() {
        // Contoh BMI underweight yang umum: 17.5
        val category = BmiCategory.fromBmi(17.5)
        assertEquals(BmiCategory.UNDERWEIGHT, category)
        assertEquals("Underweight", category.displayName)
        assertEquals(Color(0xFF3B82F6), category.color)
    }

    @Test
    fun fromBmi_typicalNormalValue_returnsNormal() {
        // Contoh BMI normal yang umum: 22.0
        val category = BmiCategory.fromBmi(22.0)
        assertEquals(BmiCategory.NORMAL, category)
        assertEquals("Normal Weight", category.displayName)
        assertEquals(Color(0xFF10B981), category.color)
    }

    @Test
    fun fromBmi_typicalOverweightValue_returnsOverweight() {
        // Contoh BMI overweight yang umum: 27.5
        val category = BmiCategory.fromBmi(27.5)
        assertEquals(BmiCategory.OVERWEIGHT, category)
        assertEquals("Overweight", category.displayName)
        assertEquals(Color(0xFFF59E0B), category.color)
    }

    @Test
    fun fromBmi_typicalObeseValue_returnsObese() {
        // Contoh BMI obese yang umum: 32.5
        val category = BmiCategory.fromBmi(32.5)
        assertEquals(BmiCategory.OBESE, category)
        assertEquals("Obese", category.displayName)
        assertEquals(Color(0xFFEF4444), category.color)
    }
}

