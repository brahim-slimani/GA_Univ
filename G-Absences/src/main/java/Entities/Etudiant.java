package Entities;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Etudiant")
public class Etudiant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEtudiant;

    @OrderColumn

    @Column(unique = true)
    private String codeEtudiant;

    @NotNull
    @Size(min = 2,max = 20)
    private String nom;

    @NotNull
    @Size(min = 2,max = 20)
    private String prenom;

    @NotNull
    @Column(nullable = false, length = 6)
    @Enumerated(EnumType.STRING)
    private Sexe genre;

    @Email
    private String email;

    @Transient
    private int age;

    @NotNull
    @Column(name = "promotion")
    private String promotion;

    @Column(name = "specialite")
    private String specialite;

    @OneToMany(mappedBy = "etudiant", cascade = CascadeType.ALL)
    private Set<Absence> LesAbsences = new HashSet<Absence>();

    public Etudiant() {
    }

    public Etudiant(String codeEtudiant, @NotNull @Size(min = 2, max = 20) String nom, @NotNull @Size(min = 2, max = 20) String prenom, @NotNull Sexe genre, @Email String email, int age, @NotNull String promotion, String specialite, Set<Absence> lesAbsences) {
        this.codeEtudiant = codeEtudiant;
        this.nom = nom;
        this.prenom = prenom;
        this.genre = genre;
        this.email = email;
        this.age = age;
        this.promotion = promotion;
        this.specialite = specialite;
        LesAbsences = lesAbsences;
    }

    public Etudiant(String codeEtudiant, @NotNull @Size(min = 2, max = 20) String nom, @NotNull @Size(min = 2, max = 20) String prenom, @NotNull Sexe genre, @Email String email, @NotNull String promotion, String specialite) {
        this.codeEtudiant = codeEtudiant;
        this.nom = nom;
        this.prenom = prenom;
        this.genre = genre;
        this.email = email;
        this.promotion = promotion;
        this.specialite = specialite;
    }


    public int getIdEtudiant() {
        return idEtudiant;
    }

    public void setIdEtudiant(int idEtudiant) {
        this.idEtudiant = idEtudiant;
    }

    public String getCodeEtudiant() {
        return codeEtudiant;
    }

    public void setCodeEtudiant(String codeEtudiant) {
        this.codeEtudiant = codeEtudiant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Sexe getGenre() {
        return genre;
    }

    public void setGenre(Sexe genre) {
        this.genre = genre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPromotion() {
        return promotion;
    }

    public void setPromotion(String promotion) {
        this.promotion = promotion;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public Set<Absence> getLesAbsences() {
        return LesAbsences;
    }

    public void setLesAbsences(Set<Absence> lesAbsences) {
        LesAbsences = lesAbsences;
    }
}
