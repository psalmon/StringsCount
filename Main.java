//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        StringsCount stringsCount = new StringsCount();

        stringsCount.inc("Hello"); // Hello has count of 1

        stringsCount.inc("Hello"); // Hello has count of 2

        stringsCount.inc("World"); // World has count of 1

        System.out.println(stringsCount.getMaxKey()); // return "Hello"

        System.out.println(stringsCount.getMinKey()); // return "World"

        stringsCount.dec("Hello"); // "Hello" has count of 3

        stringsCount.dec("Hello"); // "Hello" has count of 2

        System.out.println(stringsCount.getMaxKey());
    }
}