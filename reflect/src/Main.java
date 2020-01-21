import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author: zhuhui
 * @Description:
 */
public class Main {

    @Test
    public void newInstance() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        /**
         * 通过反射来生成对象主要有两种方式。
         */
        Class<Dog> dogClass = Dog.class;
        Dog dog = dogClass.newInstance();

        /**
         * 用Class对象获取无参构造Constructor对象
         */
        Constructor<Dog> constructor = dogClass.getConstructor();
        Dog dog1 = constructor.newInstance();

        /**
         * 用Class对象获取指定的Constructor对象
         */
        Constructor<Dog> constructor1 = dogClass.getConstructor(Character.class, String[].class, String.class);
        Dog dog2 = constructor1.newInstance('汪', new String[]{"骨头", "狗粮"}, "晚上睡觉");

        System.out.println("dog：" + dog);
        System.out.println("dog1：" + dog1);
        System.out.println("dog2：" + dog2);
        System.out.println("dog == dog1：" + (dog == dog1));
        System.out.println("dog .eq dog1：" + (dog.equals(dog1)));
    }

    @Test
    public void getClassObj() throws ClassNotFoundException {
        /**
         * 获取到class对象的三种方法：
         */
        Class<Dog> objectClass = Dog.class;
        Class<? extends Dog> dogClass = new Dog().getClass();
        Class<?> driverClass = Class.forName("com.jdbc.mysql.Driver");
    }

    @Test
    public void getConstructor() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        /**
         * 获取到对象构造方法：
         */
        Class<Dog> dogClass = Dog.class;
        Constructor<Dog> constructor = dogClass.getConstructor();
        Constructor<Dog> constructor1 = dogClass.getConstructor(String.class, String[].class);

        /**
         * 用构造方法创建对象
         */
        Dog dog1 = constructor.newInstance();
        Dog dog2 = constructor1.newInstance("哈士奇", new String[]{"拆家"});
        System.out.println("dog1：" + dog1);
        System.out.println("dog2：" + dog2);
    }

    @Test
    public void getMethods() throws NoSuchMethodException {
        Class<Dog> dogClass = Dog.class;

        // getDeclaredMethods 方法返回类或接口声明的所有方法，包括公共、保护、默认（包）访问和私有方法，但不包括继承的方法。
        Method[] declaredMethods = dogClass.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println(method);
        }

        System.out.println("------------------------------------------------------------------");

        // getMethods 方法返回某个类的所有公用（public）方法，包括其继承类的公用方法。
        Method[] methods = dogClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
    }

    @Test
    public void getFields() {
        /**
         * getFiled：访问公有的成员变量，（包含：本类+父类）。
         * getDeclaredField：所有已声明的成员变量，但不能得到其父类的成员变量
         */
        Class<Dog> dogClass = Dog.class;
        Field[] fields = dogClass.getFields();
        Field[] declaredFields = dogClass.getDeclaredFields();
    }

    @Test
    public void executeMethod() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        /**
        * 执行方法
        **/
        Class<Dog> dogClass = Dog.class;
        Method toString = dogClass.getMethod("toString");
        Object result = toString.invoke(dogClass.newInstance());
        System.out.println(result);

        Method gnaw = dogClass.getDeclaredMethod("gnaw");
        gnaw.setAccessible(true);

        //Class Main can not access a member of class Dog with modifiers "private"
        gnaw.invoke(dogClass.newInstance());
    }
}
