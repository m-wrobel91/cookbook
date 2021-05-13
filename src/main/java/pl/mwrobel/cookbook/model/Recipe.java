package pl.mwrobel.cookbook.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Recipe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String title;
    private LocalDateTime timestamp;
    private Integer preparationTimeInMinutes;
    private Integer cookingTimeInMinutes;
    private String content;
    private Float rating = 0.f;
    private Integer noOfVotes = 0;
    private String imageUrl;
    private String author;
    @OneToMany
    @JoinColumn(name = "recipe_id", insertable = false, updatable = false)
    private List<Comment> comments;

    public void updateRating(Integer rating){
        if(1 <= rating && rating <= 5) {
            this.noOfVotes++;
            this.rating = (this.rating * (noOfVotes - 1)  + rating) / noOfVotes;
        }else{
            throw new IllegalArgumentException("Rating " + rating + "is out of range.");
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getPreparationTimeInMinutes() {
        return preparationTimeInMinutes;
    }

    public void setPreparationTimeInMinutes(Integer preparationTimeInMinutes) {
        this.preparationTimeInMinutes = preparationTimeInMinutes;
    }

    public Integer getCookingTimeInMinutes() {
        return cookingTimeInMinutes;
    }

    public void setCookingTimeInMinutes(Integer cookingTimeInMinutes) {
        this.cookingTimeInMinutes = cookingTimeInMinutes;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comment) {
        this.comments = comment;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public Integer getNoOfVotes() {
        return noOfVotes;
    }

    public void setNoOfVotes(Integer noOfVotes) {
        this.noOfVotes = noOfVotes;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", timestamp=" + timestamp +
                ", preparationTimeInMinutes=" + preparationTimeInMinutes +
                ", cookingTimeInMinutes=" + cookingTimeInMinutes +
                ", content='" + content + '\'' +
                ", rating=" + rating +
                ", noOfVotes=" + noOfVotes +
                ", imageUrl='" + imageUrl + '\'' +
                ", author='" + author + '\'' +
                ", comments=" + comments +
                '}';
    }

}
