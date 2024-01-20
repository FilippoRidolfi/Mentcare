package demo;

import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.PrePersist;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Controller
public class AppController {

    @Autowired
    private PersonRepository repository;
    @Autowired
    private DrugRepository drugRepository;
    @Autowired
    private ReportRepository reportRepository;

    @Autowired
    public void initialData(){
        repository.save(new Person(
                "VRDC498468A12", "Mario", "Rossi", 45, (float)1.83, (float)78.15)
        );
        Drug drug = new Drug(
                "Paracetamol", "N02BE03", "mepha", "compress", "For headache", "VRDC498468A12", 1, 1, 8);

        Drug drug1 = new Drug(
                "Voltaren", "N02BE03", "Voltaren", "compress", "For headache", "VRDC498468A12", 1, 1, 8);

        Drug drug3 = new Drug(
                "Tachipirina", "N02BE03", "Voltaren", "compress", "For headache", "VRDF40909A", 1, 1, 8);
        Date d = new Date();
        Report rep = new Report(
                "Tachipirina", "VRDC498468A12", "Ottimo", d
        );

        reportRepository.save(rep);
        drugRepository.save(drug);
        drugRepository.save(drug1);
        drugRepository.save(drug3);
    }

    @RequestMapping("/")
    public String index(){
        return "redirect:/read";
    }

    @RequestMapping("/input")
    public String input(){
        return "input";
    }

    @RequestMapping("/read")
    public String read(Model model) {
        List<Person> data = new LinkedList<>();
        for (Person p: repository.findAll()){
            data.add(p);
        }
        model.addAttribute("person", data.get(0));
        return "read";
    }

    @RequestMapping("/drugs")
    public String drugs(@RequestParam(name="uniqueID", required = true) String uniqueID,
                        Model model){
        Optional<Person> result = Optional.ofNullable(repository.findByUniqueID(uniqueID));
        if (result.isPresent()){
            Person person = result.get();
            model.addAttribute("person", person);
            return "drugs";
        }
        else
            return "notfound";
    }

    @RequestMapping("/modifyUser")
    public String modifyUser(@RequestParam(name="uniqueID", required = true) String uniqueID,
                        Model model){
        Optional<Person> result = Optional.ofNullable(repository.findByUniqueID(uniqueID));
        if (result.isPresent()){
            Person person = result.get();
            model.addAttribute("person", person);
            return "modifyUser";
        }
        else
            return "notfound";
    }

    @RequestMapping("/actualDrugs")
    public String actualDrugs(@RequestParam(name="uniqueID", required = true) String uniqueID,
                        Model model){
        Optional<Person> result = Optional.ofNullable(repository.findByUniqueID(uniqueID));
        if (result.isPresent()){
            Person person = result.get();
            List<Drug> drugs = drugRepository.findByPersonSanitNumber(person.getSanitaryCardNumber());
            model.addAttribute("person", person);
            model.addAttribute("drugs", drugs);
            return "actualDrugs";
        }
        else
            return "notfound";
    }

    @RequestMapping("/drugsList")
    public String drugsList(@RequestParam(name="uniqueID", required = true) String uniqueID,
                              Model model){
        Optional<Person> result = Optional.ofNullable(repository.findByUniqueID(uniqueID));
        if (result.isPresent()){
            Person person = result.get();
            List<Drug> drugs = drugRepository.findByPersonSanitNumber(person.getSanitaryCardNumber());
            model.addAttribute("person", person);
            model.addAttribute("drugs", drugs);
            List<Drug> data = new LinkedList<>();
            for (Drug d: drugRepository.findAll()){
                data.add(d);
            }
            model.addAttribute("drugs", data);
            return "drugsList";
        }
        else
            return "notfound";
    }

    @RequestMapping("/formulary")
    public String formulary(@RequestParam(name="uniqueID", required = true) String uniqueID,
                            Model model){
        Optional<Person> result = Optional.ofNullable(repository.findByUniqueID(uniqueID));
        if (result.isPresent()){
            Person person = result.get();
            List<Report> rep = reportRepository.findBypersonSanityCardNumber(person.getSanitaryCardNumber());
            List<Drug> data = new LinkedList<>();
            for (Drug d: drugRepository.findAll()){
                data.add(d);
            }
            model.addAttribute("person", person);
            model.addAttribute("report", rep);
            model.addAttribute("drugs", data);
            return "formulary";
        }
        else
            return "notfound";
    }

