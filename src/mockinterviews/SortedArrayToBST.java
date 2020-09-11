package mockinterviews;


import model.TreeNode;

public class SortedArrayToBST {


    /**
     * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
     * <p>
     * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
     * <p>
     * Example:
     * <p>
     * Given the sorted array: -10,-3,0,5,9,
     * <p>
     * <p>
     * <p>
     * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
     */



/*

                              0
                             / \
                           -3   9
                           /   /
                         -10  5
*/
    public TreeNode sortedArrayToBST(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        return generateBST(start, end, nums);
    }

    TreeNode generateBST(int start, int end, int[] nums) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = generateBST(start, mid - 1, nums);
        root.right = generateBST(mid + 1, end, nums);
        return root;
    }


}
