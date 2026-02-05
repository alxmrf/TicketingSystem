package service;

import dto.CreateShowDto;
import entity.Show;
import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import mapper.ShowMapper;

import java.util.List;

import static java.lang.StringTemplate.STR;

@ApplicationScoped
public class ShowService {

    @Inject
    ShowMapper mapper;

    @Transactional
    public void createNewShow(CreateShowDto createShowDto){
            var newShow =  mapper.createNewShow(createShowDto);
            Show.persist(newShow);
    }

    public List<Show> findShow(String showName){
        if (showName.isEmpty()) return Show.findAll().list();

        return Show.find("showName LIKE :showName", Parameters.with("showName","%"+showName+"%")).list();

    }

}
