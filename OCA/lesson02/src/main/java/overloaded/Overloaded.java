/*
 * 
 * Blue Lotus Software, LLC
 * 
 * $Id: Overloaded.java 3 2011-01-10 20:33:09Z jyeary $
 * 
 * Copyright 2008 John Yeary 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * http://www.apache.org/licenses/LICENSE-2.0 
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and 
 * limitations under the License.
 */
package overloaded;

import java.io.IOException;

/**
 *
 * @author John Yeary
 * @version 1.0
 */
public class Overloaded {

    public void print() {
        System.out.println("print()");
    }

    public void print(String s) {
        System.out.println(s);
    }

    public void print(int i) {
        System.out.println("single int.");
        System.out.println(Integer.toString(i));
    }

    public void print(int a, int b) {
        System.out.println("two ints");
        System.out.println(Integer.toString(a) + " " + Integer.toString(b));
    }

    private void print(double d) {
        System.out.println(Double.toString(d));
    }

    protected String print(long l) {
        return Long.toString(l);
    }

    void print(Long l) {
        System.out.println(l.toString());
    }

    void print(int... i) {
        for (int n : i) {
            System.out.print(n + " ");
        }
    }

//    Why is this method bad?
//    void print(int[] i) {
//        for (int n : i) {
//            System.out.print(n + " ");
//        }
//    }


    public void print(int i, String... args) throws IOException {
        int ctr = 0;
        System.out.println();
        do {
            for (String s : args) {
                System.out.print(s + " ");
            }
            System.out.println();
            ctr++;
        } while (ctr < i);
    }
}
