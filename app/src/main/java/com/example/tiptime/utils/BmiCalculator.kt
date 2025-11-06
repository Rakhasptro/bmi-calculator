package com.example.tiptime.utils

import com.example.tiptime.model.BmiCategory
import com.example.tiptime.model.BmiData
import com.example.tiptime.model.UnitSystem
import kotlin.math.pow
import kotlin.math.roundToInt

/**
 * NPM: [ISI NPM ANDA]
 * Nama: [ISI NAMA ANDA]
 *
 * Utility class untuk perhitungan BMI
 */
object BmiCalculator {

    /**
     * Menghitung BMI berdasarkan berat, tinggi, dan sistem unit
     *
     * @param weight Berat badan (kg untuk Metric, lb untuk Imperial)
     * @param height Tinggi badan (cm untuk Metric, in untuk Imperial)
     * @param system Sistem pengukuran yang digunakan
     * @return BmiData yang berisi BMI, kategori, dan rentang berat ideal
     */
    fun calculateBmi(weight: Double, height: Double, system: UnitSystem): BmiData {
        val bmi = when (system) {
            UnitSystem.METRIC -> {
                // Formula: BMI = weight (kg) / (height (m))^2
                val heightInMeters = height / 100.0
                weight / heightInMeters.pow(2)
            }
            UnitSystem.IMPERIAL -> {
                // Formula: BMI = (weight (lb) / (height (in))^2) * 703
                (weight / height.pow(2)) * 703
            }
        }

        val category = BmiCategory.fromBmi(bmi)
        val healthyRange = calculateHealthyWeightRange(height, system)

        return BmiData(bmi, category, healthyRange)
    }

    /**
     * Menghitung rentang berat badan ideal (BMI 18.5 - 24.9)
     *
     * @param height Tinggi badan
     * @param system Sistem pengukuran
     * @return String rentang berat ideal
     */
    private fun calculateHealthyWeightRange(height: Double, system: UnitSystem): String {
        return when (system) {
            UnitSystem.METRIC -> {
                val heightInMeters = height / 100.0
                val minWeight = (18.5 * heightInMeters.pow(2)).roundToInt()
                val maxWeight = (24.9 * heightInMeters.pow(2)).roundToInt()
                "$minWeight - $maxWeight kg"
            }
            UnitSystem.IMPERIAL -> {
                val minWeight = ((18.5 * height.pow(2)) / 703).roundToInt()
                val maxWeight = ((24.9 * height.pow(2)) / 703).roundToInt()
                "$minWeight - $maxWeight lb"
            }
        }
    }

    /**
     * Validasi input berat badan
     *
     * @param weight Berat badan
     * @param system Sistem pengukuran
     * @return true jika valid, false jika tidak
     */
    fun isValidWeight(weight: String, system: UnitSystem): Boolean {
        val weightValue = weight.toDoubleOrNull() ?: return false
        return when (system) {
            UnitSystem.METRIC -> weightValue in 1.0..500.0  // kg
            UnitSystem.IMPERIAL -> weightValue in 2.0..1100.0  // lb
        }
    }

    /**
     * Validasi input tinggi badan
     *
     * @param height Tinggi badan
     * @param system Sistem pengukuran
     * @return true jika valid, false jika tidak
     */
    fun isValidHeight(height: String, system: UnitSystem): Boolean {
        val heightValue = height.toDoubleOrNull() ?: return false
        return when (system) {
            UnitSystem.METRIC -> heightValue in 50.0..300.0  // cm
            UnitSystem.IMPERIAL -> heightValue in 20.0..120.0  // inch
        }
    }

    /**
     * Mendapatkan pesan error untuk input tidak valid
     */
    fun getValidationMessage(system: UnitSystem): Pair<String, String> {
        return when (system) {
            UnitSystem.METRIC -> Pair(
                "Weight must be between 1-500 kg",
                "Height must be between 50-300 cm"
            )
            UnitSystem.IMPERIAL -> Pair(
                "Weight must be between 2-1100 lb",
                "Height must be between 20-120 in"
            )
        }
    }
}