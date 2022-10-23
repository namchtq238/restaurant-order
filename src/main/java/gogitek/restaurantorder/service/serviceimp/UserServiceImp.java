package gogitek.restaurantorder.service.serviceimp;

import gogitek.restaurantorder.constaint.Role;
import gogitek.restaurantorder.entity.User;
import gogitek.restaurantorder.modelutil.PasswordDTO;
import gogitek.restaurantorder.repository.UserRepo;
import gogitek.restaurantorder.security.CustomUserDetails;
import gogitek.restaurantorder.service.UserService;
import lombok.SneakyThrows;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImp implements UserService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImp(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @SneakyThrows
    @Override
    public boolean registerUser( User user) {
        if(checkExist(user.getEmail())) throw new Exception("Đã Tồn Tại Email");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.CUSTOMER);
        userRepo.save(user);
        return true;
    }

    @Override
    public boolean checkExist(String email) {
        for(String s : userRepo.getEmail()){
            if(email.equalsIgnoreCase(s)) return true;
        }
        return false;
    }

    @Override
    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        return userDetails.getUser();
    }

    @Override
    public void updateUser(int id, User userRequest) {
        //set trong db
        User user = userRepo.getById(id);
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setPhoneNumber(userRequest.getPhoneNumber());
        user.setAddress(userRequest.getAddress());
        //set security
        CustomUserDetails userDetails = new CustomUserDetails(user);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        List<GrantedAuthority> updatedAuthorities = new ArrayList<>(auth.getAuthorities());
        updatedAuthorities.add(new SimpleGrantedAuthority(user.getRole().getType()));
        Authentication newAuth = new UsernamePasswordAuthenticationToken(userDetails, auth.getCredentials(), updatedAuthorities);
        SecurityContextHolder.getContext().setAuthentication(newAuth);
        userRepo.save(user);
    }

    @Override
    public boolean updatePassword(PasswordDTO passwordDTO) {
        User user = getCurrentUser();
        if(passwordDTO.getNewPassword().equals(passwordDTO.getConfirmPassword())){
            if(passwordEncoder.matches(passwordDTO.getOldPassword(), user.getPassword())){
                user.setPassword(passwordEncoder.encode(passwordDTO.getNewPassword()));
                userRepo.save(user);
                return true;
            }
        }
        return false;
    }


}
