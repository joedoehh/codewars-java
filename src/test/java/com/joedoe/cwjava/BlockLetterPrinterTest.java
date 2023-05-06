package com.joedoe.cwjava;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Basic tests")
public class BlockLetterPrinterTest {

  @Test
  @DisplayName("Basic tests")
    void basicTests() {
      assertEquals("H   H EEEEE L     L      OOO        W   W  OOO  RRRR  L     DDDD\nH   H E     L     L     O   O       W   W O   O R   R L     D   D\nH   H E     L     L     O   O       W   W O   O R   R L     D   D\nHHHHH EEEEE L     L     O   O       W W W O   O RRRR  L     D   D\nH   H E     L     L     O   O       W W W O   O R R   L     D   D\nH   H E     L     L     O   O       W W W O   O R  R  L     D   D\nH   H EEEEE LLLLL LLLLL  OOO         W W   OOO  R   R LLLLL DDDD",BlockLetterPrinter.blockPrint("heLLo WorLD"),m);
      assertEquals(" AAA  BBBB   CCC  DDDD  EEEEE FFFFF  GGG  H   H IIIII JJJJJ K   K L     M   M\nA   A B   B C   C D   D E     F     G   G H   H   I       J K  K  L     MM MM\nA   A B   B C     D   D E     F     G     H   H   I       J K K   L     M M M\nAAAAA BBBB  C     D   D EEEEE FFFFF G GGG HHHHH   I       J KK    L     M   M\nA   A B   B C     D   D E     F     G   G H   H   I       J K K   L     M   M\nA   A B   B C   C D   D E     F     G   G H   H   I       J K  K  L     M   M\nA   A BBBB   CCC  DDDD  EEEEE F      GGG  H   H IIIII JJJJ  K   K LLLLL M   M",BlockLetterPrinter.blockPrint("ABCDEFGHIJKLM"),m);
      assertEquals("N   N  OOO  PPPP   QQQ  RRRR   SSS  TTTTT U   U V   V W   W X   X Y   Y ZZZZZ\nNN  N O   O P   P Q   Q R   R S   S   T   U   U V   V W   W X   X Y   Y     Z\nN   N O   O P   P Q   Q R   R S       T   U   U V   V W   W  X X   Y Y     Z\nN N N O   O PPPP  Q   Q RRRR   SSS    T   U   U V   V W W W   X     Y     Z\nN   N O   O P     Q Q Q R R       S   T   U   U V   V W W W  X X    Y    Z\nN  NN O   O P     Q  QQ R  R  S   S   T   U   U  V V  W W W X   X   Y   Z\nN   N  OOO  P      QQQQ R   R  SSS    T    UUU    V    W W  X   X   Y   ZZZZZ",BlockLetterPrinter.blockPrint("NOPQRSTUVWXYZ"),m);
      assertEquals(" SSS   AAA  M   M EEEEE\nS   S A   A MM MM E\nS     A   A M M M E\n SSS  AAAAA M   M EEEEE\n    S A   A M   M E\nS   S A   A M   M E\n SSS  A   A M   M EEEEE",BlockLetterPrinter.blockPrint("   same"),m);
      assertEquals(" SSS   AAA  M   M EEEEE\nS   S A   A MM MM E\nS     A   A M M M E\n SSS  AAAAA M   M EEEEE\n    S A   A M   M E\nS   S A   A M   M E\n SSS  A   A M   M EEEEE",BlockLetterPrinter.blockPrint("same   "),m);
      assertEquals("BBBB  U   U TTTTT                   DDDD  IIIII FFFFF FFFFF EEEEE RRRR  EEEEE N   N TTTTT\nB   B U   U   T                     D   D   I   F     F     E     R   R E     NN  N   T\nB   B U   U   T                     D   D   I   F     F     E     R   R E     N   N   T\nBBBB  U   U   T                     D   D   I   FFFFF FFFFF EEEEE RRRR  EEEEE N N N   T\nB   B U   U   T                     D   D   I   F     F     E     R R   E     N   N   T\nB   B U   U   T                     D   D   I   F     F     E     R  R  E     N  NN   T\nBBBB   UUU    T                     DDDD  IIIII F     F     EEEEE R   R EEEEE N   N   T",BlockLetterPrinter.blockPrint("   but   different   "),m);
      assertEquals("",BlockLetterPrinter.blockPrint(" "),m);
    }
  String m = "Most probably something is wrong with trailing whitespace and/or end-of-line characters!\n";

}