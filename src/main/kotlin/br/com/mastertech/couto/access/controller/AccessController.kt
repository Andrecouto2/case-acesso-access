package br.com.mastertech.couto.access.controller

import br.com.mastertech.couto.access.models.AccessMapper
import br.com.mastertech.couto.access.models.dtos.CreateAccessRequest
import br.com.mastertech.couto.access.models.dtos.CreateAccessResponse
import br.com.mastertech.couto.access.models.dtos.GetAccessResponse
import br.com.mastertech.couto.access.service.DoorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/acesso")
class AccessController {

    @Autowired
    lateinit var doorService: DoorService

    @Autowired
    lateinit var accessMapper: AccessMapper

    @PostMapping
    fun create(@RequestBody createAccessRequest: @Valid CreateAccessRequest): ResponseEntity<CreateAccessResponse> {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(accessMapper.toCreateAccessResponse(doorService.create(accessMapper.toAccess(createAccessRequest))))
    }

    @GetMapping(value = ["/{cliente_id}/{porta_id}"])
    fun getAccess(@PathVariable("cliente_id") customerId: Integer, @PathVariable("porta_id") doorId: Integer): ResponseEntity<GetAccessResponse> {
        return ResponseEntity.ok(accessMapper.toGetAccessResponse(doorService.getByDoorAndCustomerId(customerId, doorId)))
    }

    @DeleteMapping(value = ["/{cliente_id}/{porta_id}"])
    fun deleteAccess(@PathVariable("cliente_id") customerId: Integer, @PathVariable("porta_id") doorId: Integer): ResponseEntity<Unit> {
        return ResponseEntity.ok(doorService.delete(customerId, doorId))
    }
}