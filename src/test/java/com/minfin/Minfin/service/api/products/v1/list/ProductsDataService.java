package com.minfin.Minfin.service.api.products.v1.list;

import com.minfin.Minfin.client.api.products.v1.list.ProductsDataAPI;
import com.minfin.Minfin.model.api.products.v1.list.ProductsDataResponse;
import com.minfin.Minfin.service.BaseService;
import lombok.SneakyThrows;
import retrofit2.Call;
import retrofit2.Response;

public class ProductsDataService extends BaseService {
    @SneakyThrows
    public Response<ProductsDataResponse> getData(ProductsDataPathParameters productsDataPathParameters) {
        ProductsDataAPI service = retrofit.create(ProductsDataAPI.class);
        Call<ProductsDataResponse> call = service.getData(productsDataPathParameters.getProductType(),
                productsDataPathParameters.getGracePeriodDaysLimit(),
                productsDataPathParameters.getActive(),
                productsDataPathParameters.getDelivery(),
                productsDataPathParameters.getOwnFundsOwnAtmCommissionPercent(),
                productsDataPathParameters.getOwnAtmCommissionPercent(),
                productsDataPathParameters.getEmploymentType(),
                productsDataPathParameters.getAgeRange(),
                productsDataPathParameters.getPreparationTime(),
                productsDataPathParameters.getObtainConditionsType(),
                productsDataPathParameters.getCashback(),
                productsDataPathParameters.getCardType(),
                productsDataPathParameters.getCurrencyList(),
                productsDataPathParameters.getTechnology(),
                productsDataPathParameters.getVendorId(),
                productsDataPathParameters.getIds(),
                productsDataPathParameters.getLocal());
        return call.execute();
    }
}
