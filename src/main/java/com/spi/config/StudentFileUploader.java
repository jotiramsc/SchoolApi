package com.spi.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.util.ArrayUtils;

import com.spi.entity.Address;
import com.spi.entity.CourseClass;
import com.spi.entity.Student;
import com.spi.exception.SBZException;
import com.spi.repository.AddressRepository;
import com.spi.repository.CourseClassRepository;
import com.spi.repository.StudentRepository;

@Component
public class StudentFileUploader extends FileLoader {

	List<Student> students = null;

	@Autowired
	StudentRepository studentRepository = null;

	@Autowired
	AddressRepository addressRepository = null;

	@Autowired
	CourseClassRepository courseClassRepository = null;

	public StudentFileUploader() {
		super();
	}

	@Override
	public void validate() {
		try {

			if (this.validateHeader()) {
				this.readFileData();
				if (null == this.dataList || this.dataList.size() == 0) {
					throw new SBZException("File does not have data");
				} else {
					this.students = new ArrayList<Student>();
					for (int i = 0; i < this.dataList.size(); i++) {
						HashMap<String, String> hm = this.dataList.get(i);

						if (null == hm || hm.size() == 0) {
							this.expList.add(new SBZException("data not found for row :" + (i + 1)));
						} else {
							Student student = new Student();
							Address address = new Address();

							if (hm.get("first_name") != null && !hm.get("first_name").equalsIgnoreCase("")) {
								if (SBZUtil.isValidString(hm.get("first_name").trim(), true)) {
									student.setFirst_name(hm.get("first_name").trim());
								} else {
									this.expList.add(new SBZException("First name invalid at row :" + (i + 1)));
								}
							} else {
								this.expList.add(new SBZException("First name needed at row :" + (i + 1)));
							}

							if (hm.get("middle_name") != null && !hm.get("middle_name").equalsIgnoreCase("")) {
								if (SBZUtil.isValidString(hm.get("middle_name").trim(), true)) {
									student.setMiddle_name(hm.get("middle_name").trim());
								} else {
									this.expList.add(new SBZException("Middle name invalid at row :" + (i + 1)));
								}
							}

							if (hm.get("last_name") != null && !hm.get("last_name").equalsIgnoreCase("")) {
								if (SBZUtil.isValidString(hm.get("last_name").trim(), true)) {
									student.setLast_name(hm.get("last_name").trim());
								} else {
									this.expList.add(new SBZException("Last name invalid at row :" + (i + 1)));
								}
							} else {
								this.expList.add(new SBZException("Last name needed at row :" + (i + 1)));
							}

							if (hm.get("gender") != null && !hm.get("gender").equalsIgnoreCase("")) {
								if (SBZUtil.isValidString(hm.get("gender").trim(), true)) {
									student.setGender(hm.get("gender").trim());
								} else {
									this.expList.add(new SBZException("Gender invalid at row :" + (i + 1)));
								}
							} else {
								this.expList.add(new SBZException("Gender needed at row :" + (i + 1)));
							}

							if (hm.get("birthdate") != null && !hm.get("birthdate").equalsIgnoreCase("")) {
								if (SBZUtil.isValidDate(hm.get("birthdate").trim(), "dd/mm/yyyy")) {
									student.setBirthdate(SBZUtil.parseDate(hm.get("birthdate").trim(), "dd/mm/yyyy"));
								} else {
									this.expList.add(new SBZException("Birthdate invalid at row :" + (i + 1)));
								}
							} else {
								this.expList.add(new SBZException("Birthdate needed at row :" + (i + 1)));
							}
							if (hm.get("class") != null && !hm.get("class").equalsIgnoreCase("")) {
								if (SBZUtil.isValidString(hm.get("class").trim(), true)) {
									CourseClass cls = courseClassRepository
											.getBycourse_abbrOrCourse_name(hm.get("class").trim());
									if (null != cls) {
										student.setCourseClass(cls);
									} else {
										this.expList.add(new SBZException("Invalid class selected at row :" + (i + 1)));
									}

								} else {
									this.expList.add(new SBZException("Class invalid at row :" + (i + 1)));
								}
							} else {
								this.expList.add(new SBZException("Class needed at row :" + (i + 1)));
							}

							if (hm.get("mobile_1") != null && !hm.get("mobile_1").equalsIgnoreCase("")) {
								if (SBZUtil.isValidMobile(hm.get("mobile_1").trim())) {
									address.setMobile_1(Long.parseLong(hm.get("mobile_1").trim()));
								} else {
									this.expList.add(new SBZException("Mobile_1 invalid at row :" + (i + 1)));
								}
							} else {
								this.expList.add(new SBZException("Mobile_1 needed at row :" + (i + 1)));
							}

							if (hm.get("mobile_2") != null && !hm.get("mobile_2").equalsIgnoreCase("")) {
								if (SBZUtil.isValidMobile(hm.get("mobile_2").trim())) {
									address.setMobile_2(Long.parseLong(hm.get("mobile_2").trim()));
								} else {
									this.expList.add(new SBZException("Mobile_2 invalid at row :" + (i + 1)));
								}
							}

							if (hm.get("phone_1") != null && !hm.get("phone_1").equalsIgnoreCase("")) {
								address.setPhone_1(hm.get("phone_1").trim());
							}

							if (hm.get("phone_2") != null && !hm.get("phone_2").equalsIgnoreCase("")) {

								address.setPhone_2(hm.get("phone_2").trim());
							}

							if (hm.get("email_1") != null && !hm.get("email_1").equalsIgnoreCase("")) {
								if (SBZUtil.isValidEmail(hm.get("email_1").trim())) {
									address.setEmail_1(hm.get("email_1").trim());
								} else {
									this.expList.add(new SBZException("Email_1 invalid at row :" + (i + 1)));
								}
							} else {
								this.expList.add(new SBZException("Email_1 needed at row :" + (i + 1)));
							}

							if (hm.get("email_2") != null && !hm.get("email_2").equalsIgnoreCase("")) {
								if (SBZUtil.isValidEmail(hm.get("email_2").trim())) {
									address.setEmail_2(hm.get("email_2").trim());
								} else {
									this.expList.add(new SBZException("Email_2 invalid at row :" + (i + 1)));
								}
							}

							if (hm.get("facebook_link") != null && !hm.get("facebook_link").equalsIgnoreCase("")) {
								address.setFacebook_link(hm.get("facebook_link").trim());
							}

							if (hm.get("gplus_link") != null && !hm.get("gplus_link").equalsIgnoreCase("")) {
								address.setGplus_link(hm.get("gplus_link").trim());
							}

							if (hm.get("linkedin_link") != null && !hm.get("linkedin_link").equalsIgnoreCase("")) {
								address.setLinkedin_link(hm.get("linkedin_link").trim());
							}

							if (hm.get("website_link") != null && !hm.get("website_link").equalsIgnoreCase("")) {
								address.setWebsite_link(hm.get("website_link").trim());
							}

							if (hm.get("address_1") != null && !hm.get("address_1").equalsIgnoreCase("")) {
								address.setAddress_1(hm.get("address_1").trim());
							} else {
								this.expList.add(new SBZException("Address_1 needed at row :" + (i + 1)));
							}

							if (hm.get("address_2") != null && !hm.get("address_2").equalsIgnoreCase("")) {
								address.setAddress_2(hm.get("address_2").trim());
							}

							if (hm.get("city") != null && !hm.get("city").equalsIgnoreCase("")) {
								address.setCity(hm.get("city").trim());
							} else {
								this.expList.add(new SBZException("city needed at row :" + (i + 1)));
							}

							if (hm.get("district") != null && !hm.get("district").equalsIgnoreCase("")) {
								address.setDistrict(hm.get("district").trim());
							} else {
								this.expList.add(new SBZException("District needed at row :" + (i + 1)));
							}

							if (hm.get("state") != null && !hm.get("state").equalsIgnoreCase("")) {
								if (SBZUtil.isValidString(hm.get("state").trim(), true)
										&& ArrayUtils.contains(SBZUtil.states, hm.get("state").trim())) {
									address.setState(hm.get("state"));
								} else {
									this.expList.add(new SBZException("State name invalid at row :" + (i + 1)));
								}
							} else {
								this.expList.add(new SBZException("State needed at row :" + (i + 1)));
							}

							if (hm.get("pincode") != null && !hm.get("pincode").equalsIgnoreCase("")) {
								if (SBZUtil.isValidZip(hm.get("pincode").trim())) {
									address.setPincode(Integer.parseInt(hm.get("pincode").trim()));
								} else {
									this.expList.add(new SBZException("Pincode invalid at row :" + (i + 1)));
								}
							} else {
								this.expList.add(new SBZException("Pincode needed at row :" + (i + 1)));
							}

							student.setAddress(address);
							this.students.add(student);
						}

					}
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			this.expList.add(new SBZException(e.getMessage()));
		}
	}

	@Override
	public void preLoad() {
		this.fileHeaders = this.readFileHeaders();
		this.headers = this.getHeader();

	}

	@Override
	public void Load() {

		if (this.expList.size() > 0) {
			System.out.println("There are some exp");
		} else {

			studentRepository.saveAll(this.students);
		}
	}

	@Override
	public void postLoad() {
		// TODO Auto-generated method stub

	}

}