    @RequestMapping("/drugsInfo")
    public String drugsInfo(@RequestParam(name="uniqueID", required = true) String uniqueID,
                            @RequestParam(name="uniqueDrug", required = true) String uniqueDrug,
                            @RequestParam(name="message", required = false) String message,
                            Model model){
        Optional<Person> result = Optional.ofNullable(repository.findByUniqueID(uniqueID));
        Optional<Drug> drugResult = Optional.ofNullable(drugRepository.findByUniqueID(uniqueDrug));
        if (result.isPresent() && drugResult.isPresent()){
            Person person = result.get();
            Drug drug = drugResult.get();
            model.addAttribute("person", person);
            model.addAttribute("drug", drug);
            model.addAttribute("message", message);
            return "drugsInfo";
        }
        else
            return "notfound";
    }

    @RequestMapping("/changeFormularyDose")
    public String changeFormularyDose(@RequestParam(name="uniqueID", required = true) String uniqueID,
                            @RequestParam(name="uniqueDrug", required = true) String uniqueDrug,
                            @RequestParam(name="message", required = false) String message,
                            Model model){
        Optional<Person> result = Optional.ofNullable(repository.findByUniqueID(uniqueID));
        Optional<Drug> drugResult = Optional.ofNullable(drugRepository.findByUniqueID(uniqueDrug));
        if (result.isPresent() && drugResult.isPresent()){
            Person person = result.get();
            Drug drug = drugResult.get();
            model.addAttribute("person", person);
            model.addAttribute("drug", drug);
            model.addAttribute("message", message);
            return "changeFormularyDose";
        }
        else
            return "notfound";
    }

    @RequestMapping("/doseModify")
    public String doseModify(@RequestParam(name="uniqueID", required = true) String uniqueID,
                             @RequestParam(name="uniqueDrug", required = true) String uniqueDrug,
                              Model model){
        Optional<Person> result = Optional.ofNullable(repository.findByUniqueID(uniqueID));
        Optional<Drug> drugResult = Optional.ofNullable(drugRepository.findByUniqueID(uniqueDrug));
        if (result.isPresent() && drugResult.isPresent()){
            Person person = result.get();
            Drug drug = drugResult.get();
            model.addAttribute("person", person);
            model.addAttribute("drug", drug);
            return "doseModify";
        }
        else
            return "notfound";
    }

    @RequestMapping("/confirmPrescription")
    public String confirmPrescription(@RequestParam(name="uniqueID", required = true) String uniqueID,
                             @RequestParam(name="uniqueDrug", required = true) String uniqueDrug,
                             @RequestParam(name="doseInput", required = true) String doseRequest,
                             Model model){
        Optional<Person> result = Optional.ofNullable(repository.findByUniqueID(uniqueID));
        Optional<Drug> drugResult = Optional.ofNullable(drugRepository.findByUniqueID(uniqueDrug));
        if (result.isPresent() && drugResult.isPresent()){
            Person person = result.get();
            Drug drug = drugResult.get();
            model.addAttribute("person", person);
            model.addAttribute("drug", drug);
            model.addAttribute("doseRequest", doseRequest);
            return "confirmPrescription";
        }
        else
            return "notfound";
    }

    @RequestMapping("/report")
    public String report(@RequestParam(name="uniqueID", required = true) String uniqueID,
                             Model model){
        Optional<Person> result = Optional.ofNullable(repository.findByUniqueID(uniqueID));
        if (result.isPresent()){
            Person p = result.get();
            List<Report> data = new LinkedList<>();
            for (Report r: reportRepository.findAll()){
                data.add(r);
            }
            model.addAttribute("person", p);
            model.addAttribute("report", data);
            return "report";
        }
        else
            return "notfound";
    }

