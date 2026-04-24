public class Quantity_measurement_app {

    // Step 1: Enum for units
    enum LengthUnit {
        FEET(1.0),
        INCH(1.0 / 12.0);

        private final double conversionFactorToFeet;

        LengthUnit(double factor) {
            this.conversionFactorToFeet = factor;
        }

        public double toFeet(double value) {
            return value * conversionFactorToFeet;
        }
    }

    // Step 2: Generic Quantity Class
    static class Quantity {
        private final double value;
        private final LengthUnit unit;

        public Quantity(double value, LengthUnit unit) {
            if (unit == null) {
                throw new IllegalArgumentException("Unit cannot be null");
            }
            this.value = value;
            this.unit = unit;
        }

        private double toFeet() {
            return unit.toFeet(value);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;

            if (obj == null || getClass() != obj.getClass())
                return false;

            Quantity other = (Quantity) obj;

            return Double.compare(this.toFeet(), other.toFeet()) == 0;
        }
    }

    // Main method
    public static void main(String[] args) {

        Quantity q1 = new Quantity(1.0, LengthUnit.FEET);
        Quantity q2 = new Quantity(12.0, LengthUnit.INCH);

        System.out.println("Equal: " + q1.equals(q2));
    }
}