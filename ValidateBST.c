/*
Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 

Example 1:


Input: root = [2,1,3]
Output: true
Example 2:


Input: root = [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-231 <= Node.val <= 231 - 1
*/
#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

  struct TreeNode {
      int val;
      struct TreeNode *left;
      struct TreeNode *right;
  };
 
typedef struct TreeNode * node;

int count(node root,int *x,int *t)
{
    if(root!=NULL)
    {
        *x=*x+1;
        if(root->val>2147483647||root->val<-2147483648)
            *t=1;
        count(root->left,x,t);
        count(root->right,x,t);
    }
    return *x;
}

void inorder(node head,long int *val,int *f)
{
    if(head==NULL)
        return ;
    
    inorder(head->left,val,f);
    if(head->val>*val)
        *val=head->val;
    else
        *f=0;
    inorder(head->right,val,f);

}   

bool isValidBST(node root) 
{
    int x=1,n=0,t=0;

    n=count(root,&n,&t);

    if(t==1)
        return false;

    if(n>10000||n<1)
        return false;

    long int val=-2147483649;
    inorder(root,&val,&x);

    if(x==1)
        return true;
    else
        return false;
    
}

