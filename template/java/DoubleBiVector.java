import java.util.Objects;

class DoubleBiVector {
    double x;
    double y;
    private DoubleBiVector(final double x, final double y) {
        this.x = x;
        this.y = y;
    }
    private DoubleBiVector add(DoubleBiVector other) {
        return new DoubleBiVector(this.x+other.x, this.y+other.y);
    }
    private DoubleBiVector minus(DoubleBiVector other) {
        return new DoubleBiVector(this.x-other.x, this.y-other.y);
    }
    private DoubleBiVector rotate(double degree) {
        double radians = Math.toRadians(degree);
        double newX = Math.cos(radians)*x - Math.sin(radians)*y;
        double newY = Math.sin(radians)*x + Math.cos(radians)*y;
        return new DoubleBiVector(newX, newY);
    }
    private DoubleBiVector rotate(double degree, DoubleBiVector base) {
        return this.minus(base).rotate(degree).add(base);
    }
    @Override
    public String toString() {
        return String.format("{x=%s, y=%s}", x, y);
    }
    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final DoubleBiVector that = (DoubleBiVector) o;
        return Double.compare(that.x, x) == 0 && Double.compare(that.y, y) == 0;
    }
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}