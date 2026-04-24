import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityWeightTest {

    // ===== EQUALITY =====
    @Test
    void testEquality_KgToKg() {
        var q1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        var q2 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);

        assertTrue(q1.equals(q2));
    }

    @Test
    void testEquality_KgToGram() {
        var q1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        var q2 = new QuantityWeight(1000.0, WeightUnit.GRAM);

        assertTrue(q1.equals(q2));
    }

    @Test
    void testEquality_KgToPound() {
        var q1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        var q2 = new QuantityWeight(2.20462, WeightUnit.POUND);

        assertTrue(q1.equals(q2));
    }

    @Test
    void testEquality_DifferentValue() {
        var q1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        var q2 = new QuantityWeight(2.0, WeightUnit.KILOGRAM);

        assertFalse(q1.equals(q2));
    }

    @Test
    void testEquality_Null() {
        var q = new QuantityWeight(1.0, WeightUnit.KILOGRAM);

        assertFalse(q.equals(null));
    }

    @Test
    void testEquality_SameReference() {
        var q = new QuantityWeight(1.0, WeightUnit.KILOGRAM);

        assertTrue(q.equals(q));
    }

    // ===== CONVERSION =====
    @Test
    void testConvert_KgToGram() {
        var q = new QuantityWeight(1.0, WeightUnit.KILOGRAM);

        var result = q.convertTo(WeightUnit.GRAM);

        assertEquals(1000.0,
                result.convertTo(WeightUnit.GRAM),
                1e-6);
    }

    @Test
    void testConvert_PoundToKg() {
        var q = new QuantityWeight(2.20462, WeightUnit.POUND);

        var result = q.convertTo(WeightUnit.KILOGRAM);

        assertEquals(1.0,
                result.convertTo(WeightUnit.KILOGRAM),
                1e-3);
    }

    @Test
    void testConvert_RoundTrip() {
        var q = new QuantityWeight(2.5, WeightUnit.KILOGRAM);

        var converted = q.convertTo(WeightUnit.GRAM);
        var back = converted.convertTo(WeightUnit.KILOGRAM);

        assertEquals(2.5,
                back.convertTo(WeightUnit.KILOGRAM),
                1e-6);
    }

    // ===== ADDITION (UC6 style) =====
    @Test
    void testAddition_KgPlusKg() {
        var q1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        var q2 = new QuantityWeight(2.0, WeightUnit.KILOGRAM);

        var result = q1.add(q2);

        assertEquals(3.0,
                result.convertTo(WeightUnit.KILOGRAM),
                1e-6);
    }

    @Test
    void testAddition_KgPlusGram() {
        var q1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        var q2 = new QuantityWeight(1000.0, WeightUnit.GRAM);

        var result = q1.add(q2);

        assertEquals(2.0,
                result.convertTo(WeightUnit.KILOGRAM),
                1e-6);
    }

    // ===== ADDITION WITH TARGET UNIT (UC7 style) =====
    @Test
    void testAddition_TargetGram() {
        var q1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        var q2 = new QuantityWeight(1000.0, WeightUnit.GRAM);

        var result = q1.add(q2, WeightUnit.GRAM);

        assertEquals(2000.0,
                result.convertTo(WeightUnit.GRAM),
                1e-6);
    }

    @Test
    void testAddition_TargetPound() {
        var q1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        var q2 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);

        var result = q1.add(q2, WeightUnit.POUND);

        assertEquals(4.40924,
                result.convertTo(WeightUnit.POUND),
                1e-3);
    }

    // ===== EDGE CASES =====
    @Test
    void testZeroValue() {
        var q1 = new QuantityWeight(0.0, WeightUnit.KILOGRAM);
        var q2 = new QuantityWeight(0.0, WeightUnit.GRAM);

        assertTrue(q1.equals(q2));
    }

    @Test
    void testNegativeValues() {
        var q1 = new QuantityWeight(-1.0, WeightUnit.KILOGRAM);
        var q2 = new QuantityWeight(-1000.0, WeightUnit.GRAM);

        assertTrue(q1.equals(q2));
    }

    @Test
    void testInvalidUnit() {
        assertThrows(IllegalArgumentException.class,
                () -> new QuantityWeight(1.0, null));
    }

    @Test
    void testInvalidValue() {
        assertThrows(IllegalArgumentException.class,
                () -> new QuantityWeight(Double.NaN, WeightUnit.KILOGRAM));
    }
}