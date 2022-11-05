package class05;

import java.util.LinkedList;
import java.util.Stack;

public class Code04_IsBST {

	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}

	//一.使用List存储
	public static boolean isBST(Node head) {
		if (head == null) {
			return true;
		}
		LinkedList<Node> inOrderList = new LinkedList<>();
		process(head, inOrderList);
		int pre = Integer.MIN_VALUE;
		for (Node cur : inOrderList) {
			if (pre >= cur.value) {
				return false;
			}
			pre = cur.value;
		}
		return true;
	}

	public static void process(Node node, LinkedList<Node> inOrderList) {
		if (node == null) {
			return;
		}
		process(node.left, inOrderList);
		inOrderList.add(node);
		process(node.right, inOrderList);
	}


	//二.不使用额外空间
	public static int preValue = Integer.MIN_VALUE;

	public static boolean checkBST(Node head) {
		// 1.树是否为空
		if (head == null)
			return true;

		// 2.左子树是否为二叉搜索树
		if (!checkBST(head.left))
			return false;

		// 3.当前节点的值是否小于上一个节点
		if (head.value <= preValue)
			return false;
		else
			preValue = head.value; // 上一节点的值 = 当前节点的值

		// 4.右树是否为二叉搜索树
		return checkBST(head.right);
	}

	//三.不使用递归
	public static boolean checkBST2(Node head) {
		if (head != null) {
			Stack<Node> stack = new Stack<>();
			while (!stack.isEmpty() || head != null) {
				if (head != null) {
					stack.push(head);
					head = head.left;
				} else {
					head = stack.pop();
					if(head.value <= preValue)
						return false; 
					else {
						preValue = head.value;
					}
					head = head.right;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Node head = new Node(5);
		head.left = new Node(3);
		head.right = new Node(8);
		head.left.left = new Node(2);
		head.left.right = new Node(4);
		head.left.left.left = new Node(1);
		head.right.left = new Node(7);
		head.right.left.left = new Node(6);
		head.right.right = new Node(10);
		head.right.right.left = new Node(9);
		head.right.right.right = new Node(11);

		System.out.println(checkBST2(head));
	}

}
