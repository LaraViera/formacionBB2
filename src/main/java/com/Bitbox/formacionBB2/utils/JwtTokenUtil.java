package com.Bitbox.formacionBB2.utils;

//@Component
//public class JwtTokenUtil implements Serializable {
/*
    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;
    private static final long serialVersionUID = 123456789L;
    //    @Value("${jwt.secret}")
    private String secret;

    // username from jwt token
    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    // expirationDate from jwt token

    public Date getExpirationFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    private <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    // recupera cualquier informacoon desde token es necesario el secret key
    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    // comprobamos si el token ha expirado
    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationFromToken(token);
        return expiration.before(new Date());
    }

    // generamos el token de usuario
    public String Generatetoken(Users users) {
        Map<String, Object> claims = new HashMap<>();
        return doGenerateToken(claims, users.getUsername());
    }

    //mientras se crea el token:
    //1.  Define los recursos del token (expiration, subject, id)
    //2. Firma el JWT usando el algoritmo HS512 y la secret key
    //3. Acuerdo al JWT Compact Serialization, compacta el JWT en una URL-safe string
    private String doGenerateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date((System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000)))
                .signWith(SignatureAlgorithm.ES512, secret).compact();
    }

    // validamos token
    public Boolean validateToken(String token, Users users){
        final String username = getUsernameFromToken(token);
        return (username.equals(users.getUsername()) && !isTokenExpired(token));
    }
    */
//}
