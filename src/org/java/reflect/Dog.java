package org.java.reflect;

import java.util.Arrays;

/**
 * @Author: zhuhui
 * @Description:
 * @Date: Create in 20:07 2020/1/16
 */
public class Dog extends Animal {
    /**
    * 品种
    **/
    private String breed;
    /**
    * 爱好
    **/
    private String[] hobbys;

    //啃骨头
    private void gnaw() {
        System.out.println("Animal gnaw（啃骨头）..");
    }
    //喝汤
    protected void eat() {
        System.out.println("Animal eat（喝汤）...");
    }
    //咬人
    public void bite() {
        System.out.println("Animal bite（咬人）...");
    }

    public Dog(String breed, String[] hobbys) {
        this.breed = breed;
        this.hobbys = hobbys;
    }

    public Dog() {
    }

    @Override
    public String toString() {
        return "Dog{" +
                "breed='" + breed + '\'' +
                ", hobbys=" + Arrays.toString(hobbys) +
                '}';
    }
}
