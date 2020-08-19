package br.com.mastertech.couto.access.client.customer.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(code = HttpStatus.SERVICE_UNAVAILABLE, reason = "Customer services unavailable.")
class UnavailableCustomerService : RuntimeException()