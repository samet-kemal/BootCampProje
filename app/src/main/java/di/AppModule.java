package di;

import com.samet.bootcampproje.data.repo.YemeklerDaoRepo;
import com.samet.bootcampproje.retrofit.ApiUtils;
import com.samet.bootcampproje.retrofit.YemeklerDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {
    @Singleton
    @Provides
    public YemeklerDaoRepo provideYemeklerDaoRepo(YemeklerDao yemeklerDao){
        return new YemeklerDaoRepo(yemeklerDao);
    }

    @Singleton
    @Provides
    public YemeklerDao provideYemeklerDao(){
        return ApiUtils.getYemeklerDao();
    }


}
