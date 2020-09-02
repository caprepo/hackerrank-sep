package org.cap.demo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConvertBinary {
	
	public static boolean checkConsecutiveVowelOccurence(String str, int occurences) {
		boolean flag=true;
		
		int count=0;
		for(int i=0;i<str.length();i++) {
			
			if(str.charAt(i) == 'V')
			{
				count++;
			}else {
				if(count>occurences) {
					flag=false;
					break;
				}
				count=0;
			}
		}
		
		if(count>occurences)
			flag=false;
		
		return flag;
	}
	
	
	public static Set<StringBuffer> printBinary(int num) {
		Set<StringBuffer> binary=new HashSet<>();
		String str=null;
		StringBuffer binarynum=null;
		
		if(num==1) {
			binary.add(new StringBuffer("0"));
			binary.add(new StringBuffer("1"));
		}
		else {
				for(int i=0;i<(Math.pow(num, 2));i++) {
			
			str=Integer.toBinaryString(i);
			binarynum=new StringBuffer(str);
			
			if(str.length()!=num) {
				int len=num-str.length();
				for(int j=0;j<len;j++)
					binarynum.insert(0, "0");
				}
			
			//System.out.println(binarynum);
			for(int j=0;j<num;j++) {
				if(binarynum.charAt(j) =='0')
					binarynum.replace(j, j+1, "C");
				else
					binarynum.replace(j, j+1, "V");
			}
			
			if(checkConsecutiveVowelOccurence(binarynum.toString(), 1))
				binary.add(binarynum);
				
				}
				
				
		}
			
		
		return binary;
		
		
		
	}

	public static void main(String[] args) {
		Set<StringBuffer> patterns= printBinary(4);
		
		long sum=0;
		final int CONSONATS=21;
		final int VOWELS=5;
		
		for(StringBuffer buffer:patterns) {
			long mul=1;
			for(int i=0;i<buffer.length();i++)
			{
				if(buffer.charAt(i)=='C')
					mul*=CONSONATS;
					else
						mul*=VOWELS;	
			}
			
			sum+=mul;
		}
		
		
		System.out.println(sum%1000000007);
		
	}

}
