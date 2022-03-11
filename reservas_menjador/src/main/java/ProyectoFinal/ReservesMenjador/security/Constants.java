package ProyectoFinal.ReservesMenjador.security;

public class Constants {
	
	// Spring Security

	public static final String LOGIN_URL = "/login";
	public static final String HEADER_AUTHORIZACION_KEY = "Authorization";
	public static final String TOKEN_BEARER_PREFIX = "Bearer ";

	// JWT

	public static final String ISSUER_INFO = "Administrador";
	public static final String SUPER_SECRET_KEY = "Proyecto2022";
	public static final long TOKEN_EXPIRATION_TIME = 86_400_000; // 1 day
}
