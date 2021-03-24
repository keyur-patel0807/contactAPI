package com.exercise.contact.service;

import com.exercise.contact.model.Contact;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface ContactService {

    public List<Contact> getAllContacts();

    public Contact createContact(Contact contact);

    public Contact getContactById(Long contactId);

    public List<Contact> getContactByCity(String city);

    public List<Contact> getContactByPostalCode(String postalcode);

    public Contact updateContact(Long contactId, Contact contactDetail);

    public ResponseEntity<?> deleteContact(Long contactId);
}
