/*
Two Pointers Technique
Last Updated : 16 May, 2025
Two pointers is really an easy and effective technique that is typically used for Two Sum in Sorted Arrays,
Closest Two Sum, Three Sum, Four Sum, Trapping Rain Water and many other popular interview questions.
Given a sorted array arr (sorted in ascending order) and a target, find if there exists any pair of elements
(arr[i], arr[j]) such that their sum is equal to the target.

Illustration : 

Input: arr[] = {10, 20, 35, 50}, target =70
Output:  Yes
Explanation : There is a pair (20, 50) with given target.

Input: arr[] = {10, 20, 30}, target =70
Output :  No
Explanation : There is no pair with sum 70

Input: arr[] = {-8, 1, 4, 6, 10, 45], target = 16
Output: Yes
Explanation : There is a pair (6, 10) with given target

he idea of this technique is to begin with two corners of the given array. We use two index variables left and right to traverse from both corners.

Initialize: left = 0, right = n - 1
Run a loop while left < right, do the following inside the loop

Compute current sum, sum = arr[left] + arr[right]
If the sum equals the target, we’ve found the pair.
If the sum is less than the target, move the left pointer to the right to increase the sum.
If the sum is greater than the target, move the right pointer to the left to decrease the sum.
*/

//I am inputting an array and a target and then i will use this method to find no of paris and output it

import java.util.*;

public class twopointersearch
{
    public static void main(String []args)
    {
        Scanner in = new Scanner (System.in);

        int n,i,tt,t,s,j;

        System.out.println("Enter the number of elements");
        n=in.nextInt();

        int[] k = new int[n];


        System.out.println("Enter the elements");

        for(i=0;i<n;i++)
            k[i]=in.nextInt();

        System.out.println("Enter the target number");
        tt=in.nextInt();

        for(i=0;i<n-1;i++)
        {   
            s=0;
            for(j=0;j<n-i-1;j++)
            {
                if(k[j+1]<k[j])
                {
                    t=k[j+1];
                    k[j+1]=k[j];
                    k[j]=t;
                    s=1;
                }
            }
            if(s==0)
                break;
        }


        int a,b,u=0;

        a=0;b=n-1;

        while(a!=b)
        {
            int sum =k[a]+k[b];

            if(sum==tt)
            {
                u=u+1;
                System.out.println("Pair"+u+"=("+k[a]+","+k[b]+")");
                a=a+1;
            }
            else
            if(sum>tt)
                b=b-1;
            else
                a=a+1;
        }
        System.out.println("No of pairs="+u);
    }
}