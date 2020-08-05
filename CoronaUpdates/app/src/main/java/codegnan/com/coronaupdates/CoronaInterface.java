package codegnan.com.coronaupdates;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CoronaInterface
{
    @GET("dayone/country/india")
    Call<String> getData();
}
