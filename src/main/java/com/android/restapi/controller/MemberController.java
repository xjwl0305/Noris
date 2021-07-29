package com.android.restapi.controller;

import com.android.restapi.model.*;
//import com.android.restapi.repository.BankRepository;
import com.android.restapi.repository.MemberRepository;
//import com.android.restapi.repository.PostRepository;
//import com.android.restapi.repository.ReserveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.websocket.Session;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequestMapping("/NorisAPI")
@CrossOrigin("*")
@RestController
public class MemberController {

    @Autowired
    public MemberRepository memberRepository;


    @RequestMapping("/login")
    public login_response login(@RequestParam(name="id") String ID, @RequestParam(name="password") String Password){
        List<user> login = memberRepository.findUser(ID, Password);
        login_response response = new login_response();
        if(login.size() > 0) {
            response.setStatus("success");
            response.setName(login.get(0).getName());
            response.setEmail(login.get(0).getEmail());
            response.setPhone(login.get(0).getPhone());
            response.setCompany(login.get(0).getCompany());
            return response;
        }else{
            response.setStatus("failed");
            return response;
        }
    }
    @RequestMapping("/checkID")
    public response checkID(@RequestParam(name="id") String ID){
        List<user> find = memberRepository.checkID(ID);
        response res = new response();
        if(find.size() > 0) {
            res.setStatus("failed");
            return res;
        }else{
            res.setStatus("success");
            return res;
        }
    }
}
