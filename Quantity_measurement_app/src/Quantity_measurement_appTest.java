import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Quantity_measurement_appTest {

    // ===== ENUM TESTS =====
    @Test
    void testConvertToBaseUnit_InchesToFeet() {
        assertEquals(1.0,
                LengthUnit.INCH.convertToBaseUnit(12.0),
                1e-6);
    }

    @Test
    void testConvertFromBaseUnit_FeetToInches() {
        assertEquals(12.0,
                LengthUnit.INCH.convertFromBaseUnit(1.0),
                1e-6);
    }

    @Test
    void testConvertToBaseUnit_YardToFeet() {
        assertEquals(3.0,
                LengthUnit.YARD.convertToBaseUnit(1.0),
                1e-6);
    }

    @Test
    void testConvertFromBaseUnit_FeetToCm() {
        assertEquals(30.48,
                LengthUnit.CM.convertFromBaseUnit(1.0),
                1e-2);
    }

    // ===== QUANTITY TESTS =====
    @Test
    void testEquality_FeetAndInches() {
        var q1 = new Quantity_measurement_app.Quantity(1.0, LengthUnit.FEET);
        var q2 = new Quantity_measurement_app.Quantity(12.0, LengthUnit.INCH);

        assertTrue(q1.equals(q2));
    }

    @Test
    void testConvertTo() {
        var q = new Quantity_measurement_app.Quantity(1.0, LengthUnit.FEET);

        var result = q.convertTo(LengthUnit.INCH);

        assertEquals(12.0,
                result.convertTo(LengthUnit.INCH),
                1e-6);
    }

    // ===== ADDITION (UC6) =====
    @Test
    void testAddition_DefaultUnit() {
        var q1 = new Quantity_measurement_app.Quantity(1.0, LengthUnit.FEET);
        var q2 = new Quantity_measurement_app.Quantity(12.0, LengthUnit.INCH);

        var result = q1.add(q2);

        assertEquals(2.0,
                result.convertTo(LengthUnit.FEET),
                1e-6);
    }

    // ===== ADDITION WITH TARGET (UC7) =====
    @Test
    void testAddition_TargetUnit_Yard() {
        var q1 = new Quantity_measurement_app.Quantity(1.0, LengthUnit.FEET);
        var q2 = new Quantity_measurement_app.Quantity(12.0, LengthUnit.INCH);

        var result = q1.add(q2, LengthUnit.YARD);

        assertEquals(0.6667,
                result.convertTo(LengthUnit.YARD),
                1e-3);
    }

    // ===== EDGE CASES =====
    @Test
    void testNullUnit_Throws() {
        assertThrows(IllegalArgumentException.class, () ->
                new Quantity_measurement_app.Quantity(1.0, null));
    }

    @Test
    void testInvalidValue_Throws() {
        assertThrows(IllegalArgumentException.class, () ->
                new Quantity_measurement_app.Quantity(Double.NaN, LengthUnit.FEET));
    }

    @Test
    void testNullAddition_Throws() {
        var q = new Quantity_measurement_app.Quantity(1.0, LengthUnit.FEET);

        assertThrows(IllegalArgumentException.class, () ->
                q.add(null));
    }
}