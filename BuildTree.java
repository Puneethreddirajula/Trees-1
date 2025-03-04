//TC: O(nh)
//SC: O(h^2)

class BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder.length == 0 || preorder.length == 0) {
            return null;
        }
        //find root node
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);
        int rootInd = -1;
        //finding the root from inorder array so we know whats in left and right subtrees
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                rootInd = i;
            }
        }

        int[] inOrderLeft = Arrays.copyOfRange(inorder, 0, rootInd);
        int[] inOrderRight = Arrays.copyOfRange(inorder, rootInd + 1, inorder.length);
        int[] preOrderLeft = Arrays.copyOfRange(preorder, 1, rootInd + 1);
        int[] preOrderRight = Arrays.copyOfRange(preorder, rootInd + 1, preorder.length);
//building tree using recursion
        root.left = buildTree(preOrderLeft, inOrderLeft);
        root.right = buildTree(preOrderRight, inOrderRight);

        return root;

    }
}