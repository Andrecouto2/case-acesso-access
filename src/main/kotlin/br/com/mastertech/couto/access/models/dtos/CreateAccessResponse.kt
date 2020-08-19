package br.com.mastertech.couto.access.models.dtos

import com.fasterxml.jackson.annotation.JsonProperty
import lombok.Getter
import lombok.Setter

class CreateAccessResponse {

    @Getter
    @Setter
    @JsonProperty("porta_id")
    lateinit var doorId: Integer

    @Getter
    @Setter
    @JsonProperty("cliente_id")
    lateinit var customerId: Integer

    constructor(doorId: Integer, customerId: Integer) {
        this.doorId = doorId
        this.customerId = customerId
    }
}