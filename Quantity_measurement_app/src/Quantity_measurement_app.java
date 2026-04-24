public class QuantityMeasurementApp {

    // ================= LENGTH =================
    enum LengthUnit {
        FEET(1.0),
        INCH(1.0 / 12.0),
        YARD(3.0),
        CM(0.0328084);

        private final double toFeetFactor;

        LengthUnit(double factor) {
            this.toFeetFactor = factor;
        }

        public double toBase(double value) {
            return value * toFeetFactor;
        }

        public double fromBase(double baseValue) {
            return baseValue / toFeetFactor;
        }
    }

    static class QuantityLength {
        private final double value;
        private final LengthUnit unit;

        public QuantityLength(double value, LengthUnit unit) {
            if (unit == null || !Double.isFinite(value)) {
                throw new IllegalArgumentException("Invalid input");
            }
            this.value = value;
            this.unit = unit;
        }

        public QuantityLength convertTo(LengthUnit target) {
            double base = unit.toBase(value);
            return new QuantityLength(target.fromBase(base), target);
        }

        public QuantityLength add(QuantityLength other, LengthUnit target) {
            double sum = unit.toBase(value) + other.unit.toBase(other.value);
            return new QuantityLength(target.fromBase(sum), target);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;

            QuantityLength other = (QuantityLength) obj;
            return Double.compare(
                    unit.toBase(value),
                    other.unit.toBase(other.value)
            ) == 0;
        }

        public String toString() {
            return value + " " + unit;
        }
    }

    // ================= WEIGHT =================
    enum WeightUnit {
        KILOGRAM(1.0),
        GRAM(0.001),
        POUND(0.453592);

        private final double toKgFactor;

        WeightUnit(double factor) {
            this.toKgFactor = factor;
        }

        public double toBase(double value) {
            return value * toKgFactor;
        }

        public double fromBase(double baseValue) {
            return baseValue / toKgFactor;
        }
    }

    static class QuantityWeight {
        private final double value;
        private final WeightUnit unit;

        public QuantityWeight(double value, WeightUnit unit) {
            if (unit == null || !Double.isFinite(value)) {
                throw new IllegalArgumentException("Invalid input");
            }
            this.value = value;
            this.unit = unit;
        }

        public QuantityWeight convertTo(WeightUnit target) {
            double base = unit.toBase(value);
            return new QuantityWeight(target.fromBase(base), target);
        }

        public QuantityWeight add(QuantityWeight other, WeightUnit target) {
            double sum = unit.toBase(value) + other.unit.toBase(other.value);
            return new QuantityWeight(target.fromBase(sum), target);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;

            QuantityWeight other = (QuantityWeight) obj;
            return Double.compare(
                    unit.toBase(value),
                    other.unit.toBase(other.value)
            ) == 0;
        }

        public String toString() {
            return value + " " + unit;
        }
    }

    // ================= MAIN =================
    public static void main(String[] args) {

        // ===== LENGTH =====
        QuantityLength l1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength l2 = new QuantityLength(12.0, LengthUnit.INCH);

        System.out.println(l1.equals(l2)); // true
        System.out.println(l1.convertTo(LengthUnit.INCH)); // 12 INCH
        System.out.println(l1.add(l2, LengthUnit.FEET)); // 2 FEET

        // ===== WEIGHT =====
        QuantityWeight w1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight w2 = new QuantityWeight(1000.0, WeightUnit.GRAM);

        System.out.println(w1.equals(w2)); // true
        System.out.println(w1.convertTo(WeightUnit.GRAM)); // 1000 GRAM
        System.out.println(w1.add(w2, WeightUnit.KILOGRAM)); // 2 KG

        // Cross-category check (should be false)
        System.out.println(l1.equals(w1)); // false
    }
}