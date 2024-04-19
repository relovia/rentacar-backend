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
public class BrandController {
    private BrandService brandService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public CreateBrandResponse createBrand(@RequestBody @Valid CreateBrandRequest request) {
        return brandService.createBrand(request);
    }

    @GetMapping(value = "/get/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllBrandResponse> getAllBrands() {
        return brandService.getAllBrands();
    }

    @GetMapping("/get/{id}")
    public GetBrandByIdResponse getBrandById(@PathVariable int id) {
        return brandService.getBrandById(id);
    }

    @PutMapping("/update")
    public UpdateBrandResponse updateBrand(@RequestBody UpdateBrandRequest request) {
        return brandService.updateBrand(request);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBrand(@PathVariable int id) {
        brandService.deleteBrand(id);
    }
}
