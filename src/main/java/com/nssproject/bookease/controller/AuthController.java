package com.nssproject.bookease.controller;

import com.nssproject.bookease.dto.AuthResponseDto;
import com.nssproject.bookease.dto.LoginDto;
import com.nssproject.bookease.dto.RegisterStallDto;
import com.nssproject.bookease.dto.RegisterUserDto;
import com.nssproject.bookease.entity.BookStall;
import com.nssproject.bookease.entity.Customer;
import com.nssproject.bookease.entity.Role;
import com.nssproject.bookease.entity.UserEntity;
import com.nssproject.bookease.repository.*;
import com.nssproject.bookease.security.JwtGenerator;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtGenerator jwtGenerator;
    private final CustomerRepository customerRepository;
    private final BookStallRepository bookStallRepository;
    private final UserRoleRepository userRoleRepository;

    @Autowired
    public AuthController(UserRepository userRepository,
                          RoleRepository roleRepository,
                          PasswordEncoder passwordEncoder,
                          AuthenticationManager authenticationManager,
                          JwtGenerator jwtGenerator,
                          CustomerRepository customerRepository,
                          BookStallRepository bookStallRepository,
                          UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtGenerator = jwtGenerator;
        this.customerRepository = customerRepository;
        this.bookStallRepository = bookStallRepository;
        this.userRoleRepository = userRoleRepository;
    }


    //endpoint for user sign up - creates a user, validates a user and returns a token
    @PostMapping("/register-user")
    public ResponseEntity<AuthResponseDto> registerUser(@RequestBody RegisterUserDto registerUserDto){
        if(userRepository.existsByEmail(registerUserDto.getEmail())){
            return new ResponseEntity<>(new AuthResponseDto("Email already in use"), HttpStatus.BAD_REQUEST);
        }
        UserEntity user = new UserEntity();
        user.setEmail(registerUserDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerUserDto.getPassword()));

        Role role = roleRepository.findByName("CUSTOMER").get();
        user.setRole(Collections.singletonList(role));

        Customer customer = new Customer();
        customer.setEmail(registerUserDto.getEmail());
        customer.setName(registerUserDto.getName());

        userRepository.save(user);
        customerRepository.save(customer);

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        registerUserDto.getEmail(),
                        registerUserDto.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(authentication);

        return new ResponseEntity<>(new AuthResponseDto(token), HttpStatus.OK);
    }


    //endpoint for stall sign up - creates a stall, validates a stall and returns a token

    @PostMapping("/register-stall")
    public ResponseEntity<AuthResponseDto> registerStall(@RequestBody RegisterStallDto registerStallDto){
        if(userRepository.existsByEmail(registerStallDto.getEmail())){
            return new ResponseEntity<>(new AuthResponseDto("Email already in use"), HttpStatus.BAD_REQUEST);
        }
        UserEntity user = new UserEntity();
        user.setEmail(registerStallDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerStallDto.getPassword()));

        Role role = roleRepository.findByName("STALL").get();
        user.setRole(Collections.singletonList(role));

        BookStall bookStall = new BookStall();

        bookStall.setEmail(registerStallDto.getEmail());
        bookStall.setName(registerStallDto.getName());
        bookStall.setCity(registerStallDto.getCity());
        bookStall.setDistrict(registerStallDto.getDistrict());
        bookStall.setContact(registerStallDto.getPhone());
        bookStall.setAddress(registerStallDto.getAddress());

        userRepository.save(user);
        bookStallRepository.save(bookStall);

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        registerStallDto.getEmail(),
                        registerStallDto.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(authentication);

        return new ResponseEntity<>(new AuthResponseDto(token), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getEmail(),
                        loginDto.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(authentication);

        UserEntity user = userRepository.findByEmail(loginDto.getEmail()).orElseThrow();
        Long userId = user.getId();
        System.out.println(userId);
        Long roleId = userRoleRepository.findById(userId).orElseThrow().getRole_id();
        String role = roleRepository.findById(roleId).orElseThrow().getName();


        return new ResponseEntity<>(new AuthResponseDto(token, role), HttpStatus.OK);
    }

}
