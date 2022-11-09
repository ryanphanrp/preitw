package com.safetrust.contact.service;

import com.safetrust.contact.dto.contact.ContactDto;
import com.safetrust.contact.dto.contact.CreateContactDto;
import com.safetrust.contact.dto.contact.UpdateContactDto;
import com.safetrust.contact.dto.paging.PagingRequestDto;
import com.safetrust.contact.entity.Contact;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ContactService {
    ContactDto getDetail(Long id);
    Page<Contact> getList(Integer page, Integer size);
    ContactDto createNew(CreateContactDto dto);
    void update(Long id, UpdateContactDto dto);
    void delete(Long id);
    List<ContactDto> findContact(String name);
}
