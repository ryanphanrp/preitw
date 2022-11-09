package com.safetrust.contact.service;

import com.safetrust.contact.constant.ResponseCode;
import com.safetrust.contact.dto.contact.ContactDto;
import com.safetrust.contact.dto.contact.CreateContactDto;
import com.safetrust.contact.dto.contact.UpdateContactDto;
import com.safetrust.contact.entity.Contact;
import com.safetrust.contact.exception.GlobalAppException;
import com.safetrust.contact.repository.ContactRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements ContactService{
    final ContactRepository repository;
    public ContactServiceImpl(ContactRepository repository) {
        this.repository = repository;
    }

    @Override
    public ContactDto getDetail(Long id) {
        Contact data = repository.findById(id)
                .orElseThrow(() -> new GlobalAppException(ResponseCode.NOT_FOUND_CONTACT));
        return new ContactDto(data);
    }

    @Override
    public Page<Contact> getList() {
        return repository.findAllContacts(PageRequest.of(0,99));
    }

    @Override
    public ContactDto createNew(CreateContactDto dto) {
        Optional<Contact> contactOpt = repository.findByTelephone(dto.getTelephone());
        if (contactOpt.isPresent()) throw new GlobalAppException(ResponseCode.EXISTED_CONTACT);
        Contact entity = dto.toEntity();
        repository.save(entity);
        return new ContactDto(entity);
    }

    @Override
    public void update(Long id, UpdateContactDto dto) {
        Contact contact = repository.findById(id)
                .orElseThrow(() -> new GlobalAppException(ResponseCode.NOT_FOUND_CONTACT));
        contact.setName(dto.getName());
        contact.setTelephone(dto.getTelephone());
        contact.setEmail(dto.getEmail());
        contact.setPostalCode(dto.getPostalCode());
        repository.save(contact);
    }

    @Override
    public void delete(Long id) {
        Contact contact = repository.findById(id)
                .orElseThrow(() -> new GlobalAppException(ResponseCode.NOT_FOUND_CONTACT));
        repository.delete(contact);
    }

    @Override
    public List<ContactDto> findContact(String name) {
        return repository.findContactsByName(name)
                .stream()
                .map(ContactDto::new)
                .collect(Collectors.toList());
    }
}
