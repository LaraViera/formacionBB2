package com.Bitbox.formacionBB2.controller;

import com.Bitbox.formacionBB2.model.Role;
import com.Bitbox.formacionBB2.model.RoleEnum;
import com.Bitbox.formacionBB2.model.Users;
import com.Bitbox.formacionBB2.payload.request.LoginRequest;
import com.Bitbox.formacionBB2.payload.request.SignupRequest;
import com.Bitbox.formacionBB2.payload.response.JwtResponse;
import com.Bitbox.formacionBB2.payload.response.MessageResponse;
import com.Bitbox.formacionBB2.repository.RoleRepository;
import com.Bitbox.formacionBB2.repository.UserRepository;
import com.Bitbox.formacionBB2.security.jwt.JwtUtils;
import com.Bitbox.formacionBB2.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

// REST API para la Autenticación
// UserController se utilizó para la comprobación de la BBDD durante el desarrollo de las tablas del servidor
@CrossOrigin(origins = "*", maxAge = 3600)
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
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority()).collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getIdUser(), userDetails.getUsername(), userDetails.getEmail(), roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signupRequest) {
        if (userRepository.existsByUsername(signupRequest.getUsername())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: username is already taken!"));
        }
        if (userRepository.existsByEmail(signupRequest.getEmail())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error> email is already in use!"));
        }
        // creamos nueva cuenta de usuario
        Users user = new Users(signupRequest.getUsername(), signupRequest.getEmail(), encoder.encode(signupRequest.getPassword()));

        Set<String> strRoles = signupRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(RoleEnum.USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(RoleEnum.ADMIN)
                                .orElseThrow(() -> new RuntimeException(("Error: Role is not found")));
                        roles.add(adminRole);
                        break;
                    default:
                        Role userRole = roleRepository.findByName(RoleEnum.USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found"));
                        roles.add(userRole);
                }
            });
        }
        user.setRoles(roles);
        userRepository.save(user);
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }


}
