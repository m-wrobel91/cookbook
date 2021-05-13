package pl.mwrobel.cookbook.model;

public class Vote {
    private Long id;
    private Integer rating;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Vote{" +
                "id=" + id +
                ", rating=" + rating +
                '}';
    }
}
