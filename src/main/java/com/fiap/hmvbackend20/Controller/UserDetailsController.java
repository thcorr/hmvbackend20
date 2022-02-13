package com.fiap.hmvbackend20.Controller;

import com.fiap.hmvbackend20.DTO.ExamTypeDTO;
import com.fiap.hmvbackend20.DTO.UserDetailsDTO;
import com.fiap.hmvbackend20.Entities.ExamType;
import com.fiap.hmvbackend20.Entities.UserDetails;
import com.fiap.hmvbackend20.Service.UserDetailsService;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Log4j2
@RestController
@RequestMapping("/api/v1/userdetails")
public class UserDetailsController {

    private UserDetailsService userDetailsService;

    public UserDetailsController(UserDetailsService userDetailsService){
        this.userDetailsService = userDetailsService;
    }

    @GetMapping
    public ResponseEntity<Object> getAllUsers(@PageableDefault(page = 0, size = 10, sort = "userId", direction = Sort.Direction.ASC) Pageable pageable){
        Page<UserDetails> userDetailsPage =  userDetailsService.findAllUserDetails(pageable);
        if(userDetailsPage.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No User details found.");
        }else{
            return ResponseEntity.status(HttpStatus.FOUND).body(userDetailsPage);
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable(name = "id") Long userTypeId){
        Optional<UserDetails> userDetailsInDb = userDetailsService.findUserDetailsById(userTypeId);

        if(!userDetailsInDb.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No user details found.");
        }else{
            return ResponseEntity.status(HttpStatus.FOUND).body(userDetailsInDb.get());
        }
    }

    @PostMapping
    public ResponseEntity<Object> createUser(@RequestBody UserDetailsDTO dto){

        try{
            UserDetails newUser = userDetailsService.create(dto.transform());
            return ResponseEntity.status(HttpStatus.CREATED).body(newUser);

        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + ex.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateUserById(@PathVariable(name = "id") Long userId,
                                                     @RequestBody UserDetailsDTO dto){
        try{
            Optional<UserDetails> userDetailsInDb = userDetailsService.findUserDetailsById(userId);
            if(userDetailsInDb.isPresent()){
                UserDetails updatedUserDetails = userDetailsService.update(userId, dto.transform());
                return ResponseEntity.status(HttpStatus.OK).body(updatedUserDetails);

            }else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
            }

        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + ex.getMessage());
        }

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteUserById(@PathVariable(name = "id") Long userId){
        try{
            Optional<UserDetails> userDetailsInDb = userDetailsService.findUserDetailsById(userId);
            if(userDetailsInDb.isPresent()){
                userDetailsService.deleteById(userId);
                return ResponseEntity.status(HttpStatus.OK).body("Deleted successfully: " + userDetailsInDb.get().getUserId());
            }
            else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
            }

        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + ex.getMessage());
        }
    }

}
