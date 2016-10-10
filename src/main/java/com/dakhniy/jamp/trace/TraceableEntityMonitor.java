package com.dakhniy.jamp.trace;

import com.dakhniy.jamp.model.TraceableEntity;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@Aspect
@Component
public class TraceableEntityMonitor {

	@Before("execution(* com.dakhniy.jamp.service.*Service.create*(..)) && args(entity)")
    public void setCreationInfo(TraceableEntity entity) {
		entity.setCreated(LocalDateTime.now());
		entity.setCreatedBy(getUserIP());
	}

	@Before("execution(* com.dakhniy.jamp.service.*Service.update*(..)) && args(entity)")
	public void setUpdateInfo(TraceableEntity entity) {
		entity.setLastModified(LocalDateTime.now());
		entity.setLastModifiedBy(getUserIP());
	}

	private String getUserIP() {
		ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest req = sra.getRequest();
		return  req.getRemoteAddr();
	}

}