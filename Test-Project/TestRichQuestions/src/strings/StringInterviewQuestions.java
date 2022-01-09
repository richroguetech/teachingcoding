package strings;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class StringInterviewQuestions {

	
	/*
	 * 		// implement an algorithm to determine if a string has all unique characters..
		//String inputString = "hello";
		String inputString = "e";
		
		
		boolean result = sample1.checkString(inputString);
		System.out.println("result of exercise is :"+ result);

	 */
	
	public void removeDuplicates(char[] str)
	{
		if (str == null) return;
		
		int len = str.length;
		if (len < 2) return;
		
		int tail = 1;
		
		
		for (int i = 1; i < len; ++i) {

            int j;
            for (j = 0; j < tail; ++j) {
            	if (str[i] == str[j]) break;
            }
            
            if (j == tail) {
            	str[tail]  = str[i];
            	++tail;
            }
        }
		
		str[tail] = 0;
		
		System.out.println("len is " + str.length);
		
		for (int k = tail; k < len; k++) {
			str[k] = 0;
		}
		
		
		System.out.println(str);
		
		return;
	}
	
	
	
	public boolean checkUnique(String str) {
		
		char[] uniqueChar = new char[256];
		
		for (int i = 0; i < str.length(); i++) {
			
			char x = str.charAt(i); 
			
			if (uniqueChar[x] == '1') {
				return false;
			}
			else {
				uniqueChar[x] = '1';
			}
			
		}
		
		
		return true;
	}
	
	
	public boolean checkString(String str)
	{
       int checker = 0;
       
       for (int i = 0; i < str.length(); ++i)
       {
    	   int value = str.charAt(i) - 'a';
    	   int value2 = (checker & (1 << value));
    	   
    	   if (value2 > 0) return false;
    	   checker |= (1 << value);
       }
    	   
		return true;
	}

	public boolean reverseString(String str)
	{
       int length = str.length();
       
       char [] reverseString = new char[length];
       
       
       for (int i = length-1; i >= 0; i--)
       {
    	   char x = str.charAt(i);
    	   System.out.println("i is "+i);
    	   System.out.println("char is "+x);
    	   reverseString[i] = (char)x;
       }
       
       String newString = new String(reverseString);
       
       System.out.println("reverseString is "+ newString);
    	   
		return true;
	}
	
	
	
	
}
