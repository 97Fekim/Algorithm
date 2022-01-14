package _1TwoSum;

public class _1TwoSum_bruteForce
{
	public int[] twoSum_1(int[] nums, int target)
    {		
		int len = nums.length;
        int first = 0 , second = 0;
        
        OUT : for(int i = 0; i < len-1; ++i)
        {
            first = i;
           
            for(int j = i+1; j < len; ++j)
            {
            	if(nums[i] + nums[j] == target)
                {    
                    second = j;
                    break OUT;
                }
            }
        }

        int[] temp = new int[2];
        temp[0] = first;
        temp[1] = second;
              
        return temp;
    }
}
