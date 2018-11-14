package com.spi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spi.config.AppConstant;
import com.spi.entity.Faculty;
import com.spi.exception.SBZException;
import com.spi.model.User;
import com.spi.repository.FacultyRepository;
import com.spi.repository.UserRepository;

@Service
public class FacultyService {

	@Autowired
	private FacultyRepository facultyRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Autowired
	private UserService userService;

	public List<Faculty> getFaculties() {
		return facultyRepository.findAll();
	}

	@Transactional
	public Faculty addFaculty(Faculty faculty) {
		facultyRepository.save(faculty);
		Long l=new Long(1);
		User user = new User(faculty.getFirst_name()+" "+faculty.getLast_name(), 
				faculty.getFirst_name()+"."+faculty.getLast_name(), faculty.getAddress().getEmail_1(),
				AppConstant.DEFAULT_FACULTY_PASSWORD,faculty.getId(),AppConstant.FACULTY_USER_TYPE_ID);
		userService.registerUser(user);
		
		return faculty;
		
	}

	public Faculty updateFaculty(Faculty faculty) throws SBZException {
		User user = userRepository.findByRefIdAndTypeId(faculty.getId(), AppConstant.FACULTY_USER_TYPE_ID).orElseThrow(()-> new SBZException("User not found"));
		user.setName(faculty.getFirst_name()+" "+faculty.getLast_name());
		user.setEmail(faculty.getAddress().getEmail_1());
		userRepository.save(user);
		
		return facultyRepository.save(faculty);

	}

	public void deleteFaculty(int id) throws SBZException {
		User user = userRepository.findByRefIdAndTypeId(id, AppConstant.FACULTY_USER_TYPE_ID).orElseThrow(()-> new SBZException("User not found"));
		userRepository.delete(user);
		facultyRepository.deleteById(id);
	}

}
