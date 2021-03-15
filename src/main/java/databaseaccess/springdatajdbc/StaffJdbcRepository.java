package databaseaccess.springdatajdbc;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffJdbcRepository extends CrudRepository<Staff, Integer> {

    @Query("select * from basicjava.staff where firstName = :firstName")
    List<Staff> findByFirstName(@Param("firstName") String firstName);
}
