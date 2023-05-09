package project.registration.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "registration")
public class Registration {

    @Id
    private ObjectId _id;

    private String basic_forename;
    private String basic_surname;
    private String basic_dob;
    private String basic_height;
    private String basic_weight;
    private String basic_nhsnumber;
    private String basic_country;
    private String basic_gender;
    private String basic_address;
    private String basic_postcode;
    private String basic_email;

    private String health_suffered;
    private String health_suffereddetails;
    private String health_operations;
    private String health_TB;
    private String health_TBCountry;
    private String health_smoke;
    private String health_drink;
    private String health_disability;
    private String health_disabilitydetails;
    private String health_allergy;
    private String health_allergydetails;
    private String health_medication;
    private String health_medicationdetails;
    private String health_exercise;

    private String family_illnesss;
    private String family_illnesssdetails;
    private String family_carer;
    private String family_carerdetails;

    private String profiling_englishspoken;
    private String profiling_englishwritten;
    private String profiling_englishfirst;
    private String profiling_religion;
    private String profiling_ethnicgroup;

    private String gp_borough;
    private String gp_primary;
    private String gp_secondary;

    private String consent_resident;
    private String consent_eea;
    private String consent_prc;
    private String consent_sms;
    private String consent_email;

    private String user;
    private String status;

    @CreatedDate
    @Column(updatable = false)
    public LocalDateTime createdDate;
    @LastModifiedDate
    public LocalDateTime lastModifiedDate;
    //private Date createdDate = new Date();

    // ObjectId needs to be converted to string
    public String get_id() { return _id.toHexString(); }
    public void set_id(ObjectId _id) { this._id = _id; }
}
