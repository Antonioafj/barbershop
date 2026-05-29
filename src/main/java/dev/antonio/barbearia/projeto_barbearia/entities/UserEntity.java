package dev.antonio.barbearia.projeto_barbearia.entities;


import dev.antonio.barbearia.projeto_barbearia.enums.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    @Column(nullable = false)
    private String name;


    @Email(message = "Insira o email válido")
    @NotBlank(message = "O email é obrigatório")
    @Column(nullable = false, unique = true )
    private String email;

    @NotBlank(message = "A senha é obrigatória")
    @Column(nullable = false)
    private String password;

    @ManyToOne
    @NotNull(message = "Barbearia é obrigatória")
    @JoinColumn(name = "barbershop_id", nullable = false)
    private BarbershopEntity barbershop;

    @NotNull(message = "Perfil de usuário é obrigatório")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole userRole;

}
