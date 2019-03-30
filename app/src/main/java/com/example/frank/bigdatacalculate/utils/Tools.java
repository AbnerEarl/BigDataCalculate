package com.example.frank.bigdatacalculate.utils;

import com.example.frank.bigdatacalculate.InputSevenActivity;
import com.example.frank.bigdatacalculate.MainActivity;
import com.example.frank.bigdatacalculate.MainActivityFor21;
import com.example.frank.bigdatacalculate.SelectDataActivity;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Tools {


	public static void saveRecord(String content,String fileName) {
		FileWriter fw = null;
		try {
			//如果文件存在，则追加内容；如果文件不存在，则创建文件
			File fd=new File(MainActivity.sdcardPath );
			if (fd.exists()&&fd.isDirectory()){

			}else {
				fd.mkdir();
				//fd.mkdirs();
			}

			File f=new File(MainActivity.sdcardPath +fileName+".txt");
			if (!f.exists()){
				f.createNewFile();
			}
			//System.out.println("文件路径："+MainActivity.sdcardPath +fileName+".txt");
			fw = new FileWriter(f, true);
		} catch (IOException e) {
			e.printStackTrace();
		}
		PrintWriter pw = new PrintWriter(fw);
		pw.println(content);
		pw.flush();
		try {
			fw.flush();
			pw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public static void saveRecordFor21(String content,String fileName) {
		FileWriter fw = null;
		try {
			//如果文件存在，则追加内容；如果文件不存在，则创建文件
			File fd=new File(MainActivityFor21.sdcardPath );
			if (fd.exists()&&fd.isDirectory()){

			}else {
				fd.mkdir();
				//fd.mkdirs();
			}

			File f=new File(MainActivityFor21.sdcardPath +fileName+".txt");
			if (!f.exists()){
				f.createNewFile();
			}
			//System.out.println("文件路径："+MainActivity.sdcardPath +fileName+".txt");
			fw = new FileWriter(f, true);
		} catch (IOException e) {
			e.printStackTrace();
		}
		PrintWriter pw = new PrintWriter(fw);
		pw.println(content);
		pw.flush();
		try {
			fw.flush();
			pw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public static void saveRecordData(String content,String fileName) {
		FileWriter fw = null;
		try {
			//如果文件存在，则追加内容；如果文件不存在，则创建文件
			File fd=new File(SelectDataActivity.sdcardPath );
			if (fd.exists()&&fd.isDirectory()){

			}else {
				fd.mkdir();
				//fd.mkdirs();
			}

			File f=new File(SelectDataActivity.sdcardPath +fileName+".txt");
			if (!f.exists()){
				f.createNewFile();
			}
			//System.out.println("文件路径："+SelectDataActivity.sdcardPath +fileName+".txt");
			fw = new FileWriter(f, true);
		} catch (IOException e) {
			e.printStackTrace();
		}
		PrintWriter pw = new PrintWriter(fw);
		pw.println(content);
		pw.flush();
		try {
			fw.flush();
			pw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public static void saveRecordFor21Data(String content,String fileName) {
		FileWriter fw = null;
		try {
			//如果文件存在，则追加内容；如果文件不存在，则创建文件
			File fd=new File(SelectDataActivity.sdcardPath );
			if (fd.exists()&&fd.isDirectory()){

			}else {
				fd.mkdir();
				//fd.mkdirs();
			}

			File f=new File(SelectDataActivity.sdcardPath +fileName+".txt");
			if (!f.exists()){
				f.createNewFile();
			}
			//System.out.println("文件路径："+SelectDataActivity.sdcardPath +fileName+".txt");
			fw = new FileWriter(f, true);
		} catch (IOException e) {
			e.printStackTrace();
		}
		PrintWriter pw = new PrintWriter(fw);
		pw.println(content);
		pw.flush();
		try {
			fw.flush();
			pw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}



	public static void saveTempleData(String content,String fileName) {
		FileWriter fw = null;
		try {
			//如果文件存在，则追加内容；如果文件不存在，则创建文件
			File fd=new File(InputSevenActivity.sdcardPath );
			if (fd.exists()&&fd.isDirectory()){

			}else {
				fd.mkdir();
				//fd.mkdirs();
			}

			File f=new File(InputSevenActivity.sdcardPath +fileName+".txt");
			if (!f.exists()){
				f.createNewFile();
			}
			//System.out.println("文件路径："+SelectDataActivity.sdcardPath +fileName+".txt");
			fw = new FileWriter(f, true);
		} catch (IOException e) {
			e.printStackTrace();
		}
		PrintWriter pw = new PrintWriter(fw);
		pw.println(content);
		pw.flush();
		try {
			fw.flush();
			pw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
