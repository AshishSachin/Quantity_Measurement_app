import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Quantity_measurement_appTest {

    @Test
    void testEquality_SameValue() {
        Quantity_measurement_app.Feet f1 = new Quantity_measurement_app.Feet(1.0);
        Quantity_measurement_app.Feet f2 = new Quantity_measurement_app.Feet(1.0);

        assertTrue(f1.equals(f2));
    }

    @Test
    void testEquality_DifferentValue() {
        Quantity_measurement_app.Feet f1 = new Quantity_measurement_app.Feet(1.0);
        Quantity_measurement_app.Feet f2 = new Quantity_measurement_app.Feet(2.0);

        assertFalse(f1.equals(f2));
    }

    @Test
    void testEquality_NullComparison() {
        Quantity_measurement_app.Feet f1 = new Quantity_measurement_app.Feet(1.0);

        assertFalse(f1.equals(null));
    }

    @Test
    void testEquality_SameReference() {
        Quantity_measurement_app.Feet f1 = new Quantity_measurement_app.Feet(1.0);

        assertTrue(f1.equals(f1));
    }

    @Test
    void testEquality_DifferentType() {
        Quantity_measurement_app.Feet f1 = new Quantity_measurement_app.Feet(1.0);

        assertFalse(f1.equals("1.0"));
    }
}