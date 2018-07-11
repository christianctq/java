package com.chengtianqi;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * JAVA8内置四大核心函数式接口
 * Consumer<T>:消费型接口
 *      void accept(T t);
 * Supplier<T>:供给型接口
 *      T get();
 * Function<T,R>:函数型接口
 *      R apply(T t);
 * Predicate<T>:断言型接口
 *      boolean test(T t);
 */
public class TestLambda {
    //Consumer<T> 消费型接口
    public void happy(double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }

    @Test
    public void Test1() {
        happy(1000,m -> System.out.println("吃饭"+m+"元"));
    }

    //Supplier<T> 供给型接口：
    public List<Integer> getNumList(int num, Supplier<Integer> supplier) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Integer n = supplier.get();
            list.add(n);
        }
        return list;
    }

    @Test
    public void Test2() {
        List<Integer> numList = getNumList(10, () -> (int)(Math.random() * 100));
        for (Integer num:numList) {
            System.out.println(num);
        }
    }

    //Function(T,R) 函数式接口:
    public String strHandler(String str, Function<String, String> function) {
        return function.apply(str);
    }

    @Test
    public void test3() {
        String newStr = strHandler(" 你 好 啊 ", s -> s.trim());
        System.out.println(newStr);
    }
}
