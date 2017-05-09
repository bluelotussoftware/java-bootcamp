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
package interfaces;

/**
 *
 * @author John Yeary
 * @version 1.0
 */
public class Tester {

    public static void main(String... args) {
        D d = new D();
        System.out.println(d.ANSWER_TO_LIFE);
        System.out.println(d.KILO);
        d.print();
        System.out.println(d.getMyString());
        System.out.println(IA.KILO);
        System.out.println(IC.ANSWER_TO_LIFE);

        E e = new E();
        int x = e.ANSWER_TO_LIFE + e.ONE;
//       e.ONE = 99;
        System.out.println(x);
    }
}
