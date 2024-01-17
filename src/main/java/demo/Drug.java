package demo;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Drug {
    @Id
    private String uniqueID = UUID.randomUUID().toString();

    private String name;

    private String atc; //ATC è la classificazione del farmaco

    private String company;

    private String type;

    private String description;

    private String personSanitNumber;

    private Integer maxDose;
    private Integer minDose;

    private Integer dose;

    public Drug(String name, String atc, String company, String type, String description, String personSanitNumber, Integer dose, Integer minDose, Integer maxDose) {
        this.name = name;
        this.atc = atc;
        this.company = company;
        this.type = type;
        this.description = description;
        this.personSanitNumber = personSanitNumber;
        this.maxDose = maxDose;
        this.minDose = minDose;
        this.dose = dose;
    }

    public Drug() {}

    public String getUniqueID() {
        return uniqueID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAtc() {
        return atc;
    }

    public void setAtc(String atc) {
        this.atc = atc;
    }

    public Integer getMaxDose() {
        return maxDose;
    }

    public void setMaxDose(Integer maxDose) {
        this.maxDose = maxDose;
    }

    public Integer getMinDose() {
        return minDose;
    }

    public void setMinDose(Integer minDose) {
        this.minDose = minDose;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPersonSanitNumber() {
        return personSanitNumber;
    }

    public void setPersonSanitNumber(String person_sanitnumber) {
        this.personSanitNumber = person_sanitnumber;
    }

    public Integer getDose() {
        return dose;
    }

    public void setDose(Integer dose) {
        this.dose = dose;
    }

    @Override
    public String toString() {
        return "Drug{" +
                "uniqueID='" + uniqueID + '\'' +
                ", name='" + name + '\'' +
                ", atc='" + atc + '\'' +
                ", company='" + company + '\'' +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
