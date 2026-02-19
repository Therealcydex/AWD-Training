package esprit.canditature.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Candidature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // ID du Job (MS Job)
    private int jobId;

    // ID du Candidat (MS Candidat)
    private int candidatId;

    private LocalDateTime dateCandidature;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String message; // lettre de motivation

    // ================= CONSTRUCTORS =================

    public Candidature() {
        this.dateCandidature = LocalDateTime.now();
        this.status = Status.PENDING;
    }

    public Candidature(int jobId, int candidatId, String message) {
        this.jobId = jobId;
        this.candidatId = candidatId;
        this.message = message;
        this.dateCandidature = LocalDateTime.now();
        this.status = Status.PENDING;
    }

    // ================= GETTERS & SETTERS =================

    public int getId() {
        return id;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public int getCandidatId() {
        return candidatId;
    }

    public void setCandidatId(int candidatId) {
        this.candidatId = candidatId;
    }

    public LocalDateTime getDateCandidature() {
        return dateCandidature;
    }

    public void setDateCandidature(LocalDateTime dateCandidature) {
        this.dateCandidature = dateCandidature;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

