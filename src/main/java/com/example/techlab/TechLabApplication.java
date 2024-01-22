package com.example.techlab;

import com.example.techlab.dto.TestTypeDTO;
import com.example.techlab.entities.*;
import com.example.techlab.entities.enums.Sexe;
import com.example.techlab.entities.enums.StatutAnalyse;
import com.example.techlab.entities.enums.TypeAnalyse;
import com.example.techlab.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class TechLabApplication implements CommandLineRunner {

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private ReactifRepository reactifRepository;

    @Autowired
    private TestTypeRepository testTypeRepository;
    @Autowired
    private TestRepository testRepository;
    @Autowired
    private EchantillonRepository echantillonRepository;
    @Autowired
    private AnalyseRepository analyseRepository;

    public static void main(String[] args) {
        SpringApplication.run(TechLabApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Patient patient = new Patient();
        patient.setNom("Doe");
        patient.setPrenom("John");
//        patient.setDdn(new LocalD);
        patient.setSexe(Sexe.MASCULIN);
        patient.setAdresse("123 Main St");
        patient.setTelephone("1234567890");
        // Save the patient
        patientRepository.save(patient);
        System.out.println(patient.toString());

        List<Patient> allPatients = patientRepository.findAll();
        System.out.println("All patients:");
        for (Patient p : allPatients) {
            System.out.println(p);
        }
        Reactif reactif = new Reactif();
        // Example 1
        Reactif reactif1 = new Reactif();
        reactif1.setNomReactif("Reactif A");
        reactif1.setDescription("Description for Reactif A");
        reactif1.setQuantiteReactif(15);
        reactif1.setDateExpiration(LocalDate.now().plusMonths(9)); // Assuming a 9-month expiration
        reactif1.setFournisseur("Supplier XYZ");
        reactifRepository.save(reactif1);

        // Example 2
        Reactif reactif2 = new Reactif();
        reactif2.setNomReactif("Reactif B");
        reactif2.setDescription("Description for Reactif B");
        reactif2.setQuantiteReactif(20);
        reactif2.setDateExpiration(LocalDate.now().minusMonths(12)); // Assuming a 12-month expiration
        reactif2.setFournisseur("Supplier DEF");
        reactifRepository.save(reactif2);


        // Example 3
        Reactif reactif3 = new Reactif();
        reactif3.setNomReactif("Reactif C");
        reactif3.setDescription("Description for Reactif C");
        reactif3.setQuantiteReactif(5);
        reactif3.setDateExpiration(LocalDate.now().plusMonths(8)); // Assuming an 8-month expiration
        reactif3.setFournisseur("Supplier GHI");
        reactifRepository.save(reactif3);

        TestType testType1 = TestType.builder().nomTest("Test A").max(10.0).min(5.0).unite("Unité A").build();
        testTypeRepository.save(testType1);

        TestType testType2 = TestType.builder().nomTest("Test B").max(20.0).min(15.0).unite("Unité B").build();
        testTypeRepository.save(testType2);

        TestType testType3 = TestType.builder().nomTest("Test C").max(30.0).min(25.0).unite("Unité C").build();
        testTypeRepository.save(testType3);
        Echantillon echantillon1 = Echantillon.builder()
                .type("Blood")
                .description("Blood sample for analysis")
                .datePrelevement(LocalDate.now())
                .typeAnalyse(TypeAnalyse.MICROBIOLOGIE)
                .patient(patient)  // Assuming you have a Patient instance created and assigned to the 'patient' variable
                .analysesList(new ArrayList<>())  // Initialize with an empty list or add analyses later
                .build();
        echantillonRepository.save(echantillon1);

// Similarly, you can create more instances of Echantillon and save them
        Echantillon echantillon2 = Echantillon.builder()
                .type("Urine")
                .description("Urine sample for analysis")
                .datePrelevement(LocalDate.now())
                .typeAnalyse(TypeAnalyse.BIOCHIMIE)
                .patient(patient)
                .analysesList(new ArrayList<>())
                .build();

        echantillonRepository.save(echantillon2);

        Analyse analyse1 = Analyse.builder()
                // .dateEffet(LocalDate.now())
                .commentaire("Analyse for Test ABC")
                .typeAnalyse(TypeAnalyse.MICROBIOLOGIE)
                .statut(StatutAnalyse.EN_COURS)
                .patient(patient)
                .testsList(new ArrayList<>())  // Initialize with an empty list or add tests later
                .build();

// Save the analyse1
        analyseRepository.save(analyse1);

//// Linking Test instances to Analyse
//        analyse1.getTestsList().add(test1);
//        analyse1.getTestsList().add(test2);

// Save the updated analyse1 with linked tests
        analyseRepository.save(analyse1);

// Example 2
        Analyse analyse2 = Analyse.builder()
                //.dateEffet(LocalDate.now())
                .commentaire("Analyse for Test XYZ")
                .typeAnalyse(TypeAnalyse.BIOCHIMIE)
                .statut(StatutAnalyse.EN_COURS)
                .patient(patient)

                .testsList(new ArrayList<>())
                .build();

// Save the analyse2
        analyseRepository.save(analyse2);

//// Linking Test instances to Analyse
//        analyse2.getTestsList().add(test2);
//        analyse2.getTestsList().add(test3);

// Save the updated analyse2 with linked tests
        analyseRepository.save(analyse2);

// Example 3
        Analyse analyse3 = Analyse.builder()
                //.dateEffet(LocalDate.now())
                .commentaire("Analyse for Test 123")
                .typeAnalyse(TypeAnalyse.MICROBIOLOGIE)
                .statut(StatutAnalyse.TERMINEE)
                .testsList(new ArrayList<>())
                .patient(patient)
                .echantillon(echantillon1)
                .build();

//// Save the analyse3
//        analyseRepository.save(analyse3);
//
//// Linking Test instances to Analyse
//        analyse3.getTestsList().add(test3);

// Save the updated analyse3 with linked tests
        analyseRepository.save(analyse3);
        // Example 1
        Test test1 = Test.builder()
                .label("Test ABC")
                .resultat(15.0)
                .testType(testType1)  // Assuming you have a 'TestType' instance created and assigned to 'testType1'
                .testReactifList(new ArrayList<>())  // Initialize with an empty list or add test reactifs later
                .build();

// Save the test1
        testRepository.save(test1);

// Example 2
        Test test2 = Test.builder()
                .label("Test XYZ")
                .resultat(25.0)

                .testType(testType2)  // Assuming you have another 'TestType' instance created and assigned to 'testType2'
                .testReactifList(new ArrayList<>())
                .build();

// Save the test2
        testRepository.save(test2);

// Example 3
        Test test3 = Test.builder()
                .label("Test 123")
                .resultat(10.0)
                .testType(testType3)
                .analyse(analyse1)
                .testReactifList(new ArrayList<>())
                .build();

// Save the test3
        testRepository.save(test3);


    }
}
