package com.example.e_commerce_be.controller;

import com.example.e_commerce_be.config.jwt.JwtUtils;
import com.example.e_commerce_be.dto.AccountToken;
import com.example.e_commerce_be.entity.Account;
import com.example.e_commerce_be.entity.ERole;
import com.example.e_commerce_be.entity.Role;
import com.example.e_commerce_be.payload.request.LoginRequest;
import com.example.e_commerce_be.payload.request.SignupRequest;
import com.example.e_commerce_be.payload.response.JwtResponse;
import com.example.e_commerce_be.payload.response.MessageResponse;
import com.example.e_commerce_be.repository.AccountRepository;
import com.example.e_commerce_be.repository.RoleRepository;
import com.example.e_commerce_be.service.serviceImpl.UserDetailsImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/accounts")
public class LoginController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (accountRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }
        if (accountRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }
        Account user = new Account(signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;
                    default:
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }
        user.setRoles(roles);
        accountRepository.save(user);
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());
        Optional<Account> account = accountRepository.findByUsername(loginRequest.getUsername());
        AccountToken accountToken = new AccountToken();
        if (account != null) {
            accountToken.setId(account.get().getId());
            accountToken.setUsername(account.get().getUsername());
            accountToken.setFirstname(account.get().getFirstname());
            accountToken.setLastname(account.get().getLastname());
            accountToken.setAddress(account.get().getAddress());
            accountToken.setProvince(account.get().getProvince());
            accountToken.setDistrict(account.get().getDistrict());
            accountToken.setWard(account.get().getWard());
            accountToken.setEmail(account.get().getEmail());
            accountToken.setPhone(account.get().getPhone());
            accountToken.setAvatar(account.get().getAvatar());
            accountToken.setWallet(account.get().getWallet());
            accountToken.setStatus(account.get().getStatus());
            accountToken.setToken(jwt);
            accountToken.setRoles(roles);
            return ResponseEntity.ok(accountToken);

        }
        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles));

    }
    @PostMapping("/fail")
    public String checkUser(@RequestBody Account user) { // login fail
        return checkErr(user);
    }

    public String checkErr(Account user) {
        String err = "";
        if (accountRepository.findByUsername(user.getUsername()).isPresent()) {
            if (accountRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword()).isEmpty()) {
                err = "wrong password";
            }
        } else {
            err = "wrong username";
        }
        return err;
    }


}
