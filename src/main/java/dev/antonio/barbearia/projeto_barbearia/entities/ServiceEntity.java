package dev.antonio.barbearia.projeto_barbearia.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "services")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ServiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    @Column(nullable = false)
    private String name;

    @Positive(message = "O preço deve ser maior que zero")
    @NotNull(message = "O preço é obrigatório")
    @Column(nullable = false)
    private Double price;

    @Positive(message = "A duração deve ser maior que zero")
    @NotNull(message = "A duração é obrigatória")
    @Column(nullable = false)
    private  Integer duration;

    @ManyToOne
    @NotNull(message = "Barbearia é obrigatória")
    @JoinColumn(name = "barbershop_id", nullable = false)
    private BarbershopEntity barbershop;
}
