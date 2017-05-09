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
 * $Id: A.java 7 2011-01-10 20:37:04Z jyeary $
 */
package serial;

import java.io.Serializable;

/**
 *
 * @author John Yeary <jyeary@bluelotussoftware.com>
 * @version 1.0
 */
public class A implements Serializable {

    private static final long serialVersionUID = 6014860411398140430L;
    private B bx;
    private C cx;
    private transient D dx;
    private E ex;

    public B getBx() {
        return bx;
    }

    public void setBx(B bx) {
        this.bx = bx;
    }

    public C getCx() {
        return cx;
    }

    public void setCx(C cx) {
        this.cx = cx;
    }

    public D getDx() {
        return dx;
    }

    public void setDx(D dx) {
        this.dx = dx;
    }

    public E getEx() {
        return ex;
    }

    public void setEx(E ex) {
        this.ex = ex;
    }
}
