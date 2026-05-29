package dev.antonio.barbearia.projeto_barbearia.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "barbershops")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BarbershopEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "O telefone é obrigatório")
    @Column(nullable = false)
    private String telephone;


    @Email(message = "Insira o email válido")
    @NotBlank(message = "O email é obrigatório")
    @Column(nullable = false, unique = true )
    private  String email;

    @NotBlank(message = "O endereço é obrigatório")
    @Column(nullable = false)
    private String address;
}
