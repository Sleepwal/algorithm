package class05;

public class Code06_IsBalancedTree {

	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}

	public static boolean isBalanced(Node head) {
		return process(head).isBalanced;
	}

	public static class ReturnType { //需要的信息
		public boolean isBalanced;
		public int height;

		public ReturnType(boolean isB, int hei) {
			isBalanced = isB;
			height = hei;
		}
	}

	public static ReturnType process(Node x) {
		if (x == null) {
			return new ReturnType(true, 0);
		}

		ReturnType leftData = process(x.left);
		ReturnType rightData = process(x.right);

		//算出自身的高度
		int height = Math.max(leftData.height, rightData.height);

		//1. 左子树是平衡二叉树
		//2. 右子树是平衡二叉树
		//3. | 左子树的高度 - 右子树的高度 | <= 1
		boolean isBalanced = leftData.isBalanced && rightData.isBalanced
				&& Math.abs(leftData.height - rightData.height) < 2;
				
		return new ReturnType(isBalanced, height);
	}

}
