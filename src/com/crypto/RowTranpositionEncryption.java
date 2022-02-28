package com.crypto;


import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

class RowTranpositionEncryption {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Provide the plain text to be Encrypted");
		Scanner sc1 = new Scanner(System.in);
		String Message = sc1.nextLine();
		System.out.println("provide the key to Encrypt the text");
		Scanner sckey1 = new Scanner(System.in);
		String key = sckey1.nextLine();

		RowTranpositionEncryption RTE = new RowTranpositionEncryption();
		String FinalCipher = RTE.rowTransposeEncrypt(Message, key);
		System.out.println("Cipher text for given plain text is - "+" "+FinalCipher);
		
	}

	public String rowTransposeEncrypt(String Message, String key) {
		
		key = key.toUpperCase();
		String M = "";
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
		String FinalCipher = "";
		for (Map.Entry<Character, Integer> val : m.entrySet()) {
			int val1 = val.getValue();
			for (int j = 0; j < M.length() / key.length(); j++) {
				FinalCipher += cipher[j][val1];
			}
		}

		return FinalCipher;

	}

}
