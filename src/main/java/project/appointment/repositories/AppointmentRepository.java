package project.appointment.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import project.appointment.entities.Appointment;

import java.util.List;

public interface AppointmentRepository extends MongoRepository<Appointment, String> {

    List<Appointment> findBy_id(ObjectId _id);

    List<Appointment> findByUser(String user);

    //findByStatusCodeNot(String statusCode);
    //findFirstOrderByCounter
    //List<Person> findByNameAndNickname(String name, String nickname);

    //@Query("{'address.state' : ?0}")
    //List<Person> findByState(String state);

}
