package resumeBuider.Entity;


import jakarta.persistence.*;

@Entity
@Table(name = "project_entries")
public class ProjectEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;        // e.g., "WovvRA" or "IPOS" [cite: 23, 24]

    @Column(columnDefinition = "TEXT")
    private String description; // e.g., "Built Revenue Assurance system..." [cite: 26]

    private String technologies; // e.g., "Java, Spring Boot, MySQL, Redis"

    public ProjectEntry() {}

    // GETTERS AND SETTERS
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getTechnologies() { return technologies; }
    public void setTechnologies(String technologies) { this.technologies = technologies; }
}