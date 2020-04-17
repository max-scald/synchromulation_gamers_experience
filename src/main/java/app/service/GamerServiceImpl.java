package app.service;

import app.controller.StandardResponse;
import app.controller.StatusResponse;
import app.dto.GamerDto;
import app.entities.Activity;
import app.entities.Country;
import app.entities.Gamer;
import com.google.gson.Gson;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;
import app.repository.ActivityRepo;
import app.repository.CountryRepo;
import app.repository.GamerRepo;

@Service
public class GamerServiceImpl implements GamerService{

    private final ActivityRepo activityRepo;
    private final CountryRepo countryRepo;
    private final GamerRepo gamerRepo;
    private final DozerBeanMapper mapper;


    public GamerServiceImpl(ActivityRepo activityRepo,
                            CountryRepo countryRepo,
                            GamerRepo gamerRepo,
                            DozerBeanMapper mapper) {
        this.activityRepo = activityRepo;
        this.countryRepo = countryRepo;
        this.gamerRepo = gamerRepo;
        this.mapper = mapper;
    }


    @Override
    public StandardResponse updateGamer(String data, String uuid) {
        Country country;
        try {
            GamerDto dto = new Gson().fromJson(data, GamerDto.class);
            dto.setGamerId(uuid);
            Gamer gamer = gamerRepo.findOneByUuid(uuid);
            if (gamer == null) {
                gamer = new Gamer();
                gamer.setUuid(dto.getGamerId());
                if(dto.getCountry() != null) {
                    country = countryRepo.findOneByCode(dto.getCountry());
                    if(country == null){
                        country = countryRepo.save(new Country(dto.getCountry()));
                    }
                        gamer.setCountryId(country.getId());
                    }
                }
                gamer.setMoney(dto.getMoney());
                gamerRepo.save(gamer);
            return new StandardResponse(StatusResponse.SUCCESS);
        }catch (Exception e){
            return new StandardResponse(StatusResponse.ERROR);
        }
    }

    @Override
    public StandardResponse getGamer(String uuid) {
        Gamer gamer = gamerRepo.findOneByUuid(uuid);
        if (gamer == null) {
            return new StandardResponse(StatusResponse.ERROR, "Gamer [" + uuid + "] not found");
        }
        GamerDto dto = new GamerDto();
        dto.setGamerId(gamer.getUuid());
        dto.setCountry(countryRepo.findOneById(gamer.getCountryId()).getCode());
        dto.setMoney(gamer.getMoney());
        return new StandardResponse(StatusResponse.SUCCESS, new Gson().toJson(dto));
    }

    @Override
    public StandardResponse updateStatistic(Integer value, String uuid) {
        Gamer gamer = gamerRepo.findOneByUuid(uuid);
        if(gamer != null){
            Activity activity = new Activity(gamer.getId(),value);
            activityRepo.save(activity);
            return new StandardResponse(StatusResponse.SUCCESS);
        }
        return new StandardResponse(StatusResponse.ERROR,"Gamer [" + uuid + "] not found");
    }
}
