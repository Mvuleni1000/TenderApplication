package TenderApplication.repository;

import TenderApplication.Domain.Contracts;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by student on 2015/08/06.
 */
public interface ContractRepo extends CrudRepository<Contracts, Long> {
}
