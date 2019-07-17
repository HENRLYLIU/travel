package com.GTMStudio.datastructure.linetable;

public class TestArrayList {
    public static void main(String[] args) {
        List list=new ArrayList();
        list.add(123);
        list.add(321);
        list.add(456);
        list.add(678);
        list.add(899);
        list.add(456);
        list.add(678);
        list.add(899);
        list.add(null);
        list.add(3,666);
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        System.out.println(list.get(3));
        System.out.println(list.toString());
        System.out.println(list.contains(888));
        System.out.println(list.indexOf(888));

    }
}
