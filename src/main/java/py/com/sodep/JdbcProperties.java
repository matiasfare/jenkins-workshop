package py.com.sodep;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JdbcProperties {

	@Value("${jdbc.url}")
	private String url;
	
	@Value("${jdbc.password}")
	private String password;
	
	@Value("${jdbc.user}")
	private String user;
	
	@Value("${jdbc.driverClass}")
	private String driverClass;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getDriverClass() {
		return driverClass;
	}

	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}

}
