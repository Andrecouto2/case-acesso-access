package br.com.mastertech.couto.access.client.customer.configuration

import br.com.mastertech.couto.access.client.customer.CustomerClientFallback
import br.com.mastertech.couto.access.client.customer.decoder.CustomerClientDecoder
import feign.Feign
import feign.RetryableException
import feign.codec.ErrorDecoder
import io.github.resilience4j.feign.FeignDecorators
import io.github.resilience4j.feign.Resilience4jFeign
import org.springframework.context.annotation.Bean

class CustomerClientConfiguration {

    @Bean
    fun getCustomerClientDecoder(): ErrorDecoder? {
        return CustomerClientDecoder()
    }

    @Bean
    fun builder(): Feign.Builder {
        val decorators: FeignDecorators = FeignDecorators.builder()
                .withFallback(CustomerClientFallback(), RetryableException::class.java)
                .build()
        return Resilience4jFeign.builder(decorators)
    }
}