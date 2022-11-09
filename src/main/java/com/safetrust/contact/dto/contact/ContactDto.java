package com.safetrust.contact.dto.contact;

import com.safetrust.contact.entity.Contact;
import lombok.Data;

@Data
public class ContactDto {
    private Long id;
    private String name;
    private String email;
    private String telephone;
    private String postalCode;

    public ContactDto(Contact entity) {
        this.id = entity.getId();
        this.email = entity.getEmail();
        this.name = entity.getName();
        this.postalCode = entity.getPostalCode();
        this.telephone = entity.getTelephone();
    }
}
