package model;

import leetcode.medium.Solution210;
import leetcode.medium.Solution227;
import leetcode.medium.Solution287;

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
        //main.combinationSum();
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
        //main.getMaximumGold();
        //main.grayCode();
        //main.findWords();
        // main.rob();
        //main.numSubarrayProductLessThanK();
        //main.licenseKeyFormatting();
        //main.shortestPalindrome();
        //main.wordBreak();
        //main.specialArray();
        //main.isEvenOddTree();
        //main.subArray();
        //main.basicCalculator();
        //main.decodeString();
        //main.removeComments();
        //main.longestStrChain();
        //main.missingElement();
        //main.firstMissingPositive();
        //main.findDisappearedNumbers();
        //main.numDecoding();
        //main.getImportance();
        //main.maxScore();
        //main.highFive();
        //main.pivotSum();
        //main.randomPick();
        //main.longestPalindromeSubSeq();
        //main.countSubstrings();
        //main.longestValidParentheses();
        //main.matchRegex();
        //main.maxCoin();
        //main.coinChange();
        //main.checkSubarraySum();
        //main.maxDepth();
        //main.checkPalindromeFormation();
        //main.maxSumTwoNoOverlap();
        //main.minDominoRotations();
        //main.wildMatch();
        //main.majorityElement();
        //main.canConvert();
        //main.minCost();
        //main.hasPathSum();
        //main.serializeDeserialize();
        //main.delNodesForest();
        //main.binaryTreePaths();
        //main.widthOfBinaryTree();
        //main.distanceK();
        //main.searchMatrix();
        //main.parkingSystem();
        //main.findMedianSortedArrays();
        //main.removeNthFromEnd();
        //main.topKFrequent();
        //main.minimumWindow();
        //main.maxSlidingWindow();
        //main.minSumOfLengths();
        //main.findReplaceString();
        //main.rightSideView();
        //main.inviteFriends();
        //main.shuffle();
        // main.alphabetBoardPath();
        //main.RLEIterator();
        //main.numMatchingSubseq();
        //main.sequenceReconstruction();
        //main.canJump();
        //main.jump2();
        //main.jump3();
        //main.jump4();
        //main.snakeGame();
        //main.splitArray();
        //main.deserializeNArray();
        //main.maxEnvelopes();
        //main.lengthOfLIS();
        //main.minTransfers();
        //main.numSubmat();
        //main.autoCompleteSystem();
        //main.crackSafe();
        //main.encodeString();
        //main.search();
        //main.rangeSumMutable();
        //main.rangeSumImmutable();
        //main.rangeSumImmutable2D();
        //main.getSkyLine();
        //main.rangeModule();
        //main.sherlockValidString();
        //main.substrCount();
        //main.KMPPatternMatching();
        // main.maxSlidingWindow();
        //main.alienOrder();
        //main.concatenatedWords();
        //main.wordBreak2();
        //main.findItenerary();
        //main.findDuplicate();
        //main.basicCalculator();
        main.findOrder();

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
        int[] nums8 = {-9, 5, -3, 5, 2, -5, -5, 8, 3, 10};
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
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

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
    void expressiveWords() {
        Solution809 sol = new Solution809();
        String[] words = {"hello", "hi", "helo"};
        System.out.println(sol.expressiveWords("heeellooo", words));
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
    void findWords() {
        Solution212 sol = new Solution212();
        char[][] board = {
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
        };
        char[][] board = {
                {'a','a'}
        };
        String word1 = "aa";
        String[] words = {word1};
       // System.out.println(sol.findWords(board, words));
        System.out.println(sol.findWordsUsingTrie(board, words));
    }
    void rob() {
        Solution198 sol = new Solution198();
        int[] nums = {2, 1, 1, 4, 1, 1, 6};
        //             2        1       3       6       6       7       12

        System.out.println(sol.rob(nums));
    }
    void numSubarrayProductLessThanK() {
        Solution713 sol = new Solution713();
        int[] nums = {10, 5, 2, 6};
        sol.numSubarrayProductLessThanK(nums, 100);
    }
    void licenseKeyFormatting(){
        Solution482 sol = new Solution482();
        System.out.println(sol.licenseKeyFormatting("5F3Z-2e-9-w", 0));
    }
    void shortestPalindrome(){
        Solution214 sol = new Solution214();
        System.out.println(sol.shortestPalindrome("aacecaaa"));
    }
    void wordBreak(){
        Solution139 sol = new Solution139();
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cats");
        wordDict.add("dog");
        wordDict.add("sand");
        wordDict.add("and");
        wordDict.add("cat");
        wordDict.add("an");
        System.out.println(sol.wordBreak("catsandogcat", wordDict));
    }

    void specialArray(){

        Solution5531 sol = new Solution5531();
        int[] nums = {0,4,3,0,4};
        System.out.println(sol.specialArrayBest(nums));
    }
    void isEvenOddTree(){
        Solution1609 sol = new Solution1609();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(10);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(12);
        root.left.left.right = new TreeNode(8);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.right.right.right = new TreeNode(2);
        root.right.left.left= new TreeNode(6);
        System.out.println(sol.isEvenOddTree(root));
    }
    void subArray() {
        Solution560 sol = new Solution560();
        int[] a = {1, 2, 1, 3, 0, 5, -2};
        sol.subarraySum(a, 3);
    }
    void decodeString(){
        Solution394 sol = new Solution394();
        // System.out.println(sol.decodeString("3[a]2[bc]"));
        System.out.println(sol.decodeString("3[a2[c]]")); //accaccacc
    }

    void removeComments() {
        Solution722 sol = new Solution722();
        //String[] code = {"void func(int k) {", "// this function does nothing ", "   k = k*2/4;", "   k = k/2;", "}"};


        System.out.println(sol.removeComments(code));
    }

    void longestStrChain(){
        Solution1048 sol = new Solution1048();
        String[] str = {"a","b","ba","abc","bda","bdca"};
        System.out.println(sol.longestStrChain(str));
    }

    void missingElement(){
        Solution1060 sol = new Solution1060();
        int[] nums = {4,7,9,10};
        System.out.println(sol.missingElement(nums, 1));

    }
    void firstMissingPositive(){
        Solution41 solution41 = new Solution41();
        int[] nums = {1,3,3};
        System.out.println(solution41.firstMissingPositive(nums));
    }

    void findDisappearedNumbers(){
        Solution448 sol = new Solution448();
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(sol.findDisappearedNumbers(nums));
    }
    void numDecodings(){
        Solution91 sol = new Solution91();
        System.out.println(sol.numDecodings("3251"));
    }


    void getImportance() {

        List<Solution690.Employee> employees = new ArrayList<>();
        List<Integer> nums1 = new ArrayList<>();
        nums1.add(2);
        nums1.add(3);

        Solution690.Employee employee1 = new Solution690.Employee(1, 5, nums1);
        Solution690.Employee employee2 = new Solution690.Employee(2, 3, new ArrayList<>());
        Solution690.Employee employee3 = new Solution690.Employee(3, 3, new ArrayList<>());

        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);

        Solution690 sol = new Solution690();
        System.out.println(sol.getImportance(employees, 1));
    }


    void maxScore(){
        Solution1423 sol = new Solution1423();
        int nums[] = {1,2,3,4,5,6,1};
        int k=3;
        System.out.println(sol.maxScore(nums, k));
    }

    void highFive() {
        Solution1086 sol = new Solution1086();
        int[][] items = {{1, 91}, {1, 92}, {2, 93}, {2, 97}, {1, 60}, {2, 77}, {1, 65}, {1, 87}, {1, 100}, {2, 100}, {2, 76}};
        //int[][] items = {{1,91},{1,92},{2,93},{2,97},{2,77},{1,65},{2,100},{2,76}};
        System.out.println(Arrays.deepToString(sol.highFive(items)));
    }

    void pivotSum() {
        Solution724 sol = new Solution724();
        int[] nums = {1, 7, 3, 6, 5, 6};
        System.out.println(sol.pivotIndex(nums));
    }

    void randomPick() {
        int[] nums = {1, 7, 3, 6, 5, 6};
        Solution528 rp = new Solution528(nums);
        System.out.println(rp.pickIndex());
        System.out.println(rp.pickIndex());
        System.out.println(rp.pickIndex());
        System.out.println(rp.pickIndex());
        System.out.println(rp.pickIndex());
    }

    void longestPalindromeSubSeq(){
        Solution516 sol = new Solution516();
        System.out.println(sol.longestPalindromeSubSeq("bbbbab"));
    }
    void countSubstrings(){
        Solution647 sol = new Solution647();
        System.out.println(sol.countSubstrings("abbac"));
    }

    void longestValidParentheses(){
        Solution32 sol = new Solution32();
        System.out.println(sol.longestValidParentheses("(((()))()()(()())))"));
    }


    void matchRegex(){
        Solution10 sol = new Solution10();
        sol.matchRegex("aa", "*a");
    }

    void maxCoin() {
        Solution312 sol = new Solution312();
        int[] nums = {3, 1, 5, 8};
        sol.maxCoins(nums);
    }

    void coinChange() {
        Solution322 sol = new Solution322();
        int[] coins = {1, 3, 5};
        sol.coinChange(coins, 11);
    }

    void checkSubarraySum(){
        Solution523 sol = new Solution523();
        int[] coins = {0,1,0};
        sol.checkSubarraySum(coins, 0);
    }

    void maxDepth(){
        Solution1614 sol = new Solution1614();
        System.out.println(sol.maxDepth("(1+(2*3)+((8)/4))+1"));
    }

    void checkPalindromeFormation(){
        Solution1616 solution1616 = new Solution1616();
        System.out.println(solution1616.checkPalindromeFormation("cdeoo", "oooab"));
    }

    void maxSumTwoNoOverlap(){
        Solution1031 sol = new Solution1031();
        int[] nums= {3,8,1,3,2,1,8,9,0};
        System.out.println(sol.maxSumTwoNoOverlap(nums, 3, 4));
    }

    void minDominoRotations(){
        Solution1007 sol = new Solution1007();
        int[] A = {2,1,2,4,2,2};
        int[] B = {5,2,6,2,3,2};
        System.out.println(sol.minDominoRotations(A, B));
    }


    void wildMatch() {
        Solution44 sol = new Solution44();
        System.out.println(sol.isMatch("aacdbcdb", "a*c?b"));
    }

    void majorityElement() {
        Solution169 sol = new Solution169();
        int[] nums = {7, 7, 5, 7, 5, 1, 5, 7, 5, 5, 7, 7, 7, 7, 7, 7};
        sol.majorityElement(nums);

    }


    void canConvert(){
        Solution1153 sol = new Solution1153();
        System.out.println(sol.canConvert("abcdefghijklmnopqrstuvwxyz", "bcdefghijklmnopqrstuvwxyzq"));
    }

    void minCost(){
        Solution256 sol = new Solution256();
        int[][] costs = {{17,2,17},{16,16,5},{14,3,19}};
        System.out.println(sol.minCost(costs));
    }

    void hasPathSum(){
        Solution112 sol = new Solution112();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(5);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);
        root.left = new TreeNode(2);
        System.out.println(sol.hasPathSum2(root, 6));
    }
    void serializeDeserialize(){
        Solution297 sol = new Solution297();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        System.out.println(sol.deserialize(sol.serialize(root)));
    }

    void delNodesForest(){
        Solution1110 sol = new Solution1110();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        int [] nums = {3,5};
        System.out.println(sol.delNodes(root, nums));
    }

    void binaryTreePaths() {
        Solution257 sol = new Solution257();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(sol.binaryTreePaths(root));
    }

    void widthOfBinaryTree() {
        Solution662 sol = new Solution662();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);
        System.out.println(sol.widthOfBinaryTree(root));
    }

    void distanceK() {
        Solution863 sol = new Solution863();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        System.out.println(sol.distanceK(root, root.left, 1));
    }

    void searchMatrix(){
        Solution74 sol = new Solution74();
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        System.out.println(sol.searchMatrix(matrix, 13));
    }

    void parkingSystem(){
        Solution1603.ParkingSystem parkingSystem = new Solution1603.ParkingSystem(1,1,0);
        System.out.println(parkingSystem.addCar(1));
        System.out.println(parkingSystem.addCar(2));
        System.out.println(parkingSystem.addCar(3));
        System.out.println(parkingSystem.addCar(1));
    }

    void findMedianSortedArrays(){
        Solution4 sol = new Solution4();
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        System.out.println(sol.findMedianSortedArrays(nums1, nums2));
    }

    void removeNthFromEnd() {
        Solution19 sol = new Solution19();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        System.out.println(sol.removeNthFromEnd(head, 2));
    }

    void topKFrequent() {
        Solution692 sol = new Solution692();
        String[] words = {"the", "day", "is", "is", "sunny", "the", "the", "the", "day", "is", "is"};
        System.out.println(sol.topKFrequent(words, 4));
    }

    void topKFrequentInt() {
        Solution347 sol = new Solution347();
        int[] nums = {1};
        sol.topKFrequentHeap(nums, 1);
    }
    void minSumOfLengths(){
        Solution1477 sol = new Solution1477();
        int[] arr = {3,1,1,2,1,3,1,2};
        System.out.println(sol.minSumOfLengths(arr, 3));
    }

    void findReplaceString() {
        Solution833 sol = new Solution833();
        String S = "abcd";
        int[] indexes = {0, 2};
        String[] source = {"ad", "cd"};
        String[] target = {"eeee", "ffff"};
        System.out.println(sol.findReplaceString(S, indexes, source, target));
    }

    void rightSideView(){
        Solution199 sol = new Solution199();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);
        root.right = new TreeNode(0);
        //root.left = new TreeNode(2);
        System.out.println(sol.rightSideView(root));
    }

    void inviteFriends(){
        InviteFriends inviteFriends = new InviteFriends();
        int[][] pairs = {{1, 2}, {2,3}, {3,4}};
        System.out.println(inviteFriends.inviteFriends(pairs));
    }

    void shuffle(){
        Solution746 sol = new Solution746();
        int[] arr = {1,2,13,4,4,15,2,1};
        sol.shuffle(arr, 4);
    }

    void alphabetBoardPath(){
        Solution1138 sol = new Solution1138();
        System.out.println(sol.alphabetBoardPath("aleetC"));
    }
    void RLEIterator(){
        //int[] A = {923381016,843,898173122,924,540599925,391,705283400,275,811628709,850,895038968,590,949764874,580,450563107,660,996257840,917,793325084,82};
        //int[] calls = {612783106, 486444202, 630147341, 845077576, 243035623, 731489221, 117134294, 220460537, 794582972, 332536150, 815913097, 100607521, 146358489, 697670641, 45234068, 573866037, 519323635, 27431940, 16279485, 203970};

        int[] A = {3,8,0,9,2,5}; // 8 8 8 5 5
        int[] calls = {4,1,1,2};

        Solution900.RLEIterator rleIterator = new Solution900.RLEIterator(A);
        for (int call : calls) {
            System.out.println(rleIterator.next(call));
        }
    }

    void numMatchingSubseq() {
        Solution792 sol = new Solution792();

        String S = "abcde";
        String[] words = {"a", "bb", "acd", "ace", "bcd"};
        sol.numMatchingSubseq(S, words);
    }

    void sequenceReconstruction(){
        Solution444 sol = new Solution444();
        int[] org = {4,1,5,2,6,3};
        List<Integer> seq;
        List<List<Integer>> seqs = new ArrayList<>();
        seq = new ArrayList<>();
        seq.add(5);
        seq.add(2);
        seq.add(6);
        seq.add(3);
        seqs.add(seq);
        seq = new ArrayList<>();
        seq.add(4);
        seq.add(1);
        seq.add(5);
        seq.add(2);
        seqs.add(seq);
        sol.sequenceReconstruction(org, seqs);
    }

    void canJump() {
        Solution55 sol = new Solution55();
        int[] a = {2,3,1,0,4};
        System.out.println(sol.canJump(a));
    }

    void jump2(){
        Solution45 sol = new Solution45();
        int[] A = {5,3,1,1,4};
        System.out.println(sol.jump2(A));
    }
    void jump3(){
        Solution1306 sol = new Solution1306();
        int[] A = {5,3,1,1,4};
        System.out.println(sol.canReach(A, 5));S
    }

    void jump4(){
        Solution1345 sol = new Solution1345();
        int[] A = {100,-23,-23,404,100,23,23,23,3,404};
        System.out.println(sol.minJumps(A));
    }
    void snakeGame(){
        int width= 3;
        int height = 2;
        int[][] food = {{1,2},{0,1}};
        Solution353.SnakeGame snakeGame = new Solution353.SnakeGame(width, height, food);
        System.out.println(snakeGame.move("R"));
        System.out.println(snakeGame.move("D"));
        System.out.println(snakeGame.move("R"));
        System.out.println(snakeGame.move("U"));
        System.out.println(snakeGame.move("L"));
        System.out.println(snakeGame.move("U"));
    }


    void splitArray() {
        int[] nums = {7, 2, 5, 10, 8};
        Solution410 sol = new Solution410();
        System.out.println(sol.splitArray(nums, 2));
    }
    void deserializeNArray(){
        NTreeNode node1 = new NTreeNode(1);
        NTreeNode node2 = new NTreeNode(2);
        NTreeNode node3 = new NTreeNode(3);
        NTreeNode node4 = new NTreeNode(4);
        NTreeNode node5 = new NTreeNode(5);
        NTreeNode node6 = new NTreeNode(6);
        List<NTreeNode> children1 = new ArrayList<>();
        List<NTreeNode> children2 = new ArrayList<>();

        children1.add(node3);
        children1.add(node2);
        children1.add(node4);
        children2.add(node5);
        children2.add(node6);

        node1.children = children1;
        node1.children.get(0).children = children2;

        Solution428 sol = new Solution428();
        sol.deserialize(sol.serialize(node1));

    }

    void maxEnvelopes() {
        int[][] envelopes = {{46, 89}, {50, 53}, {52, 68}, {72, 45}, {77, 81}};
        Solution354 sol = new Solution354();
        System.out.println(sol.maxEnvelopes(envelopes));
    }
    void lengthOfLIS() {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        Solution300 sol = new Solution300();
        System.out.println(sol.lengthOfLIS(nums));
    }

    void minTransfers() {
        Solution465 sol = new Solution465();
        int[][] transactions = {{0, 1, 10},
                //{1,0,1},
                //{1,2,5},
                {2, 0, 5}};
        System.out.println(sol.minTransfers(transactions));
    }

    void numSubmat() {
        int[][] mat = {{1, 1, 1, 1, 0}, {1, 0, 0, 1, 0}, {0, 0, 1, 0, 1}, {0, 1, 0, 0, 0}};
        Solution1504 sol = new Solution1504();
        System.out.println(sol.numSubmat(mat));
    }


    void autoCompleteSystem(){

        String[] words = {"i love you", "island","ironman", "i love leetcode"};
        int[] times = {5,3,2,2};

        Solution642.AutocompleteSystem autocompleteSystem = new Solution642.AutocompleteSystem(words, times);

        //["i"],[" "],["a"],["#"],["i"],[" "],["a"],["#"],["i"],[" "],["a"],["#"]
        System.out.println(autocompleteSystem.input('i').toString());
        System.out.println(autocompleteSystem.input(' ').toString());
        System.out.println(autocompleteSystem.input('a').toString());
        System.out.println(autocompleteSystem.input('#').toString());
        System.out.println(autocompleteSystem.input('i').toString());
        System.out.println(autocompleteSystem.input(' ').toString());
        System.out.println(autocompleteSystem.input('a').toString());
        System.out.println(autocompleteSystem.input('#').toString());
        System.out.println(autocompleteSystem.input('i').toString());
        System.out.println(autocompleteSystem.input(' ').toString());
        System.out.println(autocompleteSystem.input('a').toString());
        System.out.println(autocompleteSystem.input('#').toString());

    }

    void crackSafe() {
        Solution753 sol = new Solution753();
        System.out.println(sol.crackSafe(3, 3));
    }

    void encodeString(){
        Solution471 sol = new Solution471();
        System.out.println(sol.encode("aaaaaaaaaa"));
    }

    void search() {
        Solution81 sol = new Solution81();
        int[] nums = {2, 5, 6, 0, 0, 1, 2};
        System.out.println(sol.search(nums, 3));
    }

    void rangeSumMutable() {

        int[] nums = {1, 3, 5};
        Solution307.NumArray sol = new Solution307.NumArray(nums);
        System.out.println(sol.sumRange(0, 2));
        sol.update(1, 2);
        System.out.println(sol.sumRange(0, 2));
    }


    void rangeSumImmutable() {

        int[] nums = {1, 2, 3, 4, 5, 6};
        Solution303.NumArray sol = new Solution303.NumArray(nums);
        System.out.println(sol.sumRange(0, 2));
        System.out.println(sol.sumRange(2, 5));
        System.out.println(sol.sumRange(0, 5));
        System.out.println(sol.sumRange(1, 5));
    }

    void rangeSumImmutable2D() {
        int[][] nums = {{3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}};
        Solution308.NumMatrix sol = new Solution308.NumMatrix(nums);
        System.out.println();
        System.out.println(sol.sumRegion(2, 1, 4, 3));
        System.out.println();
        sol.update(3, 2, 2);
        System.out.println();
        System.out.println(sol.sumRegion(2, 1, 4, 3));
    }

    void basicCalculator(){
        Solution224 sol = new Solution224();
        System.out.println(sol.calculate("(1-(4+5+2)-3)-(6+8)"));
    }

    void getSkyLine(){

        Solution218 sol = new Solution218();
        int[][] skyLines = {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
        sol.getSkyline(skyLines);

    }

    void rangeModule() {
        Solution715.RangeModule sol = new Solution715.RangeModule();
        sol.addRange(2, 6);
        sol.addRange(2, 6);
        System.out.println(sol.queryRange(3, 4));
        System.out.println(sol.queryRange(1, 3));
        System.out.println(sol.queryRange(5, 8));
        sol.addRange(3, 8);
        sol.addRange(10, 15);
        sol.addRange(1, 4);
        sol.removeRange(4, 6);
        sol.removeRange(1, 3);
        sol.removeRange(12, 13);
    }

    void sherlockValidString(){
        SherlockValidString sherlockValidString = new SherlockValidString();
        String s= "ibfdgaeadiaefgbhbdghhhbgdfgeiccbiehhfcggchgghadhdhagfbahhddgghbdehidbibaeaagaeeigffcebfbaieggabcfbiiedcabfihchdfabifahcbhagccbdfifhghcadfiadeeaheeddddiecaicbgigccageicehfdhdgafaddhffadigfhhcaedcedecafeacbdacgfgfeeibgaiffdehigebhhehiaahfidibccdcdagifgaihacihadecgifihbebffebdfbchbgigeccahgihbcbcaggebaaafgfedbfgagfediddghdgbgehhhifhgcedechahidcbchebheihaadbbbiaiccededchdagfhccfdefigfibifabeiaccghcegfbcghaefifbachebaacbhbfgfddeceababbacgffbagidebeadfihaefefegbghgddbbgddeehgfbhafbccidebgehifafgbghafacgfdccgifdcbbbidfifhdaibgigebigaedeaaiadegfefbhacgddhchgcbgcaeaieiegiffchbgbebgbehbbfcebciiagacaiechdigbgbghefcahgbhfibhedaeeiffebdiabcifgccdefabccdghehfibfiifdaicfedagahhdcbhbicdgibgcedieihcichadgchgbdcdagaihebbabhibcihicadgadfcihdheefbhffiageddhgahaidfdhhdbgciiaciegchiiebfbcbhaeagccfhbfhaddagnfieihghfbaggiffbbfbecgaiiidccdceadbbdfgigibgcgchafccdchgifdeieicbaididhfcfdedbhaadedfageigfdehgcdaecaebebebfcieaecfagfdieaefdiedbcadchabhebgehiidfcgahcdhcdhgchhiiheffiifeegcfdgbdeffhgeghdfhbfbifgidcafbfcd";
        System.out.println(sherlockValidString.isValid(s));

    }

    void substrCount(){
        SpecialStringAgain sp = new SpecialStringAgain();
        System.out.println(sp.substrCount(8, "mnonopoo"));
    }


    void KMPPatternMatching() {
        KMPPatternMatching kmpPatternMatching = new KMPPatternMatching();
        System.out.println(kmpPatternMatching.getKMPTable("abbcbcabc"));
    }

    void camelMatch() {
        Solution1023 sol = new Solution1023();
        String[] queries = {"FooBor", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"};
        String pattern = "FoBa";
        System.out.println(sol.camelMatch(queries, pattern));
    }

    void maxSlidingWindow(){
        Solution239 sol = new Solution239();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(sol.maxSlidingWindow(nums, 3)));
    }

    void alienOrder(){
        Solution269 sol = new Solution269();
        String[] words = {"wrt","wrf","er","ett","rftt"};
        System.out.println(sol.alienOrder(words));
    }

    void wordBreak2(){

        Solution140 sol = new Solution140();
        String s = "catsanddog";
        List<String> list = new ArrayList<>();
        list.add("cat");
        list.add("cats");
        list.add("and");
        list.add("sand");
        list.add("dog");
        sol.wordBreak2(s, list);


    }



    void concatenatedWords(){
        Solution472 sol = new Solution472();
        String[] words = {""};
        System.out.println(sol.findAllConcatenatedWordsInADict(words).toString());
    }


    void minimumWindow() {
        Solution76 sol =  new Solution76();
        System.out.println(sol.minimumWindow("ADOBECODEBANC","ABC"));
    }



    void findItenerary(){
        Solution332 sol = new Solution332();

        List<List<String>> tickets = new ArrayList<>();
        List<String> ticket1 = new ArrayList<>();
        ticket1.add("JFK");
        ticket1.add("KUL");
        List<String> ticket2 = new ArrayList<>();
        ticket2.add("JFK");
        ticket2.add("NRT");
        List<String> ticket3 = new ArrayList<>();
        ticket3.add("NRT");
        ticket3.add("JFK");

        List<String> ticket1 = new ArrayList<>();
        ticket1.add("JFK");
        ticket1.add("SFO");
        List<String> ticket2 = new ArrayList<>();
        ticket2.add("JFK");
        ticket2.add("ATL");
        List<String> ticket3 = new ArrayList<>();
        ticket3.add("SFO");
        ticket3.add("ATL");
        List<String> ticket4 = new ArrayList<>();
        ticket4.add("ATL");
        ticket4.add("JFK");
        List<String> ticket5 = new ArrayList<>();
        ticket5.add("ATL");
        ticket5.add("SFO");

        tickets.add(ticket1);
        tickets.add(ticket2);
        tickets.add(ticket3);
        tickets.add(ticket4);
        tickets.add(ticket5);

        System.out.println(sol.findItinerary(tickets).toString());


    }

    */

    void findDuplicate() {
        Solution287 sol = new Solution287();
        int[] arr = {1, 3, 4, 2, 2};
        sol.findDuplicate(arr);
    }

    void basicCalculator(){

        Solution227 sol = new Solution227();
        String s = "3+2*2";
        System.out.println(sol.calculate(s));

    }

    void findOrder(){
        Solution210 sol = new Solution210();
        int[][] preRequisites = {{1,0},{2,0},{3,1},{3,2}};
        sol.findOrder(4,preRequisites);
    }


}
