package com.example.cineflix_api.security;

import com.example.cineflix_api.entity.RoleUser;
import com.example.cineflix_api.entity.Users;
import com.example.cineflix_api.service.RoleUserServiceImp;
import com.example.cineflix_api.service.UsersServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UsersServiceImp usersServiceImp;

    @Autowired
    RoleUserServiceImp roleUserServiceImp;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        List<SimpleGrantedAuthority> roles = new ArrayList<SimpleGrantedAuthority>();
//        SimpleGrantedAuthority roleAdmin = new SimpleGrantedAuthority("ROLE_USER");
//        roles.add(roleAdmin);
//
//        Users users = userServiceImp.findByUserName(username);
////        Cách 1
////        List<RoleUser> listRoleUser = roleUserServiceImp.getRoleByUserId(users.getId());
////        List<Map<String, ?>> listRole = roleUserServiceImp.getRoleByUserId(username);
////        for(Map<String, ?> map :listRole){
////            System.out.println("check role: " + map.get("role_name"));
////            roles.add(roleAdmin);
////        }
//
////        User user = new User(users.getUsername(),
////                users.getPassword(), roles);
//
////        List<RoleUser> listRole = roleUserServiceImp.getRoleByUserId(String.valueOf(users.getId()));
//        return null;

        // TODO Auto-generated method stub

        List<SimpleGrantedAuthority> roles = new ArrayList<SimpleGrantedAuthority>();


        Users users = usersServiceImp.findByUsername(username);
        //cách 1
//		List<Map<String, ?>> listRole = roleUserServiceImp.getAllRoleByUserName(username);
//
//		for (Map<String, ?> map : listRole) {
//			SimpleGrantedAuthority role = new SimpleGrantedAuthority((String) map.get("name"));
//			roles.add(role);
//		}
        //cách 2
        List<RoleUser> listRole = roleUserServiceImp.getAllByUserId(users.getId());
        System.out.println("số role: " + listRole.size());
        for (RoleUser roleUser : listRole) {
            System.out.println("Kiểm tra: " + roleUser.getRoles().getRoleName());
            SimpleGrantedAuthority role = new SimpleGrantedAuthority(roleUser.getRoles().getRoleName());
            roles.add(role);
        }

//        // cách 3
//        for(RoleUser roleUser : users.getRoleUser()){
//            System.out.println("Kiểm tra: " + roleUser.getRoles().getRoleName());
//            SimpleGrantedAuthority role = new SimpleGrantedAuthority(roleUser.getRoles().getRoleName());
//            roles.add(role);
//        }
        User user = new User(users.getUsername(), users.getPassword(), roles);
        return user;
    }
}
