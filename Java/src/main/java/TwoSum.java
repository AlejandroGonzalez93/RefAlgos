import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	/* https://leetcode.com/problems/two-sum/description/ */
	
	public static void main(String[] args) {
		/* test cases */
		int[] num1 = {2,7,11,15};int target1 = 9;	int[] result1 = {0,1};
		int[] num2 = {3,2,4};    int target2 = 6;	int[] result2 = {1,2};
		int[] num3 = {3,3};		 int target3 = 6;	int[] result3 = {0,1};
		
		int[] resultAlgo = myAlgo(num3, target3);
		
		if (resultAlgo.length!=0) {			
			System.out.println(resultAlgo[0]);
			System.out.println(resultAlgo[1]);
		}
	}
	
	/* O(n^2) */
	private static int[] myAlgo(int[] nums, int target) {
		for(int i=0; i<nums.length-1;i++) {
			for(int j=i+1; j<nums.length;j++) {
				if(nums[i]+nums[j]==target) return new int[] {i,j};
			}			
		}
		return new int[] {};
	}
	
	/* O(n) */
	private static int[] optimizedAlgo(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        return new int[] {};
	}

}
