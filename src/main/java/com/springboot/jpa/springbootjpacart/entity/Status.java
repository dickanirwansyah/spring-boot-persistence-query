package com.springboot.jpa.springbootjpacart.entity;

import com.springboot.jpa.springbootjpacart.entity.enumerated.EnumStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "status")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idstatus;

    @Enumerated(EnumType.STRING)
    @NaturalId
    @Column(name = "status", length = 60)
    private EnumStatus status;
}
