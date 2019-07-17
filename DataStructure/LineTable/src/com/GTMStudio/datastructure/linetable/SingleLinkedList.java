package com.GTMStudio.datastructure.linetable;

import java.util.LinkedList;

public class SingleLinkedList implements List {
    //头结点，不存储数据，为了编程方便
    private Node head = new Node();
    //结点的个数
    private int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object get(int i) {
        if (i < 0 || i > size) {
            throw new MyArrayIndexOutOfBoundsException("数组指针异常：" + i);
        }
        Node p = head;
        for (int j = 0; j < i; j++) {
            p = p.getNext();
        }
        return p.getData();
    }

    @Override
    public boolean isEmpty() {
        Node p = head;
        if (p.getNext() == null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean contains(Object e) {
        return false;
    }

    @Override
    public int indexOf(Object e) {
        return 0;
    }

    @Override
    public void add(int i, Object e) {
        //如果i位置错误报异常
        if (i < 0 || i > size) {
            throw new MyArrayIndexOutOfBoundsException("数组指针异常" + i);
        }
        //找到前一个结点，从head结点开始
        Node p = head;
        for (int j = 0; j < i; j++) {
            p = p.getNext();
        }
        //新建一个结点作为要插入的结点
        Node newNode = new Node();
        //装入数据
        newNode.setData(e);
        //指明新结点的直接后继节点
        newNode.setNext(p.getNext());
        //指明新结点的直接前驱结点
        p.setNext(newNode);
        //size++
        size++;
    }

    @Override
    public void add(Object e) {
        this.add(size, e);

    }

    @Override
    public boolean addBefore(Object obj, Object e) {
        return false;
    }

    @Override
    public boolean addAfter(Object obj, Object e) {
        return false;
    }

    @Override
    public Object remove(int i) {
        if (i < 0 || i > size) {
            throw new MyArrayIndexOutOfBoundsException("数组指针异常" + i);
        }
        Node p = head;
        for (int j = 0; j < i; j++) {
            p = p.getNext();
        }
        Object data = p.getData();
        p.setNext(p.getNext().getNext());
        size--;
        return data;
    }

    @Override
    public boolean remove(Object e) {
        Node p = head;
        for (int i = 0; i < size; i++) {
            p = p.getNext();
            if (p.getData().equals(e)) {
                Node q = getPreviousNode(i);
                q.setNext(p.getNext());
                size--;
            }
        }
        return true;
    }

    @Override
    public Object replace(int i, Object e) {

        return null;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        Node p = head.getNext();
        StringBuilder builder = new StringBuilder("[");
        for (int j = 0; j < size; j++) {
            if (j != size - 1) {
                builder.append(p.getData() + ",");
            } else {
                builder.append(p.getData());
            }
            p = p.getNext();
        }
        builder.append("]");
        return builder.toString();
    }

    public Node getPreviousNode(int i) {
        Node p = head;
        if(i<=0||i>size){
            throw new MyArrayIndexOutOfBoundsException("指针异常"+i);
        }
        for (int j = 0; j < i; j++) {
            p = p.getNext();
        }
        return p;
    }
}
