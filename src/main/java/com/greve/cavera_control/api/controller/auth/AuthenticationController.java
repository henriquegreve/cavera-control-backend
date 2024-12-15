package com.greve.cavera_control.api.controller.auth;

import com.greve.cavera_control.api.dto.auth.AuthenticationDTO;
import com.greve.cavera_control.api.dto.auth.LoginResponseDTO;
import com.greve.cavera_control.api.dto.auth.UserDTO;
import com.greve.cavera_control.exception.BusinessException;
import com.greve.cavera_control.model.User;
import com.greve.cavera_control.repository.UserRepository;
import com.greve.cavera_control.security.config.TokenService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.greve.cavera_control.util.EntityConverter.convertToDTO;
import static com.greve.cavera_control.util.EntityConverter.convertToEntity;

@RestController
@RequiredArgsConstructor
@RequestMapping("/authenticate")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> authenticate(@RequestBody @Valid AuthenticationDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.getUsername(), data.getPassword());
        var auth = authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((User) auth.getPrincipal());
        var username = tokenService.validateToken(token);
        return ResponseEntity.ok(new LoginResponseDTO(username, token));
    }

    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@RequestBody @Valid UserDTO data) {
        if (userRepository.findByUsername(data.getUsername()) != null) throw new BusinessException("Username já está sendo utilizado.");
        if (userRepository.findByEmail(data.getEmail()).isPresent()) throw new BusinessException("Email já sendo utilizado.");

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.getPassword());
        User user = convertToEntity(data, User.class);
        user.setPassword(encryptedPassword);
        User savedUser = userRepository.save(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(convertToDTO(savedUser, UserDTO.class));
    }

}
