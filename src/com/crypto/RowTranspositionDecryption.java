package com.crypto;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class RowTranspositionDecryption {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Provide the cipher text to be decrypted");
		Scanner sc = new Scanner(System.in);
		String cipher = sc.next();
		System.out.println("provide the key to decrypt the text");
		Scanner sckey = new Scanner(System.in);
		String key = sckey.next();
		RowTranspositionDecryption RTD = new RowTranspositionDecryption();
		String Text = RTD.rowTransposeDecrypt(cipher, key);
		System.out.println("Text for given cipher text is - "+Text);
		
	}
	
	public String rowTransposeDecrypt(String cipher, String key){

		Map<Character, Integer> m = new TreeMap<Character,Integer>();
		for(int i=0;i<key.length();i++){
			m.put(key.charAt(i), i);
		}
		//System.out.println(m);
		char decrypt[][] = new char[key.length()][cipher.length()/key.length()];
		int count =0;
		for(Map.Entry<Character, Integer> m1:m.entrySet()){
			for(int j=0;j<cipher.length()/key.length();j++){
				decrypt[m1.getValue()][j] = cipher.charAt(count);
				count++;
			}
		}
		String str = "";
		for(int i=0; i<cipher.length()/key.length();i++){
			for(int j=0;j<key.length();j++){
				str+= decrypt[j][i];
			}
		}
		return str;
	}

}
