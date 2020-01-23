package a_线性表.array;

import java.util.Arrays;

/**
 * 优点：
 * 无须为表示表中元素之间的逻辑关系而增加额外的存储空间
 * 可以快速地存取表中任一位置的元素
 *
 * 缺点：
 * 插入和删除操作需要移动大量元素
 * 当线性表长度变化较大时，难以确定存储空间的容量。造成存储空间的碎片
 */
class TestSqlist {
    int usedSize;//当前有效的数据元素的个数。
    int[] elem;//用一组地址连续的存储空间来存储顺序表的数据元素。

    public TestSqlist() {
        this(10);
    }

    public TestSqlist(int size) {
        elem = new int[size];
        usedSize = 0;
    }

    // 判断数组已满
    public boolean isFull() {
        return this.usedSize == elem.length;
    }

    // 判断顺序表是否为空
    public boolean isEmpty() {
        return this.usedSize == 0;
    }

    /**
     * 插入一个数据
     *
     * @param pos
     * @param val
     * @return
     */
    public boolean insert(int pos, int val) {
        //判断pos合法性
        if (pos < 0 || pos > this.usedSize) {
            return false;
        }
        //判断链表是否为满
        if (isFull()) {
            elem = Arrays.copyOf(elem, elem.length * 2);
            System.out.println(elem.length);
        }
        for (int i = this.usedSize - 1; i >= pos; i--) {
            elem[i + 1] = elem[i];
        }
        elem[pos] = val;
        this.usedSize++;
        return true;
    }

    /**
     * 删除一个数据
     *
     * @param val
     * @return
     */
    public boolean delete(int val) {
        int i = search(val);
        //val不存在。
        if (i == -1) {
            return false;
        }
        for (int j = i; j < this.usedSize - 1; j++) {
            elem[j] = elem[j + 1];
        }
        this.usedSize--;
        return true;
    }

    /**
     * 查找一个元素
     *
     * @param key
     * @return
     */
    public int search(int key) {
        //存在顺序表为空
        if (isEmpty()) {
            return -1;
        }
        for (int i = 0; i < this.usedSize; i++) {
            if (key == elem[i]) {
                return i;
            }
        }
        return -1;
    }
}