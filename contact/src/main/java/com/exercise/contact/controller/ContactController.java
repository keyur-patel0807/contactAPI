package com.exercise.contact.controller;

import com.exercise.contact.exception.ResourceNotFoundException;
import com.exercise.contact.model.Contact;
import com.exercise.contact.repository.ContactRepository;
import com.exercise.contact.service.ContactService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/contact")
@Slf4j
public class ContactController {

    @Autowired
    ContactRepository contactRepository;

    @Autowired
    ContactService contactService;

    @GetMapping("/")
    public List<Contact> getAllContacts() {
        log.info("Calling getAllContacts API");
        return contactService.getAllContacts();
    }

    @PostMapping("/")
    public Contact createContact(@Valid @RequestBody Contact contact) {
        log.info("Calling createContact API");
        return contactService.createContact(contact);
    }

    @GetMapping("/{id}")
    public Contact getContactById(@PathVariable(value = "id") Long contactId) {
        log.info("Calling getContactById API");
        return contactService.getContactById(contactId);
    }

    @GetMapping("/findByCity/{city}")
    public List<Contact> getContactByCity(@PathVariable(value = "city") String city) {
        log.info("Calling getContactByCity API");
        return contactService.getContactByCity(city);
    }

    @GetMapping("/findByZipCode/{postalcode}")
    public List<Contact> getContactByPostalCode(@PathVariable(value = "postalcode") String postalcode) {
        log.info("Calling getContactByPostalCode API");
        List<Contact> contactList = contactRepository.findByAddress_Postalcode(postalcode);
        return contactList;
    }

    @PutMapping("/{id}")
    public Contact updateContact(@PathVariable(value = "id") Long contactId,
                              @Valid @RequestBody Contact contactDetail) {

        log.info("Calling updateContact API");

        Contact contact = contactRepository.findById(contactId)
                .orElseThrow(() -> new ResourceNotFoundException("Contact", "id", contactId));

        contact.setFirstName(contactDetail.getFirstName());
        contact.setLastName(contactDetail.getLastName());

        Contact updatedContact = contactRepository.save(contact);
        return updatedContact;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteContact(@PathVariable(value = "id") Long contactId) {
        log.info("Calling deleteContact API");

        Contact contact = contactRepository.findById(contactId)
                .orElseThrow(() -> new ResourceNotFoundException("Contact", "id", contactId));

        contactRepository.delete(contact);

        return ResponseEntity.ok().build();
    }

}
