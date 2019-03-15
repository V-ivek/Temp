package com.amdtelecom.facebookmessenger.facebookmessengerservices.controllers;

import com.amdtelecom.facebookmessenger.facebookmessengerservices.interfaces.PrincipalService;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.models.MessengerServicePrincipal;
import com.amdtelecom.facebookmessenger.facebookmessengerservices.util.Utility;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Clock;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PrincipalController {
    @Autowired
    private PrincipalService principalService;

    @PostMapping(value="/facebook/principal" ,produces="application/json")
    public ResponseEntity createPrincipal(@RequestHeader("platformId") String platformId, @RequestBody String request){
        Map<String, String> metadata = Utility.convertJsonToMap(request, "metadata");
        MessengerServicePrincipal principal = principalService.createPrincipal(platformId, metadata);
        MessengerServicePrincipal response = new MessengerServicePrincipal(principal.getPrincipalId(),metadata);
        String res = Utility.convertBeanToJson(response);
        return new ResponseEntity(res, HttpStatus.OK);
    }

    @GetMapping(value="/facebook/principal",produces="application/json")
    public  ResponseEntity getPrincipals(@RequestHeader("platformId") String platformId){
        List<MessengerServicePrincipal> principals = principalService.getPrincipals(platformId);
        JSONObject response = new JSONObject();
        response.put("principals",principals);
        return new ResponseEntity(response.toString(),HttpStatus.OK);
    }

    @GetMapping(value="/facebook/principal/{principalId}",produces="application/json")
    public  MessengerServicePrincipal getSpecificPrincipal(@PathVariable("principalId") String principalId){
        System.out.println(principalId);
        MessengerServicePrincipal principal = principalService.getSpecificPrincipal(principalId);
        return principal;
    }
}
