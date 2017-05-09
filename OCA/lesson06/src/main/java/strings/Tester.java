/*
 *  Copyright 2010 Blue Lotus Software, LLC.
 *  Copyright 2010 John Yeary <jyeary@bluelotussoftware.com>.
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
package strings;

/**
 *
 * @author John Yeary <jyeary@bluelotussoftware.com>
 * @version 1.0
 */
public class Tester {

    public static void main(String... args) {

        String s1 = "hello";
        String s2 = s1;
        String s3 = new String("hello");
        String s4 = new StringBuilder().append("hello").toString();
        String s5 = new StringBuilder().append("hello").toString().intern();// What is this?
        String s6 = new String("hello").intern(); 

        System.out.println("Is s1 == \"hello\" : " + (s1 == "hello"));
        System.out.println("Is s1 == s2 : " + (s1 == s2));
        System.out.println("Is s2 == s1 : " + (s2 == s1));
        System.out.println("Is s1 == s3 : " + (s1 == s3));
        System.out.println("Is s1 == s4 : " + (s1 == s4));
        System.out.println("Is s1 == s5 : " + (s1 == s5));
        System.out.println("Is s1 == s6 : " + (s1 == s6));

    }
}
