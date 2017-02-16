package com.design.elevator;

import java.util.TreeSet;

/**
 * Created by sandeep on 16/2/17.
 */
public class Elevator implements Runnable {

    private ElevatorEntity elevator;
    private TreeSet<Move> floors = new TreeSet<>();

    public void request(Button button, Status status) {
        if (button.getButtonStatus() == ButtonStatus.NEUTRAL) {
            return;
        }
        Status stat = elevator.getStatus();
        if (stat == Status.NOT_WORKING)
            return;

        if (button.getButtonType() == ButtonType.INSIDE) {
            if (status == Status.STANDING) {
                stat = elevator.getCurrentFloor() < button.getFloor() ? Status.UP : Status.DOWN;
            }
            synchronized (floors) {
                floors.add(new Move(button.getFloor(), stat));
            }
        } else if (button.getButtonType() == ButtonType.OUTSIDE) {
            synchronized (floors) {
                floors.add(new Move(button.getFloor(), status));
            }
        }
    }

    @Override
    public void run() {
        while (true) {

            if (floors.isEmpty()) {
                synchronized (floors) {
                    try {
                        floors.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            synchronized (floors) {
                Move move = floors.first();
                if (move.status == Status.UP) {
                    System.out.println("going upwards");
                } else if (move.status == Status.DOWN) {
                    System.out.println("going downwards");
                } else {
                    System.out.println(move.status);
                }
            }
        }
    }

    class Move implements Comparable<Move> {
        int floor;
        Status status;

        public Move(int floor, Status s) {
            this.floor = floor;
            this.status = s;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Move move = (Move) o;

            if (floor != move.floor) return false;
            return status == move.status;
        }

        @Override
        public int hashCode() {
            int result = floor;
            result = 31 * result + (status != null ? status.hashCode() : 0);
            return result;
        }

        @Override
        public int compareTo(Move o) {
            if (this.status == Status.UP && o.status != Status.UP) {
                return 1;
            } else if (this.status == Status.DOWN && o.status != Status.DOWN) {
                return -1;
            } else {
                if (this.status == Status.UP) {
                    return this.floor - o.floor;
                }
                return o.floor - this.floor;
            }
        }
    }
}
