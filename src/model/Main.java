package model;

import leetcode.easy.*;
import leetcode.medium.*;
import mock_interviews.MockWithEdith;
import mock_interviews.SortedArrayToBST;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        /*main.solution15();
        //main.solution62();
        //main.solution63();
        //main.solution1470();
        //main.solution914();
        //main.solution605();
        //main.mockWithEdith();
        //main.sortedArrayToBST();
        //main.solution299();
        //main.solution69();
        //main.solution82();
        //main.asteroidCollision();
        //main.combinationSum3();
        //main.letterCasePermutation();
        //main.solution79();
        //main.sumNumbers();
        //main.combinationSum();*/
        //main.combinationSum2();
        //main.combinationSum3();
        //main.smallestFromLeaf();
        main.combine();
    }

    void letterCasePermutation() {
        Solution784 sol = new Solution784();
        System.out.println(sol.letterCasePermutation("a1b1"));
    }

    void sumNumbers() {
        Solution129 sol = new Solution129();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);
        root.right = new TreeNode(0);
        //root.left = new TreeNode(2);
        System.out.println(sol.sumNumbers(root));

    }

    void smallestFromLeaf() {
        Solution988 sol = new Solution988();
        TreeNode root = new TreeNode(25);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(2);
        //root.left = new TreeNode(2);
        System.out.println(sol.smallestFromLeaf(root));

    }

    void solution79() {
        Solution79 sol = new Solution79();

        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word1 = "ABCCED";
        String word2 = "SEE";
        String word3 = "ABCB";
        System.out.println(sol.exist(board, word1));
        System.out.println(sol.exist(board, word2));
        System.out.println(sol.exist(board, word3));
    }

    void combinationSum() {
        Solution39 sol = new Solution39();
        int[] candidates = {2, 3, 6, 7};
        System.out.println(sol.combinationSum(candidates, 7));
    }

    void combinationSum2() {
        Solution40 sol = new Solution40();
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        System.out.println(sol.combinationSum2(candidates, 8));
    }

    void combinationSum3() {
        Solution216 sol = new Solution216();
        System.out.println(sol.combinationSum3(3, 9));
    }

    void combine() {
        Solution77 sol = new Solution77();
        System.out.println(sol.combine(4, 2));
    }

    void solution15() {
        Solution15 sol = new Solution15();
        int[] num = {-1, 0, 1, 2, -1, -4};
        System.out.println(sol.threeSum(num));
    }

    void solution1470() {
        Solution1470 sol = new Solution1470();
        int[] num = {-1, 0, 1, 2, -1, -4};
        System.out.println(Arrays.toString(sol.shuffle(num, 3)));
    }

    void solution442() {
        Solution442 sol = new Solution442();
        int[] num = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(sol.findDuplicates(num));
    }

    void solution448() {
        Solution448 sol = new Solution448();
        int[] num = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(sol.findDisappearedNumbers(num));
    }

    void solution605() {
        Solution605 sol = new Solution605();
        int[] num = {1, 0, 0, 0, 1};
        System.out.println(sol.canPlaceFlowers(num, 1));
    }

    void solution914() {
        Solution914 sol = new Solution914();
        int[] num = {1, 1, 1, 1, 2, 2, 2, 2, 2, 2};
        System.out.println(sol.hasGroupsSizeX(num));
    }

    void solution62() {
        Solution62 sol = new Solution62();
        int m = 4, n = 4;
        System.out.println(sol.uniquePaths(m, n));
    }

    void solution69() {
        Solution69 sol = new Solution69();
        int m = 4;
        System.out.println(sol.mySqrt(m));
    }

    void solution63() {
        Solution63 sol = new Solution63();
        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(sol.uniquePathsWithObstacles(obstacleGrid));
    }

    void mockWithEdith() {
        MockWithEdith sol = new MockWithEdith();
        String input = "12345 abcd";
        System.out.println(sol.myAtoi(input));
    }

    void solution82() {
        Solution82 sol = new Solution82();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        System.out.println(sol.deleteDuplicates(head));
    }

    void solution299() {
        Solution299 sol = new Solution299();
        String secret = "1123";
        String guess = "0111";

        System.out.println(sol.getHint(secret, guess));
    }

    void sortedArrayToBST() {
        SortedArrayToBST sol = new SortedArrayToBST();
        int[] num = {-10, -3, 0, 5, 9};
        System.out.println(sol.sortedArrayToBST(num).val);
    }

    void asteroidCollision() {
        Solution735 sol = new Solution735();
        int[] nums = {-2, -2, 1, -2};
        int[] nums1 = {-2, 2, 1, -2};
        int[] nums2 = {5, 10, -5};
        int[] nums3 = {8, -8};
        int[] nums4 = {10, 2, -5};
        int[] nums5 = {-2, -1, 1, 2};
        int[] nums6 = {-2, -1, 1, -2};
        int[] nums7 = {1, -1, -2, -2};
        int[] nums8 = {-9, 5, -7, 5, 2, -5, -5, 8, 3, 10};
        System.out.println(Arrays.toString(sol.asteroidCollision(nums)));
        System.out.println(Arrays.toString(sol.asteroidCollision(nums1)));
        System.out.println(Arrays.toString(sol.asteroidCollision(nums2)));
        System.out.println(Arrays.toString(sol.asteroidCollision(nums3)));
        System.out.println(Arrays.toString(sol.asteroidCollision(nums4)));
        System.out.println(Arrays.toString(sol.asteroidCollision(nums5)));
        System.out.println(Arrays.toString(sol.asteroidCollision(nums6)));
        System.out.println(Arrays.toString(sol.asteroidCollision(nums7)));
        System.out.println(Arrays.toString(sol.asteroidCollision(nums8)));
    }
}
