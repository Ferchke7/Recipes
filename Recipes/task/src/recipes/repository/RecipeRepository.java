package recipes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import recipes.model.Recipe;

import javax.transaction.Transactional;
import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> , CrudRepository <Recipe,Long>{
    List<Recipe> findById (boolean id);


    List<Recipe> findByCategoryIgnoreCaseOrderByDateDesc(String category);


    List<Recipe> findByNameContainingIgnoreCaseOrderByDateDesc (String name);


}

