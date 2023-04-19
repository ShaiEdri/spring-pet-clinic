package blackops.springframework.springpetclinic.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Entity
@Table(name = "vets")
public class Vet extends Person{
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "vet_specialities", joinColumns = @JoinColumn(name = "vet_id"),
                inverseJoinColumns = @JoinColumn(name = "speciality_id"))
    private Set<Speciality> specialities = new HashSet<>();

    public Set<Speciality> getSpecialities() {
        return specialities;
    }

    public Vet(Long id, String firstName, String lastName, Set<Speciality> specialities) {
        super(id, firstName, lastName);
        this.specialities = specialities;
    }

    public void setSpecialities(Set<Speciality> specialities) {
        this.specialities = specialities;
    }
}
