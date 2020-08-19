package br.com.mastertech.couto.access.client.customer.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Customer not found.")
class CustomerNotFoundException : RuntimeException()