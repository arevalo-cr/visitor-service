package cr.co.arevalo.visitorservice.data;

import cr.co.arevalo.visitorservice.common.Visitor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitorRepository extends CrudRepository< Visitor, Long >
{
}