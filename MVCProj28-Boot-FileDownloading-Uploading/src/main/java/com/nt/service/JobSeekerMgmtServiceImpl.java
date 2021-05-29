package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.JobSeekerInfo;
import com.nt.repo.JobSeekerInfoRepo;

@Service("service")
public class JobSeekerMgmtServiceImpl implements IJobSeekerMgmtService {
	
	@Autowired
	private JobSeekerInfoRepo repo;

	@Override
	public String registerJobSeeker(JobSeekerInfo info) {
		//use repo
		JobSeekerInfo info1 = repo.save(info);
		if(info!=null)
			return "JobSeeker is Registered Successfully with ID :: "+info.getId();
		else
			return "Problem in JobSeeker Registration";
	}
	
	@Override
	public List<JobSeekerInfo> getAllFiles() {
		List<JobSeekerInfo> list = (List<JobSeekerInfo>) repo.findAll();
		return list;
	}

}
