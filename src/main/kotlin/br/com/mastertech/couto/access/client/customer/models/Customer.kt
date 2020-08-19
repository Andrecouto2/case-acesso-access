package br.com.mastertech.couto.access.client.customer.models

import com.fasterxml.jackson.annotation.JsonProperty

class Customer {

    val id: Long? = null

    @JsonProperty("nome")
    val name: String? = null
}