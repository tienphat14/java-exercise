package languagebasic;

import personal.models.IntervalObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OverlappingIntervalPairs {
    /*
    Given a collection of intervals (an interval is defined by start and end property), implement a method to return all overlapping interval pairs.
    Example:
    Given [11, 15], [3, 9], [1, 4], [15, 18] => return [11, 15] and [15, 18], [3, 9] and [1, 4].
    Given [1, 5], [6, 8], [5, 12], [2, 6] => return [1, 5] and [5, 12], [1, 5] and [2, 6], [6, 8] and [5, 12], [5, 12] and [2, 6]
     */

    public String findOverlap(int[]... arrays) {
        List<IntervalObject> inputtedArrays = convertParamToObject(arrays);
        List<StringBuilder> output = new ArrayList<>();
        for (int x = 0; x < inputtedArrays.size(); x++) {
            IntervalObject srcObject = inputtedArrays.get(x);
            for (int y = x + 1; y < inputtedArrays.size(); y++) {
                IntervalObject desObject = inputtedArrays.get(y);
                boolean isOverlap = this.checkOverlap(srcObject, desObject);
                if (isOverlap) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(srcObject.toString())
                            .append(" and ")
                            .append(desObject.toString());
                    output.add(stringBuilder);
                }
            }
        }
        String stringOutput = output.toString();
        return stringOutput.substring(1, stringOutput.length() - 1);
    }

    private boolean checkOverlap(IntervalObject srcObject, IntervalObject desObject) {
        boolean isOverlap = false;
        if (srcObject.getFirstValue() >= desObject.getFirstValue() && srcObject.getFirstValue() <= desObject.getSecondValue())
            isOverlap = true;
        if (desObject.getFirstValue() >= srcObject.getFirstValue() && desObject.getFirstValue() <= srcObject.getSecondValue())
            isOverlap = true;
        return isOverlap;
    }


    private List<IntervalObject> convertParamToObject(int[]... arrays) {
        List<IntervalObject> inputtedArrays = new ArrayList<>();
        Arrays.stream(arrays).forEach(ints -> {
            IntervalObject o = IntervalObject.builder().firstValue(ints[0]).secondValue(ints[1]).build();
            inputtedArrays.add(o);
        });
        return inputtedArrays;
    }
}
