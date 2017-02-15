package com.sankiid.trie;

public class TrieNode<E> {
	private static final int	size	= 37;

	private TrieNode<E>[]		leafs	= null;
	private E					element	= null;
	private boolean				isEnd	= false;
	private char				data;

	public TrieNode(char data, E element, boolean isEnd) {
		leafs = new TrieNode[size];
		this.element = element;
		this.data = data;
		this.isEnd = isEnd;
	}

	public TrieNode(char data, E element) {
		this(data, element, false);
	}

	public TrieNode(char data) {
		this(data, null, false);
	}

	public TrieNode() {
		this((char) 0, null, false);
	}

	/**
	 * @return the leafs
	 */
	public TrieNode<E>[] getLeafs() {
		return leafs;
	}

	/**
	 * @param leafs
	 *            the leafs to set
	 */
	public void setLeafs(TrieNode<E>[] leafs) {
		this.leafs = leafs;
	}

	/**
	 * @return the element
	 */
	public E getElement() {
		return element;
	}

	/**
	 * @param element
	 *            the element to set
	 */
	public void setElement(E element) {
		this.element = element;
	}

	/**
	 * @return the isEnd
	 */
	public boolean isEnd() {
		return isEnd;
	}

	/**
	 * @param isEnd
	 *            the isEnd to set
	 */
	public void setEnd(boolean isEnd) {
		this.isEnd = isEnd;
	}

	public char getData() {
		return data;
	}

	public void setData(char data) {
		this.data = data;
	}

}
