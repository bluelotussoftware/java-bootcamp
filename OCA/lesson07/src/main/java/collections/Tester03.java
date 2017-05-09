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
 * $Id: Tester03.java 8 2011-01-10 20:37:56Z jyeary $
 */
package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author John Yeary <jyeary@bluelotussoftware.com>
 * @version 1.0
 */
public class Tester03 {

    @SuppressWarnings("unchecked")
    public static void main(String... args) {

        List<String> list = new ArrayList<String>();
        list.add("Hello");
        list.add("GreenJUG");
        list.add("Welcome to Java Boot Camp");
//        list.add(new Integer(42));

        String sx[] = Tester03.toStringArray(list);
        System.out.println(Arrays.asList(sx));

        List obj = new ArrayList();
        obj.add("Hello");
        obj.add("World");
        obj.add(42);
        obj.add(801);
        obj.add(new String[]{"Chicken", "Soup", "Soul"});
        sx = Tester03.toStringArray(obj);
        System.out.println(Arrays.asList(sx));

    }

    public static String[] toStringArray(List list) {
        if (list == null) {
            return new String[]{};
        }
        String[] s = new String[list.size()];
        Iterator it = list.iterator();
        int ctr = 0;
        while (it.hasNext()) {
            Object o = it.next();
            if (o.getClass().getName().equalsIgnoreCase("java.util.String")) {
                s[ctr] = (String) o;
            } else {
                s[ctr] = o.toString();
            }
            ctr++;
        }
        return s;
    }
}
