package TenderApplication.repository;

import TenderApplication.Domain.TenderHeadOffice;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by student on 2015/08/06.
 */
public interface TenderHeadRepo extends CrudRepository<TenderHeadOffice, Long> {
}
