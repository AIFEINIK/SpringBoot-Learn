package com.os.china.rest.resource;

import com.os.china.domain.entity.Person;
import com.os.china.dto.*;
import com.os.china.rest.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * @author <a href="zhangpengfei@wxchina.com">ZhangPengFei</a>
 * @Discription 用户信息管理
 * @Data 2017-3-24
 * @Version 1.0.0
 */
@Component
@Path("personMgr")
public class PersonMgrResource {

    @Autowired
    private PersonService personService;

    @GET
    @Path("getPersonById")
    @Produces(MediaType.APPLICATION_JSON)
    public JsonResp getPersonById(@QueryParam("id") Integer id) {
        Person person = personService.getPersonById(id);
        return JsonResp.success(person);
    }

    @GET
    @Path("getPersonByName")
    @Produces(MediaType.APPLICATION_JSON)
    public JsonResp getPersonByName(@QueryParam("userName") String userName) {
        Person person = personService.getPersonByName(userName);
        return JsonResp.success(person);
    }

    /**
     * 分页查询用户信息
     * @param req 封装分页参数
     * @return
     */
    @POST
    @Path("getPersons")
    @Produces(MediaType.APPLICATION_JSON)
    public PageResp getAllPersons(@Valid PageReq req) {
        QueryParameters params = new QueryParameters(req);
        int total = personService.getPersonCount(params);
        if (total == 0) {
            return PageResp.emptyResult();
        }

        PageInfo page = new PageInfo(req.getPage(), req.getCount(), total);
        params.setPage(page);
        List<Person> persons = personService.getPersons(params);
        return PageResp.success(total, persons);
    }

}
