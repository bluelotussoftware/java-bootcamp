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
 * $Id: Tester.java 5 2011-01-10 20:35:17Z jyeary $
 */
package equality;

/**
 *
 * @author John Yeary <jyeary@bluelotussoftware.com>
 * @version 1.0
 */
public class Tester {

    public final int x;
    public int y;
    public final int z;
    private static ValueHolder obj;

    // Initializer block
    {
        z = y;
    }

    public Tester() {
        x = 10; // Assignment of final variable in constructor ?
    }

    public static void main(String... args) {

        System.out.println("Is x == 0? " + (new Tester().x == 0));
        System.out.println("Is y == 0? " + (new Tester().y == 0));
        System.out.println("Is z == 0? " + (new Tester().z == 0));
        System.out.println("What is the value of z? " + new Tester().z);

        ValueHolder vh1 = new ValueHolder();
        ValueHolder mtv = vh1;
        ValueHolder vh2 = new ValueHolder();

        System.out.println("\nIs vh1 == mtv? " + (vh1 == mtv));
        System.out.println("Is mtv == vh2? " + (mtv == vh2));
        System.out.println("Is vh1.equals(mtv)? " + vh1.equals(mtv));
        System.out.println("Is mtv.equals(vh1)? " + mtv.equals(vh1)); // Reflexive
        System.out.println("Is vh1.equals(vh2)? " + vh1.equals(vh2));
        System.out.println("\nSetting vh2.setK(42)");
        vh2.setK(42);
        System.out.println("Is vh1.equals(vh2)? " + vh1.equals(vh2));

        System.out.println("\nmtv = vh2");
        mtv = vh2;
        System.out.println("Is mtv == vh2? " + (mtv == vh2));
        System.out.println("Is mtv.equals(vh2)? " + mtv.equals(vh2));
        System.out.println("Is mtv.equals(vh1)? " + mtv.equals(vh1));
        System.out.println("Is vh1 == mtv? " + (vh1 == mtv));

        boolean b = false;

        if (b = true) {
            System.out.println("b is true");
        } else {
            System.out.println("b is false");
        }

        System.out.println("Is Spring == Summer? " + (Seasons.Spring == Seasons.Summer));
        System.out.println("Is Spring == Spring? " + (Seasons.Spring == Seasons.Spring));
        Seasons spring = Seasons.Spring;
        Seasons fall = Seasons.Spring;
        System.out.println("Is spring == fall? " + (spring == fall));
        System.out.println("Is spring.equals (fall)? " + spring.equals(fall));
        vh2.setK(1);
        System.out.println("Is spring.equals(vh2)? " + spring.equals(vh2));

        if (vh2 instanceof ValueHolder) {
            System.out.println("vh2 is a ValueHolder");
        }

        if (mtv instanceof Holder) {
            System.out.println("mtv is a Holder");
        }

        Holder holder = null;
        if (holder instanceof Holder) {
            System.out.println("holder is an \"assignment compatible\" Holder");
        }

        holder = new ValueHolder();
        if (holder instanceof Holder) {
            System.out.println("holder is an \"assignment compatible\" Holder");
        }

        if (holder instanceof ValueHolder) {
            System.out.println("holder is a ValueHolder");
        }

        if (null instanceof Object) {
            System.out.println("null is an Object"); // What will this result in?
        }

        if (obj instanceof Object) {
            System.out.println("obj is an Object");
        }

        Seasons[] seasonal = new Seasons[4];
        if (seasonal instanceof Object) {
            System.out.println("seasonal is an Object");
        }

        Holder lvh = new LessValuableHolder();
        if (lvh instanceof Object) {
            System.out.println("lvh is an Object");
        }
        if (lvh instanceof Holder) {
            System.out.println("lvh is a Holder");
        }
        if (lvh instanceof ValueHolder) {
            System.out.println("lvh is a ValueHolder");
        }
        if (lvh instanceof LessValuableHolder) {
            System.out.println("lvh is a LessValuableHolder");
        }
        if (lvh instanceof EvenLessValuableHolder) {
            System.out.println("lvh is worthless!");
        }

    }
}

enum Seasons {

    Spring, Summer, Fall, Winter
}

interface Holder {

    void setK(int k);

    int getK();
}

class ValueHolder implements Holder {

    int k = 38;

    public ValueHolder() {
    }

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ValueHolder other = (ValueHolder) obj;
        if (this.k != other.k) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.k;
        return hash;
    }
}

class LessValuableHolder extends ValueHolder {
}

class EvenLessValuableHolder extends LessValuableHolder {
}
