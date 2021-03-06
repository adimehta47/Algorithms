package logic;

//Given three ints, a b c, return true if one of b or c is "close" (differing from a by at most 1),
//while the other is "far", differing from both other values by 2 or more.
//Note: Math.abs(num) computes the absolute value of a number.

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class closeFar {

    public boolean closeFar(int a, int b, int c) {
        int difAB = Math.abs(a - b);
        int difAC = Math.abs(a - c);
        int difBC = Math.abs(b - c);

        return (difAB < 2 && difAC >= 2 && difBC >= 2 || difAC < 2 && difAB >= 2 && difBC >= 2);
    }

    @Test
    public void test() {
        int a = 1, b = 2, c = 4;
        boolean expected = true;
        assertTrue(closeFar(a, b, c) == expected,
                "Expected: " + String.valueOf(expected) + ", Actual: " + String.valueOf(closeFar(a, b, c)));
        System.out.println(String.valueOf(closeFar(a, b, c)));
    }
}