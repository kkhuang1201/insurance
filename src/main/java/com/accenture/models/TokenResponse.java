package com.accenture.models;




import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class TokenResponse {
	
	private String access_token;
	private long expires_in;
	private String scope;
	private String token_type;
	
}
