package com.osckorea.openmsa.auth.user.dto;

import java.time.Instant;
import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.osckorea.openmsa.auth.user.domain.User;
import com.osckorea.openmsa.global.enums.UserRole;
import com.osckorea.openmsa.global.enums.UserStatus;
import com.osckorea.openmsa.global.util.CommonEncoder;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class UserDto{


	@Getter
	@Builder
	@AllArgsConstructor
	@NoArgsConstructor(access = AccessLevel.PROTECTED)
	public static class SaveRequest {


		@NotBlank(message = "{validation.notBlank.id}")
		private String loginId;

		@NotBlank(message = "{validation.notBlank.name}")
		private String name;

		@NotNull
		private UserStatus userStatus;

		@Pattern(regexp = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$")
		@NotBlank(message = "{validation.notBlank.email}")
		private String email;

		@NotBlank(message = "{validation.notBlank.password}")
		private String password;


		private String phone;

		private UserRole role;


		public User toEntity(){
			return User.builder()
				.id(UUID.randomUUID())
				.loginId(this.loginId)
				.name(this.name)
				.userStatus(this.userStatus)
				.phone(this.phone)
				.role(this.role)
				.password(new CommonEncoder().encode(this.password))
				.email(this.email)
				.build();
		}

	}

	@Getter
	@Builder
	@AllArgsConstructor
	@NoArgsConstructor(access = AccessLevel.PROTECTED)
	public static class UserInfoResponse {

		private String loginId;

		private String name;

		private UserStatus userStatus;

		private UserRole role;

		private String email;

		private String phone;

		private Instant createdAt;

	}


	@Getter
	@Builder
	@AllArgsConstructor
	@NoArgsConstructor(access = AccessLevel.PROTECTED)
	public static class UpdateRequest {


		@NotBlank(message = "{validation.notBlank.name}")
		private String name;

		@Pattern(regexp = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$")
		@NotBlank(message = "{validation.notBlank.email}")
		private String email;

		@NotBlank(message = "{validation.notBlank.password}")
		private String password;

		public User toEntity(){
			return User.builder()
					.name(this.name)
					.password(new CommonEncoder().encode(this.password))
					.email(this.email)
					.build();
		}

	}

	@Getter
	@Builder
	@AllArgsConstructor
	@NoArgsConstructor(access = AccessLevel.PROTECTED)
	public static class LoginRequest {

		@Schema(description = "사용자 ID", nullable = false, example = "user1")
		@NotBlank(message = "{validation.notBlank.id}")
		private String loginId;

		@Schema(description = "비밀번호", nullable = false,  example = "test1234")
		@NotBlank(message = "{validation.notBlank.password}")
		private String password;		
	}

}
