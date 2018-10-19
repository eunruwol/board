package kr.or.ddit.util.model;

public class StringUtil {
	public static String getFileNameFromHeader(String contentDisposition){
		String fileName = "";
		String[] splists = contentDisposition.split("; ");
		for(String str : splists){
			if(str.indexOf("filename=") >= 0){
				fileName = str.substring(10, str.lastIndexOf("\""));
			}
		}
		
		return fileName;
	}
}