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
package serial;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author John Yeary <jyeary@bluelotussoftware.com>
 * @version 1.0
 */
public class Tester {

    public static void main(String... args) {
        System.out.println("Creating a Serializable object.");
        FreezeDry freeze = new FreezeDry();
        System.out.println("Setting an instance variable to 99");
        freeze.setX(99);

        System.out.println("Serializing object to disk.");
        try {
            FileOutputStream fos = new FileOutputStream("Frozen.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(freeze);
            oos.flush();
            oos.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.err);
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }

        System.out.println("De-serializing object from disk");
        try {
            FileInputStream fis = new FileInputStream("Frozen.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            FreezeDry reconstituted = (FreezeDry) ois.readObject();
            System.out.println("object instance variable value? " + reconstituted.getX());
            ois.close();
        } catch (IOException e) {
            e.printStackTrace(System.err);
        } catch (ClassNotFoundException e) {
            e.printStackTrace(System.err);
        }

        System.out.println("Creating a bunch of recursive objects to serialize.");
        A ax = new A();
        ax.setBx(new B());
        ax.setCx(new C());
        ax.setDx(new D());
        ax.setEx(new E());
        B bx = ax.getBx();
        bx.setCx(ax.getCx());
        bx.getCx().setDx(ax.getDx());
        System.out.println("Setting Z to 100");
        bx.getCx().getDx().setZ(100);

        System.out.println("Setting Y to 801");
        ax.getEx().setY(801);

        System.out.println("Serializing object graph to disk.");
        try {
            FileOutputStream fos = new FileOutputStream("AMess.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(ax);
            oos.flush();
            oos.close();
            fos.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.err);
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }

        ObjectInputStream ois = null;
        FileInputStream fis = null;
        System.out.println("De-serializing object graph from disk.");
        try {
            fis = new FileInputStream("AMess.ser");
            ois = new ObjectInputStream(fis);
            A ax_ax = (A) ois.readObject();
            System.out.println("object instance variable Y value? " + ax_ax.getEx().getY());
            // What will this evaluate to?
//            System.out.println("object instance variable Z value? " + ax_ax.getDx().getZ());
            System.out.println("object instance D? " + ax_ax.getDx());
        } catch (IOException e) {
            e.printStackTrace(System.err);
        } catch (ClassNotFoundException e) {
            e.printStackTrace(System.err);
        } finally {
            try {
                ois.close();
                fis.close();
            } catch (IOException ignored) {
            }
        }



    }
}
