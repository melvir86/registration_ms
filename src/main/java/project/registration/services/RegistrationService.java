package project.registration.services;

import lombok.extern.slf4j.Slf4j;
import project.registration.entities.Registration;
import project.registration.repositories.RegistrationRepository;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository RegistrationRepository;

    public RegistrationService(RegistrationRepository RegistrationRepository) {
        this.RegistrationRepository = RegistrationRepository;
    }

    //Retrieve all Registrations
    public List<Registration> getAllRegistrations() {
        return RegistrationRepository.findAll();
    }
 
    //Retrieve 1 Registration
     public Registration getRegistration(String id) {
 
         return RegistrationRepository.findById(id).get();
     }

    //Creates a Registration
     public Registration saveRegistration(Registration Registration) {

        return RegistrationRepository.save(Registration);
     }

    //Updares an existing Registration
    public Registration updateRegistration(String id, Registration Registration) {
        
        Registration existRegistration = getRegistration(id);
        existRegistration.setBasic_forename(Registration.getBasic_forename());
        existRegistration.setBasic_surname(Registration.getBasic_surname());
        existRegistration.setBasic_dob(Registration.getBasic_dob());
        existRegistration.setBasic_height(Registration.getBasic_height());
        existRegistration.setBasic_weight(Registration.getBasic_weight());
        existRegistration.setBasic_nhsnumber(Registration.getBasic_nhsnumber());
        existRegistration.setBasic_country(Registration.getBasic_country());
        existRegistration.setBasic_gender(Registration.getBasic_gender());
        existRegistration.setBasic_address(Registration.getBasic_address());
        existRegistration.setBasic_postcode(Registration.getBasic_postcode());
        existRegistration.setBasic_email(Registration.getBasic_email());

        existRegistration.setHealth_suffered(Registration.getHealth_suffered());
        existRegistration.setHealth_suffereddetails(Registration.getHealth_suffereddetails());
        existRegistration.setHealth_operations(Registration.getHealth_operations());
        existRegistration.setHealth_TB(Registration.getHealth_TB());
        existRegistration.setHealth_TBCountry(Registration.getHealth_TBCountry());
        existRegistration.setHealth_smoke(Registration.getHealth_smoke());
        existRegistration.setHealth_drink(Registration.getHealth_drink());
        existRegistration.setHealth_disability(Registration.getHealth_disability());
        existRegistration.setHealth_disabilitydetails(Registration.getHealth_disabilitydetails());
        existRegistration.setHealth_allergy(Registration.getHealth_allergy());
        existRegistration.setHealth_allergydetails(Registration.getHealth_allergydetails());

        existRegistration.setHealth_medication(Registration.getHealth_medication());
        existRegistration.setHealth_medicationdetails(Registration.getHealth_medicationdetails());
        existRegistration.setHealth_exercise(Registration.getHealth_exercise());

        existRegistration.setFamily_illnesss(Registration.getFamily_illnesss());
        existRegistration.setFamily_illnesssdetails(Registration.getFamily_illnesssdetails());
        existRegistration.setFamily_carer(Registration.getFamily_carer());
        existRegistration.setFamily_carerdetails(Registration.getFamily_carerdetails());

        existRegistration.setProfiling_englishspoken(Registration.getProfiling_englishspoken());
        existRegistration.setProfiling_englishwritten(Registration.getProfiling_englishwritten());
        existRegistration.setProfiling_englishfirst(Registration.getProfiling_englishfirst());
        existRegistration.setProfiling_religion(Registration.getProfiling_religion());
        existRegistration.setProfiling_ethnicgroup(Registration.getProfiling_ethnicgroup());

        existRegistration.setGp_borough(Registration.getGp_borough());
        existRegistration.setGp_primary(Registration.getGp_primary());
        existRegistration.setGp_secondary(Registration.getGp_secondary());

        existRegistration.setConsent_resident(Registration.getConsent_resident());
        existRegistration.setConsent_eea(Registration.getConsent_eea());
        existRegistration.setConsent_prc(Registration.getConsent_prc());
        existRegistration.setConsent_sms(Registration.getConsent_sms());
        existRegistration.setConsent_email(Registration.getConsent_email());

        existRegistration.setStatus(Registration.getStatus());
        existRegistration.setGp_comments(Registration.getGp_comments());

        existRegistration.setLastModifiedDate(Registration.getLastModifiedDate());
        RegistrationRepository.save(existRegistration);
        return existRegistration;
    }
 
    //Retrieve Registration by User
    public List<Registration> getRegistrationByUser(String user) {
    
        List<Registration> registrationList = RegistrationRepository.findByUser(user);
        return registrationList;
    }

    //Retrieve Registration by Id
    public List<Registration> getFeedbackByObjectId(ObjectId id) {

        List<Registration> registrationList = RegistrationRepository.findBy_id(id);
        return registrationList;
    }

    //Delete a Registration
     public void deleteRegistration(String id) {
 
        RegistrationRepository.deleteById(id);
     }

    //Retrieve Registration by Id
    public List<Registration> getRegistrationByObjectId(ObjectId id) {

        List<Registration> Registration = RegistrationRepository.findBy_id(id);
        return Registration;
    }

}
