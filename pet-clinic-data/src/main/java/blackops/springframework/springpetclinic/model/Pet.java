package blackops.springframework.springpetclinic.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Entity
@Table(name = "pets")
public class Pet extends BaseEntity {
  private String name;

  public Pet(Long id, String name, PetType petType, Owner owner, LocalDate birthDate, Set<Visit> visits) {
    super(id);
    this.name = name;
    this.petType = petType;
    this.owner = owner;
    this.birthDate = birthDate;
    this.visits = visits;
  }

  @ManyToOne
  @JoinColumn(name = "type_id")
  private PetType petType;
  @ManyToOne
  @JoinColumn(name = "owner_id")
  private Owner owner;
  private LocalDate birthDate;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
  private Set<Visit> visits = new HashSet<>();

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public PetType getPetType() {
    return petType;
  }

  public void setPetType(PetType petType) {
    this.petType = petType;
  }

  public Owner getOwner() {
    return owner;
  }

  public void setOwner(Owner owner) {
    this.owner = owner;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
  }

  public Set<Visit> getVisits() {
    return visits;
  }

  public void setVisits(Set<Visit> visits) {
    this.visits = visits;
  }
}
