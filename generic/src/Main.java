import java.util.ArrayList;
import java.util.List;

/**
 * @author zhuhui
 */
public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {

        List<String> strings = new ArrayList<>();
        strings.add("aaa");
        strings.add("123");

        List arrayList = new ArrayList();
        arrayList.add("aaa");
        arrayList.add(123);

//        for(int i = 0; i< arrayList.size();i++){
//            String str = strings.get(i);
//            System.out.println("泛型测试：item = " + str);
//
//            String item = (String)arrayList.get(i);
//            System.out.println("泛型测试：item = " + item);
//            java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
//        }

        Generic<String> stringGeneric = new Generic<>("zhangsan");
        System.out.println(stringGeneric.getKey());

        Generic<Integer> integerGeneric = new Generic<>(999);
        System.out.println(integerGeneric.getKey());

        Generic<Number> numberGeneric = new Generic<>();
        numberGeneric.setKey(10086);
        System.out.println(numberGeneric.getKey());

        // 子类实参无法传入父类形参中
        // numberGeneric.showKeyValue(integerGeneric);
        numberGeneric.showKeyValue(numberGeneric);

        // 通配符?表示任何类型
        numberGeneric.showKeyValue222(stringGeneric);
        numberGeneric.showKeyValue222(integerGeneric);
        numberGeneric.showKeyValue222(numberGeneric);
    }
}
