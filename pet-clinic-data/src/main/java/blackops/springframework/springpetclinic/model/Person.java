package blackops.springframework.springpetclinic.model;

import lombok.NoArgsConstructor;

import javax.persistence.MappedSuperclass;

@NoArgsConstructor
@MappedSuperclass
public class Person extends BaseEntity {
    private String firstName;
    private String lastName;

    public Person(Long id, String firstName, String lastName) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
