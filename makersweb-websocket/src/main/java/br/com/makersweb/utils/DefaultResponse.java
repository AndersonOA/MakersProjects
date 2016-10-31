/**
 * 
 */
package br.com.makersweb.utils;

/**
 *
 * @author Anderson O. Aristides
 *
 */
public class DefaultResponse {

	private Long id;
	private String message;
	private String typeError;
	private Boolean error;
	private String redirect;
	private Boolean existUser;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTypeError() {
		return typeError;
	}

	public void setTypeError(String typeError) {
		this.typeError = typeError;
	}

	public Boolean getError() {
		return error;
	}

	public void setError(Boolean error) {
		this.error = error;
	}

	public String getRedirect() {
		return redirect;
	}

	public void setRedirect(String redirect) {
		this.redirect = redirect;
	}

	public Boolean getExistUser() {
		return existUser;
	}

	public void setExistUser(Boolean existUser) {
		this.existUser = existUser;
	}

}
