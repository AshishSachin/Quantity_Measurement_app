import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

class Quantity_measurement_appTest {

    @Test
    void testFeetToInches() {
        assertEquals(12.0,
                Quantity_measurement_app.convert(1.0,
                        Quantity_measurement_app.LengthUnit.FEET,
                        Quantity_measurement_app.LengthUnit.INCH),
                1e-6);
    }

    @Test
    void testYardsToFeet() {
        assertEquals(9.0,
                Quantity_measurement_app.convert(3.0,
                        Quantity_measurement_app.LengthUnit.YARD,
                        Quantity_measurement_app.LengthUnit.FEET),
                1e-6);
    }

    @Test
    void testCmToInch() {
        assertEquals(0.393701,
                Quantity_measurement_app.convert(1.0,
                        Quantity_measurement_app.LengthUnit.CM,
                        Quantity_measurement_app.LengthUnit.INCH),
                1e-3);
    }

    @Test
    void testRoundTrip() {
        double v = 5.0;

        double converted = Quantity_measurement_app.convert(v,
                Quantity_measurement_app.LengthUnit.FEET,
                Quantity_measurement_app.LengthUnit.INCH);

        double back = Quantity_measurement_app.convert(converted,
                Quantity_measurement_app.LengthUnit.INCH,
                Quantity_measurement_app.LengthUnit.FEET);

        assertEquals(v, back, 1e-6);
    }

    @Test
    void testInvalidInput() {
        assertThrows(IllegalArgumentException.class, () ->
                Quantity_measurement_app.convert(Double.NaN,
                        Quantity_measurement_app.LengthUnit.FEET,
                        Quantity_measurement_app.LengthUnit.INCH));
    }
}