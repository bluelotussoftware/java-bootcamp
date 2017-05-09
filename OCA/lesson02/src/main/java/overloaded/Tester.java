/*
 * 
 * Blue Lotus Software, LLC
 * 
 * $Id: Tester.java 3 2011-01-10 20:33:09Z jyeary $
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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author John Yeary
 * @version 1.0
 */
public class Tester {

    public static void main(String[] args) {
        Overloaded o = new Overloaded();

        o.print();
        o.print(new Long(42L));
        o.print("Hello World!");
        // This is a private method so it can't be called.
//        o.print(999.99);
        o.print(42);
        o.print(10, 12);
        o.print(987654321L);
        System.out.println("I tricked you? Why didn't 987654321L print?");

//     What code goes here to make 987654321L print?

        o.print(9, 8, 7, 6, 5, 4, 3, 2, 1);

        try {
            o.print(10, "Men", "are", "from", "Mars.");
        } catch (IOException ex) {
            Logger.getLogger(Overloaded.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
