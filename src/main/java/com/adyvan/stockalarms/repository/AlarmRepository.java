package com.adyvan.stockalarms.repository;

import com.adyvan.stockalarms.model.Alarm;
import com.adyvan.stockalarms.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface AlarmRepository extends JpaRepository<Alarm, Long> {
    Set<Alarm> findByUser(User user);

}
