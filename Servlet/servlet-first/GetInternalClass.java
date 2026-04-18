package InternalClass;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class GetInternalClass {

    public static void main(String[] args) {

        // Create Spring Container
        AnnotationConfigApplicationContext app =
                new AnnotationConfigApplicationContext(MyConfig.class);

        // Get Scanner bean
//        Scanner sc = app.getBean(Scanner.class);
//        System.out.println("Scanner Object: " + sc);
        
        //when there are multiple object of same type,java gets confuse which to send as o/p--to overcome this exception specify objects name
        Scanner s1 = app.getBean("getsca",Scanner.class);
        System.out.println("Scanner Object: " + s1);

        // Get Integer bean
        Integer i = app.getBean(Integer.class);
        System.out.println("Integer Bean: " + i);

        // Get ArrayList bean
        ArrayList<String> list = app.getBean(ArrayList.class);
        System.out.println("ArrayList Bean: " + list);

        // Get HashSet bean
        //HashSet<Integer> set1 = app.getBean(HashSet.class);
        HashSet<Integer> set1 = (HashSet<Integer>) app.getBean("getSet");
        System.out.println("HashSet Bean: " + set1);
        
        // Get RuntimeException bean
        RuntimeException ex = app.getBean(RuntimeException.class);
        System.out.println("Exception Bean: " + ex.getMessage());

        
        
        // Get Set bean (using bean name to avoid confusion)
        Set<String> set2 = (Set<String>) app.getBean("getSetData");
        System.out.println("Set Bean: " + set2);

        // Get Map bean
        //Map<Integer, String> map = app.getBean(Map.class);
        Map<Integer, String> map = (Map<Integer, String>) app.getBean("getMap");
        System.out.println("Map Bean: " + map);

        // Close container
        app.close();
    }
}