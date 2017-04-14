package com.sankiid.backtrack;

import java.util.LinkedList;
import java.util.List;

public class RatMazeProblem {

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "{" + x + "," + y + "} <- ";
		}

	}

	public static void main(String[] args) {
		int[][] maze = { { 1, 0, 1, 1, 1 }, { 1, 1, 1, 0, 1 }, { 0, 0, 0, 1, 1 }, { 0, 0, 0, 1, 1 },
				{ 0, 0, 0, 1, 1 } };

		solveRat(maze);
	}

	private static void solveRat(int[][] maze) {
		boolean[][] visited = new boolean[maze.length][maze[0].length];
		List<Point> paths = new LinkedList<Point>();
		if (traverseMaze(maze, visited, 0, 0, paths)) {
			print(paths);
		} else {
			System.out.println("no valid solution found");
		}
	}

	private static void print(List<Point> paths) {
		for (int j = 0; j < paths.size(); ++j) {
			System.out.print(" " + paths.get(j));
		}
	}

	private static boolean traverseMaze(int[][] maze, boolean[][] solution, int i, int j, List<Point> paths) {
		if (i + 1 == maze.length && j + 1 == maze.length) {
			solution[i][j] = true;
			paths.add(new Point(i, j));
			return true;
		}
		if (isValidMove(maze, i, j) && !solution[i][j]) {
			solution[i][j] = true;
			if (traverseMaze(maze, solution, i + 1, j, paths)) {
				paths.add(new Point(i, j));
				return true;
			}
			if (traverseMaze(maze, solution, i - 1, j, paths)) {
				paths.add(new Point(i, j));
				return true;
			}
			if (traverseMaze(maze, solution, i, j + 1, paths)) {
				paths.add(new Point(i, j));
				return true;
			}
			if (traverseMaze(maze, solution, i, j - 1, paths)) {
				paths.add(new Point(i, j));
				return true;
			}
			return false;
		}
		return false;
	}

	private static boolean isValidMove(int[][] maze, int i, int j) {
		return i >= 0 && i < maze.length && j >= 0 && j < maze.length && maze[i][j] == 1;
	}

}
