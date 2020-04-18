package com.fileCompare;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileCompare {
	
	private List readFile(File file) {
		List<String> list = new ArrayList<String>();
		try {
			if(file.exists()){
				InputStreamReader read = new InputStreamReader(new FileInputStream(file));
				BufferedReader bufferedReader = new BufferedReader(read);
				String line = "";
				while((line=bufferedReader.readLine())!=null){
					list.add(line);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void writeStringToFile(String filePath,StringBuffer sb){
		try {
			FileOutputStream fos = new FileOutputStream(filePath);
			String str = sb.toString();
			try {
				fos.write(str.getBytes());
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		FileCompare fileCompare = new FileCompare();
		File file1 = new File("D:\\workspace\\JSProject\\src\\com\\fileCompare\\file1.txt");
		File file2 = new File("D:\\workspace\\JSProject\\src\\com\\fileCompare\\file2.txt");
		File file3 = new File("D:\\workspace\\JSProject\\src\\com\\fileCompare\\file3.txt");
		List<String> srcList = fileCompare.readFile(file1);
		List<String> copyList = fileCompare.readFile(file2);
		
		StringBuffer sb = new StringBuffer();
		
		for(int i=0;i<srcList.size();i++){
			String s1 = srcList.get(i);
			if(!copyList.contains(s1)){
				sb.append(s1).append("\n");
			}
		}
		fileCompare.writeStringToFile(file3.getPath(),sb);
		
		
	}

}
