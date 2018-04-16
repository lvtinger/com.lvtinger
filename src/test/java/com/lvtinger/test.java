package com.lvtinger;

public class test {
    public static void main(String... args) {

        String str = "a";
        System.out.println(str.substring(0, 1).toUpperCase() + str.substring(1));

        //int 00000000 00000000 00000000 00000000

        int i = 256;
        byte[] bytes = new byte[4];
        bytes[0] = (byte) (i >>> 24);
        bytes[1] = (byte) (i >>> 16);
        bytes[2] = (byte) (i >>> 8);
        bytes[3] = (byte) (i);

        for (byte b : bytes) {
            System.out.println(Integer.toBinaryString(b));
        }
        System.out.println(Integer.toBinaryString(i));
        //System.out.println(Opcodes.NOP);
    }
}
