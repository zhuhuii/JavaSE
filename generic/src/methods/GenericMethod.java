package methods;

/**
 * Description: 泛型方法
 */
public class GenericMethod {

    static class Animal {
        @Override
        public String toString() {
            return "Animal";
        }
    }

    static class Dog extends Animal {
        @Override
        public String toString() {
            return "Dog";
        }
    }

    static class Fruit {
        @Override
        public String toString() {
            return "Fruit";
        }
    }

    static class GenericClass<T> {

        public void show01(T t) {
            System.out.println(t.toString());
        }

        public <T> void show02(T t) {
            System.out.println(t.toString());
        }

        public <K> void show03(K k) {
            System.out.println(k.toString());
        }

        /**
         * 首先在public与返回值之间的<T>必不可少，这表明这是一个泛型方法，并且声明了一个泛型T
         * 这个T可以出现在这个泛型方法的任意位置.
         * 泛型的数量也可以为任意多个
         * 如：public <T,K> K showKeyName(Generic<T> container){...}
         */
        public <T extends Comparable<T>> T add(T a, T b) {
            //（与泛型类的定义一样，此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型。）
            System.out.println(a + "+" + b + "=" + a + b);
            return a;
        }
    }

    public static void main(String[] args) {
        Animal animal = new Animal();
        Dog dog = new Dog();
        Fruit fruit = new Fruit();
        GenericClass<Animal> genericClass = new GenericClass<>();

        //泛型类在初始化时限制了参数类型
        //genericClass.show01(fruit);
        genericClass.show01(dog);

        //泛型方法的参数类型在使用时指定
        genericClass.show02(dog);
        genericClass.show02(fruit);
        genericClass.add(12,40);
    }
}