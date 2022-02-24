package com.crypto;

import java.util.Map;
import java.util.TreeMap;

public class RowTranpositionEncryption {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 String Message =
		 "CRYPTOLOGY IS THE PRACTICE AND STUDY OF TECHNIQUES " +
		 "FOR SECURE COMMUNICATION IN THE PRESENCE OF " +
		 "THIRD PARTIES CALLED ADVERSARIES";*/
		
		
		String Message = "I am bharath reddy";
		String key = "NYIT";
		RowTranpositionEncryption RTE = new RowTranpositionEncryption();
		String FinalCipher = RTE.rowTransposeEncrypt(Message, key);
		System.out.println(FinalCipher);
		
	}

	public String rowTransposeEncrypt(String Message, String key) {
		
		key = key.toUpperCase();
		String M = "";
		//int y = Message.length();
		for (int i = 0; i < Message.length(); i++) {
			if (Message.charAt(i) == ' ') {
				continue;
			} else {
				M += Message.charAt(i);
			}
			M = M.toLowerCase();
		}
		int a = M.length() % key.length();
		if (a > 0) {
			for (int i = a; i < key.length(); i++) {
				M = M + 'x';
			}
		}

		char cipher[][] = new char[M.length() / key.length()][key.length()];
		int y = 0;
		for (int i = 0; i < M.length() / key.length(); i++) {
			for (int j = 0; j < key.length(); j++) {
				cipher[i][j] = M.charAt(y);
				y += 1;
			}
		}
		
		Map<Character, Integer> m = new TreeMap<Character, Integer>();
		for (int i = 0; i < key.length(); i++) {
			m.put(key.charAt(i), i);
		}
		/*char cipher1[][] = new char[key.length()][M.length() / key.length()];
		for (int i = 0; i < key.length(); i++) {
			for (int j = 0; j < M.length() / key.length(); j++) {

				cipher1[i][j] = cipher[j][i];
			}
		}
		*/
		String FinalCipher = "";
		for (Map.Entry<Character, Integer> val : m.entrySet()) {
			int val1 = val.getValue();
			//System.out.print(val1);
			for (int j = 0; j < M.length() / key.length(); j++) {
				FinalCipher += cipher[j][val1];
			}
		}

		return FinalCipher;

	}

}
