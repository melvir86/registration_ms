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
