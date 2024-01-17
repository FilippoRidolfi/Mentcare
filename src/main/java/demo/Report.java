package demo;

import org.hibernate.exception.DataException;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;
@Entity
public class Report {
    @Id
    private String uniqueID = UUID.randomUUID().toString();

    private String drugName;
    private String personSanityCardNumber;

    private String description;

    private Date data;

    public Report(String drugName, String personSanityCardNumber, String description, Date data) {
        this.drugName = drugName;
        this.personSanityCardNumber = personSanityCardNumber;
        this.description = description;
        this.data = data;
    }

    public Report() {}

    public String getUniqueID() {
        return uniqueID;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getPersonSanityCardNumber() {
        return personSanityCardNumber;
    }

    public void setPersonSanityCardNumber(String personSanityCardNumber) {
        this.personSanityCardNumber = personSanityCardNumber;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
