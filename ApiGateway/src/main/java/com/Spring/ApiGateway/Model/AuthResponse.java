package com.Spring.ApiGateway.Model;

import java.util.Collection;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {

	
	private String userId;
	private String accessToken;
	private String refereshToken;
	private Long expiredAt;
	private Collection<String> authorities;
}
