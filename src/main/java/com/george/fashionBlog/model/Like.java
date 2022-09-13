package com.george.fashionBlog.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="likeTable")
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private boolean isLike;
    @CreationTimestamp
    private LocalDate createdDate;
    @UpdateTimestamp
    private LocalDate updatedDate;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name="postId", referencedColumnName = "id")
    private Post post;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name="commentId", referencedColumnName = "id")
    private Comment comment;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name="userId", referencedColumnName = "id")
    private User user;
}
