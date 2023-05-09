package project.registration.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import project.registration.entities.Registration;

import java.util.List;

public interface RegistrationRepository extends MongoRepository<Registration, String> {

    List<Registration> findBy_id(ObjectId _id);

    List<Registration> findByUser(String user);

    //findByStatusCodeNot(String statusCode);
    //findFirstOrderByCounter
    //List<Person> findByNameAndNickname(String name, String nickname);

    //@Query("{'address.state' : ?0}")
    //List<Person> findByState(String state);

}
