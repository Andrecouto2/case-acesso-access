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
    val id: Integer?

    @Getter
    @Setter
    val doorId: Integer

    @Getter
    @Setter
    val customerId: Integer

    constructor(id: Integer?, doorId: Integer, customerId: Integer) {
        this.id = id
        this.doorId = doorId
        this.customerId = customerId
    }

}