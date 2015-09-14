package com.whitewalk.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadUtil {

	public static String readString(String Filename)  {
		String result = "";
		
		String encodeing = "UTF-8";
	
		File file = new File(Filename);
		InputStreamReader read;
		try {
			read = new InputStreamReader(new FileInputStream(file), encodeing);
			BufferedReader bufferedReader = new BufferedReader(read);
		
			
			String s=null;
			while ((s = bufferedReader.readLine()) != null) {
				
				result+=s;
				
			}
			
		read.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

}
