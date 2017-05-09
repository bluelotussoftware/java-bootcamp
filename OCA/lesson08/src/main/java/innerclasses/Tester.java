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
 * $Id: Tester.java 9 2011-01-10 20:38:38Z jyeary $
 */
package innerclasses;

/**
 *
 * @author John Yeary <jyeary@bluelotussoftware.com>
 * @version 1.0
 */
public class Tester {

    public static void main(String... args) {
        // Traditional
        OuterClass1 oc1 = new OuterClass1();
        OuterClass1.InnerClass1 ic1 = oc1.new InnerClass1();
        OuterClass1.InnerClass1 ic2 = new OuterClass1().new InnerClass1();
        System.out.println("Inner Class Traditional");
        System.out.println(ic1.identify());
        System.out.println(ic2.identify());

        Tester t = new Tester();
        System.out.println(t.i1.identify());

        System.out.println(t.i2.identify());

        System.out.println(t.getX(new Interface1() {

            public String identify() {
                return this.getClass().getName();
            }
        }));

        System.out.println(Tester.Yummy.output());

    }
    Interface1 i1 = new Interface1() {

        public String identify() {
            return this.getClass().getName();
        }
    };
    Interface1 i2 = new Interface1() {

        public String identify() {
            return this.getClass().getName();
        }
    };

    public String getX(Interface1 iface) {
        return iface.identify();
    }

    static class Yummy {

        static String output() {
            return "I am Yummy!";
        }
    }
}
