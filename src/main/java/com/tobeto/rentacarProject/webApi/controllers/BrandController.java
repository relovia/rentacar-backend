package com.tobeto.rentacarProject.webApi.controllers;

import com.tobeto.rentacarProject.business.abstracts.BrandService;
import com.tobeto.rentacarProject.business.dtos.requests.brand.CreateBrandRequest;
import com.tobeto.rentacarProject.business.dtos.requests.brand.UpdateBrandRequest;
import com.tobeto.rentacarProject.business.dtos.responses.brand.CreateBrandResponse;
import com.tobeto.rentacarProject.business.dtos.responses.brand.GetAllBrandResponse;
import com.tobeto.rentacarProject.business.dtos.responses.brand.GetBrandByIdResponse;
import com.tobeto.rentacarProject.business.dtos.responses.brand.UpdateBrandResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class BrandController {
    private BrandService brandService;

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public CreateBrandResponse createBrand(@RequestBody @Valid CreateBrandRequest request) {
        return brandService.createBrand(request);
    }

    @GetMapping(value = "/get/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllBrandResponse> getAllBrands() {
        return brandService.getAllBrands();
    }

    @GetMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public GetBrandByIdResponse getBrandById(@PathVariable int id) {
        return brandService.getBrandById(id);
    }

    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public UpdateBrandResponse updateBrand(@RequestBody UpdateBrandRequest request) {
        return brandService.updateBrand(request);
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteBrand(@PathVariable int id) {
        brandService.deleteBrand(id);
    }
}
