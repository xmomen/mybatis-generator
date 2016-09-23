package com.xmomen;

/**
 * Created by tanxinzheng on 16/9/23.
 */
public class PathTest {

    public static void main(String[] args) {
//        String path1 = PathTest.class.getClassLoader().getResource("").getPath();
//        String path2 = PathTest.class.getClassLoader().getResource("/").getPath();
        String path3 = PathTest.class.getResource("").getPath();
        String path4 = PathTest.class.getResource("/src/main/java").getPath();
//        System.out.println(path1);
//        System.out.println(path2);
        System.out.println(path3);
//        System.out.println(path4);
    }

    public static final String getPath(){
        String path1 = PathTest.class.getClassLoader().getResource("").getPath();
        String path2 = PathTest.class.getClassLoader().getResource("/").getPath();
        String path3 = PathTest.class.getResource("").getPath();
        String path4 = PathTest.class.getResource("/").getPath();
        System.out.println(path1);
        System.out.println(path2);
        System.out.println(path3);
        System.out.println(path4);
        return path1;
    }
}
