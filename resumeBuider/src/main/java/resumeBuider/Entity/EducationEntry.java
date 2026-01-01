package resumeBuider.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "education_entries")
public class EducationEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String level;       // Graduation, 12th, or 10th [cite: 21]
    private String institution; // e.g., Dr. Babasaheb Ambedkar Technical University [cite: 21]
    private String degree;      // Bachelor of Engineering in Computer Science [cite: 21]
    private String score;       // CGPA: 8.39 [cite: 21]
    private String year;        // 2019-2023 [cite: 25]

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}