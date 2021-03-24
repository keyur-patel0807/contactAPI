package com.exercise.contact.service;

import com.exercise.contact.exception.ResourceNotFoundException;
import com.exercise.contact.model.Contact;
import com.exercise.contact.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

@Service
@Slf4j
public class ContactServiceImpl implements ContactService{

    @Autowired
    ContactRepository contactRepository;

    public List<Contact> getAllContacts() {
        log.info("Calling getAllContacts API");
        return contactRepository.findAll();
    }

    public Contact createContact(Contact contact) {
        log.info("Calling createContact API");
        return contactRepository.save(contact);
    }

    public Contact getContactById(Long contactId) {
        log.info("Calling getContactById API");
        return contactRepository.findById(contactId)
                .orElseThrow(() -> new ResourceNotFoundException("Contact", "id", contactId));
    }

    public List<Contact> getContactByCity(String city) {
        log.info("Calling getContactByCity API");
        List<Contact> contactList = contactRepository.findByAddress_City(city);
        return contactList;
    }

    public List<Contact> getContactByPostalCode(String postalcode) {
        log.info("Calling getContactByPostalCode API");
        List<Contact> contactList = contactRepository.findByAddress_City(postalcode);
        return contactList;
    }

    public Contact updateContact(Long contactId, Contact contactDetail) {

        log.info("Calling updateContact API");

        Contact contact = contactRepository.findById(contactId)
                .orElseThrow(() -> new ResourceNotFoundException("Contact", "id", contactId));

        contact.setFirstName(contactDetail.getFirstName());
        contact.setLastName(contactDetail.getLastName());

        Contact updatedContact = contactRepository.save(contact);
        return updatedContact;
    }

    public ResponseEntity<?> deleteContact(Long contactId) {
        log.info("Calling deleteContact API");

        Contact contact = contactRepository.findById(contactId)
                .orElseThrow(() -> new ResourceNotFoundException("Contact", "id", contactId));

        contactRepository.delete(contact);

        return ResponseEntity.ok().build();
    }
}
