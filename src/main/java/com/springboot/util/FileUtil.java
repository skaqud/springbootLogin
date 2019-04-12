package com.springboot.util;

import java.io.FileInputStream;


public class FileUtil {
	
	/**
	 * File 조회
	 *  
	 * @param path Full File Path
	 * 									
	 */
	public static String getFileData(String path) {

		StringBuffer strBuf = new StringBuffer();
		FileInputStream	fis = null;

		try {
			fis = new FileInputStream(path);

			byte[] buf = new byte[1024];
			while(fis.read(buf) > -1) {
				strBuf.append(new String(buf));
				buf = new byte[1024];
			}
		} catch (Exception e) {
		} finally {
			try {
				fis.close();
			} catch (Exception e1) {}
		}
		return new String(strBuf);		
	}

}
