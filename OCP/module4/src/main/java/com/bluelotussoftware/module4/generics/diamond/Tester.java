/*
 * Copyright 2012 John Yeary.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.bluelotussoftware.module4.generics.diamond;

import com.bluelotussoftware.module4.generics.Widget;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author John Yeary
 * @version 1.0
 */
public class Tester {

    public static void main(String... args) {

        List preJava5 = new ArrayList();
        List preJavaS = new ArrayList() {
            private static final long serialVersionUID = 3109256773218160485L;
            {
                add(Runtime.getRuntime());
            }
        };

        // Which would you prefer?
        List<List<Map<Integer, Map<String, String>>>> oldWay = new ArrayList<List<Map<Integer, Map<String, String>>>>();

        List<List<Map<Integer, Map<String, String>>>> newWay = new ArrayList();// No Diamond?

        List<?> something;
        List<Widget> somethingElse = new ArrayList<>();
        List<? extends Widget> somethingEntirelyDifferent = somethingElse;
        something = somethingEntirelyDifferent;
        
        List<?> x = new ArrayList<>(somethingEntirelyDifferent);

        Widget w = new Widget();

        class Wx extends Widget {

            void print() {
                System.out.println("Hello World!");
            }
        }

        Wx wx = new Wx();

//        something.add(w);
//        obj.add(w);
//        something.add(wx);
//        obj.add(wx);
        

        somethingElse.add(w);
        somethingElse.add(wx);

        preJava5.add(w);
        preJava5.add(wx);
        preJava5.add(new Integer(42));
        preJava5.add(45);
        preJava5.add(null);
        preJavaS.addAll(preJava5);
        preJava5.addAll(preJavaS);

        for (Object o : somethingEntirelyDifferent) {
            System.out.println("Class: " + o);
        }

        for (Object o : something) {
            System.out.println("Class: " + o);
        }

        for (Widget o : somethingElse) {
            System.out.println("Class: " + o);
        }

        for (Widget o : somethingElse) {
            if (o instanceof Wx) {
                ((Wx) o).print();
            }
        }

        for (Object o : preJava5) {
            System.out.println("Class: " + o);
            if (o instanceof Wx) {
                ((Wx) o).print();
            }
            if (o instanceof Runtime) {
                System.out.println("RUNTIME...");
            }
        }


        for (Object o : preJavaS) {
            System.out.println("Class: " + o);
            if (o instanceof Wx) {
                ((Wx) o).print();
            }
            if (o instanceof Runtime) {
                System.out.println("RUNTIME...");
            }
        }
        
        for (Object o : x) {
            System.out.println(o);
        }

    }
}
