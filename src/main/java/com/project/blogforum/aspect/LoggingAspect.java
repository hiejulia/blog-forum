package com.project.blogforum.aspect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.project.blogforum.service.impl.PostService.*(..)))")
    public void postServiceLog(JoinPoint joinPoint){
        logger.info("Post service : "+joinPoint.getSignature().getName());
    }

    @Before("execution(* com.project.blogforum.service.impl.UserService.*(..))")
    public void userServiceLog(JoinPoint joinPoint) {
        logger.info("User service : " + joinPoint.getSignature().getName());
    }

    @Before("execution(* com.project.blogforum.service.impl.CommentService.*(..))")
    public void commentServiceLog(JoinPoint joinPoint) {
        logger.info("Comment service : " + joinPoint.getSignature().getName());
    }

    @Before("execution(* com.project.blogforum.service.impl.AuthorityService.*(..))")
    public void roleServiceLog(JoinPoint joinPoint) {
        logger.info("Authority service : " + joinPoint.getSignature().getName());
    }
}
