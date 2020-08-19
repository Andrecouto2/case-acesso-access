package br.com.mastertech.couto.access.client.customer.decoder

import br.com.mastertech.couto.access.client.customer.exception.CustomerNotFoundException
import feign.Response
import feign.codec.ErrorDecoder

class CustomerClientDecoder : ErrorDecoder {
    private val errorDecoder: ErrorDecoder = ErrorDecoder.Default()
    override fun decode(s: String, response: Response): Exception {
        return if (response.status() == 404) {
            CustomerNotFoundException()
        } else errorDecoder.decode(s, response)
    }
}