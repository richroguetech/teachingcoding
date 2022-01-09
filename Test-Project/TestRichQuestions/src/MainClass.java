import java.util.ArrayList;
import java.util.List;
import sorting.*;
import strings.*;

public class MainClass {

    public MainClass() {}

    public static void linearSearch() {
        int[] testArray = { 1, 3, 5, 9};

        int result = LinearSearch.search(testArray, 4, 3);
        System.out.println("result is "+ result);
    }

    public static void stringquestions() {
        StringQuestions sq = new StringQuestions();
        System.out.println(sq.LC_9_isPalindrome(939));
    }

    public static void main(String arg[])
    {
        linearSearch();
        stringquestions();
    }
}
