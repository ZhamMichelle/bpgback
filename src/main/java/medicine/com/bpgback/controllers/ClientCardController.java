package medicine.com.bpgback.controllers;

import medicine.com.bpgback.models.ClientCard;
import medicine.com.bpgback.repository.ClientCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ClientCardController {

    @Autowired
    ClientCardRepository clientCardRepository;

    @GetMapping("/cards")
    public ResponseEntity<List<ClientCard>> getAllCards(@RequestParam(required = false) String title) {
        try {
            List<ClientCard> cards = clientCardRepository.findAll();
            if (cards.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(cards, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/tutorials/{id}")
    public ResponseEntity<ClientCard> getCardById(@PathVariable("id") long id) {
        Optional<ClientCard> cardData = clientCardRepository.findById(id);
        if (cardData.isPresent()) {
            return new ResponseEntity<>(cardData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/tutorials")
    public ResponseEntity<ClientCard> createCard(@RequestBody ClientCard card) {
        try {
            ClientCard _card = clientCardRepository
                    .save(new ClientCard(
                            null,
                            card.getSurname(),
                            card.getName(),
                            card.getPatronymic(),
                            card.getAge(),
                            card.getPhoneNumber(),
                            card.getComplaint(),
                            card.getAdvanceDiagnosis(),
                            card.getAppointment(),
                            new Date(),
                            null));
            return new ResponseEntity<>(_card, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/tutorials/{id}")
    public ResponseEntity<ClientCard> updateCard(@PathVariable("id") long id, @RequestBody ClientCard card) {
        Optional<ClientCard> cardData = clientCardRepository.findById(id);
        if (cardData.isPresent()) {
            ClientCard _card = cardData.get();
            _card.setSurname(card.getSurname());
            _card.setName(card.getName());
            _card.setPatronymic(card.getPatronymic());
            _card.setAge(card.getAge());
            _card.setPhoneNumber(card.getPhoneNumber());
            _card.setComplaint(card.getComplaint());
            _card.setAdvanceDiagnosis(card.getAdvanceDiagnosis());
            _card.setAppointment(card.getAppointment());
            _card.setModificationDate(new Date());
            return new ResponseEntity<>(clientCardRepository.save(_card), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
