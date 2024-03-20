package com.jrsmth.cardinal.fittrack.service.week

import com.fasterxml.jackson.databind.ObjectMapper
import com.jrsmth.cardinal.fittrack.week.Week
import com.jrsmth.cardinal.fittrack.week.WeekRepository
import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@AutoConfigureMockMvc
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class WeekIT extends Specification {

    @Autowired MockMvc mockMvc
    @Autowired ObjectMapper mapper
    @Autowired WeekRepository repository

    def "should retrieve bootstrapped week from datasource"() {
        given:
        def endpoint = "/weeks/1"

        when:
        def result = mockMvc.perform(get(endpoint))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn()

        def content = mapper.readValue(result.response.getContentAsString(), Week.class)

        then:
        content != null
        content instanceof Week

        and:
        noExceptionThrown()
    }

    @Transactional
    def "should store new week in datasource"() {
        given:
        def block = 1
        def endpoint = "/weeks"
        def week = Week.builder().block(block).build()

        when:
        mockMvc.perform(post(endpoint)
                .contentType("application/json;charset=UTF-8")
                .content(mapper.writeValueAsString(week)))
                .andDo(print())
                .andExpect(status().isCreated())

        then:
        def result = repository.getReferenceById(2)
        result.block == block

        and:
        noExceptionThrown()
    }

}
