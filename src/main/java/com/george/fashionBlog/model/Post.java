package com.george.fashionBlog.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "postTable")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String description;
    @CreationTimestamp
    private LocalDate createdDate;
    private LocalDate updatedDate;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name="userId", referencedColumnName = "id")
    private User user;

    @OneToMany(mappedBy = "post")
    @JsonManagedReference
    private List<Comment> commentList = new ArrayList<>();

    @OneToMany(mappedBy = "post")
    @JsonManagedReference
    private List<Like> likeList = new ArrayList<>();

}
