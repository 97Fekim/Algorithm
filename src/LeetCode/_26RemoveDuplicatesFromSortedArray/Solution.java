package LeetCode._26RemoveDuplicatesFromSortedArray;

public class Solution {
    public int removeDuplicates(int[] nums) {

        if(nums.length == 0)
            return 0;

        int[] dst = new int[nums.length];

        dst[0] = nums[0];
        int cnt = 1;

        for(int i=1, j=1; i<nums.length; ++i)
        {
            if(nums[i] != nums[i-1])
            {
                dst[j] = nums[i];
                j++;
                cnt++;
            }
        }

        for(int i=0; i < nums.length; ++i)
        {
            nums[i] = dst[i];
        }

        return cnt;
    }
}
