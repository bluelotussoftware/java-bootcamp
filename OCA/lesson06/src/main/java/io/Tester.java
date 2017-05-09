/*
 *  Copyright 2010 Blue Lotus Software, LLC.
 *  Copyright 2008-2010 John Yeary <jyeary@bluelotussoftware.com>.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *  under the License.
 */
/*
 * $Id: Tester.java 7 2011-01-10 20:37:04Z jyeary $
 */
package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.CharBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author John Yeary <jyeary@bluelotussoftware.com>
 * @version 1.0
 */
public class Tester {

    public static void main(String[] args) {
        File f = new File("somefile.txt");
        System.out.println("Does the file exist yet? " + f.exists());

        try {
            f.createNewFile();
            System.out.println("Does the file exist yet? " + f.exists());
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }

        System.out.println("Using a FileWriter to create a file.");
        try {
            FileWriter fwriter = new FileWriter(f);
            fwriter.write("Hello World!!");
            fwriter.flush();
            fwriter.close();
        } catch (IOException ex) {
            Logger.getLogger(Tester.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("\nUsing a char[] array.");
        try {
            FileReader freader = new FileReader(f);
            char[] cbuf = new char[100];
            int fSize = 0;
            fSize = freader.read(cbuf);
            System.out.println("File Size: " +f.length() + " Bytes read: " +  fSize + " bytes");

            for (char c : cbuf) {
                System.out.print(c);
            }
            
            //TODO print in Unicode values.
//            for (char c : cbuf) {
//                System.out.print(Character.toString(c));
//            }

            freader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.err);
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }

        System.out.println("\n\nUsing a CharBuffer object.");
        try {
            FileReader freader = new FileReader(f);
            CharBuffer cb = CharBuffer.allocate(50);
            int fsize = 0;
            fsize = freader.read(cb);
            System.out.println("File Size: " + fsize + " bytes");
            for (char c : cb.array()) {
                System.out.print(c);
            }
            freader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.err);
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }


        File f1 = new File("sometext2.txt");
        PrintWriter pwriter = null;
        System.out.println("\n\nUsing a PrintWriter to create a file.");
        try {
            pwriter = new PrintWriter(f1);
            pwriter.println("Hello Java Boot Camp.");
            pwriter.flush();
            pwriter.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.err);
        }

        System.out.println("Using a BufferedReader to read a file.");
        StringBuilder sb = new StringBuilder();
        try {
            FileReader freader = new FileReader(f1);
            BufferedReader breader = new BufferedReader(freader);
            String s = null;
            while ((s = breader.readLine()) != null) {
                System.out.println(s);
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.err);
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }


        System.out.println("Creating Directory and files.");
        File tmpDirectory = new File("temp");
        tmpDirectory.mkdir();
        File f2 = new File(tmpDirectory, "sometext3.txt");

        try {
            f2.createNewFile();
            FileWriter fw = new FileWriter(f2);
            BufferedWriter bfw = new BufferedWriter(fw);
            bfw.write("I am in somefile3.txt");
            bfw.newLine();
            bfw.flush();
            bfw.close();
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }

        File newTempDirectory = new File("temp2");
        tmpDirectory.renameTo(newTempDirectory);

        File f3 = new File(newTempDirectory, "somefile4.txt");
        f2.renameTo(f3);

        System.out.println("List Files");
        File[] files = newTempDirectory.listFiles();
        System.out.println(newTempDirectory.getAbsolutePath());

        for (File fx : files) {
            System.out.println("\t+ " + fx.getAbsolutePath());
        }

        try {
            String s = null;

            // What will happen here?
//            System.out.println("somefile3.txt");
//            BufferedReader bfr = new BufferedReader(new FileReader(f2));
//            while ((s = bfr.readLine()) != null) {
//                System.out.println(s);
//            }


            System.out.println("somefile4.txt");
            BufferedReader bfrx = new BufferedReader(new FileReader(f3));
            while ((s = bfrx.readLine()) != null) {
                System.out.println(s);
            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.err);
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }




        // Get rid of our files

//        f.delete();
//        f1.delete();
//        f2.delete();
//        f3.delete();
//        tmpDirectory.delete();
//        newTempDirectory.delete();
    }
}
