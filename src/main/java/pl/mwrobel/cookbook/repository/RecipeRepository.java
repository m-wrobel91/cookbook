package pl.mwrobel.cookbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mwrobel.cookbook.model.Recipe;

import javax.transaction.Transactional;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

}
