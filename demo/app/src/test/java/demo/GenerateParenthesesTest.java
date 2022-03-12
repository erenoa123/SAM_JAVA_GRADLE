package demo;

import org.junit.Test;

public class GenerateParenthesesTest {
    @Test public void test1(){
        GenerateParentheses target = new GenerateParentheses();

        System.out.println(target.generateParenthesis(3));
        System.out.println("終了");

    }
}
