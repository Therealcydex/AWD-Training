package esprit.canditature.dto;


import esprit.canditature.entity.Candidature;

public class CandidatureResponse {

    private Candidature candidature;
    private Job job;
    private Candidat candidat;




    public CandidatureResponse(Candidature candidature, Job job, Candidat candidat) {
        this.candidature = candidature;
        this.job = job;
        this.candidat = candidat;
    }

    public Candidature getCandidature() {
        return candidature;
    }

    public Job getJob() {
        return job;
    }

    public Candidat getCandidat() {
        return candidat;
    }
}
