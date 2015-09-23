package TenderApplication.repository;

import TenderApplication.Domain.Users;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by student on 2015/08/06.
 */
public interface UserRepo extends CrudRepository <Users , Long> {
}
