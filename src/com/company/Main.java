package com.company;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    private Scanner scanner = new Scanner(System.in);
    private Pacman pacman = new Pacman();

    public static void main(String[] args) {
        Main main = new Main();
        main.startInit();
        main.startMoving();
	// write your code here
    }

    private void startMoving(){
        String commend;
        do {
            System.out.println("Enter your commend USING LEFT RIGHT MOVE REPORT");
            commend = scanner.nextLine();
            if (Objects.equals("LEFT",commend.toUpperCase())||Objects.equals("RIGHT",commend.toUpperCase())||
                    Objects.equals("MOVE",commend.toUpperCase())||Objects.equals("REPORT",commend.toUpperCase())){
                boolean isMove = true;
                switch (commend.toUpperCase()){
                    case "LEFT": isMove = pacman.turnLeft();
                    break;
                    case "RIGHT": isMove = pacman.turnRight();
                    break;
                    case "MOVE": isMove = pacman.move();
                    break;
                    default:break;
                }
                if (!isMove) {
                    printError();
                    startMoving();
                }
                if (Objects.equals("report",commend.toLowerCase())){
                    pacman.report();
                    System.exit(0);
                }
            } else if(commend.toLowerCase().contains("place")){
                init(commend);
            } else {
                System.out.println("Invalid Commend, Try LEFT RIGHT MOVE REPORT");
            }
        }while (!Objects.equals("report",commend.toLowerCase()));
    }


    private void printStart(){
        System.out.println("Enter position using format \'PLACE x,y,facing\'");
        System.out.println("x,y should no less than 0 and no more than 4");
        System.out.println("facing should be SOUTH, NORTH, EASE, or WEST");
    }

    private void printError(){
        System.out.println("Pacmen will fall if continue the commend, try other commends ");
    }

    private void startInit(){
        try{
            printStart();
            String str = scanner.nextLine();
            if (str.toUpperCase().contains("PLACE")) {
                init(str);
            } else {
                System.out.println("Invalid input, try again please");
                startInit();
            }
        }catch (Exception e){
            System.out.println("Invalid input, try again please");
            startInit();
        }

    }

    private Pacman.Facing switchFacing(String facing){
        switch (facing) {
            case "north": return Pacman.Facing.NORTH;
            case "west": return Pacman.Facing.WEST;
            case "east": return Pacman.Facing.EAST;
            case "south": return Pacman.Facing.SOUTH;
            default: return null;
        }
    }

    private void init(String str){
        String[] strings = str.split("\\s+");
        if (strings.length !=2){
            System.out.println("Invalid input, try again please");
            startInit();
        }else {
            String position = strings[1];
            String[] localtions = position.split(",");
            if (localtions.length!=3){
                System.out.println("Invalid input, try again please");
                startInit();
            } else {
                int x = Integer.parseInt(localtions[0]);
                int y = Integer.parseInt(localtions[1]);
                String facing = localtions[2];
                if (!facing.toLowerCase().contains("north")&&!facing.toLowerCase().contains("south")&&
                        !facing.toLowerCase().contains("west")&&!facing.toLowerCase().contains("east")){
                    System.out.println("Invalid FACING, try again please");
                    startInit();
                }else {
                    if (x<0||x>4||y<0||y>4){
                        System.out.println("x or y should no less than 0 and no more than 4");
                        startInit();
                    } else {
                        Pacman.Facing facing1 = switchFacing(facing);
                        pacman.setxLocation(x);
                        pacman.setyLocation(y);
                        pacman.setFacing(facing1);
                    }
                }
            }
        }
    }

}
