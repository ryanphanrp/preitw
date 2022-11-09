package com.safetrust.contact.dto.contact;

import com.safetrust.contact.entity.Contact;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class CreateContactDto {
    @NotBlank(message = "Name must not be empty")
    private String name;

    @Email(message = "Email is not valid", regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")
    @NotBlank(message = "Email must not be empty")
    private String email;

    @NotBlank(message = "Telephone must not be empty")
    @Size(max = 10, message = "Size telephone from 0 to 10")
    private String telephone;

    @Size(max = 6, message = "Postal Code has 6 character maximum")
    private String postalCode;

    public Contact toEntity() {
        Contact entity = new Contact();
        entity.setName(name);
        entity.setEmail(email);
        entity.setTelephone(telephone);
        entity.setPostalCode(postalCode);
        return entity;
    }
}
