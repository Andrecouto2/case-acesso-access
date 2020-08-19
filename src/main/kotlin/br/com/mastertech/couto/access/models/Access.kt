package br.com.mastertech.couto.access.models

import lombok.Getter
import lombok.Setter
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Access {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    lateinit var id: Integer

    @Getter
    @Setter
    lateinit var doorId: Integer

    @Getter
    @Setter
    lateinit var customerId: Integer

}