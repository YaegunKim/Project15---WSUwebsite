package KSA_offical_web.smallgroup.spring;

import KSA_offical_web.smallgroup.spring.aggregate.group.CommunityMember;
import KSA_offical_web.smallgroup.spring.aggregate.group.SmallGroup;
import KSA_offical_web.smallgroup.spring.service.GroupService;
import KSA_offical_web.smallgroup.spring.service.MemberService;
import KSA_offical_web.smallgroup.spring.service.sdo.MemberCdo;
import KSA_offical_web.smallgroup.spring.service.sdo.SmallGroupCdo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.Date;

public class SmallGroupApp {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        String [] beanNames = context.getBeanDefinitionNames();
//        System.out.println(Arrays.toString(beanNames));


//        SmallGroupCdo firstGroup = new SmallGroupCdo("Badminton Test Group", "Test group01");
//        GroupService groupService = context.getBean("groupServiceLogic", GroupService.class);
//
//        String groupId = groupService.registerGroup(firstGroup);
//
//        SmallGroup clubFound = groupService.findGroupById(groupId);
//
//        System.out.println("ID : " + clubFound.getId());
//        System.out.println("Name : " + clubFound.getName());
//        System.out.println("Intro : " + clubFound.getIntro());
//        System.out.println("Foundation Date : " + new Date(clubFound.getFoundationTime()));

        MemberService memberService = context.getBean("memberServiceLogic", MemberService.class);

        String memderId = memberService.registerMember(
                new MemberCdo(
                        "yaegun.kim@wsu.edu",
                        "Yaegun Kim",
                        "Ethan",
                        "509-715-8102",
                        "2003.07.11"));

        CommunityMember memberFound = memberService.findMemberById(memderId);
        System.out.println("Name: " + memberFound.getName());

    }
}
