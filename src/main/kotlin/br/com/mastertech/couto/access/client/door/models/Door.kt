package br.com.mastertech.couto.access.client.door.models

import com.fasterxml.jackson.annotation.JsonProperty
import lombok.Getter
import lombok.Setter

data class Door(@Getter @Setter val id: Integer,
                @Getter @Setter @JsonProperty("andar") val floor: String,
                @Getter @Setter @JsonProperty("sala") val room: String)