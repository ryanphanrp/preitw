package com.safetrust.contact.repository;

import com.safetrust.contact.entity.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long>, CrudRepository<Contact, Long> {
    Page<Contact> findAllContacts(Pageable pageable);
    Optional<Contact> findById(Long Id);
    Optional<Contact> findByTelephone(String telephone);
    @Query("SELECT c FROM Contact c where c.name like %:name%")
    List<Contact> findContactsByName(String name);
}
