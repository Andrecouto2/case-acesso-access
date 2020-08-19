package br.com.mastertech.couto.access.client.door.configuration

import br.com.mastertech.couto.access.client.door.DoorClientFallback
import br.com.mastertech.couto.access.client.door.decoder.DoorClientDecoder
import feign.Feign
import feign.RetryableException
import feign.codec.ErrorDecoder
import io.github.resilience4j.feign.FeignDecorators
import io.github.resilience4j.feign.Resilience4jFeign
import org.springframework.context.annotation.Bean

class DoorClientConfiguration {
    @Bean
    fun getDoorClientDecoder(): ErrorDecoder? {
        return DoorClientDecoder()
    }

    @Bean
    fun builder(): Feign.Builder {
        val decorators: FeignDecorators = FeignDecorators.builder()
                .withFallback(DoorClientFallback(), RetryableException::class.java)
                .build()
        return Resilience4jFeign.builder(decorators)
    }
}