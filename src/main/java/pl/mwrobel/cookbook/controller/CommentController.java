package pl.mwrobel.cookbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.mwrobel.cookbook.model.Comment;
import pl.mwrobel.cookbook.model.Recipe;
import pl.mwrobel.cookbook.model.service.CommentService;

@RestController()
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Comment> getRecipeById(@PathVariable("id") Long id){
        Comment comment = commentService.findCommentById(id);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

    @PostMapping("/add/{recipeId}") //TODO: to be changed!
    public ResponseEntity<Comment> addComment(@RequestBody Comment comment, @PathVariable("id") Long recipeId){
        Comment newComment = commentService.addComment(comment, recipeId);
        return new ResponseEntity<>(newComment, HttpStatus.CREATED);
    }


}
