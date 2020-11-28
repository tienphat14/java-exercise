package personal.models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ArrayViolationCriteria {
    private int minLength;
    private int maxLength;
    private int minValue;
    private int maxValue;
}
