package gui;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;

public class CreateFile {
	
	public void createFolders(int start, int quantity, int limit) throws IOException {
		if(limit < quantity)
			return;
		
		String path = getProgramPath2();
        String fileSeparator = System.getProperty("file.separator");
        
		int sum = start + quantity;
		for(int i = start; i < sum; i++) {
			String folderDir = path + fileSeparator + "" + i + fileSeparator;
			new File(folderDir).mkdirs();
			File f = new File(folderDir +"Nyt tekstdokument.txt");
			f.createNewFile();
		}
	}
	
	private String getProgramPath2() throws UnsupportedEncodingException {
	      URL url = CreateFile.class.getProtectionDomain().getCodeSource().getLocation();
	      String jarPath = URLDecoder.decode(url.getFile(), "UTF-8");
	      String parentPath = new File(jarPath).getParentFile().getPath();
	      return parentPath;
	   }
	
}
