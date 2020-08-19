package br.com.mastertech.couto.access.client.customer.configuration

import br.com.mastertech.couto.access.client.customer.decoder.CustomerClientDecoder
import feign.codec.ErrorDecoder
import org.springframework.context.annotation.Bean

class CustomerClientConfiguration {

    @Bean
    fun getCustomerClientDecoder(): ErrorDecoder? {
        return CustomerClientDecoder()
    }
}