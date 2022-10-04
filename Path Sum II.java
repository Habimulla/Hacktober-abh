/*
113. Path Sum II
Medium
Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum.
Each path should be returned as a list of the node values, not node references.
A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.
Example 1:
Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: [[5,4,11,2],[5,8,4,5]]
Explanation: There are two paths whose sum equals targetSum:
5 + 4 + 11 + 2 = 22
5 + 8 + 4 + 5 = 22
Example 2:
Input: root = [1,2,3], targetSum = 5
Output: []
Example 3:
Input: root = [1,2], targetSum = 0
Output: []
 
Constraints:
The number of nodes in the tree is in the range [0, 5000].
-1000 <= Node.val <= 1000
-1000 <= targetSum <= 1000
*/
// Code Logic 1 : Recursion   -- Runtime 2ms
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subres = new ArrayList<>();
        Solve(root,targetSum,res,subres);
        return res;
    }
    public static void Solve(TreeNode node,int targetSum,List<List<Integer>> res, List<Integer> subres){
        if(node == null) return;
        subres.add(node.val);
        targetSum -=node.val;
        if(node.left==null && node.right==null && targetSum==0){
            res.add(new ArrayList<>(subres));
        }
        if(node.left!=null){
            Solve(node.left,targetSum,res,subres);
            subres.remove(subres.size()-1);
        }
        if(node.right!=null){
            Solve(node.right,targetSum,res,subres);
            subres.remove(subres.size()-1);
        }
    }
}

// Code 2 : Iterative way Runtime  4 ms
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Triple{
    int data;
    List<Integer> path;
    TreeNode node ;
    Triple(TreeNode node,int data,List<Integer> path){
        this.data = data;
        this.path = path;
        this.node = node;
    }
}
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        Stack<Triple> st = new Stack<>();
        st.push(new Triple(root,targetSum,new ArrayList<>()));
        while(!st.isEmpty()){
            Triple tie = st.pop();
            int val = tie.data;
            TreeNode node =tie.node;
            List<Integer> subres =tie.path;
            if(node!=null){
                subres.add(node.val);
                if(node.left==null && node.right==null && val==node.val){
                    res.add(subres);
                }
                st.push(new Triple(node.left,val-node.val,new ArrayList<>(subres)));
                st.push(new Triple(node.right,val-node.val,new ArrayList<>(subres)));
            }
        }
        //Solve(root,targetSum,res,subres);
        return res;
    }
    
    /*public static void Solve(TreeNode node,int targetSum,List<List<Integer>> res, List<Integer> subres){
        if(node == null) return;
        subres.add(node.val);
        targetSum -=node.val;
        if(node.left==null && node.right==null && targetSum==0){
            res.add(new ArrayList<>(subres));
        }
        if(node.left!=null){
            Solve(node.left,targetSum,res,subres);
            subres.remove(subres.size()-1);
        }
        if(node.right!=null){
            Solve(node.right,targetSum,res,subres);
            subres.remove(subres.size()-1);
        }
    }
    */
}
