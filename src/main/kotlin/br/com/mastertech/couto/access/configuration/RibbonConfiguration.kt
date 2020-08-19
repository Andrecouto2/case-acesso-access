package br.com.mastertech.couto.access.configuration

import com.netflix.loadbalancer.IRule
import com.netflix.loadbalancer.RandomRule
import org.springframework.context.annotation.Bean

class RibbonConfiguration {
    @Bean
    fun getRule(): IRule {
        return RandomRule()
    }
}