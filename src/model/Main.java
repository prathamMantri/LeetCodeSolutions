package model;

import leetcode.medium.Solution1023;
import leetcode.medium.Solution1921;
import leetcode.medium.Solution809;
import leetcode.medium.Solution89;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        //main.solution15();
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
        //main.combine();
        //main.wordDictionary();
        //main.searchBST();
        //main.countNumbersWithUniqueDigits();
        //main.task1();
        //main.task2();
        //main.task3();
        //main.task4();
        //main.longestSubarray();
        //main.validateStackSequences();
        //main.maxDistance();
        //main.isNStraightHand();
        //main.isPossible();
        //main.expressiveWords();
        //main.camelMatch();
        //main.getMaximumGold();
        main.grayCode();
    }

    /*
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

    void wordDictionary() {
        Solution211.WordDictionary wordDictionary = new Solution211.WordDictionary();
        wordDictionary.addWord("a");
        wordDictionary.addWord("a");
        System.out.println(wordDictionary.search("."));
        System.out.println(wordDictionary.search("a"));
        System.out.println(wordDictionary.search("aa"));
        System.out.println(wordDictionary.search("a"));
        System.out.println(wordDictionary.search(".a"));
        System.out.println(wordDictionary.search("a."));
    }

    void searchBST() {
        Solution700 sol = new Solution700();
        TreeNode root = new TreeNode(4,
                new TreeNode(2,
                        new TreeNode(1,
                                null,
                                null),
                        new TreeNode(3,
                                null,
                                null)),
                new TreeNode(7, null, null));
        /*root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);*/
    /*
        System.out.println(sol.searchBST(root, 2).val);

    }

    void countNumbersWithUniqueDigits() {
        Solution357 sol = new Solution357();
        System.out.println(sol.countNumbersWithUniqueDigits(3));
    }

    void task1() {
        Task1 task = new Task1();
        task.solution();
    }

    void task2() {
        Task2 task = new Task2();
        System.out.println(task.solution("aabbccddeeeaa"));
    }

    void task3() {
        Task3 task = new Task3();
        System.out.println(task.solution("id,name,age,score\n1,Jack,NULL,12\n17,Betty,28,11"));
    }

    void task4() {
        Task4 task = new Task4();
        System.out.println(task.solution("715K 2009-09-23 system.zip~\n" +
                " 179K 2013-08-14 to-do-list.xml~\n" +
                " 645K 2013-06-19 blockbuster.mpeg~\n" +
                "  536 2010-12-12 notes.html\n" +
                " 688M 1990-02-11 delete-this.zip~\n" +
                "  23K 1987-05-24 setup.png~\n" +
                " 616M 1965-06-06 important.html\n" +
                "  14M 1992-05-31 crucial-module.java~\n" +
                " 192K 1990-01-31 very-long-filename.dll~"));
    }

    void longestSubarray() {
        Solution1438 sol = new Solution1438();
        int[] arr = {1,1,1,1,1,1,1,1,1,1,1,};
        int limit = 10;
        System.out.println(sol.longestSubarray(arr, limit));
    }

    void validateStackSequences(){
        Solution946 sol = new Solution946();
        int[] pushed = {2,1,0};
        int[] popped = {1,2,0};
        System.out.println(sol.validateStackSequences(pushed, popped));
    }

    void maxDistance() {

        Solution624 sol = new Solution624();
        List<Integer> array1 = new ArrayList<>();
        array1.add(1);
        array1.add(2);
        array1.add(3);
        List<Integer> array2 = new ArrayList<>();
        array2.add(4);
        array2.add(5);
        List<Integer> array3 = new ArrayList<>();
        array3.add(1);
        array3.add(2);
        array3.add(3);
        List<List<Integer>> arrays = new ArrayList<>();
        arrays.add(array1);
        arrays.add(array2);
        arrays.add(array3);
        sol.maxDistance(arrays);
    }

    void isNStraightHand(){
        Solution846 sol = new Solution846();
        int[] hand = {1,2,3,6,2,3,4,7,8};
        System.out.println(sol.isNStraightHand(hand, 3));
    }


    void isPossible(){
        Solution659 sol = new Solution659();
        int[] hand = {1,2,3,3,4,5};
        System.out.println(sol.isPossible(hand));
    }
    */
    void expressiveWords() {
        Solution809 sol = new Solution809();
        String[] words = {"hello", "hi", "helo"};
        System.out.println(sol.expressiveWords("heeellooo", words));
    }

    void camelMatch() {
        Solution1023 sol = new Solution1023();
        String[] queries = {"mifeqvzphnrv", "mieqxvrvhnrv", "mhieqovhnryv", "mieqekvhnrpv", "miueqrvfhnrv", "mieqpvhzntrv", "gmimeqvphnrv", "mieqvhqyunrv"};
        String pattern = "mieqvhnrv";
        System.out.println(sol.camelMatch(queries, pattern));
    }

    void getMaximumGold() {
        Solution1921 sol = new Solution1921();
        int[][] grid = {{0, 6, 0}, {5, 8, 7}, {0, 9, 0}};
        sol.getMaximumGold(grid);
    }

    void grayCode() {
        Solution89 sol = new Solution89();
        System.out.println(sol.grayCode(2));
    }

}
