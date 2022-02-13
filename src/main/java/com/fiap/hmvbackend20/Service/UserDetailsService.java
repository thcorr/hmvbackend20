package com.fiap.hmvbackend20.Service;

import com.fiap.hmvbackend20.Entities.UserDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UserDetailsService {

    Page<UserDetails> findAllUserDetails(Pageable pageable);
    Optional<UserDetails> findUserDetailsById(Long userDetailsId);
    UserDetails create(UserDetails newUserDetails);
    UserDetails update(Long userDetailsId, UserDetails newUserDetails);
    void deleteById(Long userDetailsId);

}
