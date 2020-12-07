package languagebasic;

import lombok.extern.slf4j.Slf4j;
import personal.models.ArrayViolationCriteria;
import personal.validation.ViolationRuleArrayValidation;

import java.util.Arrays;


/**
 * Given array of integers, for each position i, search among the previous positions for the last (from the left) position that contains a smaller value. Store this value at position i in the answer. If no such value can be found, store -1 instead.
 * <p>
 * Example
 * <p>
 * For items = [3, 5, 2, 4, 5], the output should be
 * arrayPreviousLess(items) = [-1, 3, -1, 2, 4]
 */
@Slf4j
public class ArrayPreviousLess {
    private final ViolationRuleArrayValidation validation;

    public ArrayPreviousLess(ArrayViolationCriteria violationCriteria) {
        this.validation = new ViolationRuleArrayValidation(violationCriteria);
    }

    /**
     * @param items Non-empty array of positive integers
     * @return Array containing answer values computed
     * @throws CustomException if the input violates rules
     *                         3 ≤ items.length ≤ 15
     *                         1 ≤ items[i] ≤ 200
     */
    public int[] arrayPreviousLess(int[] items) {
        validation.validateViolationRules(items);
        int actualValueToCompare = 0;
        for (int i = 0; i < items.length; i++) {
            if (i == 0) {
                actualValueToCompare = items[i];
                items[i] = -1;
                continue;
            }

            if (items[i] > actualValueToCompare) {
                int tempt = actualValueToCompare;
                actualValueToCompare = items[i];
                items[i] = tempt;
            }else {
                actualValueToCompare = items[i];
                items[i] = -1;
            }
        }
        log.info(Arrays.toString(items));
        return items;
    }
}
