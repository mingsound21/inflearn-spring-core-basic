package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean() throws Exception {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);// 타입 지정 안하면, Object 타입으로 꺼내짐
            System.out.println("beanDefinitionName = " + beanDefinitionName + "object = " + bean);
        }
    }

    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationBean() throws Exception {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName); // 빈 메타데이터 정보꺼내오기

            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){ // ROLE_APPLICATION : 스프링이 내부적으로 알아서 등록한 것 말고, 개발자가 등록한 빈들만, ROLE_INFRASTRUCTURE : 스프링이 내부적으로 알아서 등록한 것
                Object bean = ac.getBean(beanDefinitionName);// 타입 지정 안하면, Object 타입으로 꺼내짐
                System.out.println("beanDefinitionName = " + beanDefinitionName + "object = " + bean);
            }

        }
    }
}