    @RequestMapping("/reportDescription")
    public String reportDescription(@RequestParam(name="userID", required = true) String userID,
                        @RequestParam(name="reportID", required = true) String reportID,
                         Model model){
        Optional<Report> result = Optional.ofNullable(reportRepository.findByUniqueID(reportID));
        Optional<Person> resultP = Optional.ofNullable(repository.findByUniqueID(userID));
        if (result.isPresent() && resultP.isPresent()){
            Report r = result.get();
            Person p = resultP.get();
            model.addAttribute("report", r);
            model.addAttribute("person", p);
            return "reportDescription";
        }
        else
            return "notfound";
    }

    @RequestMapping("/newDrug")
    public String newDrug(
            @RequestParam(name="uniqueID", required = true) String uniqueID,
            @RequestParam(name="uniqueDrug", required = true) String uniqueDrug,
            @RequestParam(name="dose", required=true) Integer dose,
            Model model) {
        Optional<Drug> result = Optional.ofNullable(drugRepository.findByUniqueID(uniqueDrug));
        Optional<Person> person = Optional.ofNullable(repository.findByUniqueID(uniqueID));
        if (result.isPresent() && person.isPresent()) {

            if(result.get().getMinDose() <= dose && result.get().getMaxDose() >= dose){
                Drug drug = new Drug(result.get().getName(),
                        result.get().getAtc(),
                        result.get().getCompany(),
                        result.get().getType(),
                        result.get().getDescription(),
                        person.get().getSanitaryCardNumber(),
                        dose,
                        result.get().getMinDose(),
                        result.get().getMaxDose());
                drugRepository.delete(result.get());
                drugRepository.save(drug);

                return "redirect:/actualDrugs?uniqueID=" + uniqueID;
            } else {
                if(result.get().getMinDose() > dose){
                    String message = "Dose is outside the safe range. Is too low";
                    return "redirect:/drugsInfo?uniqueDrug=" + uniqueDrug + "&uniqueID=" + uniqueID + "&message=" + message;
                } else {
                    String message = "Dose is outside the safe range. Is too high";
                    return "redirect:/drugsInfo?uniqueDrug=" + uniqueDrug + "&uniqueID=" + uniqueID + "&message=" + message;
                }
            }
        }
        else
            return "notfound";
    }

    @RequestMapping("/update")
    public String update(
            @RequestParam(name="uniqueID", required = true) String uniqueID,
            @RequestParam(name="uniqueDrug", required = true) String uniqueDrug,
            @RequestParam(name="dose", required=true) Integer dose,
            Model model) {
        Optional<Drug> result = Optional.ofNullable(drugRepository.findByUniqueID(uniqueDrug));
        if (result.isPresent()) {
            Drug drug = new Drug(result.get().getName(),
                    result.get().getAtc(),
                    result.get().getCompany(),
                    result.get().getType(),
                    result.get().getDescription(),
                    result.get().getPersonSanitNumber(),
                    dose,
                    result.get().getMinDose(),
                    result.get().getMaxDose());
            drugRepository.delete(result.get());
            drugRepository.save(drug);

            return "redirect:/actualDrugs?uniqueID=" + uniqueID;
        }
        else
            return "notfound";
    }

    @RequestMapping("/create")
    public String create(
            @RequestParam(name="sanitaryCardNumber", required=true) String sanitaryCardNumber,
            @RequestParam(name="firstname", required=true) String firstname,
            @RequestParam(name="lastname", required=true) String lastname,
            @RequestParam(name="age", required=true) int age,
            @RequestParam(name="height", required=true) float height,
            @RequestParam(name="weight", required=true) float weight) {
        repository.save(new Person(sanitaryCardNumber, firstname,lastname, age, height, weight));
        return "redirect:/list";
    }

    @RequestMapping("/edit")
    public String edit(
            @RequestParam(name="uniqueID", required = true) String uniqueID,
            @RequestParam(name="age", required=true) Integer age,
            @RequestParam(name="height", required=true) Float height,
            @RequestParam(name="weight", required=true) Float weight,
            Model model) {
        Optional<Person> result = Optional.ofNullable(repository.findByUniqueID(uniqueID));
        if (result.isPresent()) {
            Person p = result.get();
            p.setAge(age);
            p.setHeight(height);
            p.setWeight(weight);
            repository.save(p);

            return "redirect:/read?uniqueID=" + uniqueID;
        }
        else
            return "notfound";
    }
}