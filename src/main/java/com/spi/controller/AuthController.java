package com.spi.controller;

import java.net.URI;
import java.util.Collections;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.spi.model.Role;
import com.spi.model.RoleName;
import com.spi.model.User;
import com.spi.payload.ApiResponse;
import com.spi.payload.JwtAuthenticationResponse;
import com.spi.payload.LoginRequest;
import com.spi.payload.SignUpRequest;
import com.spi.repository.RoleRepository;
import com.spi.repository.UserRepository;
import com.spi.security.JwtTokenProvider;

/**
 * Created by rajeevkumarsingh on 02/08/17.
 */
@RestController
@RequestMapping("/api/auth")
public class AuthController {

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

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsernameOrEmail(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = tokenProvider.generateToken(authentication);
		return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> authenticateAppUser(@Valid @RequestBody LoginRequest loginRequest) {

		Optional<User> userData= userRepository.findByMobile(loginRequest.getUsernameOrEmail().trim());
		if(userData.isPresent())
		{
		
			if(userData.get().getOtp().equalsIgnoreCase(loginRequest.getPassword().trim()))
			{
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(userData.get().getUsername(), userData.get().getPassword()));
	
			SecurityContextHolder.getContext().setAuthentication(authentication);
	
			String jwt = tokenProvider.generateToken(authentication);
			return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
			}else
			{
				return ResponseEntity.ok("Invalid OTP");
			}
		}else
		{
			return ResponseEntity.ok("Invalid Mobile");
		}
	}
	
	

	@PostMapping("/signup")
	public ResponseEntity<ApiResponse> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Username is already taken!"), HttpStatus.BAD_REQUEST);
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Email Address already in use!"), HttpStatus.BAD_REQUEST);
		}

		// Creating user's account
	
		User user = new User(signUpRequest.getName(), signUpRequest.getUsername(), signUpRequest.getEmail(),
				signUpRequest.getPassword(),1,1);

		user.setPassword(passwordEncoder.encode(user.getPassword()));
		

		Role userRole = roleRepository.findByName(RoleName.ROLE_USER);

		// .orElseThrow(() -> new AppException("User Role not set."));

		user.setRoles(Collections.singleton(userRole));

		User result = userRepository.save(user);

		URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/users/{username}")
				.buildAndExpand(result.getUsername()).toUri();

		return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));
	}
}
