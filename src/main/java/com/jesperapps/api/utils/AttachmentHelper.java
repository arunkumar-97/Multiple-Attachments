package com.jesperapps.api.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.tomcat.util.codec.binary.Base64;

import com.jesperapps.api.model.Attachment;

public abstract class AttachmentHelper {


	public boolean saveRequestFile(String attachmentName, String fileByte, String LOCATION) {
		try{
            if(Files.notExists(Paths.get(LOCATION))){
                File directoryFile = new File(LOCATION);
                if(directoryFile.mkdir()){
                    //directory created successfully;
                }else{
                    //error creating directory
                }
            }
            if(attachmentName != ""){
                File newProfilePicture = new File(LOCATION + "\\"+ attachmentName);
				OutputStream buffer = new FileOutputStream(newProfilePicture);
				buffer.write(Base64.decodeBase64(fileByte));
				buffer.close();
            }
            else{
                return false;
            }
        }catch(Exception e){
            // System.out.println(e.toString());
            return false;
        }
        return true;
	}

}
