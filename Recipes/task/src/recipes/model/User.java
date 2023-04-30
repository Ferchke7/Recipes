package recipes.model;


import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import recipes.User.UserJsonView;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "USERS")
@Getter
@Setter
public class User {
    @Id
    @NotBlank
    @Email(regexp = "^(?=.{1,64}@)[A-Za-z0-9\\+_-]+(\\.[A-Za-z0-9\\+_-]+)*@"
            + "[^-][A-Za-z0-9\\+-]+(\\.[A-Za-z0-9\\+-]+)*(\\.[A-Za-z]{2,})$")
    @JsonView(UserJsonView.RegistrationView.class)
    private String email;


    @NotBlank
    @Size(min = 8)
    private String password;

     @OneToMany
     private Set<Recipe> recipe;
}
