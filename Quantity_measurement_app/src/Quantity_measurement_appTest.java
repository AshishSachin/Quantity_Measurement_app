import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Quantity_measurement_appTest {

    @Test
    void testAddition_TargetFeet() {
        var q1 = new Quantity_measurement_app.Quantity(1.0, Quantity_measurement_app.LengthUnit.FEET);
        var q2 = new Quantity_measurement_app.Quantity(12.0, Quantity_measurement_app.LengthUnit.INCH);

        assertEquals(2.0, q1.add(q2, Quantity_measurement_app.LengthUnit.FEET)
                .convertTo(Quantity_measurement_app.LengthUnit.FEET), 1e-6);
    }

    @Test
    void testAddition_TargetInches() {
        var q1 = new Quantity_measurement_app.Quantity(1.0, Quantity_measurement_app.LengthUnit.FEET);
        var q2 = new Quantity_measurement_app.Quantity(12.0, Quantity_measurement_app.LengthUnit.INCH);

        assertEquals(24.0, q1.add(q2, Quantity_measurement_app.LengthUnit.INCH)
                .convertTo(Quantity_measurement_app.LengthUnit.INCH), 1e-6);
    }

    @Test
    void testAddition_TargetYards() {
        var q1 = new Quantity_measurement_app.Quantity(1.0, Quantity_measurement_app.LengthUnit.FEET);
        var q2 = new Quantity_measurement_app.Quantity(12.0, Quantity_measurement_app.LengthUnit.INCH);

        assertEquals(0.6667, q1.add(q2, Quantity_measurement_app.LengthUnit.YARD)
                .convertTo(Quantity_measurement_app.LengthUnit.YARD), 1e-3);
    }

    @Test
    void testAddition_Commutativity() {
        var q1 = new Quantity_measurement_app.Quantity(1.0, Quantity_measurement_app.LengthUnit.FEET);
        var q2 = new Quantity_measurement_app.Quantity(12.0, Quantity_measurement_app.LengthUnit.INCH);

        var result1 = q1.add(q2, Quantity_measurement_app.LengthUnit.FEET);
        var result2 = q2.add(q1, Quantity_measurement_app.LengthUnit.FEET);

        assertEquals(result1.convertTo(Quantity_measurement_app.LengthUnit.FEET),
                result2.convertTo(Quantity_measurement_app.LengthUnit.FEET), 1e-6);
    }

    @Test
    void testAddition_NullTarget() {
        var q1 = new Quantity_measurement_app.Quantity(1.0, Quantity_measurement_app.LengthUnit.FEET);
        var q2 = new Quantity_measurement_app.Quantity(12.0, Quantity_measurement_app.LengthUnit.INCH);

        assertThrows(IllegalArgumentException.class, () -> q1.add(q2, null));
    }
}