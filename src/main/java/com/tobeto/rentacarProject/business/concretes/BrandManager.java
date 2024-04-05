package com.tobeto.rentacarProject.business.concretes;

import com.tobeto.rentacarProject.business.abstracts.BrandService;
import com.tobeto.rentacarProject.business.dtos.requests.brand.CreateBrandRequest;
import com.tobeto.rentacarProject.business.dtos.requests.brand.UpdateBrandRequest;
import com.tobeto.rentacarProject.business.dtos.responses.brand.CreateBrandResponse;
import com.tobeto.rentacarProject.business.dtos.responses.brand.GetAllBrandResponse;
import com.tobeto.rentacarProject.business.dtos.responses.brand.GetBrandByIdResponse;
import com.tobeto.rentacarProject.business.dtos.responses.brand.UpdateBrandResponse;
import com.tobeto.rentacarProject.business.rules.BrandBusinessRules;
import com.tobeto.rentacarProject.core.utilities.mapping.ModelMapperService;
import com.tobeto.rentacarProject.dataAccess.abstracts.BrandRepository;
import com.tobeto.rentacarProject.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class BrandManager implements BrandService {
    private BrandRepository brandRepository;
    private ModelMapperService mapperService;
    private BrandBusinessRules brandBusinessRules;

    @Override
    public CreateBrandResponse add(CreateBrandRequest request) {
        brandBusinessRules.brandNameCanNotBeDuplicated(request.getName());

        Brand brand = mapperService.forRequest().map(request, Brand.class);
        brand.setCreatedDate(LocalDateTime.now());
        brandRepository.save(brand);

        CreateBrandResponse response = mapperService.forResponse().map(brand, CreateBrandResponse.class);
        return response;
    }

    @Override
    public List<GetAllBrandResponse> getAll() {
        List<Brand> brands = brandRepository.findAll();
        List<GetAllBrandResponse> response = brands.stream()
                .map(brand -> mapperService.forResponse().map(brand, GetAllBrandResponse.class))
                .collect(Collectors.toList());
        return response;
    }

    @Override
    public GetBrandByIdResponse getBrandById(int id) {
        Brand brand = brandRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Brand not exists."));

        GetBrandByIdResponse response = mapperService.forResponse().map(brand, GetBrandByIdResponse.class);
        response.setMessage("Brand successfully listed");
        return response;
    }

    @Override
    public UpdateBrandResponse update(UpdateBrandRequest request) {
        int brandId = request.getId();
        Brand existingBrand = brandRepository.findById(brandId)
                .orElseThrow(() -> new RuntimeException("Brand id not found."));

        mapperService.forRequest().map(request, existingBrand);
        brandRepository.save(existingBrand);

        UpdateBrandResponse response = new UpdateBrandResponse();
        response.setMessage("Brand successfully updated");
        return response;
    }

    @Override
    public void delete(int id) {
        brandRepository.deleteById(id);
    }
}


