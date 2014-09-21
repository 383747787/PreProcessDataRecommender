package com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Preprocess {
	
	public static void appendMethodA(String fileName,  
			  
			String content){  
			try {  
			// ��һ����������ļ���������д��ʽ  
			RandomAccessFile randomFile = new RandomAccessFile(fileName, "rw");  
			// �ļ����ȣ��ֽ���  
			long fileLength = randomFile.length();  
			//��д�ļ�ָ���Ƶ��ļ�β��  
			randomFile.seek(fileLength);  
			randomFile.writeBytes(content);  
			randomFile.close();  
			} catch (IOException e){  
			e.printStackTrace();  
			}  
	}
	
	public static void readFileByLines(String fileName){  
		File file = new File(fileName);  
		BufferedReader reader = null; 
		try {  
		System.out.println("����Ϊ��λ��ȡ�ļ����ݣ�һ�ζ�һ���У�");  
		reader = new BufferedReader(new FileReader(file));  
		String tempString = null;  
		int line = 1;  
		//һ�ζ���һ�У�ֱ������nullΪ�ļ�����  
		while ((tempString = reader.readLine()) != null){  
		//��ʾ�к�  
		//System.out.println("line " + line + ": " + tempString);  
		//line++;  
		//д�뵽�ļ���
		String filename = "out.txt";
		String[] strarr = tempString.split("::");
		String deststr = strarr[0]+","+strarr[1]+","+strarr[2]+"\n";
		
		appendMethodA(filename,deststr);
		}  
		reader.close();  
		} catch (IOException e) {  
		e.printStackTrace();  
		} finally {  
		if (reader != null){  
		try {  
		reader.close();  
		} catch (IOException e1) {  
		}  
		}  
		}  
		}
	
	public static void main(String[] args) throws Exception{
		//FileReader fr = new FileReader("ratings.dat");
		readFileByLines("ratings.dat");
	}
	
}
