//import java.util.*;
//import java.io.*;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Driver{

    public static void main(String[] args){
	try{
	    Maze f = new Maze("Maze.txt");
	    //true animates the maze.
	    //   f.setAnimate(true);
	    //   f.solve();

	    System.out.println(f);
	    System.out.println(f.getMaze());
	}
	catch(FileNotFoundException e){
	}
	//    System.out.println(f);
    }
}
