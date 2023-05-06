package com.joedoe.cwjava;

public class BlockLetterPrinter {

    private static final int CHARACTER_WIDTH = 6;
    private static final int CHARACTER_HEIGHT = 7;
    private static final String SPACE_TEMPLATE = "      ";
    private static final int ASCII_A = 65;
    private static final int ASCII_Z = 90;
    private static final int ASCII_SPACE = 32;

    private static String[] ASCII_TEMPLATE = new String[] {
            " AAA  BBBB   CCC  DDDD  EEEEE FFFFF  GGG  H   H IIIII JJJJJ K   K L     M   M N   N  OOO  PPPP   QQQ  RRRR   SSS  TTTTT U   U V   V W   W X   X Y   Y ZZZZZ ",
            "A   A B   B C   C D   D E     F     G   G H   H   I       J K  K  L     MM MM NN  N O   O P   P Q   Q R   R S   S   T   U   U V   V W   W X   X Y   Y     Z ",
            "A   A B   B C     D   D E     F     G     H   H   I       J K K   L     M M M N   N O   O P   P Q   Q R   R S       T   U   U V   V W   W  X X   Y Y     Z  ",
            "AAAAA BBBB  C     D   D EEEEE FFFFF G GGG HHHHH   I       J KK    L     M   M N N N O   O PPPP  Q   Q RRRR   SSS    T   U   U V   V W W W   X     Y     Z   ",
            "A   A B   B C     D   D E     F     G   G H   H   I       J K K   L     M   M N   N O   O P     Q Q Q R R       S   T   U   U V   V W W W  X X    Y    Z    ",
            "A   A B   B C   C D   D E     F     G   G H   H   I       J K  K  L     M   M N  NN O   O P     Q  QQ R  R  S   S   T   U   U  V V  W W W X   X   Y   Z     ",
            "A   A BBBB   CCC  DDDD  EEEEE F      GGG  H   H IIIII JJJJ  K   K LLLLL M   M N   N  OOO  P      QQQQ R   R  SSS    T    UUU    V    W W  X   X   Y   ZZZZZ " };

    /**
     * Block Letter Printer
     * 6 kyu
     * https://www.codewars.com/kata/6375587af84854823ccd0e90/train/java
     */
    public static String blockPrint(String string) {
        String result = "";
        String normalized = string.trim().toUpperCase();
        if (normalized.length() == 0)
            return "";
        for (int i = 0; i < CHARACTER_HEIGHT; i++) {
            String nextLine = "";
            for (int j = 0; j < normalized.length(); j++) {
                byte b = (byte) normalized.charAt(j);
                if (b == ASCII_SPACE || (b >= ASCII_A && b <= ASCII_Z)) {
                    int pos = (b - ASCII_A) * CHARACTER_WIDTH;
                    if (b == ASCII_SPACE) {
                        nextLine += SPACE_TEMPLATE;
                    }                        
                    else     
                        nextLine += ASCII_TEMPLATE[i].substring(pos,pos+6);
                }
            }
            result += nextLine.replaceAll("\\s+$", "");
            if (i < CHARACTER_HEIGHT-1) 
                result += "\n";
        }
        return result;
    }

}
