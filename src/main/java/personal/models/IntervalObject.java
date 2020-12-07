package personal.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class IntervalObject {
    private int firstValue;
    private int secondValue;

    @Override
    public String toString() {
        return "[" +
                firstValue +
                ", " +
                secondValue +
                "]";
    }
}
