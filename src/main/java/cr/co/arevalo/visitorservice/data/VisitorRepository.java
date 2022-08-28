package cr.co.arevalo.visitorservice.data;

import cr.co.arevalo.app.common.Visitor;
import org.springframework.data.repository.CrudRepository;

public interface VisitorRepository extends CrudRepository< Visitor, Long >
{
}