package com.osckorea.openmsa.auth.user.domain;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.osckorea.openmsa.global.util.jdbc.WithInsert;

@Repository
public interface UserRepository extends CrudRepository<User, UUID> , UserRepositoryCustom , WithInsert<User> {

	Optional<User> findByLoginId(String loginId);

	boolean existsByLoginId(String loginId);
	// existsById

	@Override
	void deleteById(UUID id);

	@Override
	void delete(User entity);

	@Modifying
	@Query("""
   			UPDATE tb_user u
   			SET  u.name = user.name
   				, u.email = user.email
   				, u.password = user.password
   			WHERE id = id
			""")
	boolean changeUserInfo(UUID id,User user);


}
