package com.supinfo.imagecolormodifier;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class Launcher {
	
	private static final int HEADER_SIZE = 138;
	
	
	public static void main(String[] args) throws IOException {
		String picturePath = ClassLoader.getSystemResource("com/supinfo/imagecolormodifier/resources/picture.bmp").getPath();
		File source = new File(picturePath);
		List<Integer> list = readFileBytes(source);
		
		List<Integer> subList = list.subList(HEADER_SIZE, list.size());
		addToPixels(subList, 200);
		
		File target = new File("bitmap_new.bmp");
		writeFileBytes(target, list);
	}
	
	private static List<Integer> readFileBytes(File file) throws IOException {
		List<Integer> result = new ArrayList<Integer>();
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(file);
			int data;
			while (-1 != (data = inputStream.read())) {
				result.add(data);
			}
			inputStream.close();
		} finally {
			if(inputStream != null) inputStream.close();
		}
		
		return result;
	}

	private static void writeFileBytes(File target, List<Integer> list) throws FileNotFoundException, IOException {
		target.createNewFile();
		
		FileOutputStream fileOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream(target);
			for (Integer integer : list) {
				fileOutputStream.write(integer);
			}
		} finally {
			if(fileOutputStream != null) fileOutputStream.close();
		}
	}
	
	private static void addToPixels(List<Integer> list, int value) {
		for (int i = 0; i < list.size(); i++) {
			Integer pixel = list.get(i);
			list.set(i, (pixel + value) % 255);
		}
	}

}
