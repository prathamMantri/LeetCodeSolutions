package leetcode.hard;

import model.TreeNode;

public class Solution99 {

    /*
    List<TreeNode> list;
    public void recoverTree1(TreeNode root) {
        list = inorderTraverse(root);
        TreeNode[] swappingElements = findElements(list);
        swapElements(root, 2, swappingElements[0], swappingElements[1]);
    }

    List<TreeNode> inorderTraverse(TreeNode node){
        if(node.left != null ) inorderTraverse(node.left);
        list.add(node);
        if(node.left != null ) inorderTraverse(node.right);
        return list;
    }

    TreeNode[] findElements(List<TreeNode> list) {
        TreeNode firstElement = null;
        TreeNode secondElement = null;
        for(int i=0; i<list.size()-1; i++){
            if(list.get(i+1).val < list.get(i).val){
                secondElement = list.get(i+1);
                if(firstElement == null)
                    firstElement = list.get(i);
                else
                    break;
            }
        }
        return new TreeNode[]{firstElement, secondElement};
    }

    void swapElements(TreeNode node, int count, TreeNode node1, TreeNode node2){
        if(node != null){
            if(node == node1 || node == node2 ){
                node = node == node1 ? node2 : node1;
                count = count-1;
            }
            if(count == 0)
                return;

            swapElements(node.left, count, node1, node2);
            swapElements(node.right, count, node1, node2);
        }
    }

    */
    //// #######################################################################################################33


    TreeNode firstElement = null;
    TreeNode secondElement = null;
    // The reason for this initialization is to avoid null pointer exception in the first comparison when prevElement has not been initialized
    TreeNode prevElement = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {

        // In order traversal to find the two elements
        traverse(root);

        // Swap the values of the two nodes
        int temp = firstElement.val;
        firstElement.val = secondElement.val;
        secondElement.val = temp;
    }

    private void traverse(TreeNode root) {
        if (root == null)
            return;
        traverse(root.left);

        // Start of "do some business",
        // If first element has not been found, assign it to prevElement (refer to 6 in the example above)
        if (firstElement == null && prevElement.val >= root.val) {
            firstElement = prevElement;
        }

        // If first element is found, assign the second element to the root (refer to 2 in the example above)
        if (firstElement != null && prevElement.val >= root.val) {
            secondElement = root;
        }
        prevElement = root;

        // End of "do some business"

        traverse(root.right);
    }


}
