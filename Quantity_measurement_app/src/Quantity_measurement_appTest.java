import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Quantity_measurement_appTest {

    @Test
    void testFeetEquality_SameValue() {
        assertTrue(Quantity_measurement_app.compareFeet(1.0, 1.0));
    }

    @Test
    void testFeetEquality_DifferentValue() {
        assertFalse(Quantity_measurement_app.compareFeet(1.0, 2.0));
    }

    @Test
    void testInchesEquality_SameValue() {
        assertTrue(Quantity_measurement_app.compareInches(1.0, 1.0));
    }

    @Test
    void testInchesEquality_DifferentValue() {
        assertFalse(Quantity_measurement_app.compareInches(1.0, 2.0));
    }

    @Test
    void testFeet_NullComparison() {
        Quantity_measurement_app.Feet f = new Quantity_measurement_app.Feet(1.0);
        assertFalse(f.equals(null));
    }

    @Test
    void testInches_NullComparison() {
        Quantity_measurement_app.Inches i = new Quantity_measurement_app.Inches(1.0);
        assertFalse(i.equals(null));
    }

    @Test
    void testSameReference() {
        Quantity_measurement_app.Feet f = new Quantity_measurement_app.Feet(1.0);
        assertTrue(f.equals(f));
    }

    @Test
    void testDifferentType() {
        Quantity_measurement_app.Feet f = new Quantity_measurement_app.Feet(1.0);
        assertFalse(f.equals("1.0"));
    }
}