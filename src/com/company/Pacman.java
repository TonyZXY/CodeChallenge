package com.company;


public class Pacman {

    private int xLocation;
    private int yLocation;
    private Facing facing;

    public enum Facing {
        NORTH,EAST,SOUTH,WEST;

        public Facing turnRight(){
            switch (this) {
                case EAST: return SOUTH;
                case WEST: return NORTH;
                case NORTH: return EAST;
                case SOUTH: return WEST;
                default: return null;
            }
        }

        public Facing turnLeft() {
            switch (this) {
                case SOUTH: return EAST;
                case NORTH: return WEST;
                case WEST: return SOUTH;
                case EAST: return NORTH;
                default: return null;
            }
        }
    }

    public Pacman () {

    }

    public int getxLocation() {
        return xLocation;
    }

    public void setxLocation(int xLocation) {
        this.xLocation = xLocation;
    }

    public int getyLocation() {
        return yLocation;
    }

    public void setyLocation(int yLocation) {
        this.yLocation = yLocation;
    }

    public Facing getFacing() {
        return facing;
    }

    public void setFacing(Facing facing) {
        this.facing = facing;
    }

    public Pacman (int x, int y, Facing facing) {
        this.facing = facing;
        this.xLocation = x;
        this.yLocation = y;
    }

    public boolean move(){
        if (facing == Facing.WEST){
            if (xLocation ==0) {
                return false;
            } else {
                xLocation --;
                return true;
            }
        } else if (facing == Facing.SOUTH){
            if (yLocation ==0) {
                return false;
            } else {
                yLocation --;
                return true;
            }
        } else if (facing == Facing.EAST){
            if (xLocation == 4){
                return false;
            } else {
                xLocation ++;
                return true;
            }
        } else if (facing == Facing.NORTH){
            if (yLocation == 4){
                return false;
            } else {
                yLocation ++;
                return true;
            }
        } else {
            return false;
        }
    }

    public boolean turnLeft(){
        facing = facing.turnLeft();
        return true;
    }

    public boolean turnRight(){
        facing = facing.turnRight();
        return true;
    }

    public void report() {
        System.out.println("Current location is: "+xLocation+","+yLocation+","+facing);
    }
}
