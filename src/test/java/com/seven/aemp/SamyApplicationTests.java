package com.seven.aemp;


import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;


//@SpringBootTest
class SevenApplicationTests {

    public static void main(String[] args) {
        Path path = Paths.get("/dist","/dir");
        System.out.println(path.toAbsolutePath());
        File file = new File("/dist","/dir");
        System.out.println(file.getAbsolutePath());
    }

}
