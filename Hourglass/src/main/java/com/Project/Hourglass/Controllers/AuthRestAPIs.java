package com.Project.Hourglass.Controllers;


import com.Project.Hourglass.Repositories.*;
import com.Project.Hourglass.message.request.LoginForm;
import com.Project.Hourglass.message.request.SignUpClientForm;
import com.Project.Hourglass.message.request.SignUpCoachForm;
import com.Project.Hourglass.message.request.SignUpForm;
import com.Project.Hourglass.message.response.JwtResponse;
import com.Project.Hourglass.message.response.ResponseMessage;
import com.Project.Hourglass.model.Client;
import com.Project.Hourglass.model.Coach;
import com.Project.Hourglass.model.Role;
import com.Project.Hourglass.model.User;
import com.Project.Hourglass.model.enumeration.RoleName;
import com.Project.Hourglass.security.jwt.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthRestAPIs {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    CoachRepository coachRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    AdministratorRepository administratorRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateJwtToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        return ResponseEntity.ok(
                new JwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities())
        );

    }


    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpForm signUpRequest) {

        if(userRepository.existsByUsername(signUpRequest.getUsername())) {
            return new ResponseEntity<>(new ResponseMessage("Fail -> Username is already taken!"), HttpStatus.BAD_REQUEST);
        }

        if(userRepository.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity<>(new ResponseMessage("Fail -> Email is already in use!"), HttpStatus.BAD_REQUEST);
        }

        // creating user account
        User user = new User(signUpRequest.getUsername(), signUpRequest.getEmail(), signUpRequest.getName(), signUpRequest.getLastname(),
                encoder.encode(signUpRequest.getPassword()));

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        strRoles.forEach(role -> {
            switch (role) {
                case "admin" :
                    Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
                            .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find.") );
                    roles.add(adminRole);

                    break;
                case "coach" :
                    Role coachRole = roleRepository.findByName(RoleName.ROLE_COACH)
                            .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
                    roles.add(coachRole);

                    break;
                default:
                    Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
                            .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
                    roles.add(userRole);
            }
        });
        user.setRoles(roles);
        userRepository.save(user);

        return new ResponseEntity<>(new ResponseMessage("User registered successfully!"), HttpStatus.OK);
    }



    @PostMapping("/signup/coach")
    public ResponseEntity<?> registerCoach(@Valid @RequestBody SignUpCoachForm signUpRequest) {
        if(coachRepository.existsByUsername(signUpRequest.getUsername())) {
            return new ResponseEntity<>(new ResponseMessage("Fail -> Username is already taken!"), HttpStatus.BAD_REQUEST);
        }

        if(coachRepository.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity<>(new ResponseMessage("Fail -> Email is already in use!"), HttpStatus.BAD_REQUEST);
        }

        // creating coach account
        Coach coach = new Coach(signUpRequest.getUsername(), signUpRequest.getEmail(), signUpRequest.getName(), signUpRequest.getLastname(),
                encoder.encode(signUpRequest.getPassword()), signUpRequest.getResume(), signUpRequest.getScore1(),
                signUpRequest.getScore2(), signUpRequest.getScore3(), signUpRequest.getScore4(), signUpRequest.getAge(),
                signUpRequest.getPhoto(), signUpRequest.getExperience(), signUpRequest.getSpeciality(), signUpRequest.getPhone());

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        strRoles.forEach(role -> {
            switch (role) {
                case "admin" :
                    Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
                            .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find.") );
                    roles.add(adminRole);

                    break;
                case "coach" :
                    Role coachRole = roleRepository.findByName(RoleName.ROLE_COACH)
                            .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
                    roles.add(coachRole);

                    break;
                default:
                    Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
                            .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
                    roles.add(userRole);
            }
        });
        coach.setRoles(roles);
        coachRepository.save(coach);

        return new ResponseEntity<>(new ResponseMessage("User registered successfully!"), HttpStatus.OK);
    }

    @PostMapping("/signup/client")
    public ResponseEntity<?> registerClient(@Valid @RequestBody SignUpClientForm signUpRequest) {
        if(clientRepository.existsByUsername(signUpRequest.getUsername())) {
            return new ResponseEntity<>(new ResponseMessage("Fail -> Username is already taken!"), HttpStatus.BAD_REQUEST);
        }

        if(clientRepository.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity<>(new ResponseMessage("Fail -> Email is already in use!"), HttpStatus.BAD_REQUEST);
        }

        // creating client account
        Client client = new Client(signUpRequest.getUsername(), signUpRequest.getEmail(), signUpRequest.getName(), signUpRequest.getLastname(),
                encoder.encode(signUpRequest.getPassword()), signUpRequest.getHeight(), signUpRequest.getCurrentWeight(),
                signUpRequest.getDesiredWeight(), signUpRequest.getFatDistribution(), signUpRequest.getFrame(), signUpRequest.getSilhouette(),
                signUpRequest.getSex(), signUpRequest.getAge(), signUpRequest.getPhoto());

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        strRoles.forEach(role -> {
            switch (role) {
                case "admin" :
                    Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
                            .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find.") );
                    roles.add(adminRole);

                    break;
                case "coach" :
                    Role coachRole = roleRepository.findByName(RoleName.ROLE_COACH)
                            .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
                    roles.add(coachRole);

                    break;
                default:
                    Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
                            .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
                    roles.add(userRole);
            }
        });
        client.setRoles(roles);
        clientRepository.save(client);

        return new ResponseEntity<>(new ResponseMessage("User registered successfully!"), HttpStatus.OK);
    }
}
