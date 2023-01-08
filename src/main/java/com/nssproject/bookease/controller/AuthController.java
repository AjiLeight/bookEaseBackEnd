package com.nssproject.bookease.controller;

import com.nssproject.bookease.dto.AuthResponseDto;
import com.nssproject.bookease.dto.LoginDto;
import com.nssproject.bookease.dto.RegisterStallDto;
import com.nssproject.bookease.dto.RegisterUserDto;
import com.nssproject.bookease.entity.BookStall;
import com.nssproject.bookease.entity.Customer;
import com.nssproject.bookease.entity.Role;
import com.nssproject.bookease.entity.UserEntity;
import com.nssproject.bookease.repository.BookStallRepository;
import com.nssproject.bookease.repository.CustomerRepository;
import com.nssproject.bookease.repository.RoleRepository;
import com.nssproject.bookease.repository.UserRepository;
import com.nssproject.bookease.security.JwtGenerator;
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
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;
    private JwtGenerator jwtGenerator;
    private final CustomerRepository customerRepository;
    private final BookStallRepository bookStallRepository;

    @Autowired
    public AuthController(UserRepository userRepository,
                          RoleRepository roleRepository,
                          PasswordEncoder passwordEncoder,
                          AuthenticationManager authenticationManager,
                          JwtGenerator jwtGenerator,
                          CustomerRepository customerRepository,
                          BookStallRepository bookStallRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtGenerator = jwtGenerator;
        this.customerRepository = customerRepository;
        this.bookStallRepository = bookStallRepository;
    }

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

        return new ResponseEntity<>(new AuthResponseDto(token), HttpStatus.OK);
    }

}
