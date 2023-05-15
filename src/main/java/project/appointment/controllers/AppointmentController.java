package project.appointment.controllers;


import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import project.appointment.entities.Appointment;
import project.appointment.services.AppointmentService;

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
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping("/Appointments")
    public List<Appointment> getAppointments(@RequestParam(required = false) String type) throws Exception {

        log.info("Received request to retrieve all Appointment or Appointment by type : " + type);

        return appointmentService.getAllAppointments();
    }

    @GetMapping(value = "/Appointments/{id}")
    public List<Appointment> getAppointmentBy_Id(@PathVariable ObjectId id) throws Exception {

        List<Appointment> AppointmentList = appointmentService.getAppointmentByObjectId(id);

        return AppointmentList;
    }
     
    @PostMapping("/Appointments")
    public ResponseEntity<Appointment> saveAppointment(@RequestBody Appointment Appointment) {
        try {
            return new ResponseEntity<Appointment>(appointmentService.saveAppointment(Appointment), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<Appointment>(HttpStatus.BAD_REQUEST);
        }
    }
    

    @PutMapping("/Appointments/{id}")
    public ResponseEntity<Appointment> updateAppointment(@RequestBody Appointment Appointment, @PathVariable String id) {
        try {
            Appointment updatedAppointment = appointmentService.updateAppointment(id, Appointment);
            return new ResponseEntity<Appointment>(updatedAppointment, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Appointment>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/Appointments/{id}")
    public ResponseEntity<Appointment> deleteAppointment(@PathVariable String id) {
        try {
            appointmentService.deleteAppointment(id);
            return new ResponseEntity<Appointment>(HttpStatus.OK);
            //return new ResponseEntity<String>("You have successfully deleted a Appointment with an id of: " + id, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /* 
    @GetMapping(value = "/Appointments/{admin}")
    public List<Appointment> getAppointmentBy_Admin(@PathVariable String admin) throws Exception {

        //log.info("Received request to retrieve Appointment with admin = ");
        List<Appointment> AppointmentList = AppointmentService.getAppointmentByAdmin(admin);

        return AppointmentList;
    }
    */

    @GetMapping(value = "/Appointments/user")
    public List<Appointment> getAppointmentByUser(@RequestParam(required = false) String user) throws Exception {

        log.info("Received request to retrieve Appointment by user = " + user);
        List<Appointment> AppointmentList = appointmentService.getAppointmentByUser(user);

        return AppointmentList;
    }
    
    /*
    @GetMapping(value = "/Appointments/search")
    public List<Appointment> searchAppointment(@RequestParam(required = false) String keyword) throws Exception {

        log.info("Received request to retrieve Appointment containing keyword = " + keyword);
        List<Appointment> AppointmentList = AppointmentService.getAppointmentByAppointmentContains(keyword);

        return AppointmentList;
    }
    */

}
