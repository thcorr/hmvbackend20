package com.fiap.hmvbackend20.Service;

import com.fiap.hmvbackend20.Entities.Drug;
import com.fiap.hmvbackend20.Entities.UserDetails;
import com.fiap.hmvbackend20.Repositories.UserDetailsRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    private UserDetailsRepository userDetailsRepository;

    public UserDetailsServiceImpl(UserDetailsRepository userDetailsRepository){
        this.userDetailsRepository = userDetailsRepository;
    }


    @Override
    public Page<UserDetails> findAllUserDetails(Pageable pageable) {
        return userDetailsRepository.findAll(pageable);
    }

    @Override
    public Optional<UserDetails> findUserDetailsById(Long userDetailsId) {
        return userDetailsRepository.findById(userDetailsId);
    }

    @Override
    public UserDetails create(UserDetails newUserDetails) {
        return userDetailsRepository.save(newUserDetails);
    }

    @Override
    public UserDetails update(Long userDetailsId, UserDetails newUserDetails) {
        UserDetails userDetailsInDb = userDetailsRepository.findById(userDetailsId).get();
        userDetailsInDb.setCpf(newUserDetails.getCpf());
        userDetailsInDb.setEmail(newUserDetails.getEmail());
        userDetailsInDb.setName(newUserDetails.getName());
        userDetailsInDb.setPassword(newUserDetails.getPassword());
        return userDetailsRepository.save(userDetailsInDb);
    }

    @Override
    public void deleteById(Long userDetailsId) {
        userDetailsRepository.deleteById(userDetailsId);

    }
}
