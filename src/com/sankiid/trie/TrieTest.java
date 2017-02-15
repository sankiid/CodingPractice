package com.sankiid.trie;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class TrieTest {

	public static void main(String[] args) {
		try {
			System.out.println("trieMapPerformance");
			Runtime runtime = Runtime.getRuntime();
			runtime.gc();
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("supcseller.csv")));
			String s = br.readLine();
			Trie<Dummy> map = new Trie<>();
			long time = System.currentTimeMillis();
			while ((s = br.readLine()) != null) {
				String[] str = s.split("[,]");
				String supc = str[0].trim().replace("\u00A0", "");
				String seller = str[1].trim().replace("\u00A0", "");
				map.put(supc+seller, new Dummy());
			}
			runtime.gc();
			System.out.println("time taken " + (System.currentTimeMillis() - time) + " ms");
			System.out.println("Used memory is mb: " + toMB(runtime.totalMemory() - runtime.freeMemory()));
			br.close();
			br = new BufferedReader(new InputStreamReader(new FileInputStream("supcseller.csv")));
			s = br.readLine();
			time = System.currentTimeMillis();
			while ((s = br.readLine()) != null) {
				String[] str = s.split("[,]");
				String supc = str[0].trim().replace("\u00A0", "");
				String seller = str[1].trim().replace("\u00A0", "");
				Dummy data = map.get(supc+seller);
			}
			runtime.gc();
			System.out.println("time taken " + (System.currentTimeMillis() - time) + " ms");
			System.out.println("Used memory is mb: " + toMB(runtime.totalMemory() - runtime.freeMemory()));
			br.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private static long toMB(long bytes) {
		return bytes / (1024 * 1024);
	}

}
