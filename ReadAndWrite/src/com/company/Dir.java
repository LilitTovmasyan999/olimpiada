package com.company;

import java.io.File;

public class Dir {
    public static void main(String[] args) {
        File input = new File("src");
        readPath(input);
    }

    static void readPath(File file) {
        File[] files = file.listFiles();
        if (files != null) {
            for (File i : files) {
                if (i.isDirectory()) {
                    readPath(i);
                } else {
                    long count = i.getPath().chars().filter(ch -> ch == '\\').count();
                    for (int j = 0; j < count - 1; j++) {
                        System.out.print("-");
                    }
                    System.out.println(i.getName());
                }
            }
        }

    }
}
