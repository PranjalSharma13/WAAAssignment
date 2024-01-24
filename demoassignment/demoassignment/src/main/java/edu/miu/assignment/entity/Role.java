package edu.miu.assignment.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="roles")
public class Role{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int roleId;
        private String roleName;
    }

