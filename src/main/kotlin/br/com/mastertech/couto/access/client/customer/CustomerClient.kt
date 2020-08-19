package br.com.mastertech.couto.access.client.customer

import br.com.mastertech.couto.access.client.customer.configuration.CustomerClientConfiguration
import br.com.mastertech.couto.access.client.customer.models.Customer
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(name = "CUSTOMER", configuration = [CustomerClientConfiguration::class])
interface CustomerClient {
    @GetMapping("/cliente/{id}")
    fun getCustomerById(@PathVariable id: Integer): Customer
}