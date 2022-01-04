package com.github.matheusmv.apihotel.repositories;

import com.github.matheusmv.apihotel.domain.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {

}
