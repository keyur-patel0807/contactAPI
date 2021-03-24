package com.exercise.contact.repository;

import com.exercise.contact.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    List<Contact> findByAddress_City(String city);
    List<Contact> findByAddress_Postalcode(String postalCode);
}
