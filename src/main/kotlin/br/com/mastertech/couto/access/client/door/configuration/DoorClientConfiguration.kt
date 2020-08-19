package br.com.mastertech.couto.access.client.door.configuration

import br.com.mastertech.couto.access.client.door.decoder.DoorClientDecoder
import feign.codec.ErrorDecoder
import org.springframework.context.annotation.Bean

class DoorClientConfiguration {
    @Bean
    fun getDoorClientDecoder(): ErrorDecoder? {
        return DoorClientDecoder()
    }
}