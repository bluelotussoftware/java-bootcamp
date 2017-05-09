/*
 * Copyright 2012 Blue Lotus Software, LLC.
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
/*
 * $Id$
 */
package com.bluelotussoftware.module8.path;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author John Yeary
 * @version 1.0
 */
public class PathExamples {

    public static void main(String... args) throws IOException {

        Path path1 = Paths.get("target");

        System.out.println("path1.getFileName(): " + path1.getFileName());
        System.out.println("path1.toAbsolutePath(): " + path1.toAbsolutePath());
        System.out.println("path1.getFileSystem():" + path1.getFileSystem());
        System.out.println("path1.toAbsolutePath().getNameCount(): " + path1.toAbsolutePath().getNameCount());
        for (int i = 0; i < path1.toAbsolutePath().getNameCount(); i++) {

            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            System.out.println("/" + path1.toAbsolutePath().getName(i));
        }

        System.out.println("path1.getRoot(): " + path1.getRoot());
        System.out.println("path1.toAbsolutePath().getRoot(): " + path1.toAbsolutePath().getRoot());
        System.out.format("path1.toUri(): %s%n", path1.toUri());

        Path path2 = Paths.get(path1.toUri());

        System.out.println("path1.equals(path2): " + path1.equals(path2));
        System.out.println("path2.equals(path1): " + path2.equals(path1));
        System.out.format("path2.toUri(): %s%n", path2.toUri());
        System.out.println("path1.compareTo(path2): " + path1.compareTo(path2));
        System.out.println("path2.compareTo(path1): " + path2.compareTo(path1));
        System.out.println("path1.toString().equals(path2.toString()): " + path1.toString().equals(path2.toString()));
        System.out.println("path1.toUri().toString().equals(path2.toUri().toString()): " + path1.toUri().toString().equals(path2.toUri().toString()));
        System.out.println("path1.toAbsolutePath().equals(path2.toAbsolutePath()): " + path1.toAbsolutePath().equals(path2.toAbsolutePath()));
        System.out.println("Files.isSameFile(path1, path2): " + Files.isSameFile(path1, path2));//Preferred
    }
}
