package ifmo.javaDeveloper.DiplomProject.entity;

import ifmo.javaDeveloper.DiplomProject.entity.fieldOfGame.Field;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.Set;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "player_id")
    private int id;

    @Column(name = "login")
    @NotEmpty(message = "*Введите, пожалуйста, ваш логин")
    private String login;

    @Column(name = "password")
    @Length(min = 5, message = "*Ваш пароль должен состоять минимум из 5 символов")
    @NotEmpty(message = "*Введите, пожалуйста, ваш пароль")
    private String password;

    @Column(name = "email")
    @Email(message = "*Введите, пожалуйста, корректный имейл")
    @NotEmpty(message = "*Введите, пожалуйста, имейл")
    private String email;

    @Column(name = "active")
    private int active;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "player_role", joinColumns = @JoinColumn(name = "player_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

//    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private Set<Field> fields;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
