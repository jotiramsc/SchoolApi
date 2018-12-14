package com.spi.controller;

import java.util.Optional;
import java.util.Random;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.spi.exception.ResourceNotFoundException;
import com.spi.model.User;
import com.spi.payload.JwtAuthenticationResponse;
import com.spi.payload.LoginRequest;
import com.spi.payload.UserIdentityAvailability;
import com.spi.payload.UserProfile;
import com.spi.payload.UserSummary;
import com.spi.repository.RoleRepository;
import com.spi.repository.UserRepository;
import com.spi.security.CurrentUser;
import com.spi.security.JwtTokenProvider;
import com.spi.security.UserPrincipal;

import io.netty.handler.codec.http.HttpResponse;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	JwtTokenProvider tokenProvider;

	@GetMapping("/user/me")
	//@PreAuthorize("hasRole('USER')")
	public User getCurrentUser() {
		UserPrincipal currentUser =(UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user=new User();
		user.setEmail(currentUser.getEmail());
		user.setName(currentUser.getName());
		user.setId(currentUser.getId());
		user.setUsername(currentUser.getUsername());
		
		return user;
	}

	@GetMapping("/user/checkUsernameAvailability")
	public UserIdentityAvailability checkUsernameAvailability(@RequestParam(value = "username") String username) {
		Boolean isAvailable = !userRepository.existsByUsername(username);
		return new UserIdentityAvailability(isAvailable);
	}

	@GetMapping("/user/checkByMobile")
	public boolean checkByMobile(@RequestParam(value = "mobile") String mobile) {
		Boolean isAvailable = !userRepository.existsByMobile(mobile);
		return isAvailable;
	}
	@GetMapping("/user/sendOtp")
	public boolean sendOTP(@RequestParam(value = "mobile") String mobile) {
		Optional<User> user = userRepository.findByMobile(mobile);
		if(user.isPresent())
		{
		Random random = new Random();
		String otp = String.format("%04d", random.nextInt(10000));
		user.get().setOtp(otp);
		userRepository.save(user.get());
		
	    RestTemplate rt = new RestTemplate();
        rt.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        rt.getMessageConverters().add(new StringHttpMessageConverter());
        String uri = new String("http://control.msg91.com/api/sendotp.php?"
        		+ "template=your schoolapp otp is&otp_length=250"
        		+ "&authkey=251181ADziubz9L5c0e258c"
        		+ "&message=your schoolApp otp is:"+user.get().getOtp()
        		+ "&sender=APPSCH"
        		+ "&mobile=8390968506"
        		+ "&otp="+user.get().getOtp()
        		+ "&otp_expiry=120"
        		+ "&email=chavanjotiram24@gmail.com");
        String returns = rt.postForObject(uri, "", String.class);
        if(returns.contains("success"))
        {
        	return true;
        }
		}
		return false;
	}
	
	@GetMapping("/user/checkEmailAvailability")
	public UserIdentityAvailability checkEmailAvailability(@RequestParam(value = "email") String email) {
		Boolean isAvailable = !userRepository.existsByEmail(email);
		return new UserIdentityAvailability(isAvailable);
	}
	
	

//	@GetMapping("/users/{username}")
//	public UserProfile getUserProfile(@PathVariable(value = "username") String username) {
//		User user = userRepository.findByUsername(username)
//				.orElseThrow(() -> new ResourceNotFoundException("User", "username", username));
//
//		long pollCount = pollRepository.countByCreatedBy(user.getId());
//		long voteCount = voteRepository.countByUserId(user.getId());
//
//		UserProfile userProfile = new UserProfile(user.getId(), user.getUsername(), user.getName(), user.getCreatedAt(),
//				pollCount, voteCount);
//
//		return userProfile;
//	}

}
