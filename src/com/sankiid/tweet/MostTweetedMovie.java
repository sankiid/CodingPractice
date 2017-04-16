package com.sankiid.tweet;

import java.util.HashMap;
import java.util.PriorityQueue;

public class MostTweetedMovie {

	private HashMap<String, MovieNode> map = new HashMap<>();
	private PriorityQueue<MovieNode> queue = new PriorityQueue<>();

	public static void main(String[] args) {
		MostTweetedMovie movie = new MostTweetedMovie();
		movie.put("xyz");
		movie.put("tyr");
		System.out.println(movie.getMostTweetedMovie());
		movie.put("abc");
		movie.put("abc");
		System.out.println(movie.getMostTweetedMovie());
		movie.put("xyz");
		movie.put("xyz");
		System.out.println(movie.getMostTweetedMovie());
	}

	public void put(String movieName) {
		if (!map.containsKey(movieName)) {
			MovieNode mn = new MovieNode(movieName, 1);
			map.put(movieName, mn);
			queue.add(mn);
		} else {
			map.get(movieName).setCount(map.get(movieName).getCount() + 1);
		}

	}

	public String getMostTweetedMovie() {
		return queue.peek().getName();
	}

	class MovieNode implements Comparable<MovieNode> {
		private String name;
		private int count;

		public MovieNode(String movieName, int i) {
			this.name = movieName;
			this.count = i;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getCount() {
			return count;
		}

		public void setCount(int count) {
			this.count = count;
		}

		@Override
		public int compareTo(MovieNode o) {
			if (this.count < o.count) {
				return 1;
			} else if (this.count > o.count) {
				return -1;
			} else {
				return this.name.compareTo(o.name);
			}
		}

	}
}
