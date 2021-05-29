package com.nt.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.entity.JobSeekerInfo;
import com.nt.model.JobSeeker;
import com.nt.service.IJobSeekerMgmtService;

@Controller
public class JobSeekerController {
	
	@Autowired
	private IJobSeekerMgmtService service;
	
	@Autowired
	private ServletContext sc;
	
	@GetMapping("/form")
	public String showForm(@ModelAttribute("jsForm") JobSeeker js) {
		js.setQualification("Bsc ComputerScience");
		return "jobseeker_form";
	}
	
	@PostMapping("/upload")
	public String uploadForm(Map<String,Object> map,@ModelAttribute("jsForm") JobSeeker js) throws Exception {
		//create folder in server machine file System having uploaded location
		File file = new File("F:/Java/UploadStore");
		if(!file.exists()) //if file not exist
			file.mkdir(); //create folder
		
		//get names of the upload files from model object
		String photoFileName = js.getPhoto().getOriginalFilename();
		String resumeFileName = js.getResume().getOriginalFilename();
		
		//create InputStreams representing uploaded files
		InputStream photoIS = js.getPhoto().getInputStream();
		InputStream resumeIS = js.getPhoto().getInputStream();
		
		//create OutputStream pointing to Destination files
		OutputStream photoOS = new FileOutputStream(file.getAbsolutePath().replace("\\", "/")+"/"+photoFileName);
		OutputStream resumeOS = new FileOutputStream(file.getAbsolutePath().replace("\\", "/")+"/"+resumeFileName);
		
		//copy the content
		IOUtils.copy(photoIS, photoOS);
		IOUtils.copy(resumeIS, resumeOS);
		
		//close Streams
		photoIS.close();
		photoOS.close();
		resumeIS.close();
		resumeOS.close();
		
		//send the names of uploaded files to result page 
		map.put("photo", photoFileName);
		map.put("resume", resumeFileName);
		
		//prepare Entity Object
		JobSeekerInfo info = new JobSeekerInfo();
		info.setName(js.getName());
		info.setQualification(js.getQualification());
		info.setPhotoPath(file.getAbsolutePath().replace("\\", "/")+"/"+photoFileName);
		info.setResumePath(file.getAbsolutePath().replace("\\", "/")+"/"+resumeFileName);
		
		//use service
		String result = service.registerJobSeeker(info);
		
		//add result to map attribute
		map.put("msg", result);
		
		//return lvn
		return "result";
	}
	
	@GetMapping("/list_files")
	public    String  showFiles(Map<String,Object> map) {
		//use service
		List<JobSeekerInfo> list=service.getAllFiles();
		//add as model attribute
		map.put("filesList",list);
		return  "show_files";
	}
	
	
	@GetMapping("/download")
	public String downloadFile(@RequestParam("fname") String fileName,HttpServletResponse res) throws Exception {
		//Locate the file using java.io.File object
		File file = new File(fileName);
		//get the length of the file and make it as response content length
		res.setContentLengthLong(file.length());
		//get MIME of the file make it response content type
		String mimeType = sc.getMimeType(fileName);
		res.setContentType(mimeType!=null?mimeType:"application/octet-stream");
		// give instruction to browser to make the received content as the downloadable file
		res.setHeader("Content-Disposition", "attachement;fileName="+file.getName());
		//create InputStream pointing to the file
		InputStream is = new FileInputStream(file);
		//create OutputStream pointing to  response obj
		OutputStream os = res.getOutputStream();
		//complete file copy process
		IOUtils.copy(is, os);
		//since response going to browser directly from handler method itself.. So return null  (do not take void)
		return null;
	}

}
