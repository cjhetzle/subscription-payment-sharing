package com.paypal.api.products;

import java.util.Map;

import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.HttpMethod;
import com.paypal.base.rest.PayPalRESTException;
import com.paypal.base.rest.PayPalResource;
import com.paypal.base.rest.RESTUtil;

import lombok.Getter;

/**
 * 
 * @author Cameron Hetzler
 *
 */
@Getter
public class Product extends PayPalResource {
	/**
	 * 
	 */
	private String id;
	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	private String description;
	/**
	 * 
	 */
	private String type;
	/**
	 * 
	 */
	private String category;
	/**
	 * 
	 */
	private String imageUrl;
	/**
	 * 
	 */
	private String homeUrl;

	/**
	 * @param id the id to set
	 */
	public Product setId(String id) {
		this.id = id;
		return this;
	}

	/**
	 * @param name the name to set
	 */
	public Product setName(String name) {
		this.name = name;
		return this;
	}

	/**
	 * @param description the description to set
	 */
	public Product setDescription(String description) {
		this.description = description;
		return this;
	}

	/**
	 * @param type the type to set
	 */
	public Product setType(String type) {
		this.type = type;
		return this;
	}

	/**
	 * @param category the category to set
	 */
	public Product setCategory(String category) {
		this.category = category;
		return this;
	}

	/**
	 * @param imageUrl the imageUrl to set
	 */
	public Product setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
		return this;
	}

	/**
	 * @param homeUrl the homeUrl to set
	 */
	public Product setHomeUrl(String homeUrl) {
		this.homeUrl = homeUrl;
		return this;
	}

	/**
	 * Creates an Product. Include Product details including merchant information in the request.
	 * @deprecated Please use {@link #create(APIContext)} instead.
	 * @param accessToken
	 * Access Token used for the API call.
	 * @return Product
	 * @throws PayPalRESTException
	 */
	public Product create(String accessToken) throws PayPalRESTException {
		APIContext apiContext = new APIContext(accessToken);
		return create(apiContext);
	}

	/**
	 * Creates an Product. Include Product details including merchant information in the request.
	 * @param apiContext
	 * {@link APIContext} used for the API call.
	 * @return Product
	 * @throws PayPalRESTException
	 */
	public Product create(APIContext apiContext) throws PayPalRESTException {
		String resourcePath = "v1/catalogs/products";
		String payLoad = this.toJSON();
		return configureAndExecute(apiContext, HttpMethod.POST, resourcePath, payLoad, Product.class);
	}

	/**
	 * Lists some or all merchant Products. Filters the response by any specified optional query string parameters.
	 * @deprecated Please use {@link #getAll(APIContext)} instead.
	 * @param accessToken
	 * Access Token used for the API call.
	 * @return Products
	 * @throws PayPalRESTException
	 */
	public static Products getAll(String accessToken) throws PayPalRESTException {
		APIContext apiContext = new APIContext(accessToken);
		return getAll(apiContext, null);
	}

	/**
	 * Lists some or all merchant Products. Filters the response by any specified optional query string parameters.
	 * @param apiContext
	 * {@link APIContext} used for the API call.
	 * @return Products
	 * @throws PayPalRESTException
	 */
	public static Products getAll(APIContext apiContext) throws PayPalRESTException {
		return getAll(apiContext, null);
	}

	/**
	 * Lists some or all merchant Products. Filters the response by any specified optional query string parameters.
	 * @param apiContext
	 * {@link APIContext} used for the API call.
	 * @param options
	 * {@link Map} of query parameters. Allowed options: page, page_size, total_count_required.
	 * @return Products
	 * @throws PayPalRESTException
	 */
	public static Products getAll(APIContext apiContext, Map<String, String> options) throws PayPalRESTException {
		String pattern = "v1/invoicing/Products";
		String resourcePath = RESTUtil.formatURIPath(pattern, null, options);
		String payLoad = "";
		return configureAndExecute(apiContext, HttpMethod.GET, resourcePath, payLoad, Products.class);
	}

	/**
	 * Gets the details for a specified Product, by ID.
	 * @deprecated Please use {@link #get(APIContext, String)} instead.
	 * @param accessToken
	 * Access Token used for the API call.
	 * @param ProductId
	 * String
	 * @return Product
	 * @throws PayPalRESTException
	 */
	public static Product get(String accessToken, String ProductId) throws PayPalRESTException {
		APIContext apiContext = new APIContext(accessToken);
		return get(apiContext, ProductId);
	}

	/**
	 * Gets the details for a specified Product, by ID.
	 * @param apiContext
	 * {@link APIContext} used for the API call.
	 * @param ProductId
	 * String
	 * @return Product
	 * @throws PayPalRESTException
	 */
	public static Product get(APIContext apiContext, String ProductId) throws PayPalRESTException {
		if (ProductId == null) {
			throw new IllegalArgumentException("ProductId cannot be null");
		}
		Object[] parameters = new Object[] { ProductId };
		String pattern = "v1/invoicing/Products/{0}";
		String resourcePath = RESTUtil.formatURIPath(pattern, parameters);
		String payLoad = "";
		return configureAndExecute(apiContext, HttpMethod.GET, resourcePath, payLoad, Product.class);
	}
}
