package pl.mwrobel.cookbook.model.service;

import org.springframework.stereotype.Service;
import pl.mwrobel.cookbook.model.Comment;

@Service
public interface CommentService {

    public Comment findCommentById(Long id);

    public Comment addComment(Comment comment, Long recipeId);
}
