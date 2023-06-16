package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return list -> {
            for(String s : list){
                if(!Character.isUpperCase(s.charAt(0))){
                    return false;
                }
            }
            return true;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return list -> {
            List<Integer> list_2 = new ArrayList<>();
            for(Integer i : list){
                if(i%2 == 0){
                    list_2.add(i);
                }
            }
            list.addAll(list_2);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            List<String> list = new ArrayList<>();
            for(String s : values){
                String[] str = s.split(" ");
                if(str.length > 3 && Character.isUpperCase(s.charAt(0)) && s.charAt(s.length()-1) == '.'){
                    list.add(s);
                }
            }
            return list;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return list -> {
            Map<String, Integer> map = new HashMap<>();
            for(String s : list){
                map.put(s, s.length());
            }
            return map;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list_1, list_2) -> {
            List<Integer> list_3 = new ArrayList<>();
            list_3.addAll(list_1);
            list_3.addAll(list_2);
            return list_3;
        };
    }
}
