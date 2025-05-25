/*
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.

 

Example 1:


Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
Example 2:

Input: height = [1,1]
Output: 1
 

Constraints:

n == height.length
2 <= n <= 105
0 <= height[i] <= 104
*/
class WaterLevel 
{
    public int maxArea(int[] height) 
    {
        int n,i,max=0;

        n=height.length;

        if(n>100000||n<2)
            System.exit(0);

        for(i=0;i<n;i++)
            if(height[i]>10000||height[i]<0)
                System.exit(0);

        int a=0,b=n-1,area,m;

        while(a<b)
        {   
            if(height[a]>height[b])
                m=b;
            else
                m=a;

            area=height[m]*(b-a);

            if(area>max)
                max=area;

            if(height[a]<height[b])
                a=a+1;
            else
                b=b-1;
        }

        return max;
    }
}