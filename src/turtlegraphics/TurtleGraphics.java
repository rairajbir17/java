/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turtlegraphics;
import java.util.Scanner;
public class TurtleGraphics {
public static void main(String[] args) {
int choice=0;
int steps_count;
Scanner obj= new Scanner(System.in);
Turtle tur1=new Turtle(20,20);
System.out.println("Press 1 for Pen Up\n Press 2 for Pen down\n Press 3 for Turn right\n Press 4 for turn left\n 5,10 for Move forward\n 6 for display pattarn\n 9 For end of game");
while(choice!=9){
    System.out.print("Enter command (9 to end input):");
    choice=obj.nextInt();
    switch(choice){
            case 1:
            tur1.penUp();
            break;
            case 2:
            tur1.penDown();
            break;
            case 3:
            tur1.turnRight();
            break;
            case 4:
            tur1.turnLeft();
            break;
            case 5:
            System.out.print("Enter forward spaces:");
            steps_count=obj.nextInt();
            if(steps_count<tur1.surface.length){
            tur1.moveForward(steps_count);
            }
            else{
            System.out.println("Your Step count is larger than available space! Max Length "+tur1.surface.length);
            }
            break;
            case 6:
            tur1.displayArray();
            break;
            case 9:             
            break;
            default:
            System.out.println("Incorrect Command");
    }
}
}  
}
class Turtle{
 public int[][] surface;
 boolean pendown;
 int currentRow, currentColumn;
 int turn;
 int turnL;
 char firstTime;
 Turtle(int row, int column){
surface=new int[row][column];
pendown=false;
turn=0;
turnL=0;
currentRow=0;
currentColumn=0;
firstTime='Y';
}
public void penUp(){
        pendown=false;
}
public void penDown(){
        pendown=true;
}
public void turnRight(){
    if (firstTime=='Y'){
        firstTime='N';
    }
    else{ if (turn<3){
             turn++;}
             else{
             turn=0;
             }
        }
}
public void turnLeft(){
    if (turn>0){
    turn--;}
    else{
        turn=3;
    }
}
public void moveForward(int steps){   
    if(turn==0){       
        if(currentColumn+steps<surface[0].length){
            for(int i=0; i<steps;i++){
            writeToMatric();
            currentColumn+=1;
            }
        }
        else{
            System.out.println("Value is greater than available moves in this direction: "+(surface[0].length-currentColumn-1));
        }
    }
    else if(turn==1){
         if(currentRow+steps<surface.length){
            for(int i=0; i<steps;i++){
            writeToMatric();
            currentRow+=1;
            }
         }
          else{
            System.out.println("Value is greater than available spaces "+(surface.length-currentRow));
        }
    }
    else if(turn==2){     
     if(currentColumn-steps>=0){
            for(int i=0; i<steps;i++){
            writeToMatric();
            currentColumn-=1;     
            }    
     } 
        else{
            System.out.println("Not Possible: Available backward spaces are  "+currentColumn);
        }
    }
     else if(turn==3){
           if(currentRow-steps>=0){
            for(int i=0; i<steps;i++){
            writeToMatric();
            currentRow-=1;
            }
    }
            else{
            System.out.println("Value is greater than available spaces "+currentRow);
        }
     }
}
public void writeToMatric(){
    if (pendown==true){
        if(currentRow >=0 && currentColumn>=0){
        surface[currentRow][currentColumn]=1;
        }
       }   
}
public void displayArray(){
    System.out.println("The Drawing is:");
    for(int i=0; i<surface.length;i++){
        for(int j=0;j<surface[0].length;j++){
            if(surface[i][j]==0)     System.out.print(" ");
            else                     System.out.print("*");
        }
        System.out.println();
    }
}
}