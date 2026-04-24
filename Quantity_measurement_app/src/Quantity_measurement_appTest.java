import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Quantity_measurement_appTest {

    @Test
    void testSameUnitAddition() {
        var q1 = new Quantity_measurement_app.Quantity(1.0, Quantity_measurement_app.LengthUnit.FEET);
        var q2 = new Quantity_measurement_app.Quantity(2.0, Quantity_measurement_app.LengthUnit.FEET);

        assertEquals(3.0, q1.add(q2).convertTo(Quantity_measurement_app.LengthUnit.FEET), 1e-6);
    }

    @Test
    void testCrossUnitAddition_FeetPlusInches() {
        var q1 = new Quantity_measurement_app.Quantity(1.0, Quantity_measurement_app.LengthUnit.FEET);
        var q2 = new Quantity_measurement_app.Quantity(12.0, Quantity_measurement_app.LengthUnit.INCH);

        assertEquals(2.0, q1.add(q2).convertTo(Quantity_measurement_app.LengthUnit.FEET), 1e-6);
    }

    @Test
    void testCrossUnitAddition_InchPlusFeet() {
        var q1 = new Quantity_measurement_app.Quantity(12.0, Quantity_measurement_app.LengthUnit.INCH);
        var q2 = new Quantity_measurement_app.Quantity(1.0, Quantity_measurement_app.LengthUnit.FEET);

        assertEquals(24.0, q1.add(q2).convertTo(Quantity_measurement_app.LengthUnit.INCH), 1e-6);
    }

    @Test
    void testAddition_WithZero() {
        var q1 = new Quantity_measurement_app.Quantity(5.0, Quantity_measurement_app.LengthUnit.FEET);
        var q2 = new Quantity_measurement_app.Quantity(0.0, Quantity_measurement_app.LengthUnit.INCH);

        assertEquals(5.0, q1.add(q2).convertTo(Quantity_measurement_app.LengthUnit.FEET), 1e-6);
    }

    @Test
    void testAddition_Negative() {
        var q1 = new Quantity_measurement_app.Quantity(5.0, Quantity_measurement_app.LengthUnit.FEET);
        var q2 = new Quantity_measurement_app.Quantity(-2.0, Quantity_measurement_app.LengthUnit.FEET);

        assertEquals(3.0, q1.add(q2).convertTo(Quantity_measurement_app.LengthUnit.FEET), 1e-6);
    }

    @Test
    void testAddition_Null() {
        var q1 = new Quantity_measurement_app.Quantity(1.0, Quantity_measurement_app.LengthUnit.FEET);

        assertThrows(IllegalArgumentException.class, () -> q1.add(null));
    }
}