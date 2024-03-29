package com.tree.gdhealth.employee.api;

import com.tree.gdhealth.employee.dto.EmployeeInformation;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EmployeeRestApiControllerTest {

    @LocalServerPort
    int port;

    @Autowired
    RestTemplate restTemplate;
    @Test
    void 본사직원리스트를_가져온다() {
        String UrlStr = "http://localhost:"+port+"/api/v1/employee";
        URI uri = UriComponentsBuilder.fromUriString(UrlStr).queryParam("isHeadOffice", "true").build().toUri();
        ResponseEntity<List<EmployeeInformation>> responseEntity = restTemplate.exchange(
                uri, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<EmployeeInformation>>(){});
        log.debug(responseEntity.getBody().toString());
    }

    @Test
    void 지점직원리스트를_가져온다() {
        String UrlStr = "http://localhost:"+port+"/api/v1/employee";
        URI uri = UriComponentsBuilder.fromUriString(UrlStr).queryParam("branchNo", "2").build().toUri();
        ResponseEntity<List<EmployeeInformation>> responseEntity = restTemplate.exchange(
                uri, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<EmployeeInformation>>(){});
        log.debug(responseEntity.getBody().toString());
    }

    @Test
    void 직원하나를_가져온다() {
        String UrlStr = "http://localhost:"+port+"/api/v1/employee/2";
        URI uri = UriComponentsBuilder.fromUriString(UrlStr).build().toUri();
        ResponseEntity<EmployeeInformation> responseEntity = restTemplate.exchange(
                uri, HttpMethod.GET, null,
                EmployeeInformation.class);
        log.debug(responseEntity.getBody().toString());
    }
}