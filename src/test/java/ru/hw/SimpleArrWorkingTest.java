package ru.hw;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SimpleArrWorkingTest {

    static SimpleArrWorking simpleArrWorking;

    @BeforeAll
    static void getOne(){
        simpleArrWorking = new SimpleArrWorking();
    }

    @Test
    void afterFourExTest(){
        Assertions.assertThrows(ArithmeticException.class,()->simpleArrWorking.afterFour(new int[]{5,14,30,10,15,8,11,6}));
    }


    static Stream<Arguments> testSet(){
        return Stream.of(
                Arguments.arguments(new int[]{6,6,7},new int[]{1,2,5,4,6,6,7}),
                Arguments.arguments(new int[]{},new int[]{4,3,5,4}),
                Arguments.arguments(new int[]{5,6,3,2,2,1},new int[]{4,5,6,3,2,2,1}),
                Arguments.arguments(new int[]{5,2,2,1},new int[]{4,5,63,3,4,14,4,4,5,2,2,1})

        );
    }

    @ParameterizedTest
    @MethodSource("testSet")
    void massAfterFourTest(int[] exp,int[] started){
        Assertions.assertArrayEquals(exp,simpleArrWorking.afterFour(started));
    }


    static Stream<Arguments> testSet2(){
        return Stream.of(
                Arguments.arguments(false,new int[]{1,2,5,4,6,6,7}),
                Arguments.arguments(true,new int[]{4,1,1,4}),
                Arguments.arguments(false,new int[]{4,4,4,4,4,4}),
                Arguments.arguments(false,new int[]{1})

        );
    }
    @ParameterizedTest
    @MethodSource("testSet2")
    void hasOnlyOneOrFourTest(boolean expect,int[] started) {
        Assertions.assertEquals(expect,simpleArrWorking.hasOnlyOneOrFour(started));
    }
}