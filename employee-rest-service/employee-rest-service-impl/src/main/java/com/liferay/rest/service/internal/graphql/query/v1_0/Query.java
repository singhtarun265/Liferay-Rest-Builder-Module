package com.liferay.rest.service.internal.graphql.query.v1_0;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.rest.service.dto.v1_0.EmployeeAllInfo;
import com.liferay.rest.service.resource.v1_0.EmployeeAllInfoResource;

import java.util.Map;
import java.util.function.BiFunction;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.UriInfo;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author Argil DX
 * @generated
 */
@Generated("")
public class Query {

	public static void setEmployeeAllInfoResourceComponentServiceObjects(
		ComponentServiceObjects<EmployeeAllInfoResource>
			employeeAllInfoResourceComponentServiceObjects) {

		_employeeAllInfoResourceComponentServiceObjects =
			employeeAllInfoResourceComponentServiceObjects;
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {employeeInfo(empId: ___){empId, jobTitle, deptId, userName, salary, userId, phoneNo, name, projectId}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(
		description = "Retrieves the employee information based on employee ID."
	)
	public EmployeeAllInfo employeeInfo(@GraphQLName("empId") Integer empId)
		throws Exception {

		return _applyComponentServiceObjects(
			_employeeAllInfoResourceComponentServiceObjects,
			this::_populateResourceContext,
			employeeAllInfoResource -> employeeAllInfoResource.getEmployeeInfo(
				empId));
	}

	@GraphQLName("EmployeeAllInfoPage")
	public class EmployeeAllInfoPage {

		public EmployeeAllInfoPage(Page employeeAllInfoPage) {
			actions = employeeAllInfoPage.getActions();

			items = employeeAllInfoPage.getItems();
			lastPage = employeeAllInfoPage.getLastPage();
			page = employeeAllInfoPage.getPage();
			pageSize = employeeAllInfoPage.getPageSize();
			totalCount = employeeAllInfoPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<EmployeeAllInfo> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

	}

	private <T, R, E1 extends Throwable, E2 extends Throwable> R
			_applyComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeFunction<T, R, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			return unsafeFunction.apply(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private void _populateResourceContext(
			EmployeeAllInfoResource employeeAllInfoResource)
		throws Exception {

		employeeAllInfoResource.setContextAcceptLanguage(_acceptLanguage);
		employeeAllInfoResource.setContextCompany(_company);
		employeeAllInfoResource.setContextHttpServletRequest(
			_httpServletRequest);
		employeeAllInfoResource.setContextHttpServletResponse(
			_httpServletResponse);
		employeeAllInfoResource.setContextUriInfo(_uriInfo);
		employeeAllInfoResource.setContextUser(_user);
		employeeAllInfoResource.setGroupLocalService(_groupLocalService);
		employeeAllInfoResource.setRoleLocalService(_roleLocalService);
	}

	private static ComponentServiceObjects<EmployeeAllInfoResource>
		_employeeAllInfoResourceComponentServiceObjects;

	private AcceptLanguage _acceptLanguage;
	private com.liferay.portal.kernel.model.Company _company;
	private BiFunction<Object, String, Filter> _filterBiFunction;
	private GroupLocalService _groupLocalService;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private RoleLocalService _roleLocalService;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private UriInfo _uriInfo;
	private com.liferay.portal.kernel.model.User _user;

}