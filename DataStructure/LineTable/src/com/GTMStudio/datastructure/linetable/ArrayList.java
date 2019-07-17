package com.GTMStudio.datastructure.linetable;

import java.util.Arrays;

public class ArrayList implements List {

    //底层是一个数组，目前还没有确定长度
    private Object[] elementData;
    //不是数组分配了几个空间，而是元素的个数
    private int size;


    public ArrayList() {
        this(4);
    }

    /**
     * @param initialCapacity 指定数组的初始长度
     */
    public ArrayList(int initialCapacity) {
        //给数组分配指定的空间个数
        elementData = new Object[initialCapacity];
        //指定顺序表的元素个数，默认是0
        //size=0
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object get(int i) {
        if (i < 0 || i >= size) {
//            throw new RuntimeException("数组指针越界异常：" + i);
            throw new MyArrayIndexOutOfBoundsException("数组指针越界异常：" + i);
        } else {
            return elementData[i];
        }
    }

    @Override
    public boolean isEmpty() {

        return size == 0;
    }

    @Override
    public boolean contains(Object e) {
/*        boolean exist=false;
        for (int i = 0; i < size; i++) {
            if(elementData[i].equals(e)) {
                exist=true;
                break;
            }
        }
        return exist;*/
    return indexOf(e)>=0;
    }

    @Override
    public int indexOf(Object e) {
        if(e==null){
            for (int i = 0; i <size; i++) {
                if(elementData[i]==null){
                    return i;
                }
            }
        }else{
            for (int i = 0; i <size; i++) {
                if(elementData.equals(e)){
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public void add(int i, Object e) {
        if (i < 0 || i > size) {
            throw new MyArrayIndexOutOfBoundsException("数组索引越界异常" + i);
        }
        //如果数组满了就扩容
        if (size == elementData.length) {
            grow();
        }
        //将指定位置后面的数据后移一位
        for (int j = size; j > i; j--) {
            elementData[j] = elementData[j - 1];
        }
        //给数组赋值
        elementData[i] = e;
        //元素个数+1
        size++;
    }

    @Override
    public void add(Object e) {
        /*//如果数组满了就扩容
        if (size == elementData.length) {
            grow();
        }
        //给数组赋值
        elementData[size] = e;
        //元素个数+1
        size++;*/
        add(size, e);
    }

    private void grow() {
            /* //新创建一个数组，长度是旧数组2倍数
            Object [] newArr=new Object[elementData.length*2];
            //将就数组的数据拷贝到新数组中
            for (int i = 0; i <size ; i++) {
                newArr[i]=elementData[i];
            }
            //让elementData指向新数组
            elementData=newArr;//指针*/

        elementData = Arrays.copyOf(elementData, elementData.length * 2);

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
        return null;
    }

    @Override
    public boolean remove(Object e) {
        return false;
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
        StringBuilder builder = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            if (i != size - 1)
                builder.append(elementData[i] + ",");
            else
                builder.append(elementData[i]);
        }
        builder.append("]");
        return builder.toString();
    }

}
