package _1TwoSum;

import java.util.HashMap;
import java.util.Map;

public class _1TwoSum_HashMap
{
	public int[] twoSum_2(int[] array, int target)
	{
		HashMap<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
		
		for(int i=0; i<array.length; ++i)
		{
			int requireNum = (int)(target - array[i]);
			
			if(indexMap.containsKey(requireNum))
			{
				int toReturn[] = {indexMap.get(requireNum),i};
				return toReturn;
			}
			indexMap.put(array[i], i);					
		}
		return null;
	}
}
