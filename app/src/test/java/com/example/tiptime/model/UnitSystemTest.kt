package com.example.tiptime.model

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Unit tests untuk UnitSystem enum
 *
 * Test coverage:
 * - Enum values
 * - Display names
 * - Enum properties
 */
class UnitSystemTest {

    // ==================== Test Enum Values ====================

    @Test
    fun unitSystem_hasMetricValue() {
        val metric = UnitSystem.METRIC
        assertEquals("Metric (kg, cm)", metric.displayName)
    }

    @Test
    fun unitSystem_hasImperialValue() {
        val imperial = UnitSystem.IMPERIAL
        assertEquals("Imperial (lb, in)", imperial.displayName)
    }

    @Test
    fun unitSystem_hasTwoValues() {
        val values = UnitSystem.entries
        assertEquals(2, values.size)
    }

    @Test
    fun unitSystem_ordersCorrectly() {
        val values = UnitSystem.entries
        assertEquals(UnitSystem.METRIC, values[0])
        assertEquals(UnitSystem.IMPERIAL, values[1])
    }

    // ==================== Test Display Names ====================

    @Test
    fun metric_displayName_containsKgAndCm() {
        val displayName = UnitSystem.METRIC.displayName
        assert(displayName.contains("kg"))
        assert(displayName.contains("cm"))
    }

    @Test
    fun imperial_displayName_containsLbAndIn() {
        val displayName = UnitSystem.IMPERIAL.displayName
        assert(displayName.contains("lb"))
        assert(displayName.contains("in"))
    }

    // ==================== Test Enum Behavior ====================

    @Test
    fun unitSystem_valueOf_metric_returnsMetric() {
        val system = UnitSystem.valueOf("METRIC")
        assertEquals(UnitSystem.METRIC, system)
    }

    @Test
    fun unitSystem_valueOf_imperial_returnsImperial() {
        val system = UnitSystem.valueOf("IMPERIAL")
        assertEquals(UnitSystem.IMPERIAL, system)
    }

    @Test
    fun unitSystem_entries_containsBothSystems() {
        val entries = UnitSystem.entries
        assertEquals(2, entries.size)
        assert(entries.contains(UnitSystem.METRIC))
        assert(entries.contains(UnitSystem.IMPERIAL))
    }
}

