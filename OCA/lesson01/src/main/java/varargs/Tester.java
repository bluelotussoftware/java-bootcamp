/*
 * 
 * Blue Lotus Software, LLC
 * 
 * $Id: Tester.java 2 2011-01-10 20:29:25Z jyeary $
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
package varargs;

/**
 *
 * @author John Yeary
 * @version 1.0
 */
public class Tester {

    @SuppressWarnings("static-access")
    public static void main(String... args) {
        int[] ints = new int[100];

        for (int i = 0; i < ints.length; i++) {
            ints[i] = i * i + 1;
        }

        new BunnyReplicator(ints);
        System.out.println(BunnyReplicator.getBunnyCounter());

        BunnyReplicator br = new BunnyReplicator(1);
        System.out.println(br.getBunnyCounter());

        new BunnyReplicator(2, 2, 2, 2, 2);
        System.out.println(BunnyReplicator.getBunnyCounter());

        C c = new C("Hello World!", 1, 2, 3, 4, 5);
        System.out.println(c.myString);
        c.printN();
        c.printP();
    }
}
