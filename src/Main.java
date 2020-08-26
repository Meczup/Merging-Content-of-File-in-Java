import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Main {
public static void main(String[] args) {
    
    
BufferedWriter bufWriter = null;
    try {
        bufWriter = new BufferedWriter(new FileWriter("C:\\join\\join.txt")); // opening file for writing.
    } catch (IOException ex) {
        System.out.println("File Directory Couln't Find or File Couldn't Open");
    }
File directory = new File("C:\\yunus"); // The process of listing files in the directory.
LinkedList<String> names = new LinkedList<>();
for (File file : directory.listFiles()) { // taking the fies from the directory.
BufferedReader bufReader = null;
    
    try {
        System.out.println("Raading From "+file);
        bufReader = new BufferedReader(new FileReader(file)); // opening file for reading
    } catch (FileNotFoundException ex) {
        System.out.println("File Couldn't Open!");
    }
    try {
        for (String name = bufReader.readLine(); name != null; name = bufReader.readLine()){ 
            
            if(names.contains(name)) // if name is avialable
                continue; // pass it
            names.addLast(name); // else add name to the linkedList
            bufWriter.write(name); // write name to the file
            bufWriter.newLine();//and go to the new line
            
        }  
       
    //exceptions
    } catch (IOException ex) {
        System.out.println("I / O operations problem dedected!");
    }
    try {
        bufReader.close();
    } catch (IOException ex) {
        System.out.println("I / O operations problem dedected!");
    }
}
    try {
        bufWriter.close();
    } catch (IOException ex) {
        System.out.println("I / O operations problem dedected!");
    }
    System.out.println("Reading from all files" +  
        " in directory " + directory.getName() + " completed!"); 
}

}