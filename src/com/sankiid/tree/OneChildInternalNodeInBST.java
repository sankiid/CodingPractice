package com.sankiid.tree;

public class OneChildInternalNodeInBST {

	public static void main(String[] args) {
		int[] preorder = { 60, 50, 40, 42, 46, 48, 47 };
		System.out.println(hasOneChild(preorder));
	}

	private static boolean hasOneChild(int[] preorder) {
		int n = preorder.length - 1;
		int min = preorder[n], max = preorder[n];
		for (int i = n - 1; i >= 0; --i) {
			if (preorder[i] <= min || preorder[i] >= max) {
				min = preorder[i] <= min ? preorder[i] : min;
				max = preorder[i] >= max ? preorder[i] : max;
			} else {
				return false;
			}
		}
		return true;
	}

}
