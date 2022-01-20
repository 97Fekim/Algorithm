package _35SearchInsertPosition;

public class Solution {
    public int searchInsert(int[] nums, int target) {

        // 브루트 포스
        /*for(int i=0; i < nums.length-1; ++i)
        {
            if(target <= nums[i])
                return i;
        }
        return nums.length;*/

        // 이진탐색
        int first = 0;
        int last = nums.length - 1;
        int mid;

        while(first <= last){
            mid = (first + last) / 2;
            if(target == nums[mid])
                return mid;
            else if(target < nums[mid])
                last = mid -1;
            else
                first = mid + 1;
        }
        return first;

    }
}
