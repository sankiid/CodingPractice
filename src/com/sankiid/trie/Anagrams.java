package com.sankiid.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Anagrams {

	public static void main(String[] args) {
		String[] keys = { "car", "ape", "meal", "pea", "male", "arc", "lame", "dog" };
		Trie trie = new Trie();
		for (String key : keys) {
			char[] chars = key.toLowerCase().toCharArray();
			Arrays.sort(chars);
			trie.insert(chars, key);
		}
		trie.print();
	}

	static class Trie {

		TrieNode root;

		public Trie() {
			root = new TrieNode();
		}

		public void print() {
			Stack<TrieNode> stack = new Stack<>();
			stack.push(root);
			while (!stack.isEmpty()) {
				TrieNode node = stack.pop();
				if (node == null)
					return;
				if (node.indexes.isEmpty()) {
					for (int i = 0; i < 26; ++i) {
						if (node.child[i] != null)
							stack.push(node.child[i]);
					}
				} else {
					for (String ch : node.indexes) {
						System.out.print(ch + ' ');
					}
					System.out.println();
				}
			}
		}

		public void insert(char[] key, String str) {
			TrieNode tmp = root;
			for (int i = 0; i < key.length; ++i) {
				char c = key[i];
				int id = c - 'a';
				if (tmp.child[id] == null) {
					tmp.child[id] = new TrieNode();
				}
				tmp.child[id].ch = c;
				if (i + 1 == key.length) {
					tmp.child[id].indexes.add(str);
				}
				tmp = tmp.child[id];
			}
		}

		class TrieNode {
			char			ch		= (char) 0;
			List<String>	indexes	= new ArrayList<>();
			TrieNode[]		child	= new TrieNode[26];
		}
	}
}
