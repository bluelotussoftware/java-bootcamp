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
 * $Id: Tester04.java 8 2011-01-10 20:37:56Z jyeary $
 */
package collections;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author John Yeary <jyeary@bluelotussoftware.com>
 * @version 1.0
 */
public class Tester04 {

    public static void main(String... args) {

        ArrayList<Number> values = new ArrayList<Number>();
        values.add(new Integer(1));
        values.add(new Double(2.0));
        values.add(30);

        double d = Tester04.add(values);
        System.out.println("I am feeling lucky d + 1 = " + (d + 1));

        // Will this work???
//        List<Number> ints = new ArrayList<Integer>();
//        ints.add(1);
//        ints.add(2);
//        ints.add(3);
//        ints.add(4);
//        double dx = Tester04.add(ints);
//        System.out.println("dx = " + dx);

    }

    public static double add(Collection<Number> numbers) {
        if (numbers == null || numbers.size() == 0) {
            return 0.0;
        }
        double d = 0.0;
        for (Number n : numbers) {
            d += n.doubleValue();
        }
        return d;
    }

    private static double add(ArrayList<Integer> ints) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
