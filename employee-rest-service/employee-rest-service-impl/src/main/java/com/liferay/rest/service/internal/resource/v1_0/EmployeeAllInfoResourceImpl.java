package com.liferay.rest.service.internal.resource.v1_0;

import com.liferay.rest.service.dto.v1_0.EmployeeAllInfo;
import com.liferay.rest.service.resource.v1_0.EmployeeAllInfoResource;
import com.liferay.training.employee.model.Employee;
import com.liferay.training.office.api.OfficeApi;

import javax.validation.constraints.NotNull;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author Argil DX
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/employee-all-info.properties",
	scope = ServiceScope.PROTOTYPE, service = EmployeeAllInfoResource.class
)
public class EmployeeAllInfoResourceImpl
	extends BaseEmployeeAllInfoResourceImpl {
	@SuppressWarnings("null")
	@Override
	public EmployeeAllInfo getEmployeeInfo(@NotNull Integer empId) throws Exception {
		// TODO Auto-generated method stub
	EmployeeAllInfo employeeAllInfo = new EmployeeAllInfo() ;
	
	long emp=empId;
	Long emps=Long.valueOf(empId.toString());
	Employee employee=officeApi.getEmployeeOffice(emp);
	
	System.out.println(employee);
	employeeAllInfo.setEmpId(emps);
	employeeAllInfo.setJobTitle(employee.getJobTitle());
	employeeAllInfo.setDeptId(employee.getDeptId());
	employeeAllInfo.setUserName(employee.getUserName());
	employeeAllInfo.setSalary(employee.getSalary());
	employeeAllInfo.setUserId(employee.getUserId());
	employeeAllInfo.setPhoneNo(employee.getPhoneNo());
	employeeAllInfo.setName(employee.getName());
	employeeAllInfo.setProjectId(employee.getProjectId());
	
	return employeeAllInfo;
}

@Reference
OfficeApi officeApi;
}