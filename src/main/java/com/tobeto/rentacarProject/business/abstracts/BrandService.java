package com.tobeto.rentacarProject.business.abstracts;

import com.tobeto.rentacarProject.business.dtos.requests.brand.CreateBrandRequest;
import com.tobeto.rentacarProject.business.dtos.requests.brand.UpdateBrandRequest;
import com.tobeto.rentacarProject.business.dtos.responses.brand.CreateBrandResponse;
import com.tobeto.rentacarProject.business.dtos.responses.brand.GetAllBrandResponse;
import com.tobeto.rentacarProject.business.dtos.responses.brand.GetBrandByIdResponse;
import com.tobeto.rentacarProject.business.dtos.responses.brand.UpdateBrandResponse;

import java.util.List;

public interface BrandService {
    CreateBrandResponse createBrand(CreateBrandRequest request);

    List<GetAllBrandResponse> getAllBrands();

    GetBrandByIdResponse getBrandById(int id);

    UpdateBrandResponse updateBrand(UpdateBrandRequest request);

    void deleteBrand(int id);
}
