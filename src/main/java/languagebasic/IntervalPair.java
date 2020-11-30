package languagebasic;

import java.util.Objects;

public class IntervalPair {
    private Interval left;
    private Interval right;

    public IntervalPair(Interval left, Interval right) {
        this.left = left;
        this.right = right;
    }

    public Interval getLeft() {
        return left;
    }

    public Interval getRight() {
        return right;
    }

    @Override
    public String toString() {
        return left.toString() + " is overlap with " + right.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IntervalPair)) return false;
        IntervalPair that = (IntervalPair) o;
        return (Objects.equals(left, that.getLeft()) && Objects.equals(right, that.getRight())) ||
                (Objects.equals(left, that.getRight()) && Objects.equals(right, that.getLeft()));
    }

    @Override
    public int hashCode() {
        if ((left.getStart() < right.getStart()) ||
                ((left.getStart() == right.getStart()) && (left.getEnd() < right.getEnd()))) {
            return Objects.hash(left, right);
        }
        return Objects.hash(right, left);
    }
}
