package entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
public class Hobby {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hobby_id", nullable = false)
    private Long id;

    @Size(max = 45)
    @NotNull
    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Size(max = 1000)
    @NotNull
    @Column(name = "wikiLink", nullable = false, length = 1000)
    private String wikiLink;

    @Size(max = 45)
    @NotNull
    @Column(name = "category", nullable = false, length = 45)
    private String category;

    @Size(max = 45)
    @NotNull
    @Column(name = "type", nullable = false, length = 45)
    private String type;

    @ManyToMany
    @JoinTable(name = "Hobby_Person",
            joinColumns = @JoinColumn(name = "hobby_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id"))
    private Set<Person> people = new LinkedHashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWikiLink() {
        return wikiLink;
    }

    public void setWikiLink(String wikiLink) {
        this.wikiLink = wikiLink;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<Person> getPeople() {
        return people;
    }

    public void setPeople(Set<Person> people) {
        this.people = people;
    }

}