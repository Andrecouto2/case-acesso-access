package br.com.mastertech.couto.access.repository

import br.com.mastertech.couto.access.models.Access
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import java.util.*

interface AccessRepository : CrudRepository<Access, Integer> {
    @Query("SELECT a FROM Access a WHERE a.customerId = ?1 AND a.doorId = ?2")
    fun findByCustomerIdAndDoorId(clientId: Integer, doorId: Integer): Optional<Access>

    @Query("DELETE FROM Access a WHERE a.customerId = ?1 AND a.doorId = ?2")
    fun deleteByCustomerIdAndDoorId(customerId: Integer, doorId: Integer)
}