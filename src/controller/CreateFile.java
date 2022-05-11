package controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CreateFile {
	
	private String fileSeparator = System.getProperty("file.separator");
	
	private LocalDate date = LocalDate.now();
	private DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.YY");
	private String desktopFolder = date.format(format);
	
	public void createFolders(String headFolder, int start, int quantity, int limit) throws IOException {
		String path = getProgramPath2(); //	Gets the path to desktop
		String dateFolder = path + fileSeparator + desktopFolder + fileSeparator;
		
		File df = new File(dateFolder);
		if(!df.isDirectory()) {
			FailureDialog fd = new FailureDialog("Dato-mappen kan ikke findes i systemet");
			fd.setVisible(true);
			return;
		}
		
		if(headFolder.isEmpty()) {
			FailureDialog failHead = new FailureDialog("<html>Mangler at indtaste ved <br>hovedmappen");
			failHead.setVisible(true);
			return;
		}
		
		if(start == 0) {
			FailureDialog startFail = new FailureDialog("<html>Mangler at indtaste ved <br>start mappe nummeret");
			startFail.setVisible(true);
			return;
		}
		
		if(quantity == 0) {
			FailureDialog quantityFail = new FailureDialog("<html>Mangler at indtaste ved <br>antallet");
			quantityFail.setVisible(true);
			return;
		}
		
		if(limit < quantity) {
			FailureDialog fdd = new FailureDialog("Antallet overstiger limit");
			fdd.setVisible(true);
			return;
		}	

        String mainFolder = path + fileSeparator + desktopFolder + fileSeparator + headFolder + fileSeparator; //Gets the path to headFolder inside of the date folder
        
        new File(mainFolder).mkdir();
        
		int sum = start + quantity;
		for(int i = start; i < sum; i++) {
			String subdirs = mainFolder + fileSeparator + "" + i + fileSeparator;
			System.out.println(subdirs);
			new File(subdirs).mkdirs();
			File f = new File(subdirs + "Nyt tekstdokument.txt");
			if(f.createNewFile()) {
				
			}
		}
		SuccessDialog sd = new SuccessDialog();
		sd.setVisible(true);
	}
	
	private String getProgramPath2() throws UnsupportedEncodingException {
	      URL url = CreateFile.class.getProtectionDomain().getCodeSource().getLocation();
	      String jarPath = URLDecoder.decode(url.getFile(), "UTF-8");
	      String parentPath = new File(jarPath).getParentFile().getPath();
	      return parentPath;
	   }
	
}
