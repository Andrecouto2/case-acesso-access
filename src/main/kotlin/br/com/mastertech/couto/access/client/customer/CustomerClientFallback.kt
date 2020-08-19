package br.com.mastertech.couto.access.client.customer

import br.com.mastertech.couto.access.client.customer.exception.UnavailableCustomerService
import br.com.mastertech.couto.access.client.customer.models.Customer

class CustomerClientFallback : CustomerClient {
    override fun getCustomerById(id: Integer): Customer {
        throw UnavailableCustomerService()
    }
}