package demo;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class SubstringwithConcatenationofAllWordsSolutionTest {
    @Test public void test1(){
        SubstringwithConcatenationofAllWordsSolution target = new SubstringwithConcatenationofAllWordsSolution();
        String s = "barfoothefoobarman";
        String[] words = {"foo","bar"};
        List<Integer> expect = new ArrayList<>();
        expect.add(0);
        expect.add(9);
        assertEquals(target.findSubstring(s, words), expect);

    }

    @Test public void test2(){
        SubstringwithConcatenationofAllWordsSolution target = new SubstringwithConcatenationofAllWordsSolution();
        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word","good","best","good"};
        List<Integer> expect = new ArrayList<>();
        expect.add(8);
        assertEquals(target.findSubstring(s, words), expect);

    }

    @Test public void test3(){
        SubstringwithConcatenationofAllWordsSolution target = new SubstringwithConcatenationofAllWordsSolution();
        String s = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
        String[] words = {"fooo","barr","wing","ding","wing"};
        List<Integer> expect = new ArrayList<>();
        expect.add(13);
        assertEquals(target.findSubstring(s, words), expect);
    }
}
