package com.file.uploaded.dynamicly.helper;



import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadhelper {

	public final String UPLOAD_DIR = new ClassPathResource("static/image").getFile().getAbsolutePath();
	
	public FileUploadhelper()throws IOException 
	{
		
	}

	public boolean uploadfile(MultipartFile f) {

		boolean b = false;

		try {
			Files.copy(f.getInputStream(), Paths.get(UPLOAD_DIR + File.separator + f.getOriginalFilename()),
					StandardCopyOption.REPLACE_EXISTING);
			b = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}
}