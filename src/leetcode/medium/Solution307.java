package leetcode.medium;

public class Solution307 {
    public static class NumArray {

        int[] tree;
        int[] nums;

        public NumArray(int[] nums) {
            int n = nums.length;
            this.tree = new int[n * 2 + 2];
            this.nums = nums;
            int left = 0;
            int right = n - 1;
            constructTree(1, left, right);
        }

        public void constructTree(int index, int left, int right) {
            if (left > right) return;
            if (left == right) {
                tree[index] = nums[left];
                return;
            }
            int mid = (left + right) / 2;
            constructTree(index * 2, left, mid);
            constructTree(index * 2 + 1, mid + 1, right);
            tree[index] = tree[index * 2] + tree[index * 2 + 1];
        }

        public void update(int i, int val) {
            update(i, i, 0, nums.length - 1, 1, val);
        }

        public int sumRange(int i, int j) {
            return getSum(1, i, j, 0, nums.length - 1);
        }

        public void update(int updateLeft, int updateRight, int leftNode, int rightNode, int i, int val) {
            if (updateLeft > rightNode || updateRight < leftNode)
                return;
            if (leftNode == rightNode) {
                tree[i] = val;
                nums[leftNode] = val;
                return;
            }
            int mid = (leftNode + rightNode) / 2;
            update(updateLeft, updateRight, leftNode, mid, i * 2, val);
            update(updateLeft, updateRight, mid + 1, updateRight, i * 2 + 1, val);
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
            return;
        }

        public int getSum(int index, int left, int right, int leftNode, int rightNode) {
            if (left > rightNode || right < leftNode) return 0;
            if (left <= leftNode && right >= rightNode) return tree[index];

            int mid = (leftNode + rightNode) / 2;
            int leftAns = getSum(index * 2, left, right, leftNode, mid);
            int rightAns = getSum(index * 2 + 1, left, right, mid + 1, rightNode);
            return leftAns + rightAns;
        }

    }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */


}
