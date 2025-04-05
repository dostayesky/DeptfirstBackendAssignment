//package com.bright.assignment_backend.configuration;
//
//import com.bright.assignment_backend.entity.User;
//import com.bright.assignment_backend.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//public class CustomUserDetailService implements UserDetailsService {
//    @Autowired
//    private UserRepository userRepo;
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        User user = userRepo.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));;
//        if(user == null){
//            System.out.println("User Not Found");
//            throw new UsernameNotFoundException("user not found");
//        }
//        return new CustomUserDetail(user);
//    }
//}
