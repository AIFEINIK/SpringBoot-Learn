package com.os.china.rest.resource;

import com.os.china.domain.entity.Person;
import com.os.china.dto.JsonResp;
import com.os.china.rest.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

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
    @Path("getPersonByName")
    @Produces(MediaType.APPLICATION_JSON)
    public JsonResp getPersonByName(@QueryParam("username") String username) {
        Person person = personService.getPersonByName(username);
        return JsonResp.success(person);
    }

    @POST
    @Path("removePersonByName")
    @Produces(MediaType.APPLICATION_JSON)
    public JsonResp removePersonByName(@QueryParam("username") String username) {
        if (personService.removePersonByName(username)) {
            return JsonResp.success();
        }
        return JsonResp.fail("系统错误！");
    }

    @POST
    @Path("savePerson")
    @Produces(MediaType.APPLICATION_JSON)
    public JsonResp savePerson(Person person) {
        if (personService.isExistPersonName(person)) {
            return JsonResp.fail("用户名已存在！");
        }
        if (personService.savePerson(person).getId() > 0) {
            return JsonResp.success();
        }
        return JsonResp.fail("系统错误！");
    }
}
