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
 * $Id: Directory.java 8 2011-01-10 20:37:56Z jyeary $
 */
package collections.misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author John Yeary <jyeary@bluelotussoftware.com>
 * @version 1.0
 */
public class Directory<C, E> {

    private List<C> contacts;
    private List<E> entries;
    private HashMap<C, List<E>> listings;

    /**
     * Default Constructor
     */
    public Directory() {
        contacts = new ArrayList<C>();
        entries = new ArrayList<E>();
        listings = new HashMap<C, List<E>>();
    }

    public List<C> getContacts() {
        return contacts;
    }

    public List<E> getEntries() {
        return entries;
    }

    public void setContacts(List<C> contacts) {
        this.contacts = contacts;
        for (C c : contacts) {
            if (!listings.containsKey(c)) {
                listings.put(c, new ArrayList<E>());
            }
        }
    }

    public List<? extends E> getListingsByContact(final C contact) {
        return listings.get(contact);
    }

    public void addListingForContact(final C contact, final E entry) {
        contacts.add(contact);
        entries.add(entry);
        if (listings.containsKey(contact)) {
            listings.get(contact).add(entry);
        } else {
            List<E> e = new ArrayList<E>();
            e.add(entry);
            listings.put(contact, e);
        }
    }
}
