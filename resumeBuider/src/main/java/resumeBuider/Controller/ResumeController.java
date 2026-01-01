package resumeBuider.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import resumeBuider.Entity.ResumeEntity;
import resumeBuider.Repository.ResumeRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
@CrossOrigin(origins = "*", allowedHeaders = "*")

@RestController
@RequestMapping("/api/resumes")
public class ResumeController {

    @Autowired
    private ResumeRepository repository;

    // UPSERT API: Handles both Create and Update
    @PostMapping("/save")
    public ResponseEntity<ResumeEntity> saveOrUpdate(@RequestBody ResumeEntity incomingResume) {
        // 1. Search for existing user by email
        return repository.findByEmail(incomingResume.getEmail())
                .map(existingResume -> {
                    // 2. UPDATE PATH: Set the existing ID onto the incoming data
                    incomingResume.setId(existingResume.getId());

                    // Hibernate will now perform an UPDATE instead of an INSERT
                    ResumeEntity updated = repository.save(incomingResume);
                    return ResponseEntity.ok(updated);
                })
                .orElseGet(() -> {
                    // 3. CREATE PATH: New user, generate new ID
                    incomingResume.setId(UUID.randomUUID());
                    ResumeEntity saved = repository.save(incomingResume);
                    return ResponseEntity.status(HttpStatus.CREATED).body(saved);
                });
    }

    // FETCH API
    @GetMapping("/check")
    public ResponseEntity<?> getUser(
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String phone) {

        return repository
                .findByEmailOrPhone(email, phone)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }





}
