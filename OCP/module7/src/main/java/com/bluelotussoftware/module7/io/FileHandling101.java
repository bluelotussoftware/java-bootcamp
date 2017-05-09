/*
 *  Copyright 2010-2012 Blue Lotus Software, LLC.
 *  Copyright 2010-2012 John Yeary.
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
 * $Id: FileHandling101.java 25 2012-11-12 13:22:11Z jyeary $
 */
package com.bluelotussoftware.module7.io;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.tools.FileObject;
import javax.tools.SimpleJavaFileObject;

/**
 *
 * @author John Yeary
 * @version 1.0
 */
public class FileHandling101 {

    public static void main(String... args) throws IOException, URISyntaxException {

        Path p = Paths.get("target/", "out.txt");
        Files.deleteIfExists(p);
        Files.createFile(p);

        System.out.println("Path exists? : " + Files.exists(p));
        System.out.println(p.toUri().toString());
        System.out.println("Last Modified Time : " + new Date(Files.getLastModifiedTime(p).toMillis()));

        List<String> lines = new ArrayList<>();
        lines.add("Hello World!");
        lines.add("I love Java Programming!");

        Path goat = Paths.get("target/", "goat.txt");
        System.out.println("Path: " + goat);
        Files.deleteIfExists(goat);
        Files.createFile(goat);
        Files.write(goat, lines, Charset.defaultCharset());
        System.out.println("Last Modified Time : " + new Date(Files.getLastModifiedTime(goat).toMillis()));

        byte[] b = Files.readAllBytes(goat);
        byte[] z = Files.readAllBytes(Paths.get(p.toUri()));
        System.out.println("Files equal? : " + Arrays.equals(b, z));
        Files.write(p, b);

        z = Files.readAllBytes(p);
        System.out.println("Files equal? : " + Arrays.equals(b, z));
    }
}
