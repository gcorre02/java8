import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

/**
 * Created by Guilherme on 20/05/2014.
 */
public class SomeClass {
    public static void main(String[] args) {
        String[] testStrings = {"One","Two","Three","Four"};
        Arrays.sort(testStrings,
                (s1, s2) -> {
                    return (s1.length() - s2.length());
                }
        );
        for(String s : testStrings){
            System.out.println(s);
        }

        Arrays.sort(testStrings, Comparator.<String>reverseOrder());
        for(String s : testStrings){
            System.out.println(s);
        }

        Arrays.sort(testStrings,
                (s1, s2) -> s1.charAt(s1.length()-1)-
                            s2.charAt(s2.length()-1));
        for(String s : testStrings){
            System.out.println(s);
        }

        SaySomething g = (i,t) ->  i*t;
        System.out.println(g.someMethod(5,5));
        System.out.println(g.someotherMethod("hey"));

        Arrays.sort(testStrings,
                SomeClass::eChecker);

        for(String s : testStrings){
            System.out.println(s);
        }

        System.out.println(betterString(
                "Man",
                "Woman",
                (s1, s2) -> true
                )
        );

        System.out.println(betterString(
                        "Man",
                        "Woman",
                        (s1, s2) -> s1.length()>s2.length()
                )
        );

        List<String> myWords = new ArrayList<>();
        myWords.add("Awesome");
        myWords.add("Playing");
        myWords.add("With");
        myWords.add("Lambdas");
        myWords.add("Innit");
        System.out.println(transformedList(myWords, s -> s+"!!"));
        System.out.println(transformedList(myWords, String::toUpperCase));
        System.out.println(transformedList(myWords, s -> s.replace("i","eye")));

    }

    public static int eChecker(String s1, String s2) {
        return s1.contains("e")? -1 : 1;
    }

    public static String betterString(String s1, String s2, TwoStringPredicate fife){
        return fife.checkBest(s1,s2) ? s1 : s2 ;
    }

    public static List<String> transformedList(List<String> words, Function<String,String> s){
        List<String> returnableList = new ArrayList<>();
        for(String str : words){
            returnableList.add(s.apply(str));
        }
        return returnableList;
    }
}
