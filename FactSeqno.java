/*The set [1, 2, 3, ..., n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

 

Example 1:

Input: n = 3, k = 3
Output: "213"
Example 2:

Input: n = 4, k = 9
Output: "2314"
Example 3:

Input: n = 3, k = 1
Output: "123"
 

Constraints:

1 <= n <= 9
1 <= k <= n!
 */

class FactSeqno
{
    int factorial(int n)
    {
        if(n==0||n==1)
            return 1;
        else
            return n*factorial(n-1);
    }

    public String getPermutation(int n, int k) 
    {
        int f,i;
        String s="";
        char c;

        if(n>9||n<1)
            System.exit(0);

        f=factorial(n);

        if(k>f||k<1)
            System.exit(0);
        
        char [] ar= new char[n];

        for(i=0;i<n;i++)
            ar[i]=(char)(i+49);

        int d=f/n;
        k=k-1;

        int num,den;
        while(d!=0)
        {
            num=k/d;
            den=k%d;
            c=ar[num];
            s=s+c;
            for(i=num;i<n-1;i++)
                ar[i]=ar[i+1];
            n=n-1;
            if(n==0)
                break;
            d=d/n;
            k=den;
        }

        return s; 
    }
}