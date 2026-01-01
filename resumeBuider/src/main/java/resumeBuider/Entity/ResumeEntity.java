package resumeBuider.Entity;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*; // Use jakarta for Spring Boot 3+

import java.util.*;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import java.sql.Types;
import java.util.UUID;

@Entity
@Table(name = "resumes")
public class ResumeEntity {

    @Id
    @JdbcTypeCode(java.sql.Types.VARCHAR)
    @Column(length = 36)
    private UUID id;

    // Fixed Personal Fields
    private String fullName; // Maharudra Yadav
    private String email;    //
    private String phone;    // +91-9307229509
    private String address;  // Pune, Maharashtra, India, 411005 [cite: 2]
    // Dynamic Personal Links (Extra fields like GitHub, Portfolio, Linkedin)
    @ElementCollection(fetch = FetchType.EAGER) // Change from default LAZY to EAGER
    @CollectionTable(name = "resume_links", joinColumns = @JoinColumn(name = "resume_id"))
    @MapKeyColumn(name = "link_type")
    @Column(name = "url")
    private Map<String, String> personalLinks = new HashMap<>();

    // Getter
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "resume_additional_info", joinColumns = @JoinColumn(name = "resume_id"))
    @MapKeyColumn(name = "info_key") // e.g., "Certification" or "Language"
    @Column(name = "info_value")    // e.g., "AWS Certified Developer" or "English, Marathi"
    private Map<String, String> additionalInfo = new HashMap<>();

    // Getter and Setter
    public Map<String, String> getAdditionalInfo() { return additionalInfo; }
    public void setAdditionalInfo(Map<String, String> additionalInfo) { this.additionalInfo = additionalInfo; }

    @Column(columnDefinition = "TEXT")
    private String summary;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "resume_id")
    private List<EducationEntry> education;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "resume_id")
    private List<ProjectEntry> projects;
    @Column(name = "user_password")
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Map<String, String> getPersonalLinks() {
        return personalLinks;
    }

    public void setPersonalLinks(Map<String, String> personalLinks) {
        this.personalLinks = personalLinks;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public List<EducationEntry> getEducation() {
        return education;
    }

    public void setEducation(List<EducationEntry> education) {
        this.education = education;
    }

    public List<ProjectEntry> getProjects() {
        return projects;
    }

    public void setProjects(List<ProjectEntry> projects) {
        this.projects = projects;
    }
// Standard Getters and Setters...
}