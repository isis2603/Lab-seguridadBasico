/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.isis2503.competitors.service;

import co.edu.uniandes.isis2503.competitors.logic.CompetitorsLogic;
import co.edu.uniandes.isis2503.competitors.logic.dto.CompetitorDTO;
import co.edu.uniandes.isis2503.competitors.persistence.entity.CompetitorEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.simple.JSONObject;

/**
 *
 * @author Estudiante
 */
@Path("/competitors")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CompetitorService {

  
    final protected List<CompetitorDTO> competitors = new ArrayList();
    protected CompetitorsLogic competitorsLogic;

    @PostConstruct
    public void loadDependencies() {
        competitorsLogic = new CompetitorsLogic();
    }

    @GET
    public Response getAll() {
        if (competitors.isEmpty()){
            generateCompetitors();
        }
        return Response.status(Response.Status.OK).entity(competitors).build();        
    }

    @POST
    public Response createCompetitor(CompetitorDTO competitor) {
        competitors.add(competitor);
        return Response.status(Response.Status.OK).entity("Competidor " + competitor.getName()+ " registrado").build();
    }
    
    public void generateCompetitors (){
        for (int i = 0; i<15;i++){
            CompetitorDTO c = new CompetitorDTO("Juan"+i, "Perez", i+1, "311"+i,"Colombia");
            competitors.add(c);
        }      
    }

}


    