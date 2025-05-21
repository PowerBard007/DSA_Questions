/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

 

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
 

Constraints:

2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.


*/ 

class TwoSum
{
    public int[] twoSum(int[] nums, int target) 
    {
        int n=nums.length;

        if(n>1000000000||n<2) 
            System.exit(0);

        if(target>1000000000||target<-1000000000) 
            System.exit(0);

        for(int i=0;i<n;i++)
            if (nums[i]>1000000000||nums[i]<-1000000000)
                System.exit(0);


        for (int a = 0; a < n; a++) 
            for (int b = a+1; b < n; b++) 
                if (a != b) 
                    if (nums[a] + nums[b] == target) 
                        return new int[] {a,b};
                        
        return new int [] {-1,-1};
    }
}

//given answer is O(n^2), to get better result use hash map
//When in doubt, regurgitate a HASH MAP 