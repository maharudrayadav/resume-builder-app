package resumeBuider.model;

import java.util.List;

public class ResumeContent {
    private PersonalInfo personal;
    private List<Experience> experience;
    private List<Education> education;
    private List<String> skills;

    // Constructors
    public ResumeContent() {}

    // Getters and Setters
    public PersonalInfo getPersonal() { return personal; }
    public void setPersonal(PersonalInfo personal) { this.personal = personal; }

    public List<Experience> getExperience() { return experience; }
    public void setExperience(List<Experience> experience) { this.experience = experience; }

    public List<Education> getEducation() { return education; }
    public void setEducation(List<Education> education) { this.education = education; }

    public List<String> getSkills() { return skills; }
    public void setSkills(List<String> skills) { this.skills = skills; }

    public static class PersonalInfo {
        private String name;
        private String email;
        private String phone;

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
        public String getPhone() { return phone; }
        public void setPhone(String phone) { this.phone = phone; }
    }

    public static class Experience {
        private String company;
        private String role;
        private String description;

        public String getCompany() { return company; }
        public void setCompany(String company) { this.company = company; }
        public String getRole() { return role; }
        public void setRole(String role) { this.role = role; }
        public String getDescription() { return description; }
        public void setDescription(String description) { this.description = description; }
    }

    public static class Education {
        private String school;
        private String degree;

        public String getSchool() { return school; }
        public void setSchool(String school) { this.school = school; }
        public String getDegree() { return degree; }
        public void setDegree(String degree) { this.degree = degree; }
    }
}