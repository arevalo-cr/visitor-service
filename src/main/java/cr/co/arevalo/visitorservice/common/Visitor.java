package cr.co.arevalo.visitorservice.common;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table( name = "visitor", schema = "arevalo" )
public class Visitor
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String description;

    public Visitor()
    {
    }

    public Visitor( String firstName, String lastName, String description )
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = description;
    }

    @Override
    public boolean equals( Object o )
    {
        if ( this == o ) return true;
        if ( o == null || getClass() != o.getClass() ) return false;
        Visitor visitor = ( Visitor ) o;
        return Objects.equals( id, visitor.id ) &&
                Objects.equals( firstName, visitor.firstName ) &&
                Objects.equals( lastName, visitor.lastName ) &&
                Objects.equals( description, visitor.description );
    }

    @Override
    public int hashCode()
    {

        return Objects.hash( id, firstName, lastName, description );
    }

    public Long getId()
    {
        return id;
    }

    public void setId( Long id )
    {
        this.id = id;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName( String firstName )
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName( String lastName )
    {
        this.lastName = lastName;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription( String description )
    {
        this.description = description;
    }

    @Override
    public String toString()
    {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
