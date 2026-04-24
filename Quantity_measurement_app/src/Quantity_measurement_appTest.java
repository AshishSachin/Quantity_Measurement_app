import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Quantity_measurement_appTest {

    @Test
    public void testYardToFeet() {
        var q1 = new Quantity_measurement_app.Quantity(1.0, Quantity_measurement_app.LengthUnit.YARD);
        var q2 = new Quantity_measurement_app.Quantity(3.0, Quantity_measurement_app.LengthUnit.FEET);

        assertTrue(q1.equals(q2));
    }

    @Test
    public void testYardToInches() {
        var q1 = new Quantity_measurement_app.Quantity(1.0, Quantity_measurement_app.LengthUnit.YARD);
        var q2 = new Quantity_measurement_app.Quantity(36.0, Quantity_measurement_app.LengthUnit.INCH);

        assertTrue(q1.equals(q2));
    }

    @Test
    public void testCmToInch() {
        var q1 = new Quantity_measurement_app.Quantity(1.0, Quantity_measurement_app.LengthUnit.CM);
        var q2 = new Quantity_measurement_app.Quantity(0.393701, Quantity_measurement_app.LengthUnit.INCH);

        assertTrue(q1.equals(q2));
    }

    @Test
    public void testDifferentValues() {
        var q1 = new Quantity_measurement_app.Quantity(1.0, Quantity_measurement_app.LengthUnit.YARD);
        var q2 = new Quantity_measurement_app.Quantity(2.0, Quantity_measurement_app.LengthUnit.FEET);

        assertFalse(q1.equals(q2));
    }

    @Test
    public void testTransitiveProperty() {
        var a = new Quantity_measurement_app.Quantity(1.0, Quantity_measurement_app.LengthUnit.YARD);
        var b = new Quantity_measurement_app.Quantity(3.0, Quantity_measurement_app.LengthUnit.FEET);
        var c = new Quantity_measurement_app.Quantity(36.0, Quantity_measurement_app.LengthUnit.INCH);

        assertTrue(a.equals(b));
        assertTrue(b.equals(c));
        assertTrue(a.equals(c));
    }

    @Test
    public void testNullComparison() {
        var q = new Quantity_measurement_app.Quantity(1.0, Quantity_measurement_app.LengthUnit.FEET);
        assertFalse(q.equals(null));
    }
}