package br.com.mastertech.couto.access.client.door.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus
import java.lang.RuntimeException

@ResponseStatus(code = HttpStatus.SERVICE_UNAVAILABLE, reason = "Access services unavailable.")
class UnavailableDoorService : RuntimeException()