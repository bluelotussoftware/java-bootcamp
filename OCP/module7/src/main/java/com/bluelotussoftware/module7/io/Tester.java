/*
 *  Copyright 2010-2012 Blue Lotus Software, LLC.
 *  Copyright 2008-2012 John Yeary.
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
 * $Id: Tester.java 24 2012-11-11 14:15:41Z jyeary $
 */
package com.bluelotussoftware.module7.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.CharBuffer;

/**
 *
 * @author John Yeary
 * @version 1.1
 */
public class Tester {

    public static void main(String[] args) {
        File f = new File("target/somefile.txt");
        System.out.println("Does the file exist yet? " + f.exists());

        try {
            f.createNewFile();
            System.out.println("Does the file exist yet? " + f.exists());
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }

        System.out.println("Using a FileWriter to create a file.");
        try {
            try (FileWriter fwriter = new FileWriter(f)) {
                fwriter.write("Hello World!!");
                fwriter.flush();
            }
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }

        System.out.println("\nUsing a char[] array.");
        try {
            try (FileReader freader = new FileReader(f)) {
                char[] cbuf = new char[100];
                int fSize;
                fSize = freader.read(cbuf);
                System.out.println("File Size: " + f.length() + " Bytes read: " + fSize + " bytes");

                for (char c : cbuf) {
                    System.out.print(c);
                }
                System.out.println();
                for (char c : cbuf) {
                    if (!Character.isIdentifierIgnorable(c)) {
                        System.out.print(c);
                    }
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.err);
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }

        System.out.println("\n\nUsing a CharBuffer object.");
        try {
            try (FileReader freader = new FileReader(f)) {
                CharBuffer cb = CharBuffer.allocate(50);
                int fsize;
                fsize = freader.read(cb);
                System.out.println("File Size: " + fsize + " bytes");
                for (char c : cb.array()) {
                    if (!Character.isIdentifierIgnorable(c)) {
                        System.out.print(c);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.err);
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }


        File f1 = new File("target/sometext2.txt");
        PrintWriter pwriter;
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
        try (
                FileReader freader = new FileReader(f1);
                BufferedReader breader = new BufferedReader(freader);) {

            String s;
            while ((s = breader.readLine()) != null) {
                sb.append(s);
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.err);
        } catch (IOException e) {
            e.printStackTrace(System.err);
        } finally {
            System.out.println(sb.toString());
        }


        System.out.println("Creating Directory and files.");
        File tmpDirectory = new File("target/temp");
        tmpDirectory.mkdir();
        File f2 = new File(tmpDirectory, "target/sometext3.txt");

        try {
            f2.createNewFile();
            FileWriter fw = new FileWriter(f2);
            try (BufferedWriter bfw = new BufferedWriter(fw)) {
                bfw.write("I am in somefile3.txt");
                bfw.newLine();
                bfw.flush();
            }
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }

        File newTempDirectory = new File("target/temp2");
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
            String s;

            // What will happen here?
//            System.out.println("somefile3.txt");
//            FileReader rx = new FileReader(f2);
//            BufferedReader bfr;
//            bfr = new BufferedReader(rx);
//            
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
    }
}
