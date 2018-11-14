package com.spi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spi.exception.ResourceNotFoundException;
import com.spi.model.User;
import com.spi.payload.UserIdentityAvailability;
import com.spi.payload.UserProfile;
import com.spi.payload.UserSummary;
import com.spi.repository.UserRepository;
import com.spi.security.CurrentUser;
import com.spi.security.UserPrincipal;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/user/me")
	@PreAuthorize("hasRole('USER')")
	public UserSummary getCurrentUser(@CurrentUser UserPrincipal currentUser) {
		UserSummary userSummary = new UserSummary(currentUser.getId(), currentUser.getUsername(),
				currentUser.getName());
		return userSummary;
	}

	@GetMapping("/user/checkUsernameAvailability")
	public UserIdentityAvailability checkUsernameAvailability(@RequestParam(value = "username") String username) {
		Boolean isAvailable = !userRepository.existsByUsername(username);
		return new UserIdentityAvailability(isAvailable);
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
