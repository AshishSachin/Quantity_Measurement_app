public class Quantity_measurement_app {

    // ===== ENUM (base unit = FEET) =====
    enum LengthUnit {
        FEET(1.0),
        INCH(1.0 / 12.0),
        YARD(3.0),
        CM(0.0328084);

        private final double toFeetFactor;

        LengthUnit(double factor) {
            this.toFeetFactor = factor;
        }

        public double toFeet(double value) {
            return value * toFeetFactor;
        }

        public double fromFeet(double feetValue) {
            return feetValue / toFeetFactor;
        }
    }

    // ===== QUANTITY CLASS =====
    static class Quantity {
        private final double value;
        private final LengthUnit unit;

        public Quantity(double value, LengthUnit unit) {
            if (unit == null || !Double.isFinite(value)) {
                throw new IllegalArgumentException("Invalid input");
            }
            this.value = value;
            this.unit = unit;
        }

        // ===== UC6: ADD METHOD =====
        public Quantity add(Quantity other, LengthUnit targetUnit) {
            if (other == null || targetUnit == null) {
                throw new IllegalArgumentException("Invalid input");
            }

            // Convert both to base unit (feet)
            double thisFeet = this.unit.toFeet(this.value);
            double otherFeet = other.unit.toFeet(other.value);

            // Add
            double sumFeet = thisFeet + otherFeet;

            // Convert to target unit
            double resultValue = targetUnit.fromFeet(sumFeet);

            return new Quantity(resultValue, targetUnit);
        }


        @Override
        public String toString() {
            return value + " " + unit;
        }
    }

    // ===== MAIN METHOD =====
    public static void main(String[] args) {

        Quantity q1 = new Quantity(1.0, LengthUnit.FEET);
        Quantity q2 = new Quantity(12.0, LengthUnit.INCH);

        System.out.println(q1.add(q2)); // 2.0 FEET

        Quantity q3 = new Quantity(12.0, LengthUnit.INCH);
        Quantity q4 = new Quantity(1.0, LengthUnit.FEET);

        System.out.println(q3.add(q4)); // 24.0 INCH

        Quantity q5 = new Quantity(1.0, LengthUnit.YARD);
        Quantity q6 = new Quantity(3.0, LengthUnit.FEET);

        System.out.println(q5.add(q6)); // 2.0 YARD
    }
}