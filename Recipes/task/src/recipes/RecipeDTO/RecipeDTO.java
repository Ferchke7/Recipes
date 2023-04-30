package recipes.RecipeDTO;

import lombok.AllArgsConstructor;
import lombok.Value;
import org.springframework.boot.context.properties.ConstructorBinding;

@Value
@ConstructorBinding
@AllArgsConstructor
public class RecipeDTO{
    Long id;
}
