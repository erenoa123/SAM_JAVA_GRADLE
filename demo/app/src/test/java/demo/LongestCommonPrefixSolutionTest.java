package demo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LongestCommonPrefixSolutionTest {
    @Test public void test1(){
        LongestCommonPrefixSolution target = new LongestCommonPrefixSolution();
        String[] strs = {"flower","flow","flight"};
        System.out.println(target.longestCommonPrefix(strs));
        assertTrue("fl".equals(target.longestCommonPrefix(strs)));
    }

    @Test public void test2(){
        LongestCommonPrefixSolution target = new LongestCommonPrefixSolution();
        String[] strs = {"dog","racecar","car"};
        System.out.println(target.longestCommonPrefix(strs));
        assertTrue("".equals(target.longestCommonPrefix(strs)));
    }
}
