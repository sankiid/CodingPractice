package com.sankiid.trie;

public class Trie<E> {

	private TrieNode<E> root;

	public Trie() {
		root = new TrieNode<E>();
	}

	public void put(String key, E value) {
		TrieNode<E> tmp = root;
		for (int i = 0; i < key.length(); ++i) {
			char c = getChar(key, i);
			int index = getIndex(c);
			if (tmp.getLeafs()[index] == null) {
				tmp.getLeafs()[index] = new TrieNode<>(c, i == key.length() - 1 ? value : null, i == key.length() - 1);
			} else {
				TrieNode<E> node = tmp.getLeafs()[index];
				node.setElement(i == key.length() - 1 ? value : null);
				node.setEnd(i == key.length() - 1);
			}
			tmp = tmp.getLeafs()[index];
		}
	}

	public E get(String key) {
		if (root == null)
			return null;
		TrieNode<E> tmp = root;
		for (int i = 0; i < key.length(); ++i) {
			char c = getChar(key, i);
			int index = getIndex(c);
			TrieNode<E> node = tmp.getLeafs()[index];
			if (node == null) {
				return null;
			}
			if (i + 1 == key.length() && node.isEnd()) {
				return node.getElement();
			}
			tmp = node;
		}
		return null;
	}

	private char getChar(String key, int i) {
		char c = key.charAt(i);
		if (Character.isUpperCase(c)) {
			c = Character.toLowerCase(c);
		}
		return c;
	}

	private int getIndex(char c) {
		if (Character.isDigit(c)) {
			return (c - '0') + 27;
		} else {
			return c - 'a';
		}
	}
}
