package kr.or.ddit.file.web;

public class FileUtil {

	public final static String fileUploadPath = "D:\\A_TeachingMaterial\\6.JspSpring\\fileUpload";
	
	/**
	* Method : getFileName
	* 작성자 : iks
	* 변경이력 :
	* @param contentDisposition
	* @return
	* Method 설명 : part의 Content-Disposition header로 부터 업로드 파일명을 리턴한다.
	*/
	public static String getFileName(String contentDisposition){
		
		String[] cdSplit = contentDisposition.split("; ");		
		String fileName = "";
		
		for (String str : cdSplit) {
			if (str.startsWith("filename")) {
				fileName = str.substring("filename".length()+2, str.length()-1);
				break;
			}
		}
		
		return fileName;
	}
}
