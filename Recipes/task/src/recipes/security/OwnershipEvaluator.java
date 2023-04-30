package recipes.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Component;
import recipes.model.Recipe;
import recipes.service.RecipeService;
import recipes.service.RecipeUserDetails;

@Component(value = "ownerShipEvaluator")
public class OwnershipEvaluator {
    private final RecipeService recipeService;

    @Autowired
    public OwnershipEvaluator(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    public boolean isOwner(Long id, RecipeUserDetails userDetails) throws ChangeSetPersister.NotFoundException {
        Recipe temp = recipeService.get(id);
        return temp.getUser().getEmail().equals(userDetails.getUsername());
    }
}
