package org.stanislav.spring.database.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedAttributeNode;
import jakarta.persistence.NamedEntityGraph;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;
import org.hibernate.envers.RelationTargetAuditMode;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Stanislav Hlova
 */
@NamedEntityGraph(
        name = "User.company",
        attributeNodes = @NamedAttributeNode(value = "company"))
@Data
@ToString(exclude = "userChats")
@EqualsAndHashCode(of = "username")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
public class User extends AuditingEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    private String image;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Company company;

    @NotAudited
    @Builder.Default
    @OneToMany(mappedBy = "user")
    private List<UserChat> userChats = new ArrayList<>();
}
