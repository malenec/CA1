package dtos;

import entities.Hobby;

import java.util.LinkedHashSet;
import java.util.Set;

public class HobbyDTO {
    private Long hobbyId;
    private String hobbyName;
    private String wikiLink;
    private String category;
    private String type;

    private Set<Long> personIds = new LinkedHashSet<>();

    public HobbyDTO(Hobby hobby) {
        this.hobbyId = hobby.getId();
        this.hobbyName = hobby.getName();
        this.wikiLink = hobby.getWikiLink();
        this.category = hobby.getCategory();
        this.type = hobby.getType();
        hobby.getPeople().forEach(person -> this.personIds.add(person.getId()));
    }

    public HobbyDTO(String hobbyName, String wikiLink, String category, String type) {
        this.hobbyName = hobbyName;
        this.wikiLink = wikiLink;
        this.category = category;
        this.type = type;
    }

    public Long getHobbyId() {
        return hobbyId;
    }

    public void setHobbyId(Long hobbyId) {
        this.hobbyId = hobbyId;
    }

    public String getHobbyName() {
        return hobbyName;
    }

    public void setHobbyName(String hobbyName) {
        this.hobbyName = hobbyName;
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

    public Set<Long> getPersonIds() {
        return personIds;
    }

    public void setPersonIds(Set<Long> personIds) {
        this.personIds = personIds;
    }

    @Override
    public String toString() {
        return "HobbyDTO{" +
                "hobbyId=" + hobbyId +
                ", hobbyName='" + hobbyName + '\'' +
                ", wikiLink='" + wikiLink + '\'' +
                ", category='" + category + '\'' +
                ", type='" + type + '\'' +
                ", personIds=" + personIds +
                '}';
    }
}
