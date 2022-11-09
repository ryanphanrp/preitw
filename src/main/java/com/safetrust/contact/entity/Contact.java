package com.safetrust.contact.entity;

import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = Contact.TABLE_NAME)
public class Contact implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "contacts";

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String email;
    private String telephone;
    private String postalCode;
}
