package com.tobeto.rentacarProject.business.abstracts;

import com.tobeto.rentacarProject.business.dtos.requests.brand.CreateBrandRequest;
import com.tobeto.rentacarProject.business.dtos.requests.brand.UpdateBrandRequest;
import com.tobeto.rentacarProject.business.dtos.responses.brand.CreateBrandResponse;
import com.tobeto.rentacarProject.business.dtos.responses.brand.GetAllBrandResponse;
import com.tobeto.rentacarProject.business.dtos.responses.brand.GetBrandByIdResponse;
import com.tobeto.rentacarProject.business.dtos.responses.brand.UpdateBrandResponse;

import java.util.List;

public interface BrandService {
    CreateBrandResponse add(CreateBrandRequest request);

    List<GetAllBrandResponse> getAll();

    GetBrandByIdResponse getBrandById(int id);

    UpdateBrandResponse update(UpdateBrandRequest request);

    void delete(int id);
}
