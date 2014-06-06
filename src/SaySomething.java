/**
 * Created by Guilherme on 20/05/2014.
 */
public interface SaySomething extends Say{
    double someMethod(int i, int t);
    default String someotherMethod(String takesSomeArgs) {
        return takesSomeArgs;
    }
}
