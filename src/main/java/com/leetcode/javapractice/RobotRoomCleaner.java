package com.leetcode.javapractice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

interface Robot {

    public boolean move();

    public void turnLeft();

    public void turnRight();

    public void clean();
}

class RobotImpl implements Robot {

    int[][] room;
    int x;
    int y;
    Map<Character, int[]> dir;
    char currentDir;
    int dirtyRooms;

    public RobotImpl(int[][] room, int row, int col) {
        this.room = room;
        this.x = row;
        this.y = col;
        this.dir = new HashMap<Character, int[]>();
        this.dir.put('U', new int[] {-1, 0});
        this.dir.put('D', new int[] {1, 0});
        this.dir.put('L', new int[] {0, -1});
        this.dir.put('R', new int[] {0, 1});
        this.currentDir = 'U';
        this.dirtyRooms = 0;
        for (int i = 0; i < room.length; i++) {
            for (int j = 0; j < room[i].length; j++) {
                if (room[i][j] == 1) {
                    this.dirtyRooms++;
                }
            }
        }
    }

    @Override
    public boolean move() {
        int i = x + this.dir.get(currentDir)[0];
        int j = y + this.dir.get(currentDir)[1];
        if (isValid(i, j)) {
            x = i;
            y = j;
            return true;
        }
        return false;
    }

    private boolean isValid(int i, int j) {
        return i >= 0 && i < room.length && j >= 0 && j < room[0].length && room[i][j] != 0;
    }

    @Override
    public void turnLeft() {
        switch (this.currentDir) {
            case 'U':
                this.currentDir = 'L';
                break;
            case 'D':
                this.currentDir = 'R';
                break;
            case 'R':
                this.currentDir = 'U';
                break;
            case 'L':
                this.currentDir = 'D';
                break;
        }
    }

    @Override
    public void turnRight() {
        switch (this.currentDir) {
            case 'U':
                this.currentDir = 'R';
                break;
            case 'D':
                this.currentDir = 'L';
                break;
            case 'R':
                this.currentDir = 'D';
                break;
            case 'L':
                this.currentDir = 'U';
                break;
        }
    }

    @Override
    public void clean() {
        dirtyRooms--;
    }

    public void checkIfAllRoomsCleaned() {
        if (dirtyRooms == 0) {
            System.out.println("Robot cleaned all rooms.");
        } else {
            System.out.println(
                    "The robot did not clean all rooms - " + dirtyRooms + " rooms were not cleaned.");
        }
    }
}

public class RobotRoomCleaner {

    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void cleanRoom(Robot robot) {
        Set<String> visited = new HashSet<>();
        cleanRoomHelper(robot, visited, 0, 0, 0);
    }

    private static void cleanRoomHelper(Robot robot, Set<String> visited, int x, int y, int arrow) {
        String path = x + "-" + y;
        if (visited.contains(path)) {
            return;
        }
        visited.add(path);
        robot.clean();
        for (int i = 0; i < 4; i++) {
            if (robot.move()) {
                int nx = x + dir[arrow][0];
                int ny = y + dir[arrow][1];
                cleanRoomHelper(robot, visited, nx, ny, arrow);
                robot.turnLeft();
                robot.turnLeft();
                robot.move();
                robot.turnLeft();
                robot.turnLeft();
            }
            robot.turnRight();
            arrow = (arrow + 1) % 4;
        }
    }

    public static void main(String[] args) {

        int[][] room = {
            {1, 1, 1, 1, 1, 0, 1, 1},
            {1, 1, 1, 1, 1, 0, 1, 1},
            {1, 0, 1, 1, 1, 1, 1, 1},
            {0, 0, 0, 1, 0, 0, 0, 0},
            {1, 1, 1, 1, 1, 1, 1, 1}
        };
        RobotImpl robot = new RobotImpl(room, 1, 3);
        cleanRoom(robot);
        robot.checkIfAllRoomsCleaned();
    }
}
