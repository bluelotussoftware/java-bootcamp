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
 * $Id: PassByReferenceAndValue.java 4 2011-01-10 20:34:25Z jyeary $
 */
package scope;

/**
 *
 * @author John Yeary <jyeary@bluelotussoftware.com>
 * @version 1.0
 */
public class PassByReferenceAndValue {

    public static void main(String[] args) {
        int q = 42;
        int r = q; // Assign a copy of q to r

        ValueHolder pbr = new ValueHolder();
        System.out.println("q:" + q);
        System.out.println("r:" + r);
        System.out.println("pbr:k:" + pbr.getK());
        r = pbr.getK(); // assign the value of k to r
        pbr.setK(q);
        //Check the values
        System.out.println("pbr:k: " + pbr.getK());
        System.out.println("q:" + q);
        System.out.println("r:" + r);
    }
}

class ValueHolder {

    private int k = 99;

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }
}
