/*
 *  Copyright 2011 Blue Lotus Software, LLC.
 *  Copyright 2011 John Yeary <jyeary@bluelotussoftware.com>.
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
 * $Id: Tester06.java 8 2011-01-10 20:37:56Z jyeary $
 */
package collections;

import collections.misc.Entry;
import collections.misc.Contact;
import collections.misc.Directory;
import collections.misc.PhoneEntry;

/**
 *
 * @author John Yeary <jyeary@bluelotussoftware.com>
 * @version 1.0
 */
public class Tester06 {
    
    public static void main(String[] args) {
        Contact c = new Contact("Sullivan", "Daniel");
        Entry<PhoneEntry> phone1 = new PhoneEntry("888-999-1111");
        Entry<PhoneEntry> phone2 = new PhoneEntry("900-800-1212");
        Directory<Contact, Entry> directory = new Directory<Contact, Entry>();
        directory.addListingForContact(c, phone1);
        directory.addListingForContact(c, phone2);

        for(Entry e : directory.getListingsByContact(c)) {
            System.out.println(c.getUuid().toString() + " : " + e.get());
        }
    }
}
