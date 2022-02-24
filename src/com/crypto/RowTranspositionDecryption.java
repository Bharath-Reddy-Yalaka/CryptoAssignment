package com.crypto;

import java.util.Map;
import java.util.TreeMap;

public class RowTranspositionDecryption {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*String cipher = "eroohalpsmeptroohalsefxphtnlefhhxtwstiiiieoec"
				+ "rastitosplmgeasentmitrasnefylypnhiasnetoiroitaetaxoeet"
				+ "onicrasetltesnicrfwmurnhrrhitrcrxhtpipsrmaimiitpiphlaleiucciptotpe";*/
		String cipher = "mrryihtdbaexaahd";
		String key = "NYIT";
		RowTranspositionDecryption RTD = new RowTranspositionDecryption();
		String Text = RTD.rowTransposeDecrypt(cipher, key);
		System.out.println(Text);
		
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
		/*for(int i =0; i<key.length();i++ ){
			for(int j=0;j<cipher.length()/key.length();j++){
				System.out.print(decrypt[i][j]);
			}
			System.out.println();
		}*/
		//char decrypt1[][] = new char[cipher.length()/key.length()][key.length()];
		String str = "";
		for(int i=0; i<cipher.length()/key.length();i++){
			for(int j=0;j<key.length();j++){
				str+= decrypt[j][i];
			}
		}
		/*String str ="";
		for(int i=0; i<cipher.length()/key.length();i++){
			for(int j=0;j<key.length();j++){
				str+=decrypt1[i][j];
			}
		}*/
		return str;
	}

}
