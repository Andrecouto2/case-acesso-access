package br.com.mastertech.couto.access.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Access not found.")
class AccessNotFoundException : RuntimeException()