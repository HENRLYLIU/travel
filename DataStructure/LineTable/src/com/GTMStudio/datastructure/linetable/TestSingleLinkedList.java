package com.GTMStudio.datastructure.linetable;

public class TestSingleLinkedList {
    public static void main(String[] args) {
        List list = new SingleLinkedList();

        list.add(222);
        list.add(123);
        list.add(321);
        list.add(456);
        list.add(678);
        list.add(789);
        list.add(111);
        list.add(222);


//        list.add(10, 666);
        System.out.println(list.toString());

        list.remove("222");
        SingleLinkedList s=(SingleLinkedList)list;
        System.out.println((s.getPreviousNode(1).getData()));
//        System.out.println(list.size());
//        System.out.println(list.isEmpty());
//        System.out.println(list.get(5));
        System.out.println(list.toString());
    }
}
