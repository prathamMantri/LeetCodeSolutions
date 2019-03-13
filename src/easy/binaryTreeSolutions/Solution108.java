package easy.binaryTreeSolutions;

public class Solution108 {

   /* Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

    For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

    Example:

    Given the sorted array: [-10,-3,0,5,9],

    One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

             0
            / \
          -3   9
          /   /
        -10  5
    */

    public void sortedArrayToBST(int[] nums) {

        int start=0;
        int end = nums.length-1;

        System.out.println(getBST(start,end,nums));

       // return getBST(start, end, nums);

    }
    public TreeNode getBST(int start, int end, int[] nums){

        if(start>end){
            return null;
        }

        int mid = (start+end)/2 ;

        TreeNode root = new TreeNode(nums[mid]);

        root.left = getBST(start, mid-1, nums);
        root.right = getBST(mid+1, end, nums);

        return root;
    }

    public static void main(String args[]){
        int[] nums = {-10,-3,0,5,9};
        Solution108 solution108 = new Solution108();

        solution108.sortedArrayToBST(nums);

    }
}
