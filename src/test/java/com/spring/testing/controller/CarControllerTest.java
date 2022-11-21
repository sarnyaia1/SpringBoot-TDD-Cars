package com.spring.testing.controller;

import com.spring.testing.exception.CarNotFoundException;
import com.spring.testing.model.Car;
import com.spring.testing.service.CarService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = CarController.class)
public class CarControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CarService carService;

    @Test
    public void carDetailsStatusIsOkTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/cars/Opel"))
                .andExpect(status().isOk());
    }

    @Test
    public void carDetailsValuesAreValidTest() throws Exception {
        given(carService.getCarDetails(Mockito.anyString())).willReturn(new Car("Opel","Sedan"));

        mockMvc.perform(MockMvcRequestBuilders.get("/cars/Opel"))
                .andExpect(jsonPath("$").isMap())
                .andExpect(jsonPath("name").value("Opel"))
                .andExpect((jsonPath("type").value("Sedan"))
                );
    }

    @Test
    public void carDetailsRunIntoCarNotFoundExceptionTest() throws Exception {
        given(carService.getCarDetails(Mockito.anyString())).willThrow(new CarNotFoundException());

        mockMvc.perform(MockMvcRequestBuilders.get("/cars/Opel"))
                .andExpect(status().isNotFound());
    }


}
