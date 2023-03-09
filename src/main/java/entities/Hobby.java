package entities;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Hobby")
public class Hobby {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Hobby_id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Column(name = "wikiLink", nullable = false, length = 1000)
    private String wikiLink;

    @Column(name = "category", nullable = false, length = 45)
    private String category;

    @Column(name = "type", nullable = false, length = 45)
    private String type;

    @ManyToMany(mappedBy = "hobbies")
    private Set<Person> persons = new LinkedHashSet<>();

    public Set<Person> getPersons() {
        return persons;
    }

    public void setPersons(Set<Person> persons) {
        this.persons = persons;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getWikiLink() {
        return wikiLink;
    }

    public void setWikiLink(String wikiLink) {
        this.wikiLink = wikiLink;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hobby hobby = (Hobby) o;
        return id != null && Objects.equals(id, hobby.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}