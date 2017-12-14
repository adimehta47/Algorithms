package recursion;

//Given an array of ints, is it possible to choose a group of some of the ints, such that the group sums to the given target?
//This is a classic backtracking recursion problem. Once you understand the recursive backtracking strategy in this problem,
//you can use the same pattern for many problems to search a space of choices. Rather than looking at the whole array,
//our convention is to consider the part of the array starting at index start and continuing to the end of the array.
//The caller can specify the whole array simply by passing start as 0. No loops are needed -- the recursive calls progress down the array.


//Hint:
//The base case is when start>=nums.length. In that case, return true if target==0. Otherwise, consider the element at nums[start].
//The key idea is that there are only 2 possibilities -- nums[start] is chosen or it is not.
//Make one recursive call to see if a solution is possible if nums[start] is chosen (subtract nums[start] from target in that call).
//Make another recursive call to see if a solution is possible if nums[start] is not chosen.
//Return true if either of the two recursive calls returns true.

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class groupSum {

    public boolean groupSum(int start, int[] nums, int target) {
        // Base case: if there are no numbers left, then there is a
        // solution only if target is 0.
        if (start >= nums.length) return (target == 0);

        // Key idea: nums[start] is chosen or it is not.
        // Deal with nums[start], letting recursion
        // deal with all the rest of the array.

        // Recursive call trying the case that nums[start] is chosen --
        // subtract it from target in the call.
        if (groupSum(start + 1, nums, target - nums[start])) return true;

        // Recursive call trying the case that nums[start] is not chosen.
        if (groupSum(start + 1, nums, target)) return true;

        // If neither of the above worked, it's not possible.
        return false;
    }

    @Test
    public void test() {
        int start = 1;
        int[] nums = {1, 2, 3, 3};
        int target = 5;
        boolean expected = true;
        assertTrue(groupSum(start, nums, target) == expected,
                "Expected: " + String.valueOf(expected) + ", Actual: " + String.valueOf(groupSum(start, nums, target)));
        System.out.println(String.valueOf(groupSum(start, nums, target)));
    }
}