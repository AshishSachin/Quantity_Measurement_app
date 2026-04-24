public class Quantity_measurement_app {

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

        // ===== Convert =====
        public Quantity convertTo(LengthUnit targetUnit) {
            if (targetUnit == null) {
                throw new IllegalArgumentException("Target unit cannot be null");
            }

            double base = unit.convertToBaseUnit(value);
            double result = targetUnit.convertFromBaseUnit(base);

            return new Quantity(result, targetUnit);
        }

        // ===== Equality =====
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;

            if (obj == null || getClass() != obj.getClass())
                return false;

            Quantity other = (Quantity) obj;

            double thisBase = unit.convertToBaseUnit(value);
            double otherBase = other.unit.convertToBaseUnit(other.value);

            return Double.compare(thisBase, otherBase) == 0;
        }

        // ===== UC6 =====
        public Quantity add(Quantity other) {
            return this.add(other, this.unit);
        }

        // ===== UC7 =====
        public Quantity add(Quantity other, LengthUnit targetUnit) {
            if (other == null || targetUnit == null) {
                throw new IllegalArgumentException("Invalid input");
            }

            double sumBase =
                    unit.convertToBaseUnit(value) +
                            other.unit.convertToBaseUnit(other.value);

            double result = targetUnit.convertFromBaseUnit(sumBase);

            return new Quantity(result, targetUnit);
        }

        @Override
        public String toString() {
            return value + " " + unit;
        }
    }

    // ===== Demo =====
    public static void main(String[] args) {

        Quantity q1 = new Quantity(1.0, LengthUnit.FEET);
        Quantity q2 = new Quantity(12.0, LengthUnit.INCH);

        System.out.println(q1.convertTo(LengthUnit.INCH)); // 12 INCH
        System.out.println(q1.equals(q2));                 // true
        System.out.println(q1.add(q2));                   // 2 FEET
        System.out.println(q1.add(q2, LengthUnit.YARD));  // ~0.667 YARD
    }
}