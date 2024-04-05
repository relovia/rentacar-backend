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
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandController {
    private BrandService brandService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public CreateBrandResponse add(@RequestBody @Valid CreateBrandRequest request) {
        return brandService.add(request);
    }

    @GetMapping("/get/all")
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllBrandResponse> getAll() {
        return brandService.getAll();
    }

    @GetMapping("/get/{id}")
    public GetBrandByIdResponse getBrandById(@PathVariable int id) {
        return brandService.getBrandById(id);
    }

    @PutMapping("/update")
    public UpdateBrandResponse update(@RequestBody UpdateBrandRequest request) {
        return brandService.update(request);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        brandService.delete(id);
    }
}
