package edu.miu.assignment.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")


public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    String name;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private List<Post> posts;
}
