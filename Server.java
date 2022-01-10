/*
 * Server.java
 *
 * Version:
 *     $Id$
 *
 * Revisions:
 *     $Log$
 */

/**
 * This class implements server side of the game
 *
 * @author Muskan Mall
 * @author Dibyanshu
 */

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Server {
    public static void main(String args[]) throws Exception {
        String fileName = "/Users/dibyanshuchatterjee/Desktop/Home_Work_13.2/src/batman.txt";
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        String data = "";
        while (scanner.hasNextLine()) {
            data += (scanner.nextLine() + "\n");
        }
        String fileName1 = "/Users/dibyanshuchatterjee/Desktop/Home_Work_13.2/src/superman.txt";
        File file1 = new File(fileName1);
        Scanner scanner1 = new Scanner(file1);
        String data1 = "";
        while (scanner1.hasNextLine()) {
            data1 += (scanner1.nextLine() + "\n");
        }
        System.out.println("Reading file in as server");

        while (true) {
            try {
                Socket s = new Socket("localhost", 6666);
                DataOutputStream dataOutputStream = new DataOutputStream(s.getOutputStream());
                dataOutputStream.writeUTF(data);
                scanner.close();
                dataOutputStream.flush();
                dataOutputStream.close();
                DataOutputStream dataOutputStream1 = new DataOutputStream(s.getOutputStream());
                dataOutputStream1.writeUTF(data1);
                scanner1.close();
                dataOutputStream1.flush();
                dataOutputStream1.close();
                s.close();
            } catch (Exception e) {

            }

        }
    }
}
