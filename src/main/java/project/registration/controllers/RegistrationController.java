package project.registration.controllers;


import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import project.registration.entities.Registration;
import project.registration.services.RegistrationService;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Log
@RestController
@CrossOrigin
@RequestMapping(value = "/api/v1")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @GetMapping("/Registrations")
    public List<Registration> getregistrations(@RequestParam(required = false) String type) throws Exception {

        log.info("Received request to retrieve all registration or registration by type : " + type);

        return registrationService.getAllRegistrations();
    }

    @GetMapping(value = "/Registrations/{id}")
    public List<Registration> getRegistrationBy_Id(@PathVariable ObjectId id) throws Exception {

        List<Registration> registrationList = registrationService.getRegistrationByObjectId(id);

        return registrationList;
    }
     
    @PostMapping("/Registrations")
    public ResponseEntity<Registration> saveregistration(@RequestBody Registration registration) {
        try {
            return new ResponseEntity<Registration>(registrationService.saveRegistration(registration), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<Registration>(HttpStatus.BAD_REQUEST);
        }
    }
    

    @PutMapping("/Registrations/{id}")
    public ResponseEntity<Registration> updateregistration(@RequestBody Registration registration, @PathVariable String id) {
        try {
            Registration updatedregistration = registrationService.updateRegistration(id, registration);
            return new ResponseEntity<Registration>(updatedregistration, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Registration>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/Registrations/{id}")
    public ResponseEntity<Registration> deleteRegistration(@PathVariable String id) {
        try {
            registrationService.deleteRegistration(id);
            return new ResponseEntity<Registration>(HttpStatus.OK);
            //return new ResponseEntity<String>("You have successfully deleted a registration with an id of: " + id, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /* 
    @GetMapping(value = "/registrations/{admin}")
    public List<Registration> getregistrationBy_Admin(@PathVariable String admin) throws Exception {

        //log.info("Received request to retrieve registration with admin = ");
        List<Registration> registrationList = registrationService.getRegistrationByAdmin(admin);

        return registrationList;
    }
    */

    @GetMapping(value = "/Registrations/user")
    public List<Registration> getregistrationByUser(@RequestParam(required = false) String user) throws Exception {

        log.info("Received request to retrieve registration by user = " + user);
        List<Registration> registrationList = registrationService.getRegistrationByUser(user);

        return registrationList;
    }

    @GetMapping(value = "/Registrations/registered/user")
    public List<Registration> getregistrationByUserAndStatus(@RequestParam(required = false) String user) throws Exception {

        log.info("Received request to retrieve registration by user and status = " + user);
        List<Registration> registrationList = registrationService.getRegistrationByUserAndStatus(user, "Registered");

        return registrationList;
    }

    @GetMapping(value = "/Registrations/gp_primary")
    public List<Registration> getregistrationByGpPrimary(@RequestParam(required = false) String gp_primary) throws Exception {

        log.info("Received request to retrieve registration by gpprimary = " + gp_primary);
        List<Registration> registrationList = registrationService.getRegistrationByPrimaryGP(gp_primary);

        return registrationList;
    }
    
    /*
    @GetMapping(value = "/registrations/search")
    public List<registration> searchregistration(@RequestParam(required = false) String keyword) throws Exception {

        log.info("Received request to retrieve registration containing keyword = " + keyword);
        List<registration> registrationList = registrationService.getregistrationByregistrationContains(keyword);

        return registrationList;
    }
    */

}
