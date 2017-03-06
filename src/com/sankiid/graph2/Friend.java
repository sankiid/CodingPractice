package com.sankiid.graph2;

/**
 * Created by sankiid on 06-03-2017.
 */
public class Friend {
    public static void main(String[] args) {
        char[][] friends = {
                {'Y', 'N', 'N', 'N'},
                {'N', 'Y', 'Y', 'N'},
                {'N', 'Y', 'Y', 'N'},
                {'N', 'N', 'N', 'Y'}
        };
        System.out.println(getAllFriendCircle(friends));
    }

    private static int getAllFriendCircle(char[][] friends) {
        boolean[] visited = new boolean[friends.length];
        int friendCircles = 0;
        for (int i = 0; i < friends.length; ++i) {
            if (!visited[i]) {
                friendCircles++;
                dfs(friends, visited, i);
            }
        }
        return friendCircles;
    }

    private static void dfs(char[][] friends, boolean[] visited, int i) {
        if (visited[i]) return;
        visited[i] = true;
        for (int j = 0; j < friends.length; ++j) {
            if (!visited[j] && friends[j][i] == 'Y') {
                dfs(friends, visited, j);
            }
        }
    }
}
