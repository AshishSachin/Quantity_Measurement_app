import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Quantity_measurement_appTest {

    @Test
    void testEquality_FeetToFeet_SameValue() {
        Quantity_measurement_app.Quantity q1 =
                new Quantity_measurement_app.Quantity(1.0, Quantity_measurement_app.LengthUnit.FEET);
        Quantity_measurement_app.Quantity q2 =
                new Quantity_measurement_app.Quantity(1.0, Quantity_measurement_app.LengthUnit.FEET);

        assertTrue(q1.equals(q2));
    }

    @Test
    void testEquality_InchToInch_SameValue() {
        Quantity_measurement_app.Quantity q1 =
                new Quantity_measurement_app.Quantity(1.0, Quantity_measurement_app.LengthUnit.INCH);
        Quantity_measurement_app.Quantity q2 =
                new Quantity_measurement_app.Quantity(1.0, Quantity_measurement_app.LengthUnit.INCH);

        assertTrue(q1.equals(q2));
    }

    @Test
    void testEquality_FeetToInch_EquivalentValue() {
        Quantity_measurement_app.Quantity q1 =
                new Quantity_measurement_app.Quantity(1.0, Quantity_measurement_app.LengthUnit.FEET);
        Quantity_measurement_app.Quantity q2 =
                new Quantity_measurement_app.Quantity(12.0, Quantity_measurement_app.LengthUnit.INCH);

        assertTrue(q1.equals(q2));
    }

    @Test
    void testEquality_DifferentValue() {
        Quantity_measurement_app.Quantity q1 =
                new Quantity_measurement_app.Quantity(1.0, Quantity_measurement_app.LengthUnit.FEET);
        Quantity_measurement_app.Quantity q2 =
                new Quantity_measurement_app.Quantity(2.0, Quantity_measurement_app.LengthUnit.FEET);

        assertFalse(q1.equals(q2));
    }

    @Test
    void testEquality_NullComparison() {
        Quantity_measurement_app.Quantity q1 =
                new Quantity_measurement_app.Quantity(1.0, Quantity_measurement_app.LengthUnit.FEET);

        assertFalse(q1.equals(null));
    }

    @Test
    void testEquality_SameReference() {
        Quantity_measurement_app.Quantity q1 =
                new Quantity_measurement_app.Quantity(1.0, Quantity_measurement_app.LengthUnit.FEET);

        assertTrue(q1.equals(q1));
    }
}