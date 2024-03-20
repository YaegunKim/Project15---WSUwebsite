package KSA_official_web.smallgroup.spring.service;

import KSA_offical_web.smallgroup.spring.aggregate.group.SmallGroup;
import KSA_offical_web.smallgroup.spring.service.GroupService;
import KSA_offical_web.smallgroup.spring.service.logic.GroupServiceLogic;
import KSA_offical_web.smallgroup.spring.service.sdo.SmallGroupCdo;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.hamcrest.MatcherAssert.assertThat;


public class GroupServiceLogicTest {

    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    GroupService groupService = context.getBean("groupServiceLogic", GroupService.class);

    @Test
    public void register(){

        SmallGroupCdo firstGroup = new SmallGroupCdo("Badminton Test Group", "Test group01");

        String groupId = groupService.registerGroup(firstGroup);

        System.out.println("ID : " + groupId);

        assertThat(groupService.findGroupById(groupId)).isEqualTo(firstGroup);

    }

